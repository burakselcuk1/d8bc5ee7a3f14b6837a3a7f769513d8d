package com.example.burakselcuk.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.model.shipItem
import com.example.burakselcuk.repository.FavoriteStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteFragmentViewModel @Inject constructor(private val repository: FavoriteStationRepository):ViewModel() {

    val readAllData: LiveData<List<shipItem>> = repository.readAllData

    fun addStation(station: shipItem)=viewModelScope.launch {
        repository.insertStation(station)
    }
}