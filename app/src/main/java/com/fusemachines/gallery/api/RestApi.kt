package com.fusemachines.gallery.api

import com.fusemachines.gallery.model.data.GalleryDetail
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class RestApi {
    companion object {
        fun RestApi():RestApi.RequestAPI{
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://services.hanselandpetal.com/feeds/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            return retrofit.create(RequestAPI::class.java)
        }
    }

    interface RequestAPI {

        @GET("flowers.json")
        fun getFlower(): Call<List<GalleryDetail>>

    }
}

