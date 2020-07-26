package com.mcnmr.utilities.extension

import android.widget.TextView
import com.mcnmr.utilities.extension.isNotEmptyOrNotNull

fun TextView.error(message: String?){
    if(!message.isNotEmptyOrNotNull()){
        this.text = ""
        gone()
    }else {
        this.text = message
        setTextColor(this.context.getCompatColor(android.R.color.holo_red_light))
        visible()
    }
}