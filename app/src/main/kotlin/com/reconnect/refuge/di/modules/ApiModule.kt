package com.reconnect.refuge.di.modules


import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.reconnect.refuge.BuildConfig
import com.reconnect.refuge.data.api.ApiRetrofitService
import com.reconnect.refuge.di.qualifiers.AppContextQualifier
import com.reconnect.refuge.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author lusinabrian on 23/01/18.
 * @Notes: Api Module used to generate dependencies for use when making network calls
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setPrettyPrinting()
                .setLenient()
                .create()
    }

    @Provides
    @Singleton
    @Named("apiBaseUrl")
    fun provideBaseUrl(): String {
        return BASE_URL
    }


    @Provides
    @Singleton
    @Named("apiRetrofit")
    fun provideRetrofit(@Named("apiBaseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    @Named("mojaRetrofit")
    fun provideMojaRetrofit(@Named("mojaBaseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Content-type", "application/json")
                            .build()
                    chain.proceed(request)
                }
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(@AppContextQualifier context: Context): Cache {
        val cacheSize = 20 * 1024 * 1024 // 20 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideBaseApiRetrofitService(@Named("apiRetrofit") retrofit: Retrofit): ApiRetrofitService {
        return retrofit.create(ApiRetrofitService::class.java)
    }

}