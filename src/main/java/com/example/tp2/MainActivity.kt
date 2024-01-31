package com.example.tp2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var isButton2On = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            v -> myClick(v)
        })

        val textNouv = findViewById<TextView>(R.id.nouvView)
        textNouv.setOnClickListener(View.OnClickListener {
            v -> myClick(v)
        })

        val toggleButton = findViewById<Button>(R.id.button2)
        toggleButton.setOnClickListener(View.OnClickListener {
            v -> myClick(v)
        })
    }

    fun myClick(v: View) {
        when (v.getId()) {

            R.id.nouvView -> Toast.makeText(
                applicationContext,
                "OK. Vous voulez créer un nouveau Compte",
                Toast.LENGTH_SHORT
            ).show()

            R.id.button -> {
                val editTextLogin: EditText = findViewById(R.id.editTextLogin)
                val editTextMDP: EditText = findViewById(R.id.editTextMDP)

                val login: String = editTextLogin.text.toString()
                val password: String = editTextMDP.text.toString()

                if (login == "admin@@" && password == "123456") {
                    Toast.makeText(
                        applicationContext,
                        "SUCCESS!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "ECHEC!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            R.id.button2 -> {
                if (isButton2On) {
                    isButton2On = false
                    (v as Button).text = "OFF"
                    Toast.makeText(applicationContext, "OFF", Toast.LENGTH_SHORT).show()
                } else {
                    isButton2On = true
                    (v as Button).text = "ON"
                    Toast.makeText(applicationContext, "ON", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}