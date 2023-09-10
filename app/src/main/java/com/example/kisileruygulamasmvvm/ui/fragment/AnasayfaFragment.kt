package com.example.kisileruygulamasmvvm.ui.fragment

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
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasmvvm.R
import com.example.kisileruygulamasmvvm.data.entity.Kisiler
import com.example.kisileruygulamasmvvm.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasmvvm.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasmvvm.util.gecisYap
import com.example.kisileruygulamasmvvm.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasmvvm.viewmodel.KisiDetayViewModel

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        tasarim.anasayfaFragment = this

        tasarim.anasayfaToolbarBaslik = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

/*
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Helin","2222")
        val k3 = Kisiler(3,"Orcan","444")
        val k5 = Kisiler(4,"Döne","7777")
        val k6 = Kisiler(4,"Büşra","6666")
        val k7 = Kisiler(4,"Nazlıcan","0000")
        val k8 = Kisiler(4,"Türkan","8598")
        val k9 = Kisiler(4,"Can","85847")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k5)
        kisilerListesi.add(k6)
        kisilerListesi.add(k7)
        kisilerListesi.add(k8)
        kisilerListesi.add(k9)
 */


        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            //viewModel ekledik
            // Kisiler adapterda ne ekeldiysek burada belirtmemiz lazım o yuzden kiislerlistesini de viewmodeli de o yüzden ekledik
            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            tasarim.kisilerAdapter = adapter
        }




        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

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

    //sayfa başındaki onCreate'in içine yazmayacaksın
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels ()
        viewModel = tempViewModel
    }
    fun fabTikla(it:View){
        //navigationu defalarca kullanacagımzı zaman tek tek yazmak yerıne util'in altında Extension oluşturduk>>
        // << ve Navigation.gecisYap(R.id.kisiKayitGecis,it) yazarak oradan çekiyoruz.
        //Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        Navigation.gecisYap(R.id.kisiKayitGecis,it)

    }

    //SearchView.OnQueryTextListener kısmını implement ettiğimiz yer
    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }
/*
    //iki yerde de aynı işlevi kullanacagımız için fonsıyon olsuturduk searchviewle Implement ettımgımzı yerlerde kullanacagız.
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }
//gereksiz oldu kaldırdık

 */
    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa", "Dönüldü")
    }

}