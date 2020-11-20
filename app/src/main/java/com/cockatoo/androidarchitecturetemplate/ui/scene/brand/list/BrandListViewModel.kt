package com.cockatoo.androidarchitecturetemplate.ui.scene.brand.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cockatoo.androidarchitecturetemplate.data.BrandRepository
import com.cockatoo.androidarchitecturetemplate.model.Result
import com.cockatoo.androidarchitecturetemplate.model.response.BrandResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BrandListViewModel @ViewModelInject constructor(private val brandRepository: BrandRepository) : ViewModel() {

     val brandList = MutableLiveData<Result<BrandResponse>>()

    init {
        fetchBrands()
    }

    private fun fetchBrands() {
        viewModelScope.launch {
            brandRepository.fetchBranch().collect {
                brandList.value = it
            }
        }
    }
}