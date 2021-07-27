package com.example.quis

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quis.Question.QuestionLibrary

class MainActivity : AppCompatActivity()
{
    private  var mQuestionLibrary: QuestionLibrary = QuestionLibrary()
    private lateinit var mScoreView : TextView
    private lateinit var mQuestionView : TextView
    private lateinit var mButtonChoice1 : Button
    private lateinit var mButtonChoice2 : Button
    private lateinit var mButtonChoice3 : Button
    private var mAnswer : String = ""
    private var mScore : Int = 0
    private var mQuestionNumber : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mScoreView = findViewById(R.id.score)
        mQuestionView = findViewById(R.id.question)
        mButtonChoice1 = findViewById(R.id.choice1)
        mButtonChoice2 = findViewById(R.id.choice2)
        mButtonChoice3 = findViewById(R.id.choice3)
        updateQuestion()

        //listen pilihan 1
        mButtonChoice1.setOnClickListener {
            if (mButtonChoice1.text == mAnswer){
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this,"BENAR",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"SALAH",Toast.LENGTH_LONG).show()
                updateQuestion()
            }
        }
        //listen pilihan 2
        mButtonChoice2.setOnClickListener {
            if (mButtonChoice2.text == mAnswer){
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this,"BENAR",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"SALAH",Toast.LENGTH_LONG).show()
                updateQuestion()
            }
        }
        //listen pilihan 3
        mButtonChoice3.setOnClickListener {
            if (mButtonChoice3.text == mAnswer){
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this,"BENAR",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"SALAH",Toast.LENGTH_LONG).show()
                updateQuestion()
            }
        }
    }

    private fun updateQuestion() {
        if (mQuestionNumber<mQuestionLibrary.getLength()){
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber))
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber))
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber))
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber))
            mAnswer=mQuestionLibrary.getCorrection(mQuestionNumber)
            mQuestionNumber++
        }else{
            gameOver()
        }
    }

    private fun gameOver() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Skor Kamu: "+mScore + " Point")
        builder.setCancelable(false)
        builder.setPositiveButton("Main Lagi", object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                val main = Intent(applicationContext, MainActivity::class.java)
                startActivity(main)
            }

        })
        builder.setNegativeButton("KELUAR", object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                finish()
            }

        })
        builder.create().show()
    }

    private fun updateScore(mScore: Int) {
        mScoreView.setText(" "+mScore)
    }
}