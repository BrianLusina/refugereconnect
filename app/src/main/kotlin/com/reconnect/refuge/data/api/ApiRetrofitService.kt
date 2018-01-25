package com.reconnect.refuge.data.api

import com.reconnect.refuge.data.db.entities.UserEntity
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author lusinabrian on 23/01/18.
 * @Notes Retrofit Service
 */
interface ApiRetrofitService {

    @POST
    fun postRefugeeData(@Body userEntity: UserEntity)
}