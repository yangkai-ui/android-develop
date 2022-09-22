package com.example.arraylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.arraylist.Animal
import java.util.*


class AnimalAdapter(mData: LinkedList<Animal>, mContext: Context) : BaseAdapter() {
    private val mData: LinkedList<Animal>
    private val mContext: Context

    init {
        this.mData = mData
        this.mContext = mContext
    }
    
    override fun getCount(): Int {
        return mData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup?): View {
        var convertView: View = convertView
        convertView =
            LayoutInflater.from(mContext).inflate(R.layout.item_list_animal, parent, false)
        val img_icon: ImageView = convertView.findViewById(R.id.img_icon) as ImageView
        val txt_aName: TextView = convertView.findViewById(R.id.txt_aName) as TextView
        val txt_aSpeak: TextView = convertView.findViewById(R.id.txt_aSpeak) as TextView
        img_icon.setBackgroundResource(mData[position].aIcon)
        txt_aName.text = mData[position].aName
        txt_aSpeak.text = mData[position].aSpeak
        return convertView
    }


}