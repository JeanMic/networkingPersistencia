package com.jeanandroid.networkingpersistencia.retrofit

import com.jeanandroid.networkingpersistencia.entidadeFakeAPI
import io.reactivex.Observable
import retrofit2.http.GET


interface RestAPI {

    @GET("posts/1/comments")
    fun getJsonAPI() : Observable<List<entidadeFakeAPI>>

}
