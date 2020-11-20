package com.cockatoo.androidarchitecturetemplate.ui.scene.brand.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cockatoo.androidarchitecturetemplate.R
import com.cockatoo.androidarchitecturetemplate.model.Brand
import com.cockatoo.androidarchitecturetemplate.model.Result
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.brand_list_fragment.*

class BrandListFragment : Fragment() {

    private val brandList = ArrayList<Brand>()
    private lateinit var brandAdapter: BrandsAdapter
    private val viewModel by viewModels<BrandListViewModel>()

    companion object {
        fun newInstance() = BrandListFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.brand_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        subscribeUi()
    }

    private fun init() {
        brandAdapter = BrandsAdapter(brandList)
        brandRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = brandAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.brandList.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    result.data?.result?.let { brandAdapter.updateData(it) }
                    progressBar.visibility = View.GONE
                }

                Result.Status.ERROR -> {
                    result.message?.let {
                        showError(it)
                    }
                    progressBar.visibility = View.GONE
                }

                Result.Status.LOADING -> progressBar.visibility = View.VISIBLE
            }
        })
    }


    private fun showError(msg: String) {
        Snackbar.make(parentRelative, msg, Snackbar.LENGTH_INDEFINITE).setAction("DISMISS") {
        }.show()
    }

}