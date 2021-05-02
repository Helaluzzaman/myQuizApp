package com.learning.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class result : AppCompatActivity() {
    private var score = 0
    private var totalquestions = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResultBoard = findViewById<TextView>(R.id.resultBoard)

        if(intent.extras != null){
            score = intent.getIntExtra(QuestionActivity.SCORE,0)
            totalquestions = intent.getIntExtra(QuestionActivity.TOTALQUESTIONS,0)
        }else{
            tvResultBoard.text = "Something went wrong!"
        }

        tvResultBoard.text = "Your score is $score out of $totalquestions"
    }
    fun finish(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}