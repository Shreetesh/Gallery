package com.fusemachines.gallery.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fusemachines.gallery.model.data.GalleryDetail

class ActivityGallery : AppCompatActivity() {
    var imageUrl="http://services.hanselandpetal.com/photos/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_detail)
        var gallery = intent.getSerializableExtra("Flower") as GalleryDetail

    }

}