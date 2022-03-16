package com.example.burakselcuk.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.repository.shipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationFragmentViewModel @Inject constructor(private val repository: shipRepository):ViewModel() {

    val _shipes = MutableLiveData<ship>()

    init {
        getShipes()
    }

    private fun getShipes()=viewModelScope.launch {
        repository.getShipes().let { response ->
        if (response.isSuccessful){
            _shipes.postValue(response.body())
        }else{
            Log.e("Brk:StationViewModel","error")
        }
        }
    }
}