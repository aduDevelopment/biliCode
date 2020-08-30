package com.waterDrop.goodscenter
/**
 * Created by payne on 7/28/20.
 * ClassName: GoodsListActivity
 * Description:商品列表页
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.waterDrop.baselibrary.model.RecyclerInfo
import com.waterDrop.baselibrary.ui.adapter.GoodsAdapter
import com.waterdrop.goodscenter.R
import kotlinx.android.synthetic.main.activity_goods_list.*

class GoodsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_list)

        var index = 0
        var arr: ArrayList<RecyclerInfo> = ArrayList()
        while (index < 50) {
            arr.add(
                RecyclerInfo(
                    "华为 mate${index.toString()}",
                    "价格 ￥1${index.toString()}${index.toString()}${index.toString()}${index.toString()}"
                )
            )
            index++
        }

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = GoodsAdapter(arr)


    }


}