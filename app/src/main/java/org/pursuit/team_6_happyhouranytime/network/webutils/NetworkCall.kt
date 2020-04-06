package org.pursuit.team_6_happyhouranytime.network.webutils

import androidx.lifecycle.MutableLiveData
<<<<<<< HEAD
=======
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
>>>>>>> refactoring to improve architecture
import org.pursuit.team_6_happyhouranytime.repository.Resource
import retrofit2.Call
import javax.inject.Inject

<<<<<<< HEAD
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

=======
open class NetworkCall<T> : RequestInterface<T> {

    private var job: CompletableJob? = null

    override suspend fun makeCall(call: Call<T>): MutableLiveData<Resource<T>> {
        job = Job()
        return object : MutableLiveData<Resource<T>>() {
            override fun onActive() {
                super.onActive()
                job?.let { job ->
                    CoroutineScope(IO + job).launch {
                        val callBackKt = CallBackKt<T>()
                        call.enqueue(callBackKt)
                        job.complete()
                    }
                }

            }
        }
    }

    override fun cancel() {
        job?.cancel()
    }

>>>>>>> refactoring to improve architecture
    private fun requestRandom() {
    }
}