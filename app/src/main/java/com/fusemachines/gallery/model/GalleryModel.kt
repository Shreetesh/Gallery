package com.fusemachines.gallery.model

import com.fusemachines.gallery.GalleryContract
import com.fusemachines.gallery.api.RestApi
import com.fusemachines.gallery.model.data.GalleryDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryModel : GalleryContract.GalleryModel{

    override fun getGalleryFromApi(listener: GalleryContract.ModelListener) {
        val response = RestApi.RestApi().getFlower()

        response.enqueue(object : Callback<List<GalleryDetail>> {

            override fun onFailure(call: Call<List<GalleryDetail>>?, t: Throwable?) {
                listener.onError(t?.message.toString())
            }

            override fun onResponse(call: Call<List<GalleryDetail>>?, response: Response<List<GalleryDetail>>?) {
                listener.onSuccess(response!!.body()!!.toList())

            }

        })

    }

}