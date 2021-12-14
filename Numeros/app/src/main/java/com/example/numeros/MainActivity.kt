package com.example.numeros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etNumber1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNumber1 = findViewById(R.id.etNumber1)
    }

    fun contButton(view: View){
        if(etNumber1.text.toString()!= ""){
            val numNum = etNumber1.text.toString().toInt()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("numNum", numNum)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Se necesita un número", Toast.LENGTH_LONG).show()
        }
    }


}