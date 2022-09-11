package com.example.shiyan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit(getRandomLengthString("Apple"),R.drawable.apple))
            fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana))
            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry))
            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape))
            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple))
            fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon))

        }
    }
    private fun getRandomLengthString(str:String):String{
        val n =(1..20).random()
        val builder = StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }

}