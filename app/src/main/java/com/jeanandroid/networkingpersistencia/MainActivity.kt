package com.jeanandroid.networkingpersistencia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jeanandroid.networkingpersistencia.retrofit.ActivityRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viaretrofit?.setOnClickListener(this)
        viabanco?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {
            viaretrofit -> {startActivity<ActivityRetrofit>()}
//            viabanco -> {startActivity<listTarefasCasa>()}
        }
    }
}

