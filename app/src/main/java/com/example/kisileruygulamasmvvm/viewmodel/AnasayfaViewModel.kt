package com.example.kisileruygulamasmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory

class AnasayfaViewModel: ViewModel() {
    val krepo =  KisilerDaRepostory()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }
    fun ara(aramaKelimesi:String){
       krepo.kisiAra(aramaKelimesi)
    }
    fun sil(kisiId: Int){
        krepo.kisiSil(kisiId)
    }
    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }


}