package core

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import ui.translateCoordinateX
import ui.translateCoordinateY


@Composable
fun Rectangles(
    modifier: Modifier,
    scale: Int,
    listOfTau: List<Pair<Float, Float>>,
    listOfPsi: List<Pair<Float, Float>>
) {
    Canvas(modifier = modifier) {
        for (i in listOfPsi.indices) {
            drawRect(
                topLeft = Offset(
                    x = translateCoordinateX(listOfTau[i].first, size.width, scale),
                    y = if (listOfPsi[i].second >= 0) translateCoordinateY(listOfPsi[i].second, size.height, scale) else
                        translateCoordinateY(0f, size.height, scale)
                ),
                size = Size(
                    width = kotlin.math.abs((listOfTau[i + 1].first - listOfTau[i].first)) * scale + 1f,
                    height = kotlin.math.abs(listOfPsi[i].second) * scale
                ),
                color = Color(0xaa6790C4),
            )
        }
    }
}