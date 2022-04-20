package com.rsamqui.transactions.entities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsamqui.transactions.repositories.GeneroRepository
import com.rsamqui.transactions.repositories.GeneroRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val generoRepository: GeneroRepository = GeneroRepositoryImp.invoke()): ViewModel() {

    private var _genero = MutableLiveData<List<Genero>>()
    var genero : LiveData<List<Genero>> = _genero
        init{
            getGenero()
        }

    private fun getGenero() {
        viewModelScope.launch (Dispatchers.IO) {
            generoRepository.getAll()
        }
    }



}