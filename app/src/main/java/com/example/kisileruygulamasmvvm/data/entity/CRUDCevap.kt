package com.example.kisileruygulamasmvvm.data.entity

import com.google.gson.annotations.SerializedName

data class CRUDCevap(@SerializedName("succes") var success:Int,
                     @SerializedName("message")var message:String){
}