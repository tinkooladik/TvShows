package com.tinkooladik.tvshows.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tinkooladik.tvshows.compose.ui.theme.Purple500
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.compose.view.show.ShowPage
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Toolbar", color = Color.White)
                },
                backgroundColor = Purple500
            )
        }
    ) { innerPadding ->
        MainScreenContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier) {
//    ShowsList(shows = SHOWS, modifier)
    ShowPage(show = SHOWS.first(), modifier)
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PreviewTvAppView() {
    TvShowsTheme {
        TvAppView()
    }
}