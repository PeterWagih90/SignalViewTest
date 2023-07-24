package com.base.testproject

import android.content.Context
import androidx.annotation.ColorInt
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand
import com.beardedhen.androidbootstrap.utils.ColorUtils


data class CustomBootstrapBrand(val textColorM: Int = android.R.color.white,
                                val colorM: Int) : BootstrapBrand {

    @ColorInt
    override fun defaultFill(context: Context): Int {
        return ColorUtils.resolveColor(colorM, context)
    }

    @ColorInt
    override fun defaultEdge(context: Context): Int {
        return ColorUtils.decreaseRgbChannels(context, colorM, ColorUtils.ACTIVE_OPACITY_FACTOR_EDGE)
    }

    @ColorInt
    override fun activeFill(context: Context): Int {
        return ColorUtils.decreaseRgbChannels(context, colorM, ColorUtils.ACTIVE_OPACITY_FACTOR_FILL)
    }

    @ColorInt
    override fun activeEdge(context: Context): Int {
        return ColorUtils.decreaseRgbChannels(
            context,
            colorM,
            ColorUtils.ACTIVE_OPACITY_FACTOR_FILL + ColorUtils.ACTIVE_OPACITY_FACTOR_EDGE
        )
    }

    @ColorInt
    override fun disabledFill(context: Context): Int {
        return ColorUtils.increaseOpacity(context, colorM, ColorUtils.DISABLED_ALPHA_FILL)
    }

    @ColorInt
    override fun disabledEdge(context: Context): Int {
        return ColorUtils.increaseOpacity(
            context,
            colorM,
            ColorUtils.DISABLED_ALPHA_FILL - ColorUtils.DISABLED_ALPHA_EDGE
        )
    }

    @ColorInt
    override fun defaultTextColor(context: Context): Int {
        return ColorUtils.resolveColor(textColorM, context)
    }

    @ColorInt
    override fun activeTextColor(context: Context): Int {
        return ColorUtils.resolveColor(textColorM, context)
    }

    @ColorInt
    override fun disabledTextColor(context: Context): Int {
        return ColorUtils.resolveColor(textColorM, context)
    }

    override fun getColor(): Int {
        return colorM
    }

}