package com.example.kisileruygulamasmvvm.ui.adapter
/*
import android.content.Context
import android.view.View
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.databinding.CardTasarimBinding

class KisilerAdapter(var mContext: Context, var kisilerListesi:List<Kisiler>) {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root){

        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGrup,viewType:Int) CardTasarimTutucu


}


 */


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.databinding.CardTasarimBinding
import com.example.kisileruygulamasmvvm.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerListesi: List<Kisiler>):RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding)
        : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t= holder.tasarim

        t.textViewKisiBilgi.text = "${kisi.kisiAd} - ${kisi.kisiTel}"

        t.satirCard.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisiAd} silinsin mi ? ", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    Log.e("Kişi Sil",kisi.kisiId.toString())
                }.show()
        }
    }
}