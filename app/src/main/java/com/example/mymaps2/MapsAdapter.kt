package com.example.mymaps2

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymaps2.models.UserMap
import android.os.SystemClock

import android.view.animation.BounceInterpolator
import android.view.animation.Interpolator

import com.google.android.gms.maps.model.Marker




private const val TAG ="MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface  OnClickListener {
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener{
            Log.i(TAG, "tapped on position $position")
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTitle)
        //val textViewNumber = holder.itemView.findViewById<TextView>(R.id.tvNumber)

        textViewTitle.text = userMap.title
        //textViewNumber.text = userMap.places.size.toString()

    }


    override fun getItemCount() = userMaps.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
