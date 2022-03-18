package com.example.burakselcuk.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burakselcuk.model.shipItem
import com.example.burakselcuk.repository.FavoriteStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedStationViewModel @Inject constructor(private val repository: FavoriteStationRepository):ViewModel() {

    fun deleteStation(station: shipItem)=viewModelScope.launch {
        repository.deleteStation(station)
    }
}