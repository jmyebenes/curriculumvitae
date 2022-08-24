package com.jmyebenes.curriculum.core

import android.util.Log
import com.jmyebenes.curriculum.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .addInterceptor(createErrorInterceptor())
            .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        return loggingInterceptor
    }

    private fun createErrorInterceptor(): Interceptor {
        val errorInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request = chain.request()
                val response = chain.proceed(request)
                return when (response.code) {
                    200 -> {
                        Log.d("JMJMJM", "Success 200")
                        response
                    }
                    400 -> throw Exception()
                    401 -> throw Exception()
                    404 -> {
                        Log.d("JMJMJM", "Error 404")
                        throw IOException()
                    }
                    500 -> throw Exception()
                    else -> {
                        Log.d("JMJMJM", "No se...")
                        response
                    }
                }
            }
        }
        return errorInterceptor
    }

    //interceptors para errores
}