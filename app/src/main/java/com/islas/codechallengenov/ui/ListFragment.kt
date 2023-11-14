package com.islas.codechallengenov.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.islas.codechallengenov.data.HomeRepositoryImp
import com.islas.codechallengenov.data.utils.ResultApi
import com.islas.codechallengenov.databinding.FragmentListBinding
import com.islas.codechallengenov.ui.adapter.HomeAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListFragment : Fragment() {

    private val repository = HomeRepositoryImp()

    private lateinit var mBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository.makeCall { result ->
            lifecycleScope.launch(Dispatchers.Main){
                when(result){
                    ResultApi.Error -> TODO()
                    is ResultApi.Success -> {
                        Log.i("Fragment", "result $result")
                        mBinding.recyclerview.adapter = HomeAdapter(result.data)
                        mBinding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }
}