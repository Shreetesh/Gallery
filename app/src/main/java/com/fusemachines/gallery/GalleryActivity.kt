package com.fusemachines.gallery

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.fusemachines.gallery.GalleryContract.GalleryPresenter
import com.fusemachines.gallery.adapter.GalleryAdapter
import com.fusemachines.gallery.model.GalleryModel
import com.fusemachines.gallery.model.data.GalleryDetail
import kotlinx.android.synthetic.main.rv_gallery.*


class GalleryActivity : AppCompatActivity(),GalleryContract {

    lateinit var presenter: GalleryPresenter
    lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_details)
        dialog = ProgressDialog(this)
        dialog.setMessage("Please wait")
        dialog.setTitle("Loading")
        dialog.setCancelable(false)
        dialog.isIndeterminate=true
        dialog.show()

        presenter = GalleryPresenter(this, GalleryModel())
        presenter.getGallerys()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onSuccessGallery(list: List<GalleryDetail>) {
        if (dialog.isShowing)
            dialog.dismiss()
        recyclerView.adapter = GalleryAdapter(list,{ gallery:GalleryDetail->galleryClicked(gallery)})

    }

    fun galleryClicked(gallery: GalleryDetail){
        println(gallery.name)
        var i = Intent(this, GalleryActivity::class.java)
        i.putExtra("Flower",gallery)
        startActivity(i)
    }

    override fun onErrorGallery(error: String) {
        Toast.makeText(applicationContext,error, Toast.LENGTH_LONG).show()
    }
}