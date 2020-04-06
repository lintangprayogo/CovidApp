package com.rplgdc.covidapp.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rplgdc.covidapp.base.data.model.Country
import com.rplgdc.covidapp.base.ui.BaseHolder
import com.rplgdc.covidapp.base.ui.BaseRecylerViewAdapter
import kotlinx.android.synthetic.main.location_layout.view.*
import java.text.NumberFormat
import java.util.*

class CountryAdapter : BaseRecylerViewAdapter<Country, CountryAdapter.CountryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val holder = CountryHolder(
            LayoutInflater.from(mContext).inflate(mLayout, parent, false)
        )
        return holder
    }

    inner class CountryHolder(view: View) : BaseHolder<Country>(view) {
        override fun bindData(data: Country) {
            val nf = NumberFormat.getInstance(Locale.ENGLISH)
            val confirmedVal = data.totalConfirmed
            val curedVal = data.totalRecovered
            val deathVal = data.totalDeaths
            itemView.country.text=data.slug
            itemView.death.text = nf.format(deathVal)
            itemView.cured.text = nf.format(curedVal)
            itemView.confirm.text = nf.format(confirmedVal)
            val imgUrl = "https://www.countryflags.io/${data.countryCode}/shiny/64.png"
            Glide.with(itemView.flag).load(imgUrl).into(itemView.flag)

        }
    }


}