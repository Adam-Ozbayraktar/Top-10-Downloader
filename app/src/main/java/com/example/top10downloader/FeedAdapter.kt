package com.example.top10downloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ViewHolder(v: View) {
    val tvName: TextView = v.findViewById(R.id.tvName)
    val tvArtist: TextView = v.findViewById(R.id.tvArtist)
    val tvNumber: TextView = v.findViewById(R.id.tvNumber)
    val imageDisplay: ImageView = v.findViewById(R.id.imageDisplay)
//    val tvSummary: TextView = v.findViewById(R.id.tvSummary)
}


class FeedAdapter(
    context: Context,
    private val resource: Int,
    private val applications: List<FeedEntry>
) :
    ArrayAdapter<FeedEntry>(context, resource) {
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


//        val tvName: TextView = view.findViewById(R.id.tvName)
//        val tvArtist: TextView = view.findViewById(R.id.tvArtist)
//        val tvSummary: TextView = view.findViewById(R.id.tvSummary)

        val currentApp = applications[position]
        val numberDisplay = "${position + 1}"
        viewHolder.tvName.text = currentApp.name
        viewHolder.tvArtist.text = currentApp.artist
        viewHolder.tvNumber.text = numberDisplay
        Picasso
            .get()
            .load(currentApp.imageURL)
            .into(viewHolder.imageDisplay)
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into((imageView) imageDisplay)
//        viewHolder.tvSummary.text = currentApp.summary

        return view
    }

    override fun getCount(): Int {
        return applications.size
    }
}