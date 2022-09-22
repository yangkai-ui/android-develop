package com.example.arraylist

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private var mData: MutableList<Animal>? = null
    private var mContext: Context? = null
    private var mAdapter: AnimalAdapter? = null
    private var list_animal: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this@MainActivity
        list_animal = findViewById(R.id.list_animal)
        mData = LinkedList<Animal>()
        mData!!.add(Animal("狗说", "你是狗么?", R.mipmap.dog))
        mData!!.add(Animal("牛说", "你是牛么?", R.mipmap.cow))
        mData!!.add(Animal("鸭说", "你是鸭么?", R.mipmap.duck))
        mData!!.add(Animal("鱼说", "你是鱼么?", R.mipmap.fish))
        mData!!.add(Animal("马说", "你是马么?", R.mipmap.horse))
        mAdapter = AnimalAdapter((mData as LinkedList<Animal>?)!!, mContext as MainActivity)
        list_animal!!.adapter = mAdapter
    }
}