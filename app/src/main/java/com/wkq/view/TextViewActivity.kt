package com.wkq.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wkq.view.databinding.ActivityTextviewBinding


/**
 * @author wkq
 *
 * @date 2021年12月07日 14:21
 *
 *@des
 *
 */

class TextViewActivity : AppCompatActivity() {
    var binding: ActivityTextviewBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityTextviewBinding>(this, R.layout.activity_textview)

        binding!!.bt.setOnClickListener {
           var ssr= binding!!.et.text.toString()

            binding!!.tvColor.setTextSpan(ssr,"123456我的测试???1234")
        }
    }
}