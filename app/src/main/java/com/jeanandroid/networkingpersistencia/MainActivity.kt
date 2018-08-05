package com.jeanandroid.networkingpersistencia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.jeanandroid.networkingpersistencia.retrofit.ActivityRetrofit
import com.jeanandroid.networkingpersistencia.rom.Activityrom
import com.jeanandroid.networkingpersistencia.rom.BASE
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

            viabanco -> {
                if (BASE.productDao != null) {
                    startActivity<Activityrom>()
                } else {
                    Toast.makeText(this, "Favor clique no 1° botão para popular o banco", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

