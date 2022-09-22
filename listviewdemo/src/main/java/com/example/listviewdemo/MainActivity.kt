package com.example.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.list_item, fruitList)
        listView.adapter = adapter
    }

    private fun initFruits() {
        repeat(10) {
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Banana", R.drawable.banana))
            fruitList.add(Fruit("Cherry", R.drawable.cherry))
        }
    }
}