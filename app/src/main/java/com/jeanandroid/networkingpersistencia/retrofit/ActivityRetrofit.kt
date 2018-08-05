package com.jeanandroid.networkingpersistencia.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.jeanandroid.networkingpersistencia.R
import com.jeanandroid.networkingpersistencia.entidadeFakeAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ActivityRetrofit : AppCompatActivity(){

    //a URL abaixo contém o JSON que vamos pegar
    //https://jsonplaceholder.typicode.com/posts/1/comments
    private val URL = "https://jsonplaceholder.typicode.com"
    private var mCompositeDisposable: CompositeDisposable? = null
    private var arrayEntidadeFake: ArrayList<entidadeFakeAPI>? = null
    private var adapter: adapterForResponseAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        mCompositeDisposable = CompositeDisposable()

        recycleview()
        getJson()
    }

    private fun recycleview() {
        List.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        List.layoutManager = layoutManager
    }

    private fun getJson() {

        val requestInterface = Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestAPI::class.java)

        mCompositeDisposable?.add(requestInterface.getJsonAPI()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError))

    }

    private fun handleResponse(listaEntidadeFake: List<entidadeFakeAPI>) {
        arrayEntidadeFake = ArrayList(listaEntidadeFake)
        adapter = adapterForResponseAPI(arrayEntidadeFake!!)

        List.adapter = adapter
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(this, "Deu Ruim Pra Tu hj Fera ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }
}
