package com.example.flaggyquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentPosition: Int =1
    private var mQuestionsList:ArrayList<Question>? =null
    private var mSelected:Int = 0

    private var mUserName : String? =null
    private var mCorrectAnswers :Int = 0
//    variables for accessing other elements of screen
    private var progressBar: ProgressBar? =null
    private var progress: TextView? = null
    private var que: TextView? =null
    private var img: ImageView? = null

//    variables for accessing options
    private var one:TextView? = null
    private var two:TextView? = null
    private var three:TextView? = null
    private var four:TextView? = null
    private var submit:Button? =null
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
//        Getting all the elements by there ids
        progress = findViewById(R.id.progress)
        progressBar = findViewById(R.id.progressBar)
        que = findViewById(R.id.question)
        img = findViewById(R.id.que_img)
        one =findViewById(R.id.firstopt)
        two = findViewById(R.id.secondopt)
        three = findViewById(R.id.threeopt)
        four =findViewById(R.id.fouropt)
        submit = findViewById(R.id.btn_submit)


        mQuestionsList = Constants.getQuestions()

        setQuestion()
        one?.setOnClickListener(this)
        two?.setOnClickListener(this)
        three?.setOnClickListener(this)
        four?.setOnClickListener(this)
        submit?.setOnClickListener(this)


    }

    private fun setQuestion() {
        defaultOptions()
        //        changing the elements values by questions made in constant object file
        val question: Question = mQuestionsList!![mcurrentPosition - 1]

//        setting the image of flag with actual question
        img?.setImageResource(question.image)

//        changing progress & progressbar
        progressBar?.progress = mcurrentPosition
        progress?.text = "${mcurrentPosition}/${progressBar?.max}"

//        changing question
        que?.text = question.question

//        changing options
        one?.text = question.optionOne
        two?.text = question.optionTwo
        three?.text = question.optionThree
        four?.text = question.optionFour

//Changing the button
        if (mcurrentPosition == mQuestionsList!!.size){
            submit?.text = "FINISH"
        }else{
            submit?.text = "SUBMIT"
        }
    }

    private fun defaultOptions(){
        val options = ArrayList<TextView>()
        one?.let {
            options.add(0,it)
        }
        two?.let {
            options.add(1,it)
        }
        three?.let {
            options.add(2,it)
        }
        four?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOption(tv:TextView,selectedOptioNum:Int){
        defaultOptions()

        mSelected = selectedOptioNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_opt_border
        )
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.firstopt->{
                one?.let {
                    selectedOption(it,1)
                }
            }
            R.id.secondopt->{
                two?.let {
                    selectedOption(it,2)
                }
            }
            R.id.threeopt->{
                three?.let {
                    selectedOption(it,3)
                }
            }
            R.id.fouropt->{
                four?.let {
                    selectedOption(it,4)
                }
            }
            R.id.btn_submit->{
                if (mSelected==0){
                    mcurrentPosition++
                    when{
                        mcurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this, Result::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mcurrentPosition-1)
                    if (question!!.answer !=mSelected){
                        answerView(mSelected,R.drawable.wrong_option_broder)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.answer,R.drawable.correct_option_border)


//                    changing the button content
                    if (mcurrentPosition == mQuestionsList!!.size){
                        submit?.text = "FINISH"
                    }else{
                        submit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelected = 0

                }
            }

        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                one?.background = ContextCompat.getDrawable(
                    this,
                     drawableView
                )
            }
            2->{
                two?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                three?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                four?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}