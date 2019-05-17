package com.homeng.canvas.path


import android.graphics.*


class PathUtils private constructor() {

    var rect = RectF(100f, 150f, 100f, 150f)
    companion object {

        private var instance: PathUtils? = null
        fun getInstance(): PathUtils {
            if (instance == null) {
                instance = PathUtils()
            }
            return instance as PathUtils
        }

        fun getBitmap(pathType: String): Bitmap {

            val path = Path()
            val paint = Paint()
            paint.color = Color.RED
            paint.strokeWidth = 5f
            paint.isAntiAlias = true

            paint.style = Paint.Style.STROKE
            val bitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            println(" path type : $pathType")
            when (pathType) {
                "lineTo" -> {
                    getInstance().lineTo(path)
                }
                "quadTo" -> {
                    getInstance().quadTo(path)
                }
                "arcTo" -> {
                    getInstance().arcTo(path)
                }
                "moveTo" -> {
                    getInstance().moveTo(path)
                }
                "cubicTo" -> {
                    getInstance().cubicTo(path)
                }
                "addRect" -> {
                    getInstance().addRect(path)
                }
                "addOval" -> {
                    getInstance().addOval(path)
                }
                "addCircle" -> {
                    getInstance().addCircle(path)
                }
                "addArc" -> {
                    getInstance().addArc(path)
                }
                "addRoundRect" -> {
                    getInstance().addRoundRect(path)
                }
                "close" -> {
                    getInstance().close(path)
                }
            }


            canvas.drawPath(path, paint)

            return bitmap
        }

        fun getPath(pathType: String): Path {

            val path = Path()
            println(" path type : $pathType")
            when (pathType) {
                "lineTo" -> {
                    getInstance().lineTo(path)
                }
                "quadTo" -> {
                    getInstance().quadTo(path)
                }
                "arcTo" -> {
                    getInstance().arcTo(path)
                }
                "moveTo" -> {
                    getInstance().moveTo(path)
                }
                "cubicTo" -> {
                    getInstance().cubicTo(path)
                }
                "addRect" -> {
                    getInstance().addRect(path)
                }
                "addOval" -> {
                    getInstance().addOval(path)
                }
                "addCircle" -> {
                    getInstance().addCircle(path)
                }
                "addArc" -> {
                    getInstance().addArc(path)
                }
                "addRoundRect" -> {
                    getInstance().addRoundRect(path)
                }
                "close" -> {
                    getInstance().close(path)
                }
            }
            return path
        }

    }

    /**
     * 方法用于从当前轮廓点绘制一条线段到x，y点
     */
    private fun lineTo(path: Path): Path {

        path.lineTo(100f, 100f)

        path.lineTo(100f, 200f)

        path.lineTo(150f, 250f)
        return path
    }

    /**
     * path的moveTo方法将起始轮廓点移至x，y坐标点，默认情况为0,0点
     */
    private fun moveTo(path: Path) {
        path.moveTo(400f,600f)
        path.lineTo(500f,800f)
    }

    /**
     * arcTo和addArc的区别:
     * 1. addArc可以直接加入一段椭圆弧。使用arcTo还需要使用moveTo指定当前点的坐标。
     * 2. arcTo如果当前点坐标和曲线的起始点不是同一个点的话，还会自动添加一条直线补齐路径。
     */
    private fun arcTo(path: Path) {
        path.moveTo(400f,400f)
        path.arcTo(rect,300f,200f)
    }

    /**
     * 使用path绘制圆形，xy为圆的圆心 radius为圆的半径，Direction 为绘制元的方向
     * Diection.CCW 逆时针方向
     * Diection.CW 顺时针方向
     */
    private fun addCircle(path: Path) {
        path.addCircle(200f,200f,300f,Path.Direction.CCW)
    }

    /**
     * 绘制椭圆，同上绘制圆的方法
     */
    private fun addOval(path: Path) {
        path.moveTo(400f,400f) // 必须移动中心点才能绘制出来
        path.addOval(rect,Path.Direction.CCW)
    }

    /**
     * 以当前路径结束点为开始点，(x1,y1)为控制点，(x2,y2)为结束点画一条二次贝塞尔曲线（相关贝赛尔曲线请再做查询）
     */
    private fun quadTo(path: Path) {
        path.moveTo(20f, 50f);

        path.lineTo(50f, 200f);

        path.quadTo(100f, 200f, 150f, 250f);
    }

    /**
     * path.addArc方法用于绘制圆弧，这个圆弧取自RectF矩形的内接椭圆上的一部分，圆弧长度由后两个参数决定
     * startAngle：起始位置的角度值
     * sweepAngle：旋转的角度值
     */
    private fun addArc(path: Path) {
        path.addArc(rect,15f,15f)
    }

    /**
     * 回到初始点形成封闭的曲线:
     */
    private fun close(path: Path) {
        path.moveTo(20f, 200f);

        path.lineTo(50f, 200f);

        path.lineTo(100f, 300f);

        path.lineTo(200f, 350f);

        path.close()
    }

    private fun addRoundRect(path: Path) {
        var radii = floatArrayOf(15f, 15f, 15f, 15f, 15f, 15f, 15f, 15f)
        path.addRoundRect(15f, 15f, 15f, 15f, 100f, 100f, Path.Direction.CCW)
    }

    /**
     * 在路径中添加一个封闭的矩形轮廓
     *
     * @param left要添加到路径的矩形的左侧
     * @param top要添加到路径的矩形的顶部
     * @param right要添加到路径的矩形的右侧
     * @param bottom要添加到路径的矩形的底部
     * @param dir缠绕矩形轮廓的方向
     */
    private fun addRect(path: Path) {
        path.moveTo(500f,500f)

        var rectF = RectF(200f,100f,500f,300f)

        path.addRect(rectF, Path.Direction.CW)
        //path.addRect(200f, 100f, 500f, 300f, Path.Direction.CW);
    }

    /**
     *从最后一点添加一个立方贝塞尔曲线，接近控制点
     *（x1，y1）和（x2，y2），并以（x3，y3）结束。 如果没有moveTo（）调用
     *为此轮廓制作，第一个点自动设置为（0,0）。
     *
     * @param x1三次曲线上第一个控制点的x坐标
     * @param y1三次曲线上第一个控制点的y坐标
     * @param x2三次曲线上第二个控制点的x坐标
     * @param y2三次曲线上第二个控制点的y坐标
     * @param x3三次曲线上终点的x坐标
     * @param y3三次曲线上终点的y坐标
     */
    private fun cubicTo(path: Path) {
        path.cubicTo(100f, 100f, 100f, 200f, 150f, 400f)
    }
}
