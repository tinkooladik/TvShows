package com.tinkooladik.tvshows.compose.view.show

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tinkooladik.tvshows.compose.ui.theme.CardBackground
import com.tinkooladik.tvshows.compose.ui.theme.CardBackgroundHighlighted
import com.tinkooladik.tvshows.compose.ui.theme.TvShowsTheme
import com.tinkooladik.tvshows.data.stub.StubData
import com.tinkooladik.tvshows.domain.show.Show
import java.time.format.DateTimeFormatter

val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM yyyy")

@Composable
fun ShowCard(show: Show, isSelected: Boolean = false) {
    val background: Color by animateColorAsState(
        targetValue = if (isSelected) CardBackgroundHighlighted else CardBackground
    )
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = background
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ShowPoster(show.imageUrl)
            Spacer(modifier = Modifier.height(8.dp))
            Captions(show = show)
        }
    }
}

@Composable
private fun Captions(show: Show) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = show.title, style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Release date
            Text(
                // TODO is there any more compose-ish way to do this?
                text = show.releaseDate.format(dateFormat),
                style = MaterialTheme.typography.body1
            )
            // Rating
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp
            ) {
                Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                    Text(
                        text = show.rating.value.toString(),
                        style = MaterialTheme.typography.body2
                    )
                }
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
private fun PreviewShowCard() {
    TvShowsTheme {
        ShowCard(
            show = StubData.SHOWS.first()
        )
    }
}