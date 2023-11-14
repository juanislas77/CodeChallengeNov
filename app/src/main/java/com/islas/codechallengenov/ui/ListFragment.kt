package com.islas.codechallengenov.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import com.islas.codechallengenov.data.CharacterPagingSource
import com.islas.codechallengenov.databinding.FragmentListBinding
import com.islas.codechallengenov.domain.models.Character
import com.islas.codechallengenov.ui.adapter.HomeAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


private const val ITEMS_PER_PAGE = 50

class ListFragment : Fragment() {

    private lateinit var mBinding: FragmentListBinding

    private val items: Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { CharacterPagingSource() }
    ).flow
        .cachedIn(lifecycleScope)

    private val homeAdapter = HomeAdapter()

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

        lifecycleScope.launch {
            items.collectLatest {
                homeAdapter.submitData(it)
            }
        }

        mBinding.recyclerview.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}