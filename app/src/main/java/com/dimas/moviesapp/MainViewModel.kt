package com.dimas.moviesapp

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimas.moviesapp.data.models.Movies
import com.dimas.moviesapp.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    private var _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
    get() = _allMovies

    fun getAllMovies(){
        viewModelScope.launch {
            repository.getAllMovies().let{
                if(it.isSuccessful){
                    _allMovies.postValue(it.body())
                } else {
                    //Toast.makeText(this, "Failed to load: ${it.errorBody()}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}