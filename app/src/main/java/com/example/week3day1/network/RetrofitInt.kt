package com.example.week3day1.network



    import okhttp3.OkHttpClient
    import okhttp3.logging.HttpLoggingInterceptor
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory
    import java.security.KeyManagementException
    import java.security.NoSuchAlgorithmException
    import java.util.concurrent.TimeUnit
    import kotlin.jvm.Throws

    object RetrofitInt {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/todos"
        private var mClient: OkHttpClient? = null
        private val client: OkHttpClient
            @Throws(NoSuchAlgorithmException::class,KeyManagementException::class)
            get(){
                if (mClient == null){
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    val httpBuilder = OkHttpClient.Builder()
                    httpBuilder
                        .connectTimeout(15,TimeUnit.SECONDS)
                        .readTimeout(20,TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                    mClient = httpBuilder.build()
                }
                return mClient!!
            }
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
