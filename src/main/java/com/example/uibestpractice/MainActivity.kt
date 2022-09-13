package com.example.uibestpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null
//    var msgType: Int = Msg.TYPE_SENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        send.setOnClickListener(this)
        titleList.setOnClickListener(this)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.change_account -> {
//                if (msgType == Msg.TYPE_SENT) {
//                    msgType = Msg.TYPE_RECEIVED
//                    inputText.setText("")
//                    Toast.makeText(this, "已切换当前账号为响子", Toast.LENGTH_SHORT).show()
//                } else {
//                    msgType = Msg.TYPE_SENT
//                    inputText.setText("")
//                    Toast.makeText(this, "已切换当前账号为米斯蒂娅", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//        return true
//    }

    private fun initMsg() {
        val msg1 = Msg("Hello.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Kasodani Kyouko. Nice talking to you.", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.msgType)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1)//当有新消息时，刷新显示信息
                    recyclerView.scrollToPosition(msgList.size - 1)//定位页面道消息最后一行
                    inputText.setText("")
                }
            }
            titleList -> {
                val intent = Intent(this, ChangeAccountActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {

                if (Msg.msgType == 1) {
                    titleText.text = "幽谷响子"
                    titleText.setTextColor(ContextCompat.getColor(this,R.color.green))
                    Toast.makeText(this, "已切换当前账号为米斯蒂娅", Toast.LENGTH_SHORT).show()
                } else {
                    titleText.text = "米斯蒂娅"
                    titleText.setTextColor(ContextCompat.getColor(this,R.color.pink))
                    Toast.makeText(this, "已切换当前账号为幽谷响子", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}