package com.homeng.canvas

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.homeng.canvas.path.PathUtils

class ShowViewActivity : Activity() {

    lateinit var mShowBitmap : Bitmap

    //@BindView(R.id.show_view) lateinit var mShowImageView : ImageView
    lateinit var mShowImageView :ShowImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pathType = intent.getStringExtra("type")

        mShowImageView= ShowImageView(this,PathUtils.getPath(pathType))
        mShowImageView.minimumWidth = 1024
        mShowImageView.minimumHeight= 2560

        setContentView(mShowImageView)
        //setContentView(R.layout.activity_show_view)
        //ButterKnife.bind(this)
        //mShowImageView.setImageBitmap(PathUtils.getBitmap(pathType))
    }


}