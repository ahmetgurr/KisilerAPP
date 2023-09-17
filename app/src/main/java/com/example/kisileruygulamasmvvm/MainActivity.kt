package com.example.kisileruygulamasmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

/*
*******Retrofit********,
* Android uygulamalarında kullanılan kütüphanedir
* Web servislerine bağlanmak için kullanılır
* Applicaton Programming Interface (API) = Uygulama Programlama Arayüzü
* Htto ve Https protokollerini kullanarak web servislerine bağlanmamızı sağlar
* kullandıgımız api http ile başlıyorsa 
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}