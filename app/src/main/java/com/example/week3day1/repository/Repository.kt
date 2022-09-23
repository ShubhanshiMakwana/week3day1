package com.example.week3day1.repository
    import androidx.lifecycle.MutableLiveData
    import com.example.week3day1.model.DataId
    import com.example.week3day1.network.RetrofitInt
    import com.example.week3day1.network.RetrofitService
    import retrofit2.Response

    object Repository {
        var datalist = MutableLiveData<List<DataId>>()
        var failureData = MutableLiveData<String>()
        fun getApiData(): MutableLiveData<List<DataId>> {
            val retrofitService =
                RetrofitInt.getRetrofitInstance().create(RetrofitService::class.java)
            retrofitService.getData().enqueue(object : retrofit2.Callback<List<DataId>> {
                override fun onResponse(
                    call: retrofit2.Call<List<DataId>>,
                    response: Response<List<DataId>>){

                    datalist.postValue(response.body())
                }

                override fun onFailure(call: retrofit2.Call<List<DataId>>, t: Throwable) {
                    failureData.postValue("failed")

                }


            })
            return datalist

        }
    }
