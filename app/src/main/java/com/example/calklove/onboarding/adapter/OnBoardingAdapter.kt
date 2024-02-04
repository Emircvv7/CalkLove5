package com.example.calklove.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.calklove.onboarding.OnBoardingPage
import com.example.calklove.databinding.ItemOnboardingBinding


class OnBoardingAdapter(private val pages: List<OnBoardingPage>) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    inner class OnBoardingViewHolder(val binding: ItemOnboardingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
       holder.binding.tvTitle.text = pages[position].title
       holder.binding.tvDesc.text = pages[position].description
        Glide.with(holder.itemView)
            .load(pages[position].image)
            .into(holder.binding.ivBoard)
    }

    override fun getItemCount() = pages.size
}


