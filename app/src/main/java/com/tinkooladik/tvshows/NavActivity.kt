package com.tinkooladik.tvshows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import com.tinkooladik.tvshows.domain.actor.FetchAllActorsUseCase
import com.tinkooladik.tvshows.ui.theme.TvShowsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class NavActivity : ComponentActivity() {

    @Inject
    lateinit var useCase: FetchAllActorsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowsApplication()
        }

        CoroutineScope(Dispatchers.IO).launch {
            useCase.invoke().onSuccess {
                Timber.e("actors list: ${it.map { it.name }}")
            }.onFailure {
                Timber.e("failed to fetch actors")
            }
        }
    }
}

@Composable
fun TvShowsApp() {
    TvShowsTheme {
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TvShowsTheme {
        Greeting("Android")
    }
}