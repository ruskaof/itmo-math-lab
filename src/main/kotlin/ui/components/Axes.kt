package ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun Axes(
    modifier: Modifier
) {
    Canvas(modifier = modifier) {
        drawLine(
            start = Offset(
                x = 0f,
                y = size.height / 2
            ),
            end = Offset(
                x = size.width,
                y = size.height / 2
            ),
            color = Color.Black
        )
        drawLine(
            start = Offset(
                x = size.width / 2,
                y = 0f
            ),
            end = Offset(
                x = size.width / 2,
                y = size.height
            ),
            color = Color.Black
        )
    }
}