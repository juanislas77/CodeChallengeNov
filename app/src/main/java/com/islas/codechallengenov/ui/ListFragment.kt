package com.islas.codechallengenov.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.islas.codechallengenov.R
import com.islas.codechallengenov.data.models.CharacterResult
import com.islas.codechallengenov.data.HomeRepositoryImp
import com.islas.codechallengenov.data.utils.ResultApi


class ListFragment : Fragment() {

    private val repository = HomeRepositoryImp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        //Here we call the Api Service it does not return anything yet
        repository.makeCall { result ->
            when(result){
                ResultApi.Error -> TODO()
                is ResultApi.Success -> {
                    Log.i("Fragment", "result $result")
                }
            }
        }
        val _result = MutableLiveData<List<CharacterResult>>()
        return view
    }
}