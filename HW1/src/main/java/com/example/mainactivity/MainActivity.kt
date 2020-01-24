package com.example.mainactivity
import com.example.mainactivity.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import android.graphics.Color;
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton = findViewById<Button>(R.id.addButton)
        val button2 = findViewById<Button>(R.id.button2)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val textViewResult = findViewById<TextView>(R.id.resultTextView)
        val textView = findViewById<TextView>(R.id.textView)
        addButton.setText("concat")
        button2.setText("NUMBERS")
        addButton.setOnClickListener {
            val result = editText1.text.toString() + editText2.text.toString()
            textViewResult.text = result
            val randR = (0..255).random()
            val randG = (0..255).random()
            val randB = (0..255).random()

            addButton.setBackgroundColor(Color.argb(255,randR,randG,randB))
        }
        button2.setOnClickListener {
            val res1: Int = editText1.text.toString().toInt()
            val res2: Int = editText2.text.toString().toInt()
            val result2 = res1*res2
            val finalres = result2.toString()
            textView.text = finalres

            val randR = (0..255).random()
            val randG = (0..255).random()
            val randB = (0..255).random()

            button2.setBackgroundColor(Color.argb(255,randR,randG,randB))
        }
    }
}
