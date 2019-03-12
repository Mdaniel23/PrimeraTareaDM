package com.edu.uabc.appm.primeratareadm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // var pedro: Intent = Intent(this,Main2Activity::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            println("Picaste el boton")

            var intento: Intent = Intent(this, Main2Activity::class.java)

            //Enviar datos a otro activity
            intento.putExtra("dato enviado", "Hola")

            //Se ejecuta el intent
            startActivity(intento)
        }

    }

    override fun onStart() {
        super.onStart()
        println("Se activo on Start - onStart")
        Toast.makeText(this, "Esta iniciando!!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        println("Se activo  la pausa- Pause")
        Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()
        println("Se reanudo - Resume")
        Toast.makeText(this, "En resume", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        println("Se paro la aplicacion- Stop")
        Toast.makeText(this, "En Stop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        println("Se reinicio la aplicacion- Restar")
        Toast.makeText(this, "En restart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Se cerro la aplicacion -Destroy")
        Toast.makeText(this, "En destroy", Toast.LENGTH_SHORT).show()
    }


}
