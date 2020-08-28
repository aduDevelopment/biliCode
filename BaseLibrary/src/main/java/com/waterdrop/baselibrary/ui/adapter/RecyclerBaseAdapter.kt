package com.waterDrop.baselibrary.ui.adapter

/**
 * Created by payne on 8/6/20.
 * ClassName:RecyclerBaseAdapter
 * Description: 数据绑定基类
 */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerBaseAdapter<VH: RecyclerView.ViewHolder>(val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    val inflater: LayoutInflater = LayoutInflater.from(context)

    abstract override fun getItemCount(): Int

    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder

    abstract override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    abstract override fun getItemViewType(position: Int): Int

    abstract override fun getItemId(position: Int): Long

    var itemClickListener: AdapterView.OnItemClickListener? = null

    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener){
        this.itemClickListener =listener
    }

    var itemLongClickListener: AdapterView.OnItemLongClickListener? = null

    fun setOnItemLongClickListener(listener: AdapterView.OnItemLongClickListener){
        this.itemLongClickListener =listener
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}

    override fun onItemLongClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ): Boolean {
        return true
    }

}