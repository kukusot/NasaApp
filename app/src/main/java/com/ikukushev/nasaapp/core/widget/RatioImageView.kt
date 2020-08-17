package com.ikukushev.nasaapp.core.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.ikukushev.nasaapp.R

class RatioImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attributeSet, defStyleAttr) {

    private var _measuredWidth: Int = 0
    var ratio: Float = defaultRatio
        set(value) {
            field = value
            invalidate()
        }

    init {
        val attrSet = context.obtainStyledAttributes(attributeSet, R.styleable.RatioImageView)
        with(attrSet) {
            ratio = attrSet.getFloat(R.styleable.RatioImageView_ratio, defaultRatio)
            recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        _measuredWidth = MeasureSpec.getSize(widthMeasureSpec)
        val ratioHeight = (_measuredWidth * ratio).toInt()
        setMeasuredDimension(_measuredWidth, ratioHeight)
    }

    companion object {
        const val defaultRatio = 1.0f
    }

}