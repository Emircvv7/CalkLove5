package com.example.calklove

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calklove.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var liveData: MutableLiveData<LoveModel> = MutableLiveData()

    fun getLove(firstName: String, secondName: String) {
        viewModelScope.launch {
            val data = repository.getLoveModel(firstName, secondName)
            data.observeForever { model ->
                model?.let { liveData.value = it }
            }
        }
    }
}

