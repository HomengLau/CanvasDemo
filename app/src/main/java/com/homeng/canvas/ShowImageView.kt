package com.homeng.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class ShowImageView : AppCompatImageView {

    var path : Path? = null
    var paint : Paint? = null

    constructor(context: Context,path :Path) : this(context){
        this.path = path
    }
    constructor(context: Context,path :Path, paint: Paint) : this(context){
        this.path = path
        this.paint = paint
    }

    constructor(context: Context) : super(context) {
        println("ShowImageView : 1")
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        println("ShowImageView : 2")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        println("ShowImageView : 3")
    }

    override fun drawableStateChanged() {
        println("drawableStateChanged : ")
        super.drawableStateChanged()
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        println("onCreateDrawableState : ")
        return super.onCreateDrawableState(extraSpace)

    }

    override fun onRtlPropertiesChanged(layoutDirection: Int) {
        println("onRtlPropertiesChanged : ")
        super.onRtlPropertiesChanged(layoutDirection)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        println("onMeasure : ")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        println("onDraw : ")
        if (paint == null){
            paint = Paint()
            paint!!.color = Color.RED
            paint!!.strokeWidth = 5f
            paint!!.isAntiAlias = true
            paint!!.style = Paint.Style.STROKE
        }
        canvas.drawPath(path,paint)
        super.onDraw(canvas)
    }

    override fun onVisibilityAggregated(isVisible: Boolean) {
        println(" onVisibilityAggregated : ")
        super.onVisibilityAggregated(isVisible)
    }

    override fun onAttachedToWindow() {
        println("onAttachedToWindow : ")
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        println("onDetachedFromWindow : ")
        super.onDetachedFromWindow()

    }
}
