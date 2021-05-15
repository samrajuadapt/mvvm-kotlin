package com.samboy.map.utils

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * Created by Sam Raju on 5/1/21.
 */

fun Context.loge(msg:String){
    Log.e(this.className(), msg )
}
fun ViewModel.loge(msg:String){
    Log.e(this.className(), msg )
}


fun Any.className():String{
    return this.javaClass.simpleName.toUpperCase(Locale.ROOT)
}