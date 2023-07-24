package com.base.testproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SignalStrengthView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var segmentCount = 1
    private var segmentColors = intArrayOf(Color.GREEN)
    private var signalStrength = 0

    private val segmentPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        // Load custom attributes from XML
        val a = context.obtainStyledAttributes(attrs, R.styleable.SignalStrengthView)
        segmentCount = a.getInt(R.styleable.SignalStrengthView_segmentCount, 1)
        segmentColors = IntArray(segmentCount)
        for (i in 0 until segmentCount) {
            segmentColors[i] = when (i) {
                0 -> a.getColor(R.styleable.SignalStrengthView_segmentColor_0, Color.RED)
                1 -> a.getColor(R.styleable.SignalStrengthView_segmentColor_1, Color.YELLOW)
                2 -> a.getColor(R.styleable.SignalStrengthView_segmentColor_2, Color.CYAN)
                3 -> a.getColor(R.styleable.SignalStrengthView_segmentColor_3, Color.GREEN)
                else -> a.getColor(R.styleable.SignalStrengthView_segmentColor_3, Color.GREEN)
            }
        }
        a.recycle()

        // Set up paint properties
        segmentPaint.style = Paint.Style.FILL
        backgroundPaint.color = Color.LTGRAY
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        // Calculate segment width
        val segmentWidth = width.toFloat() / segmentCount

        // Draw segments
        for (i in 0 until segmentCount) {
            val segmentLeft = i * segmentWidth
            val segmentRight = (i + 1) * segmentWidth
            segmentPaint.color = segmentColors[i]
            canvas.drawRect(segmentLeft, 0f, segmentRight, height.toFloat(), segmentPaint)
        }

        // Draw signal strength indicator
        val signalStrengthLeft = signalStrength * segmentWidth
        val signalStrengthRight = (signalStrength + 1) * segmentWidth
        canvas.drawRect(
            signalStrengthLeft,
            0f,
            signalStrengthRight,
            height.toFloat(),
            backgroundPaint
        )
    }

    fun setSignalStrength(strength: Int) {
        signalStrength = strength.coerceIn(0, segmentCount - 1)
        invalidate()
    }

    fun setSegmentCount(count: Int) {
        segmentCount = count
        segmentColors = IntArray(segmentCount) { i -> segmentColors.getOrElse(i, { Color.GREEN }) }
        invalidate()
    }

    fun setSegmentColors(vararg colors: Int) {
        segmentCount = colors.size
        segmentColors = colors
        invalidate()
    }

}