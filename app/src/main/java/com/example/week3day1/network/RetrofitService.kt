package com.example.week3day1.network



import android.telecom.Call
import com.example.week3day1.model.DataId
import retrofit2.http.GET

interface RetrofitService {
    @GET("/todos")
    fun getData() :retrofit2.Call<List<DataId>>
}