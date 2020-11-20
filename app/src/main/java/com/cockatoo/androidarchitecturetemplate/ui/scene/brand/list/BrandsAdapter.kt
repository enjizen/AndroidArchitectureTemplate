package com.cockatoo.androidarchitecturetemplate.ui.scene.brand.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.cockatoo.androidarchitecturetemplate.R
import com.cockatoo.androidarchitecturetemplate.model.Brand
import kotlinx.android.synthetic.main.item_brand_list.view.*

class BrandsAdapter(private val brandList: ArrayList<Brand>?) : RecyclerView.Adapter<BrandsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_brand_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        brandList?.let { brand ->
            brand[position].let {
                with(holder) {
                    name.text = it.nameEnglish
                }
            }
        }
    }

    override fun getItemCount(): Int = brandList?.size ?: 0

    fun updateData(brandList: List<Brand>?) {
        this.brandList?.clear()
        brandList?.let { this.brandList?.addAll(it.sortedBy { brand -> brand.nameEnglish }) }
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: AppCompatTextView = view.brandNameTextView
    }
}