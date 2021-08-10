package com.tinkooladik.tvshows.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tinkooladik.tvshows.R
import com.tinkooladik.tvshows.base.BaseFragment
import com.tinkooladik.tvshows.base.onSuccess
import com.tinkooladik.tvshows.databinding.FragmentHomeBinding
import com.tinkooladik.tvshows.domain.show.Show
import com.tinkooladik.tvshows.extentions.addHorizontalSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun inflateView() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ShowsAdapter(::onShowItemClicked)
        binding.shows.adapter = adapter
        binding.shows.addHorizontalSpacingItemDecoration(R.dimen.spacing_small)

        //TODO extract this to the base fragment
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                state.shows.onSuccess {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun onShowItemClicked(item: Show) {

    }
}