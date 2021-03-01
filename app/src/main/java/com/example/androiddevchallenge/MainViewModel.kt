package com.example.androiddevchallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.SolarTerm

class MainViewModel : ViewModel() {

    var navigation = MutableLiveData<SolarTerm>()
}