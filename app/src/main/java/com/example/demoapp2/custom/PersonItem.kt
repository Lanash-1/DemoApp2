package com.example.demoapp2.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class PersonItem(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        val childCount = childCount
        var prevChildRight = 0
        var prevChildBottom = 0
        for(i in 0 until childCount){
            val child: View = getChildAt(i)
            child.layout(prevChildRight, prevChildBottom, prevChildRight+child.measuredWidth, prevChildBottom+child.measuredHeight)
            prevChildRight += child.measuredWidth
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var totalWidth = 0
        var totalHeight = 0
        val childCount = childCount

        for(i in 0 until childCount){
            val child: View = getChildAt(i)
            child.setPadding(20,0,20,0)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            totalWidth += child.measuredWidth
            if(child.measuredHeight > totalHeight){
                totalHeight = child.measuredHeight
            }
        }

        setMeasuredDimension(totalWidth, totalHeight)
    }
}