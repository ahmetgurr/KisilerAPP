package com.example.kisileruygulamasmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var krepo : KisilerDaRepostory): ViewModel() {

    fun kayit(kisiAd:String, kisiTel:String){
        krepo.kisiKayit(kisiAd,kisiTel)
    }
}