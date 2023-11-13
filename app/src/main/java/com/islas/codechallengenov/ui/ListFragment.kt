package com.islas.codechallengenov.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.islas.codechallengenov.R
import com.islas.codechallengenov.data.mappers.CharacterResult
import com.islas.codechallengenov.domain.IMarvelApiImpl


class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        //Here we call the Api Service it does not return anything yet
        val list = IMarvelApiImpl().makeCall()
        val _result = MutableLiveData<List<CharacterResult>>()
        return view
    }
}