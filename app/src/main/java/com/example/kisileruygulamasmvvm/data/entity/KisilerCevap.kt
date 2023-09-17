package com.example.kisileruygulamasmvvm.data.entity

import com.google.gson.annotations.SerializedName

data class KisilerCevap(@SerializedName("kisiler") var kisiler:List<Kisiler>,
                        @SerializedName("succes")var success:Int) {
}