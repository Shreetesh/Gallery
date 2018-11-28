package com.fusemachines.gallery

import com.fusemachines.gallery.model.data.GalleryDetail

interface GalleryContract {
    interface GalleryPresenter{
        fun getGallerys()
    }

    interface GalleryView{
        fun onSuccessGallery( list: List<GalleryDetail>)
        fun onErrorGallery( error: String)

    }

    interface GalleryModel{
        fun getGalleryFromApi( listener:ModelListener)
    }

    interface ModelListener{
        fun onSuccess( list: List<GalleryDetail>)
        fun onError( error: String)
    }
}