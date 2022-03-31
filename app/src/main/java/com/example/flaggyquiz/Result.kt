package com.example.flaggyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName :TextView = findViewById(R.id.username)
        val score : TextView = findViewById(R.id.score)
        val btnFinish :Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        score.text = "Your score is $correctAnswers out of $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}