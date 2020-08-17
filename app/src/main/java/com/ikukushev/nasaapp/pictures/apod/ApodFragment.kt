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
import com.ikukushev.nasaapp.core.displayImageWithRatio
import com.ikukushev.nasaapp.core.displayUrl
import com.ikukushev.nasaapp.pictures.apod.data.Apod
import com.ikukushev.nasaapp.pictures.apod.data.ApodRoomEntity
import com.ikukushev.nasaapp.pictures.apod.db.ApodDatabase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_apod.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ApodFragment : Fragment() {

    private val viewModel: ApodViewModel by viewModels()

    @Inject
    lateinit var db: ApodDatabase
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
                    apodAdapter.setItems(listOf(result.data))
                }
            }
        })
    }

}