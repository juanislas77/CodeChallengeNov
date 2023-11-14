package com.islas.codechallengenov.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.islas.codechallengenov.data.utils.toDomain
import com.islas.codechallengenov.domain.models.Character

class CharacterPagingSource : PagingSource<Int, Character>() {

    private val repository = HomeRepositoryImp()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {

        val nextPageNumber = params.key ?: 1
        val response = repository.makeCall(nextPageNumber)
        return LoadResult.Page(
            data = response.results.map { it.toDomain() },
            prevKey = null,
            nextKey = response.offset + 1
        )

    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}