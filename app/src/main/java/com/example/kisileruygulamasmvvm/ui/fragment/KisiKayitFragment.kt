package com.example.kisileruygulamasmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.databinding.FragmentKisiKayitBinding


class KisiKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container,false)

        tasarim.kisiKayitFragment = this
        tasarim.kisiKayitToolbarBaslik = "Kişi Kayıt"

        //databBinding ile tıklanma ozelligi oldugu için setOnClickListeneri kaldırıyoruz
        /*tasarim.buttonKaydet.setOnClickListener{

            val kisiAd = tasarim.editTextKisiAd.text.toString()
            val kisiTel = tasarim.editTextKisiTel.text.toString()
            buttonkayit(kisiAd,kisiTel)
        }

         */
        return tasarim.root
    }

    fun buttonKaydet(kisiAd:String, kisiTel:String){
        Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
    }

}
