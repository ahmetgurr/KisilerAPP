package com.example.kisileruygulamasmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasmvvm.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = FragmentKisiKayitBinding.inflate(inflater,container,false)

        tasarim.toolbarKisiKayit.title = "Kişi Kayıt"
        tasarim.buttonKaydet.setOnClickListener{

            val kisiAd = tasarim.editTextKisiAd.text.toString()
            val kisiTel = tasarim.editTextKisiTel.text.toString()
            kayit(kisiAd,kisiTel)
        }
        return tasarim.root
    }
    fun kayit (kisiAd:String, kisiTel:String){
        Log.e("Kişi Kayıt", "$kisiAd - $kisiTel")
    }

}