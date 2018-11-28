package com.fusemachines.gallery.presenter

import com.fusemachines.gallery.GalleryContract
import com.fusemachines.gallery.model.data.GalleryDetail

class GalleryDetailPresenter(val galleryView:GalleryContract.GalleryView,val galleryModel:GalleryContract.GalleryModel) : GalleryContract.GalleryPresenter,GalleryContract.ModelListener{
    override fun getGallerys() {
    galleryModel.getGalleryFromApi(this)
    }

    override fun onSuccess(list: List<GalleryDetail>) {
    galleryView.onSuccessGallery(list)
    }

    override fun onError(error: String) {
        galleryView.onErrorGallery(error)
    }

}