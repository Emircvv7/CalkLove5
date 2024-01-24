package com.example.calklove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calklove.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                val firstName = firstEd.text.toString()
                val secondName = secondEd.text.toString()
                getCompatibility(firstName, secondName)
            }
        }
    }

    private fun getCompatibility(firstName: String, secondName: String) {
        RetrofitService().api.getCompatibility(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val intent = Intent(this@MainActivity, ResultActivity::class.java)
                            intent.putExtra("percentage", it.percentage)
                            intent.putExtra("result", it.result)
                            startActivity(intent)
                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("Error", "onFailure: ${t.message}")
                }
            })
    }
}
