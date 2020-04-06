package org.pursuit.team_6_happyhouranytime.network.webutils

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CompletableJob
import org.pursuit.team_6_happyhouranytime.repository.Resource
import retrofit2.Call
open class NetworkCall<T>: RequestInterface<T> {
    private var job: CompletableJob? = null

//    override suspend fun makeCall(call: Call<T>): MutableLiveData<Resource<T>> {
//        job = Job()
//        return object : MutableLiveData<Resource<T>>() {
//            override fun onActive() {
//                super.onActive()
//                job?.let { job ->
//                    CoroutineScope(IO + job).launch {
//                        val callBackKt = CallBackKt<T>()
//                        call.enqueue(callBackKt)
//                        job.complete()
//                    }
//                }
//
//            }
//        }
//    }

    override fun cancel() {
        job?.cancel()
    }

    override fun makeCall(call: Call<T>): MutableLiveData<Resource<T>> {

        val callBackKt = CallBackKt<T>()
        call.enqueue(callBackKt)
        return callBackKt.result

    }
}
