package org.pursuit.team_6_happyhouranytime.network.webutils;

import androidx.lifecycle.MutableLiveData
import org.pursuit.team_6_happyhouranytime.network.errorutil.APIError
import org.pursuit.team_6_happyhouranytime.repository.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CallBackKt<T> : Callback<T> {

    var result: MutableLiveData<Resource<T>> = MutableLiveData()

    override fun onFailure(call: Call<T>, t: Throwable) {

        result.value = Resource.error(APIError())
        t.printStackTrace()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful)
            result.value = Resource.success(response.body())
        else {
            result.value = Resource.error(APIError())
        }
    }
}