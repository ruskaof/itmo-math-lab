package ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Func(
    list: List<Pair<Float, Float>>,
    modifier: Modifier,
    scale: Int
) {
    Canvas(modifier = modifier) {

        for (i in 0 until list.size - 1) {
            val x1 = translateCoordinateX(list[i].first, size.width, scale)
            val y1 = translateCoordinateY(list[i].second, size.height, scale)

            val x2 = translateCoordinateX(list[i + 1].first, size.width, scale)
            val y2 = translateCoordinateY(list[i + 1].second, size.height, scale)

            drawLine(
                start = Offset(
                    x = x1,
                    y = y1
                ),
                end = Offset(
                    x = x2,
                    y = y2
                ),
                color = Color.Black,
                strokeWidth = 2.dp.toPx()
            )

        }
    }
}

