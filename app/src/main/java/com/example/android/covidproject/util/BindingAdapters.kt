package com.example.android.covidproject.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.covidproject.network.data.Country
import com.example.android.covidproject.ui.main.MainAdapter

@BindingAdapter("listCountries")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}

@BindingAdapter("setNumberCases")
fun bindNumberCases(textview: TextView, cases: Int?)
{
    if(cases != null)
    {
        val caseSet = "Current cases: $cases"
        textview.text = caseSet
    }
    else
    {
        textview.text = "No current cases!"
    }
}

@BindingAdapter("setNumberNewCases")
fun bindNumberNewCases(textview: TextView, cases: String?)
{
    if(cases != null)
    {
        val caseSet = "New cases: $cases"
        textview.text = caseSet
    }
    else
    {
        textview.text = "No new cases!"
    }
}

@BindingAdapter("setNumberTotalCases")
fun bindNumberTotalCases(textview: TextView, cases: Int?)
{
    if(cases != null)
    {
        val caseSet = "Total cases: $cases"
        textview.text = caseSet
    }
    else
    {
        textview.text = "No cases!"
    }
}

@BindingAdapter("setNumberDeaths")
fun bindNumberDeaths(textview: TextView, cases: Int?)
{
    if(cases != null)
    {
        val caseSet = "Deaths: $cases"
        textview.text = caseSet
    }
    else
    {
        textview.text = "No deaths!"
    }
}

@BindingAdapter("setPopulation")
fun bindPopulation(textview: TextView, cases: Int?)
{
    if(cases != null)
    {
        val caseSet = "Population: $cases"
        textview.text = caseSet
    }
    else
    {
        textview.text = "No population data."
    }
}
