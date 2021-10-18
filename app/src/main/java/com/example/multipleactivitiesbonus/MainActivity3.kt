package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var al:ArrayList<String>
    lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        rv = findViewById(R.id.rv)
        al = arrayListOf()
        sp = this.getSharedPreferences("sp", MODE_PRIVATE)
        var na = sp.getString("name","")
        var lo = sp.getString("location","")
        var ph = sp.getString("phone","")
        var em = sp.getString("email","")
        al.add(na!!)
        al.add(lo!!)
        al.add(ph!!)
        al.add(em!!)

        rv.adapter = MyAdapter(al)
        rv.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.a -> AlertDialog.Builder(this)
                .setMessage("yyy")
                .setPositiveButton("Home", DialogInterface.OnClickListener{
                        dialog,id -> var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                })
                .setNegativeButton("Exit", DialogInterface.OnClickListener{
                        dialog,id -> finishAffinity()
                    System.exit(0)
                })
                .setTitle("Are you sure this data")
                .create()
                .show()
            R.id.b -> Toast.makeText(this,"",Toast.LENGTH_SHORT).show()

            else ->  Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }
}