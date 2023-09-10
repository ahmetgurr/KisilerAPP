package com.example.kisileruygulamasmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory

class KisiDetayViewModel: ViewModel() {
    val krepo =  KisilerDaRepostory()

    fun kayit(kisiAd:String, kisiTel:String){
        krepo.kisiKayit(kisiAd,kisiTel)
    }

    fun kisiGuncelle(kisiId:Int,kisiAd:String, kisiTel:String){
        krepo.kisiGuncelle(kisiId,kisiAd,kisiTel)
    }
}