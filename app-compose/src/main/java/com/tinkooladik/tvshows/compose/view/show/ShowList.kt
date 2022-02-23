package com.tinkooladik.tvshows.compose.view.show

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.data.stub.StubData
import com.tinkooladik.tvshows.domain.show.Show

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowsList(shows: List<Show>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp)
    ) {
        items(shows) { show ->
            //TODO replace with card view
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp
            ) {
                ShowCard(show = show)
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewShowList() {
    TvShowsTheme {
        ShowsList(shows = StubData.SHOWS)
    }
}