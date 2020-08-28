package com.waterDrop.usercenter.model;


import com.haoyue.wanandroidkotlin.http.BaseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者：Nixon
 * date：2020/7/16.
 * 邮箱：jan.romon@gmail.com
 * TODO：接口API
 */
public class ApiClient {
    public interface HomePageAPI{
        @GET("article/list/{id}/json")
        Observable<BaseData<ArticleList>> homeArticleList(@Path("id") String id);
    }
}
