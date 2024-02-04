package com.example.calklove.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calklove.databinding.ActivityOnBoardingBinding
import com.example.calklove.onboarding.adapter.OnBoardingAdapter

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private val pages = listOf(
        OnBoardingPage("Have a good time", "You should take the time to help those who need you", "https://avatars.mds.yandex.net/i?id=214e286882e96d432d62cc9b558af6cdac097d99-12216120-images-thumbs&n=13"),
        OnBoardingPage("Cherishing love", "It is now no longer possible for you to cherish love", "https://avatars.mds.yandex.net/i?id=f28cf17d3ba04fe633b0efc112f5c4fb85eea931-9833405-images-thumbs&n=13"),
        OnBoardingPage("Have a breakup?", "We have made the correction for you don't worry  Maybe someone is waiting for you", "https://avatars.mds.yandex.net/i?id=28acf5e747c389913211932586bf845d3cd192db-10618387-images-thumbs&n=13" ),
        OnBoardingPage("Start now", "good time and love!", "https://avatars.mds.yandex.net/i?id=7af035ff7fbac57068244890ae5c1a9c7fbd16b7-10108140-images-thumbs&n=13")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = OnBoardingAdapter(pages)
        binding.viewpager.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager)
    }
}
