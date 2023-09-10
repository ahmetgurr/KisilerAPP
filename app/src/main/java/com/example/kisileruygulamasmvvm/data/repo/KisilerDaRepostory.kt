package com.example.kisileruygulamasmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasmvvm.data.entity.Kisiler

class KisilerDaRepostory {
    var kisilerListesi: MutableLiveData<List<Kisiler>>
    init {
        kisilerListesi = MutableLiveData()
    }
    fun kisileriGetir(): MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }
    fun kisiKayit(kisiAd:String, kisiTel:String){
        Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
    }
    fun kisiGuncelle(kisiId: Int, kisiAd:String, kisiTel:String){
        Log.e("Kişi Guncelle","$kisiId - $kisiAd - $kisiTel")
    }
    fun kisiAra(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }
    fun kisiSil(kisiId: Int){
        Log.e("Kişi Sil",kisiId.toString())
    }
    fun tumKisileriAl(){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","5530001122")
        val k2 = Kisiler(2,"Dilara","5530000015")
        val k3 = Kisiler(3,"Mehemt","5530001413")
        val k4 = Kisiler(4,"Firuze","5530009972")
        val k5 = Kisiler(5,"Derya","5530001478")
        val k6 = Kisiler(6,"Ahmet","5530001122")
        val k7 = Kisiler(7,"Dilara","5530000015")
        val k8 = Kisiler(8,"Mehemt","5530001413")
        val k9 = Kisiler(9,"Firuze","5530009972")
        val k10 = Kisiler(10,"Derya","5530001478")
        val k11 = Kisiler(11,"Ahmet","5530001122")
        val k12 = Kisiler(12,"Dilara","5530000015")
        val k13 = Kisiler(13,"Mehemt","5530001413")
        val k14 = Kisiler(14,"Firuze","5530009972")
        val k15 = Kisiler(15,"Derya","5530001478")
        val k16 = Kisiler(16,"Ahmet","5530001122")
        val k17 = Kisiler(17,"Dilara","5530000015")
        val k18 = Kisiler(18,"Mehemt","5530001413")
        val k19 = Kisiler(19,"Firuze","5530009972")
        val k20 = Kisiler(20,"Derya","5530001478")

        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        liste.add(k4)
        liste.add(k5)
        liste.add(k6)
        liste.add(k7)
        liste.add(k8)
        liste.add(k9)
        liste.add(k10)
        liste.add(k11)
        liste.add(k12)
        liste.add(k13)
        liste.add(k14)
        liste.add(k15)
        liste.add(k16)
        liste.add(k17)
        liste.add(k18)
        liste.add(k19)
        liste.add(k20)
        kisilerListesi.value = liste
    }
}