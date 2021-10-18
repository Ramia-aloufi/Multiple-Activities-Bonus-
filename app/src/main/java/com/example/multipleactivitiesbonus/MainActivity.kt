package com.example.multipleactivitiesbonus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var et3: EditText
    lateinit var et4: EditText

    lateinit var btn:Button
    lateinit var cb:CheckBox

    lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        et1 = findViewById(R.id.editTextTextPersonName)
        et2 = findViewById(R.id.editTextTextPersonName2)
        et3 = findViewById(R.id.editTextTextPersonName3)
        et4 = findViewById(R.id.editTextTextPersonName4)

        btn = findViewById(R.id.button)
        cb = findViewById(R.id.checkBox2)

        btn.setOnClickListener {
            var name = et1.text.toString()
            var location = et2.text.toString()
            var phone = et3.text.toString()
            var email = et4.text.toString()
            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty()){
                Toast.makeText(this,"There empty field",Toast.LENGTH_SHORT).show()
            }else{
                if(cb.isChecked){

                    sp = this.getSharedPreferences("sp", MODE_PRIVATE)
                    sp.edit()
                        .putString("name",name)
                        .putString("location",location)
                        .putString("phone",phone)
                        .putString("email",email)
                        .apply()



                    var intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"agree with terms & condition",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}