package com.example.recruitment.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.recruitment.data.Repository
import com.example.recruitment.models.Connpass
import com.example.recruitment.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
        private val repository: Repository,
        application: Application
): AndroidViewModel(application){

    var connpassResponse: MutableLiveData<NetworkResult<Connpass>> = MutableLiveData()

    fun getInformation(queries: Map<String,String>) = viewModelScope.launch {
        getInformationSafeCall(queries)
    }

    private suspend fun getInformationSafeCall(queries: Map<String, String>) {
        connpassResponse.value = NetworkResult.Loading()
        if (checkInternetConnection()){
            try {
                val response = repository.remote.getInformation(queries)
                connpassResponse.value = handleConnpassResponse(response)
            } catch (e:Exception){
                connpassResponse.value = NetworkResult.Error("Not found")
            }
        } else{
            connpassResponse.value = NetworkResult.Error("No Internet Connection")
        }
    }

    private fun handleConnpassResponse(response: Response<Connpass>): NetworkResult<Connpass>? {
        return when {
            response.body()!!.events.isNullOrEmpty() -> {
                NetworkResult.Error("Not found.")
            }
            response.isSuccessful -> {
                val connpassInfomation = response.body()
                NetworkResult.Success(connpassInfomation!!)
            }
            else -> {
                NetworkResult.Error(response.message())
            }
        }
    }

    private fun checkInternetConnection():  Boolean{
        val connectivityManager = getApplication<Application>().getSystemService(
                Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when{
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}