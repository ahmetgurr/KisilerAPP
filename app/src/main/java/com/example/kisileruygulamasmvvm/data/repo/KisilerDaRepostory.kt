package com.example.kisileruygulamasmvvm.data.repo


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasmvvm.data.entity.CRUDCevap
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.data.entity.KisilerCevap
import com.example.kisileruygulamasmvvm.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaRepostory(var kdao:KisilerDao) {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi

    }

    fun kisiKayit(kisi_ad:String, kisi_tel:String){
        kdao.kisiEkle(kisi_ad,kisi_tel).enqueue(object  : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val succes = response.body()!!.success
                val mesege = response.body()!!.message
                Log.e("Kişi Kayıt"," $succes - $mesege")
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            }

        })
    }

    fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        kdao.kisiGuncelle(kisi_id,kisi_ad,kisi_tel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val succes = response.body()?.success
                val mesage = response.body()?.message
                Log.e("Kişi Güncelle", "$succes - $mesage")
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            }

        })

    }

    fun kisiAra(aramaKelimesi:String){
        kdao.kisiAra(aramaKelimesi).enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {}


        })
    }

    fun kisiSil(kisi_id: Int){
        kdao.kisiSil(kisi_id).enqueue(object  : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val succes = response.body()!!.success
                val mesage = response.body()!!.message
                Log.e("Kişi Sil", "$succes - $mesage")
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                Log.e("Kişi Sil", "İşlem başarısız")

            }

        })
    }

    fun tumKisileriAl(){
        kdao.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }

        })
    }
}


/*
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasmvvm.data.entity.CRUDCevap
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.data.entity.KisilerCevap
import com.example.kisileruygulamasmvvm.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects


class KisilerDaRepostory(var kdao:KisilerDao) {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi

    }

    fun kisiKayit(kisiAd:String, kisiTel:String){
       // Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
        kdao.kisiKayit(kisiAd,kisiTel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Kişi kayıt","İşlem Başarısız")
            }

        })
    }
    fun kisiGuncelle(kisi_id: Int, kisi_ad:String, kisi_tel:String){
        //Log.e("Kişi Guncelle","$kisiId - $kisiAd - $kisiTel")
        kdao.kisiGuncelle(kisi_id,kisi_ad,kisi_tel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Kişi güncelle","İşlem Başarısız")
            }

        })
    }
    fun kisiAra(aramaKelimesi:String){
        //Log.e("Kişi Ara",aramaKelimesi)
        kdao.kisiAra(aramaKelimesi).enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }

        })
    }

    fun kisiSil(kisi_id: Int){
        //Log.e("Kişi Sil",kisiId.toString()),
        kdao.kisiSil(kisi_id).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Kişi sil","İşlem Başarısız")
            }

        })
    }





    fun tumKisileriAl(){
        kdao.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }

        })
    }
}

 */