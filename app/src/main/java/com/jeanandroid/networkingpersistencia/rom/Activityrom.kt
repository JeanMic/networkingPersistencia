package com.jeanandroid.networkingpersistencia.rom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jeanandroid.networkingpersistencia.R
import com.jeanandroid.networkingpersistencia.entidadeFakeAPI
import kotlinx.android.synthetic.main.activity_activityrom.*

class Activityrom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityrom)

        recycleview()
        Listbanco.adapter = adapterForDB(BASE.productDao?.getAll() as ArrayList<entidadeFakeAPI>)
    }

    private fun recycleview() {
        Listbanco.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        Listbanco.layoutManager = layoutManager
    }
}
