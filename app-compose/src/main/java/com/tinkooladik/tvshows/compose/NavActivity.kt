package com.tinkooladik.tvshows.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.compose.view.show.ShowsList
import com.tinkooladik.tvshows.data.stub.StubData.SHOWS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowsTheme {
                TvAppView()
            }
        }
    }
}

@Composable
fun TvAppView() {
    MainScreenContent()
}

@Composable
fun MainScreenContent() {
    ShowsList(shows = SHOWS)
}