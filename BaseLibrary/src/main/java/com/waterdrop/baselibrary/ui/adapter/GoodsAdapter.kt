package com.waterDrop.baselibrary.ui.adapter

/**
 * Created by payne on 8/6/20.
 * ClassName:GoodsAdapter
 * Description: 商品数据绑定
 */

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.waterDrop.baselibrary.model.RecyclerInfo
import com.waterdrop.baselibrary.R

class GoodsAdapter(
    private val listGoods: ArrayList<RecyclerInfo>
) : RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_linear, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iv_pic.setImageResource(R.drawable.icon_phone)
        holder.tv_title.text = listGoods[position].title
        holder.tv_desc.text = listGoods[position].desc
    }

    override fun getItemCount(): Int = listGoods.size

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        val iv_pic: ImageView = itemsView.findViewById(R.id.iv_pic)
        val tv_title: TextView = itemsView.findViewById(R.id.tv_title)
        val tv_desc: TextView = itemsView.findViewById(R.id.tv_desc)
    }
}