package com.waterDrop.baselibrary.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by payne on 8/6/20.
 * ClassName:RecyclerCommonAdapter
 * Description: 数据绑定公共基类
 */

class RecyclerCommonAdapter<T>(context: Context, private val layoutId: Int, private val items: List<T>, val init:(View, T) -> Unit):RecyclerBaseAdapter<RecyclerCommonAdapter.ItemHolder<T>>(context){


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(layoutId, parent, false)
        return ItemHolder<T>(view, init)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh: ItemHolder<T> = holder as ItemHolder<T>
        vh.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        //暂时占位，日后完善
        return position
    }

    override fun getItemId(position: Int): Long {
        //暂时占位，日后完善
        return Long.MIN_VALUE
    }

    class ItemHolder<T>(val view: View, val init: (View, T) -> Unit): RecyclerView.ViewHolder(view) {
        fun bind(item: T){
            init(view, item)
        }
    }

}