package com.base.testproject

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class ProgressBarView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var progress = 0
    private val segmentColors = intArrayOf(
        Color.rgb(244, 67, 54),
        Color.rgb(255, 87, 34), // Orange
        Color.rgb(139, 195, 74), // light green
        Color.rgb(76, 175, 80)//green
    )

    private val segmentPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        // Set up paint properties
        segmentPaint.style = Paint.Style.FILL
        backgroundPaint.color = Color.LTGRAY
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    /*override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        // Calculate segment width
        val segmentWidth = width.toFloat() / segmentColors.size

        // Draw segments
        for (i in segmentColors.indices) {
            val segmentLeft = i * segmentWidth
            val segmentRight = (i + 1) * segmentWidth
            segmentPaint.color = segmentColors[i]
            canvas.drawRect(segmentLeft, 0f, segmentRight, height.toFloat(), segmentPaint)
        }

        // Draw progress indicator
        val progressLeft = (progress).toFloat() / 100 * width
        canvas.drawRect(progressLeft, 0f, width.toFloat(), height.toFloat(), backgroundPaint)
    }*/

//gradient
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        // Create gradient
        val gradient = LinearGradient(
            0f, 0f, width.toFloat(), 0f,
            segmentColors, null, Shader.TileMode.CLAMP
        )

        // Set segment paint color to gradient
        segmentPaint.shader = gradient

        // Calculate segment width
        val segmentWidth = width.toFloat() / segmentColors.size

        // Draw segments
        for (i in segmentColors.indices) {
            val segmentLeft = i * segmentWidth
            val segmentRight = (i + 1) * segmentWidth
            canvas.drawRect(segmentLeft, 0f, segmentRight, height.toFloat(), segmentPaint)
        }

        // Draw progress indicator
        val progressLeft = (progress).toFloat() / 100 * width
        canvas.drawRect(progressLeft, 0f, width.toFloat(), height.toFloat(), backgroundPaint)
    }


    fun setProgress(progress: Int) {
        this.progress = progress.coerceIn(0, 100)
        invalidate()
    }

}