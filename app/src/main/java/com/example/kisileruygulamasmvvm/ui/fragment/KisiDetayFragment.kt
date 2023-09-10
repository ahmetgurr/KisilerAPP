package com.example.kisileruygulamasmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay, container, false)
        tasarim.kisiDetayFragment = this

        tasarim.kisiDetayToolbarBaslik = "Kişi Detay"

        val bundle: KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        tasarim.kisiNesnesi = gelenKisi

        /*
       //burayı da yukarıda gelen kısı ile aldık
       tasarim.editTextKisiAd.setText(gelenKisi.kisiAd)
        tasarim.editTextKisiTel.setText(gelenKisi.kisiTel)

        //buradaki tıklanma ozelligi yerıne viewDataBinding kullandık kaldırdık
        tasarim.buttonGuncelle.setOnClickListener{
            val kisiAd = tasarim.editTextKisiAd.text.toString()
            val kisiTel= tasarim.editTextKisiTel.text.toString()

            buttonGuncelle(gelenKisi.kisiId,kisiAd,kisiTel)
            //guncelle(gelenKisi.kisiId,kisiAd,kisiTel)
        }
         */

        return tasarim.root
    }

    fun buttonGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        Log.e("Kişi Güncelle", "$kisiId - $kisiAd - $kisiTel")
    }

}