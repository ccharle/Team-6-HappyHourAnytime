package org.pursuit.team_6_happyhouranytime.network.webutils

import androidx.lifecycle.MutableLiveData
import org.pursuit.team_6_happyhouranytime.repository.Resource
import retrofit2.Call
import javax.inject.Inject

open class NetworkCall<T>: RequestInterface<T> {
   private lateinit var call: Call<T>

    override fun makeCall(call: Call<T>): MutableLiveData<Resource<T>> {
        this.call = call
        val callBackKt = CallBackKt<T>()
        this.call.enqueue(callBackKt)
        return callBackKt.result
    }


    override fun cancel() {
        if (::call.isInitialized) {
            call.cancel()
        }
    }

    private fun requestRandom() {
    }
}