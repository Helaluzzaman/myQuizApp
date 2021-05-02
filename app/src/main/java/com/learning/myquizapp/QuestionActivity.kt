package com.learning.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.learning.myquizapp.QuestionsList.getQuestions

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvQuestion: TextView
    lateinit var ivQuestion: ImageView
    lateinit var pbProgressBar: ProgressBar
    lateinit var tvProgressBarText: TextView
    lateinit var tvOptionOne : TextView
    lateinit var tvOptionTwo : TextView
    lateinit var tvOptionThree : TextView
    lateinit var tvOptionFour : TextView
    lateinit var btnSubmit: Button

    // variables
    private var questionsList : ArrayList<question>? = null
    var currentPosition = 1
    var totalQuestions = 0
    var selectedOption = 0
    var correctAns = 0
    private var acceptable = false
    var score = 0
    private var isSubmitted = false

    companion object{
        const val SCORE = "score"
        const val TOTALQUESTIONS = "tatalquestions"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        //creating questions

        // binding
        tvQuestion = findViewById(R.id.tvQuestion)
        ivQuestion = findViewById(R.id.ivQuestion)
        pbProgressBar = findViewById(R.id.progressBar)
        tvProgressBarText = findViewById(R.id.progressBarText)
        tvOptionOne  = findViewById(R.id.tvOption1)
        tvOptionTwo = findViewById(R.id.tvOption2)
        tvOptionThree = findViewById(R.id.tvOption3)
        tvOptionFour = findViewById(R.id.tvOption4)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        setquestion()
    }
    @SuppressLint("SetTextI18n")
    fun setquestion(){
        // setting all variable
        if (questionsList == null){
            questionsList = getQuestions()
        }
        totalQuestions = questionsList!!.size
        val question = questionsList!![this.currentPosition -1]
        correctAns = question.answer
        tvQuestion.text = question.question
        ivQuestion.setImageResource(question.image)
        pbProgressBar.progress +=1
        pbProgressBar.max = totalQuestions
        tvProgressBarText.text = "$currentPosition/$totalQuestions"
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
        setDefault()
        acceptable = true
        selectedOption = 0
        btnSubmit.text = "submit"
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tvOptionOne.id -> {
                setDefault()
                setSelected(tvOptionOne)
                selectedOption = 1
            }
            tvOptionTwo.id ->{
                setDefault()
                setSelected(tvOptionTwo)
                selectedOption = 2

            }
            tvOptionThree.id -> {
                setDefault()
                setSelected(tvOptionThree)
                selectedOption = 3
            }
            tvOptionFour.id -> {
                setDefault()
                setSelected(tvOptionFour)
                selectedOption = 4
            }
            btnSubmit.id -> {
                submit()

            }
        }
    }
    fun submit(){
        if(selectedOption != 0 && correctAns !=0){
            setcorrectIncorrect(selectedOption,correctAns)
            acceptable = false
            btnSubmit.text = "Continue Next"
            selectedOption = 0
            isSubmitted = true
        }else if(isSubmitted){
            if (currentPosition < totalQuestions){
                currentPosition += 1
                isSubmitted = false
                setquestion()
            }else finishing()

        }else{
            Toast.makeText(this, "Please, Select an option.", Toast.LENGTH_SHORT).show()
        }

    }
    fun finishing(){
        var intent = Intent(this,result::class.java)
        intent.putExtra(SCORE, score)
        intent.putExtra(TOTALQUESTIONS, totalQuestions)
        startActivity(intent)
        finish()
    }
    fun setcorrectIncorrect(selected: Int, answer: Int){
        when(answer){
            1-> setCorrect(tvOptionOne)
            2-> setCorrect(tvOptionTwo)
            3-> setCorrect(tvOptionThree)
            4-> setCorrect(tvOptionFour)
        }
        if(selected != answer){
            when(selected){
                1-> setIncorrect(tvOptionOne)
                2-> setIncorrect(tvOptionTwo)
                3-> setIncorrect(tvOptionThree)
                4-> setIncorrect(tvOptionFour)
            }
        }
        if(selected == answer && acceptable){
            score ++
            val tst = Toast.makeText(this, "scored!", Toast.LENGTH_SHORT)
            tst.setGravity(Gravity.TOP,0,300)
            tst.show()
        }
    }
    fun setCorrect(tv: TextView){
        tv.background = ContextCompat.getDrawable(this, R.drawable.correct_option_background)
//        tv.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_primary))
    }
    fun setIncorrect(tv: TextView){
        tv.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_background)
        tv.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    fun setDefault(){
        val lst = ArrayList<TextView>()
        lst.add(tvOptionOne)
        lst.add(tvOptionTwo)
        lst.add(tvOptionThree)
        lst.add(tvOptionFour)
        for ( tv in lst){
            tv.setTextColor(Color.parseColor("#494949"))
            tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_background)
        }
    }
    fun setSelected(tv: TextView){
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
        tv.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_primary))
    }
}