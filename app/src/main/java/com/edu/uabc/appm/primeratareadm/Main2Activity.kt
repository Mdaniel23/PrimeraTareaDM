package com.edu.uabc.appm.primeratareadm

import android.content.Intent

import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import android.Manifest
import android.content.SharedPreferences
import android.os.SharedMemory
import android.provider.CallLog
import android.provider.MediaStore

class Main2Activity : AppCompatActivity() {


    val PREFS_FILENAME = "como.edu.uabc.appm.primeratareadm"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Se crean las variables para poder solicitar los permisos de privacidad
        var sP: SharedPreferences? = this.getSharedPreferences(PREFS_FILENAME, 0);
        var editor = sP?.edit()
        var respuesta = sP?.getString("llave", "Nada")
        editor?.apply()
        editor?.commit()
        println(respuesta)


        //Recibde el texto creado en el intent en el activity 1
        var saludo: String? = intent.extras?.getString("dato enviado", "Hola")
        textView2.text = saludo


        //Al picar el boton de llamar se pregunta sobre los permisos si los autoriza llama
        if (setupPermissions()) {
            println("Estas en llamada")
            llamar.setOnClickListener(
                View.OnClickListener { v: View? ->
                    var llamarIntento = Intent(Intent.ACTION_CALL, Uri.parse("tel:+526863482277"))
                    startActivity(llamarIntento)

                })


            //Al picar el boton de foto
            foto.setOnClickListener(View.OnClickListener {
                var fotoIntento = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                println("Estas para tomar foto")
                startActivity(fotoIntento)
            })

        }
    }

    //

    //Se ajustan los permisos
    private fun setupPermissions(): Boolean {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("La app", "Permission Call denied")
            makeRequest();
        }
        return true;
    }

    //Codigo de aceptacion
    private val CALL_PHONE_CODE = 101

    //Solitiud de permisos
    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ), CALL_PHONE_CODE
        )

    }


}

