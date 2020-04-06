@file:Suppress("DEPRECATION")

package com.lintang.jetpackprolintang.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Helper : BaseHelper() {

    object Func {

        fun isNetworkAvailable(context: Context): Boolean? {
            var isConnected: Boolean? = false // Initial Value
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected) isConnected = true
            return isConnected
        }

        fun toDatetoString(dateStr: String, mode: String): String {
            try {
                val sourceFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                sourceFormat.timeZone = TimeZone.getTimeZone("GMT")
                val locale = Locale("in", "ID")
                val formatTujuan = SimpleDateFormat(mode, locale)
                formatTujuan.timeZone = TimeZone.getTimeZone("GMT+08:00")

                val dateTime = dateStr
                val date = sourceFormat.parse(dateTime)
                println("Date:$dateTime")
                return formatTujuan.format(date ?: "")

            } catch (e: ParseException) {
                return "-"
            }

        }

    }


}
