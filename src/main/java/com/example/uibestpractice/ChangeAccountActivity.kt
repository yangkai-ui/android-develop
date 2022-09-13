package com.example.uibestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change_account.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title.*

class ChangeAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_account)
        change_account.setOnClickListener {
            val intent = Intent()
            if (Msg.msgType == 1) {
                Msg.msgType = 0
            } else {
                Msg.msgType = 1
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}