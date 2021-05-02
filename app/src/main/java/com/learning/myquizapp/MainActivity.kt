package com.learning.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etUserName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        etUserName = findViewById(R.id.username)


    }
    fun startbtn(view: View){ // todo   fix here
        //etUserName.text.isNotEmpty()||
        if(true){ // Todo    fix this later
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
        }
    }
}