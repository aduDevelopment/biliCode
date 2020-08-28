package com.waterDrop.baselibrary.utils

import com.waterDrop.baselibrary.ui.fragment.BaseFragment


/**
 * Created by payne on 7/28/20.
 * ClassName:FragmentUtil
 * Description:管理fragment的util类
 */
class FragmentUtil private constructor(){//私有化构造方法
//    val homeFragment by lazy { HomeFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabid获取对应的fragment
     */
    fun getFragment(tabId:Int): BaseFragment?{
        when(tabId){
//            R.id.tab_home->return homeFragment
        }
        return null
    }
}