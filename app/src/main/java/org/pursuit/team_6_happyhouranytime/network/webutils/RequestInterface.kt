package org.pursuit.team_6_happyhouranytime.network.webutils

import androidx.lifecycle.MutableLiveData
import org.pursuit.team_6_happyhouranytime.repository.Resource
import retrofit2.Call

interface RequestInterface<T> {

<<<<<<< HEAD
    fun makeCall(call: Call<T>): MutableLiveData<Resource<T>>
=======
    suspend fun makeCall(call: Call<T>): MutableLiveData<Resource<T>>
>>>>>>> refactoring to improve architecture
    fun cancel()
}