package com.example.numeros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var etNumber2: EditText
    private lateinit var bttnIngresaLista: Button
    private lateinit var bttnOrdenaMenor: Button
    private lateinit var bttnOrdenaMayor: Button
    var numNum: Int =0
    var temp: Long =0
    val listaNumeros = ArrayList<Long>()
    val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeros)
    val lv: ListView = findViewById<ListView>(R.id.lv)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        etNumber2 = findViewById(R.id.etNumber2)
        bttnIngresaLista = findViewById(R.id.bttnIngresaLista)
        bttnOrdenaMayor = findViewById(R.id.bttnOrdenaMayor)
        bttnOrdenaMenor = findViewById(R.id.bttnOrdenaMenor)
        numNum = getIntent().getIntExtra("numNum",-1)
        lv.adapter = adaptador
    }

    fun ingresaNum(view: View){
        if(etNumber2.text.toString()!= ""){
            for(i in 1 until numNum){
                listaNumeros.add(etNumber2.text.toString().toLong())
            }
        }else{
            Toast.makeText(this, "Se necesita ingresar al menos 1 número", Toast.LENGTH_LONG).show()
        }
    }

    fun ordenaMayor(view: View){
        if(listaNumeros.isNotEmpty()){
            for(i in 0 until numNum-1){
                for(j in i+1 until numNum) {
                    if(listaNumeros[i]>listaNumeros[j]){
                        temp = listaNumeros[j]
                        listaNumeros[j] = listaNumeros[i]
                        listaNumeros[j]= temp
                    }
                }
            }
            //Mostrar en list view
        }else{
            Toast.makeText(this, "Se necesita ingresar al menos 1 número", Toast.LENGTH_LONG).show()
        }
    }

    fun ordenaMenor(view: View){
        if(listaNumeros.isNotEmpty()){
            for(i in 0 until numNum-1){
                for(j in i+1 until numNum) {
                    if(listaNumeros[i]<listaNumeros[j]){
                        temp = listaNumeros[j]
                        listaNumeros[j] = listaNumeros[i]
                        listaNumeros[j]= temp
                    }
                }
            }
            //Mostrar en list view

        }else{
            Toast.makeText(this, "Se necesita ingresar al menos 1 número", Toast.LENGTH_LONG).show()
        }
    }

    fun clickButtonRegresar(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}