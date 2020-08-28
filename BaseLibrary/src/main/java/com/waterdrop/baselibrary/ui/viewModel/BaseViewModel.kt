package com.waterDrop.baselibrary.ui.viewModel

/**
 * Created by payne on 7/28/20.
 * ClassName:BaseViewModel
 * Description:所有ViewModel的基类
 */

import com.waterDrop.baselibrary.ui.viewModel.view.BaseViewInterface

open class BaseViewModel<V: BaseViewInterface> {
    var mView: V? = null
}