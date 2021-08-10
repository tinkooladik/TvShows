package com.tinkooladik.tvshows.screen.show

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.tinkooladik.tvshows.R
import com.tinkooladik.tvshows.base.BaseFragment
import com.tinkooladik.tvshows.base.Incomplete
import com.tinkooladik.tvshows.base.onSuccess
import com.tinkooladik.tvshows.databinding.FragmentShowDetailsBinding
import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.domain.show.Show
import com.tinkooladik.tvshows.extentions.addVerticalSpacingItemDecoration
import com.tinkooladik.tvshows.extentions.isLoading
import com.tinkooladik.tvshows.screen.actor.ActorsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ShowDetailsFragment : BaseFragment<FragmentShowDetailsBinding>() {

    private val viewModel: ShowDetailsViewModel by viewModels()

    override fun inflateView() = FragmentShowDetailsBinding.inflate(layoutInflater)

    private val actorsAdapter = ActorsAdapter(::onActorItemClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actors.adapter = actorsAdapter
        binding.actors.addVerticalSpacingItemDecoration(R.dimen.spacing_small)

        //TODO extract this to the base fragment
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                binding.groupContent.isVisible = state.show !is Incomplete
                binding.progress.isLoading = state.show is Incomplete
                state.show.onSuccess { show ->
                    updateInfo(show)
                }
            }
        }
    }

    private fun onActorItemClicked(item: Actor) {

    }

    private fun updateInfo(show: Show) {
        Glide.with(requireContext()).load(show.imageUrl).into(binding.image)
        binding.title.text = show.title
        binding.rating.text = show.rating.value.toString()
        actorsAdapter.submitList(show.actors)
    }
}