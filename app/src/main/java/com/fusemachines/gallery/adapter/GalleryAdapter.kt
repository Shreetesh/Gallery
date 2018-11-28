package com.fusemachines.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fusemachines.gallery.model.data.GalleryDetail

class GalleryAdapter (val gallery:List<GalleryDetail>, val itemclickListener: (GalleryDetail) -> Unit):RecyclerView.Adapter<GalleryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_gallery_list,parent,false))
    }

    override fun getItemCount(): Int {
        return  gallery.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gallery.get(position),itemclickListener)
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){


    }

}