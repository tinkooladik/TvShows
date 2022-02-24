package com.tinkooladik.tvshows.compose.view.show

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.tinkooladik.tvshows.domain.show.Show

/**
 * File for any shared elements related to [Show]
 */

@Composable
fun ShowPoster(url: String, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(
            url,
            builder = {
                transformations(RoundedCornersTransformation(8f))
            },
        ),
        contentDescription = "poster",
        modifier = modifier.aspectRatio(0.7f)
    )
}