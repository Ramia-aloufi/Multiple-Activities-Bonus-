package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {

    lateinit var tv1:TextView
    lateinit var tv2:TextView
    lateinit var tv3:TextView
    lateinit var tv4:TextView

    lateinit var btn:Button
    lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tv1 = findViewById(R.id.textView)
        tv2 = findViewById(R.id.textView2)
        tv3 = findViewById(R.id.textView3)
        tv4 = findViewById(R.id.textView4)


        sp = this.getSharedPreferences("sp", MODE_PRIVATE)
        var na = sp.getString("name","")
        var lo = sp.getString("location","")
        var ph = sp.getString("phone","")
        var em = sp.getString("email","")
            tv1.text = na
            tv2.text = lo
            tv3.text = ph
            tv4.text = em

        btn = findViewById(R.id.button2)
        btn.setOnClickListener {
                AlertDialog.Builder(this)
                .setMessage("$na\n$lo\n$ph\n$em")
                .setPositiveButton("yes",DialogInterface.OnClickListener{
                    dialog,id -> var intent = Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                })
                .setNegativeButton("No",DialogInterface.OnClickListener{
                        dialog,id -> var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                })
                .setTitle("Are you sure this data")
                .create()
                .show()
        }

    }
}