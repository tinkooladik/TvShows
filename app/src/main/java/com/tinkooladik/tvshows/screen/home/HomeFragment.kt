package com.tinkooladik.tvshows.screen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tinkooladik.tvshows.base.BaseFragment
import com.tinkooladik.tvshows.base.onSuccess
import com.tinkooladik.tvshows.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun inflateView() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO extract this to the base fragment
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                state.actors.onSuccess {
                    Timber.e("received actors: ${it.map { it.name }}")
                }
            }
        }
    }
}