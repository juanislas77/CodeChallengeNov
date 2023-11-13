package com.islas.codechallengenov.domain.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.islas.codechallengenov.R
import com.islas.codechallengenov.data.mappers.Result

import com.squareup.picasso.Picasso

class MyListAdapter(
    private val context: Activity,
    private val characterList: ArrayList<Result>,
    private val onClickListener: (detail: Result) -> Unit
) : ArrayAdapter<Result>(context, R.layout.list_item,characterList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item,null)
        val currentItem = characterList[position]

        val patchView: ImageView = view.findViewById(R.id.character_image)
        val launchMission: TextView = view.findViewById(R.id.character_title)
        val launchDate: TextView = view.findViewById(R.id.character_description)

        if(currentItem.thumbnail.path.isNotEmpty()){
            Picasso.get()
                .load(currentItem.thumbnail.path)
                .into(patchView)
        } else {
            Picasso.get()
                .load(R.drawable.patch_default)
                .into(patchView)
        }
        launchMission.text = currentItem.name
        launchDate.text = currentItem.description

        view.setOnClickListener {
            onClickListener.invoke(currentItem)
        }

        return view
    }
}