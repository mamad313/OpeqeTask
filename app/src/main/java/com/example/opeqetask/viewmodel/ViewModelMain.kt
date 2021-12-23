package com.example.opeqetask.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.opeqetask.di.RetrofitClient
import com.example.opeqetask.models.Results
import com.example.opeqetask.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ViewModelMain (private val repository: Repository =  Repository(RetrofitClient.instance))
    : ViewModel(){

    @Inject
    lateinit var retrofitCLass:RetrofitClient

        private var _liveDataVar = MutableLiveData<List<Results>>()
        val liveDataVar : LiveData<List<Results>>
            get() = _liveDataVar

        init {
            getCharacter()
        }

    private fun getCharacter(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val client = repository.getUsers()
                _liveDataVar.postValue(client.userList)
            }catch (e: Exception){
                Log.d("Exception","Exception -> $e")
            }
        }
    }
}