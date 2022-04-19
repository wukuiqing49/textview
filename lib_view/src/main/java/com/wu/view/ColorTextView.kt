package com.wu.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.util.regex.Pattern


/**
 * @author wkq
 *
 * @date 2022年04月19日 11:26
 *
 *@des
 *
 */

class ColorTextView : AppCompatTextView {
    constructor(mContext: Context) : this(mContext, null)
    constructor(mContext: Context, mAttributeSet: AttributeSet?) : this(mContext, mAttributeSet, 0)
    constructor(mContext: Context, mAttributeSet: AttributeSet?, defStyleAttr: Int) : super(
        mContext,
        mAttributeSet,
        defStyleAttr
    ) {
        //初始换数据
        initAttributeSet(mAttributeSet!!)
        initView()

    }

    private fun initView() {

        this.setTextColor(mTextColor)
    }

    var highColor = 0
    var mTextColor = 0

    @SuppressLint("ResourceAsColor")
    fun initAttributeSet(mAttributeSet: AttributeSet) {

        val array: TypedArray = context!!.obtainStyledAttributes(
            mAttributeSet,
            R.styleable.ColorTextView
        )
        //文字颜色
        mTextColor =
            array.getColor(R.styleable.ColorTextView_color_text_color, R.color.color_text_color)
        //高亮颜色
        highColor = array.getColor(
            R.styleable.ColorTextView_color_high_light_text_color,
            R.color.color_text_high_color
        )
        array.recycle()
    }


    fun setTextSpan(keywords: String?, orgS: String?) {
        val s = SpannableString(orgS)
        if (keywords == null) {
            this.text = orgS
            return
        }
        var start = orgS!!.indexOf(keywords)
        if (start == -1) {
            this.text = orgS
        } else {
            var end = start + keywords.length
            s.setSpan(
                ForegroundColorSpan(highColor),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        setText(s)
    }


}