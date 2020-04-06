package com.rplgdc.covidapp.base.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    open fun bindData(data: T) {}
}