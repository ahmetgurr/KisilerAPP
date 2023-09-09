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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasmvvm.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {//SearchView.OnQueryTextListener kısmını ekleyip implement et aram işlemini yapıyor
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)



        tasarim.toolbarAnasayfa.title="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)//action ve tooplbarı ayarlar

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())
        /*
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler("1","Ahmet","5530001122")
        val k2 = Kisiler("2","Dilara","5530000015")
        val k3 = Kisiler("3","Mehemt","5530001413")
        val k4 = Kisiler("4","Firuze","5530009972")
        val k5 = Kisiler("5","Derya","5530001478")
        val k6 = Kisiler("1","Ahmet","5530001122")
        val k7 = Kisiler("2","Dilara","5530000015")
        val k8 = Kisiler("3","Mehemt","5530001413")
        val k9 = Kisiler("4","Firuze","5530009972")
        val k10 = Kisiler("5","Derya","5530001478")
        val k11 = Kisiler("1","Ahmet","5530001122")
        val k12 = Kisiler("2","Dilara","5530000015")
        val k13 = Kisiler("3","Mehemt","5530001413")
        val k14 = Kisiler("4","Firuze","5530009972")
        val k15 = Kisiler("5","Derya","5530001478")
        val k16 = Kisiler("1","Ahmet","5530001122")
        val k17 = Kisiler("2","Dilara","5530000015")
        val k18 = Kisiler("3","Mehemt","5530001413")
        val k19 = Kisiler("4","Firuze","5530009972")
        val k20 = Kisiler("5","Derya","5530001478")

         */

        val kisilerListesi = ArrayList<Kisiler>()
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




        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)
        kisilerListesi.add(k5)
        kisilerListesi.add(k6)
        kisilerListesi.add(k7)
        kisilerListesi.add(k8)
        kisilerListesi.add(k9)
        kisilerListesi.add(k10)
        kisilerListesi.add(k11)
        kisilerListesi.add(k12)
        kisilerListesi.add(k13)
        kisilerListesi.add(k14)
        kisilerListesi.add(k15)
        kisilerListesi.add(k16)
        kisilerListesi.add(k17)
        kisilerListesi.add(k18)
        kisilerListesi.add(k19)
        kisilerListesi.add(k20)

        val adapter = KisilerAdapter(requireContext(),kisilerListesi)
        tasarim.rv.adapter = adapter



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