package com.example.calklove.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calklove.LoveViewModel
import com.example.calklove.databinding.ActivityMainBinding
import com.example.calklove.onboarding.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import android.content.SharedPreferences
import com.example.calklove.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)
        if (isFirstRun) {

            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)

            val editor = sharedPreferences.edit()
            editor.putBoolean("isFirstRun", false)
            editor.apply()
        }

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                val firstName = binding.firstEd.text.toString()
                val secondName = binding.secondEd.text.toString()
                if (firstName.isNotBlank() && secondName.isNotBlank()) {
                    viewModel.getLove(firstName, secondName)
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.Winner), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        viewModel.liveData.observe(this) { model ->
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("firstName", model.firstName)
            intent.putExtra("secondName", model.secondName)
            intent.putExtra("percentage", model.percentage)
            intent.putExtra("result", model.result)
            startActivity(intent)
        }
    }
}
