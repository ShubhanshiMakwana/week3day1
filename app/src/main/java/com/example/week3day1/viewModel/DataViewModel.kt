package com.example.week3day1.viewModel
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.example.week3day1.model.DataId
    import com.example.week3day1.network.RetrofitInt
    import com.example.week3day1.network.RetrofitService
    import retrofit2.Response
    import com.example.week3day1.repository.Repository

    class DataViewModel:ViewModel() {
        var datalist = MutableLiveData<List<DataId>>()
        fun getApiData() {
            val retrofitService =
                RetrofitInt.getRetrofitInstance().create(RetrofitService::class.java)
            retrofitService.getData().enqueue(object : retrofit2.Callback<List<DataId>> {
                override fun onResponse(
                    call: retrofit2.Call<List<DataId>>,
                    response: Response<List<DataId>>
                ) {
                    datalist.value = response.body()
                }

                override fun onFailure(call: retrofit2.Call<List<DataId>>, t: Throwable) {

                }


            })

            fun getApiData():LiveData<List<DataId>>{
                datalist = Repository.getApiData()
                return datalist
            }
        }
}