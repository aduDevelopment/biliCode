package com.waterDrop.baselibrary.ui.adapter
/**
 * Created by payne on 8/6/20.
 * ClassName:RecyclerCommonAdapter
 * Description: 竖列数据绑定公共基类
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.waterDrop.baselibrary.model.RecyclerInfo
import com.waterdrop.baselibrary.R
import org.jetbrains.anko.toast

//ViewHolder在构造时初始化布局中的控件对象
class RecyclerLinearAdapter(private val context: Context, private val infos: MutableList<RecyclerInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    val inflater: LayoutInflater = LayoutInflater.from(context)

    //获得列表项的数目
    override fun getItemCount(): Int = infos.size

    //创建整个布局的视图持有者
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.item_recycler_linear, parent, false)
        return ItemHolder(view)
    }

    //绑定每项的视图持有者
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh: ItemHolder = holder as ItemHolder
        vh.iv_pic.setImageResource(R.drawable.icon_phone)
        vh.tv_title.text = infos[position].title
        vh.tv_desc.text = infos[position].desc
    }

    //ItemHolder中的属性在构造时初始化
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ll_item = view.findViewById(R.id.ll_item) as LinearLayout
        var iv_pic = view.findViewById(R.id.iv_pic) as ImageView
        var tv_title = view.findViewById(R.id.tv_title) as TextView
        var tv_desc = view.findViewById(R.id.tv_desc) as TextView
    }

    private var itemClickListener: AdapterView.OnItemClickListener? = null
    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
        this.itemClickListener = listener
    }

    private var itemLongClickListener: AdapterView.OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener: AdapterView.OnItemLongClickListener) {
        this.itemLongClickListener = listener
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val desc = "您点击了第${position+1}项，标题是${infos[position].title}"
        context.toast(desc)
    }

    override fun onItemLongClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ): Boolean {
        val desc = "您长按了第${position+1}项，标题是${infos[position].title}"
        context.toast(desc)
        return true
    }
}
