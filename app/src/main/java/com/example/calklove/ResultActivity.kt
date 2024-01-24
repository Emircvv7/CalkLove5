package com.example.calklove

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calklove.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")

        displayResult(percentage, result)
    }

    @SuppressLint("SetTextI18n")
    private fun displayResult(percentage: String?, result: String?) {
        binding.resultTv.text = "$percentage\n$result"
    }
}
