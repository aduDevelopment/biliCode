package com.waterDrop.baselibrary.repository

/**
 * Created by payne on 7/28/20.
 * ClassName:HttpService
 * Description: ServiceRepository
 */
import com.waterDrop.baselibrary.common.BASE_URL
import com.waterDrop.baselibrary.model.Hello
import com.waterDrop.baselibrary.model.userRes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object HttpService {
    val service by lazy{
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ServiceRepository::class.java)
    }

}



interface ServiceRepository{
    @FormUrlEncoded
    @POST("/login")
    suspend fun postLogin(
        @Field("username") username: CharSequence?,
        @Field("password") password: CharSequence?
    ): userRes

    @FormUrlEncoded
    @POST("/register")
    suspend fun postRegister(
        @Field("mobile") mobile: CharSequence?,
        @Field("verifyCode") verifyCode: CharSequence?
    ): userRes

    @GET("/")
    suspend fun getHello(): Hello
}