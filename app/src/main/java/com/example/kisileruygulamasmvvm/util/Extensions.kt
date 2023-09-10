package com.example.kisileruygulamasmvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(id:Int, it: View) {
    findNavController(it).navigate(id)
}
//aynı baslık altında gecisYap fonksiyonunu oluşturduk, buradaki amaç ihtiyacımız doğrultusunda gerekli fonksiyonu kullanmak.
fun Navigation.gecisYap(it: View,id: NavDirections){
    findNavController(it).navigate(id)
}