package com.homeng.canvas.path

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.homeng.canvas.R

class CanvasPathActivity : Activity(),View.OnClickListener {
    var canvas = Canvas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path)

    }



    override fun onClick(view : View) {
        var  textView = view as TextView
        Log.d("liuhq", textView.text.toString() +" click ")

        var intent = Intent()
        intent.component = ComponentName(this,"com.homeng.canvas.ShowViewActivity")
        intent.putExtra("type",view.text)
        this.startActivity(intent)
    }

}
