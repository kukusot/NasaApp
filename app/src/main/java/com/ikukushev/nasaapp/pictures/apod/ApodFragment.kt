package com.ikukushev.nasaapp.pictures.apod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikukushev.nasaapp.R
import com.ikukushev.nasaapp.core.data.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_apod.*

@AndroidEntryPoint
class ApodFragment : Fragment() {

    private val viewModel: ApodViewModel by viewModels()

    lateinit var apodAdapter: ApodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_apod, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apodAdapter = ApodAdapter()
        apodList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = apodAdapter
        }

        viewModel.apodData.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Success -> {
                    apodAdapter.setItems(result.data)
                }
            }
        })
    }

}