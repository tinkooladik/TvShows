package com.tinkooladik.tvshows.compose.view.show

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.data.stub.StubData
import com.tinkooladik.tvshows.domain.show.Show

@Composable
fun ShowPage(show: Show) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        ShowPoster(url = show.imageUrl, modifier = Modifier.width(200.dp))
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PreviewShowPage() {
    TvShowsTheme {
        ShowPage(show = StubData.SHOWS.first())
    }
}