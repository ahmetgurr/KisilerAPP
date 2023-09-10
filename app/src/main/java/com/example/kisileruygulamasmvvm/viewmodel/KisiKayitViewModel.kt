package com.example.kisileruygulamasmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory

class KisiKayitViewModel: ViewModel() {
    val krepo =  KisilerDaRepostory()

    fun kayit(kisiAd:String, kisiTel:String){
        //Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
        krepo.kisiKayit(kisiAd,kisiTel)
    }
}