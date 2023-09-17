package com.example.kisileruygulamasmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class KisiDetayViewModel @Inject constructor (var krepo : KisilerDaRepostory): ViewModel() {
    fun guncelle(kisiId:Int, kisiAd:String, kisiTel:String){
        krepo.kisiGuncelle(kisiId,kisiAd,kisiTel)
    }
}