package com.tinkooladik.tvshows.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.data.stub.StubData.SHOWS
import com.tinkooladik.tvshows.domain.show.Show
import dagger.hilt.android.AndroidEntryPoint
import java.time.format.DateTimeFormatter

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
//    Scaffold(
//        content = MainScreenContent()
//    )
    MainScreenContent()
}

@Composable
fun MainScreenContent() {
    ShowsList(shows = SHOWS)
}

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

@Composable
fun ShowCard(show: Show) {
    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM yyyy")
    with(show) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = rememberImagePainter(
                    imageUrl,
                    builder = {
                        transformations(RoundedCornersTransformation(8f))
                    },
                ),
                contentDescription = "poster",
                modifier = Modifier.aspectRatio(0.7f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = title, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        //TODO is there any more compose-ish way to do this?
                        text = releaseDate.format(dateFormat),
                        style = MaterialTheme.typography.body1
                    )
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        elevation = 1.dp
                    ) {
                        Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                            Text(
                                text = rating.value.toString(),
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Show Card in Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Show Card in Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    TvShowsTheme {
        ShowCard(
            show = SHOWS.first()
        )
    }
}

@Preview(name = "Show List")
@Composable
fun PreviewShowList() {
    TvShowsTheme {
        ShowsList(shows = SHOWS)
    }
}