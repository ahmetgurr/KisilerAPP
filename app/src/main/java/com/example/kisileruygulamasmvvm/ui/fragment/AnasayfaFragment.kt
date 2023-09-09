package com.example.kisileruygulamasmvvm.ui.fragment
/*
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.databinding.FragmentAnasayfaBinding
 */

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.databinding.FragmentAnasayfaBinding



class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {//SearchView.OnQueryTextListener kısmını ekleyip implement et aram işlemini yapıyor
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)



        tasarim.toolbarAnasayfa.title="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)//action ve tooplbarı ayarlar

        tasarim.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        requireActivity().addMenuProvider(object  : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(this@AnasayfaFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return tasarim.root
    }
//SearchView.OnQueryTextListener kısmını implement ettiğimiz yer
    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
    return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }
//iki yerde de aynı işlevi kullanacagımız için fonsıyon olsuturduk searchviewle Implement ettımgımzı yerlerde kullanacagız.
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }

}