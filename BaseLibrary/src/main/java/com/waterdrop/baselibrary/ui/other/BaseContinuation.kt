package com.waterDrop.baselibrary.ui.other

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by payne on 7/28/20.
 * ClassName:BaseContinuation
 * Description:所有Continuation的基类
 */
class BaseContinuation: Continuation<Unit>{
    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }

}