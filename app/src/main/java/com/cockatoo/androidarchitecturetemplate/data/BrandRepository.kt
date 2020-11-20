package com.cockatoo.androidarchitecturetemplate.data

import com.cockatoo.androidarchitecturetemplate.data.local.BrandDao
import com.cockatoo.androidarchitecturetemplate.data.remote.BrandRemoteDataSource
import com.cockatoo.androidarchitecturetemplate.model.Result
import com.cockatoo.androidarchitecturetemplate.model.response.BrandResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BrandRepository @Inject constructor(
        private val brandRemoteDataSource: BrandRemoteDataSource,
        private val brandDao: BrandDao
) {
    suspend fun fetchBranch() : Flow<Result<BrandResponse>?> {
        return flow {
            emit(fetchBranchCached())
            emit(Result.loading())
            val result = brandRemoteDataSource.fetchBrand()

            if (result.status == Result.Status.SUCCESS) {
                result.data?.result?.let { it ->
                    brandDao.deleteAll(it)
                    brandDao.insertAll(it)
                }
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    private fun fetchBranchCached() : Result<BrandResponse>? =
        brandDao.getAll()?.let {
            Result.success(BrandResponse(it))
        }
}