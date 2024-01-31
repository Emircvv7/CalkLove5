package com.example.calklove

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.calklove.remote.LoveModel
import com.example.calklove.remote.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    val api = RetrofitService().api

    suspend fun getLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        withContext(Dispatchers.IO) {
            api.getCompatibility(firstName = firstName, secondName = secondName).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        var model = response.body()!!
                        mutableLiveData.postValue(model)
                    } else {
                        Log.e("Repository", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("Repository", "Failure: ${t.message}")
                }
            })
        }
        return mutableLiveData
    }
}
