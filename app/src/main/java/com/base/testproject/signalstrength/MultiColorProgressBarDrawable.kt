package com.base.testproject.signalstrength

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.TypedValue

class MultiColorProgressBarDrawable(private val context: Context,
                                    private val greenColor: Int,
                                    private val yellowColor: Int,
                                    private val redColor: Int,
                                    private val grayColor: Int
) : Drawable() {

    private val greenPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val yellowPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val redPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val grayPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        greenPaint.color = greenColor
        yellowPaint.color = yellowColor
        redPaint.color = redColor
        grayPaint.color = grayColor
    }

//    override fun draw(canvas: Canvas) {
//        val width = bounds.width().toFloat()
//        val height = bounds.height().toFloat()
//        val progressGreen = 40f
//        val greenSize = (width * progressGreen) / 100f
//        val progressYellow = 20f
//        val yellowSize = (width * progressYellow) / 100f
//        val progressRed = 15f
//        val redSize = (width * progressRed) / 100f
//        val progressGray = 5f
//        val graySize = (width * progressGray) / 100f
//        val remainingProgress = 100f - (progressGreen + progressYellow + progressRed + progressGray)
//        val remainingSize = (width * remainingProgress) / 100f
//        val cornerRadius = TypedValue.applyDimension(
//            TypedValue.COMPLEX_UNIT_DIP,
//            2f,
//            context.resources.displayMetrics
//        )
//
//        // Draw green progress
//        canvas.drawRoundRect(
//            0f, 0f, greenSize, height, cornerRadius, cornerRadius, greenPaint
//        )
//
//        // Draw yellow progress
//        canvas.drawRoundRect(
//            greenSize, 0f, greenSize + yellowSize, height, 0f, 0f, yellowPaint
//        )
//
//        // Draw red progress
//        canvas.drawRoundRect(
//            greenSize + yellowSize, 0f, greenSize + yellowSize + redSize, height, 0f, 0f, redPaint
//        )
//
//        // Draw gray progress
//        canvas.drawRoundRect(
//            greenSize + yellowSize + redSize, 0f, greenSize + yellowSize + redSize + graySize, height, 0f, 0f, grayPaint
//        )
//
//        // Draw remaining progress
//        canvas.drawRoundRect(
//            greenSize + yellowSize + redSize + graySize, 0f, width, height, cornerRadius, cornerRadius, grayPaint
//        )
//    }

    override fun draw(canvas: Canvas) {
        val width = bounds.width().toFloat()
        val height = bounds.height().toFloat()
        val sectionSize = width / 4f
        val cornerRadius = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            2f,
            context.resources.displayMetrics
        )

        // Draw red progress
        canvas.drawRoundRect(
            0f, 0f, sectionSize, height, cornerRadius, cornerRadius,
            greenPaint
        )

        // Draw yellow progress
        canvas.drawRoundRect(
            sectionSize, 0f, sectionSize * 2f, height, cornerRadius, cornerRadius,
            yellowPaint
        )

        // Draw blue progress
        canvas.drawRoundRect(
            sectionSize * 2f, 0f, sectionSize * 3f, height, cornerRadius, cornerRadius,
            redPaint
        )

        // Draw green progress
        canvas.drawRoundRect(
            sectionSize * 3f, 0f, sectionSize * 4f, height, cornerRadius, cornerRadius,
            grayPaint
        )

    }
    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(colorFilter: ColorFilter?) {}

    override fun getOpacity(): Int = PixelFormat.OPAQUE
}