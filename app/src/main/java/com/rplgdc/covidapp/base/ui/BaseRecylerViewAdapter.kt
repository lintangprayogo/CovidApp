package com.rplgdc.covidapp.base.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecylerViewAdapter<T, Holder : BaseHolder<T>> : RecyclerView.Adapter<Holder>() {
    private val dataList: MutableList<T> = mutableListOf()
    protected lateinit var mContext: Context
    protected var mLayout: Int = 0
    protected lateinit var mListener: (T) -> Unit


     fun setLayout(layout: Int, context: Context) {
        mLayout = layout
        mContext = context
    }

   fun setListener(listner: (T) -> Unit) {
        mListener = listner
    }


    fun addData(data: List<T>) {
        destroyData()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    fun destroyData() {
        dataList.removeAll(dataList)

    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(dataList[position])
    }
}