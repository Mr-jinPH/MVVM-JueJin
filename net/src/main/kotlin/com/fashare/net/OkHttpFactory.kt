package com.fashare.net

import com.fashare.net.util.HttpsUtil
import com.socks.library.KLog
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpFactory {
    private var CONNECT_TIMEOUT_SECONDS = 20L
    private var READ_TIMEOUT_SECONDS = 20L
    private var WRITE_TIMEOUT_SECONDS = 20L

    val client: OkHttpClient by lazy { create() }

    fun create(): OkHttpClient {
        val sslParams = HttpsUtil.getSslSocketFactory(null, null, null)
        val loggingInterceptor = HttpLoggingInterceptor({ chain, msg ->
            KLog.json("okhttp-${chain.request().url().uri().path}", msg)
        }).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
    }
}