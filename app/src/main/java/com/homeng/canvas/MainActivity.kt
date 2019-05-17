package com.homeng.canvas


import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick


class MainActivity : AppCompatActivity() {

    @BindView(R.id.canvas_path) lateinit var mpath : TextView

    @OnClick(R.id.canvas_path)
    fun onClick(view : View) {
        when(view.id) {
            R.id.canvas_path ->{
                var canvasPath  = Intent()
                var comName = ComponentName("com.homeng.canvas", "com.homeng.canvas.path.CanvasPathActivity");
                canvasPath.component = comName
                startActivity(canvasPath)

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }
}
