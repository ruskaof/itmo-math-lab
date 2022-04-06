package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.RectSumResult
import core.Rectangles
import core.getFunctionDots

@Composable
fun App(
    result: RectSumResult,
    func: (Float) -> Float
) {
    var sliderPosition by remember { mutableStateOf(1f) }
    var mainFunctionShown by remember { mutableStateOf(true) }
    var axesShown by remember { mutableStateOf(true) }
    var rectanglesShown by remember { mutableStateOf(true) }


    MaterialTheme {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CustomCheckBox(
                    onValueChange = { mainFunctionShown = !mainFunctionShown },
                    label = "Show function",
                    value = mainFunctionShown
                )
                CustomCheckBox(
                    onValueChange = { axesShown = !axesShown },
                    label = "Show axes",
                    value = axesShown
                )
                CustomCheckBox(
                    onValueChange = { rectanglesShown = !rectanglesShown },
                    label = "Show rectangles",
                    value = rectanglesShown
                )
                Text(text = "The result is ${result.sum}")
                Slider(value = sliderPosition, onValueChange = { sliderPosition = it }, valueRange = 1f..100f)
            }
            Column(
                modifier = Modifier.weight(4f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box {
                    if (mainFunctionShown) {
                        Func(
                            list = getFunctionDots(func = func, limits = -100f to 300f, 10_000),
                            modifier = Modifier
                                .size(1000.dp),
                            scale = sliderPosition.toInt()
                        )
                    }
                    if (axesShown) {
                        Axes(
                            modifier = Modifier
                                .size(1000.dp)
                        )
                    }
                    if (rectanglesShown) {
                        Rectangles(
                            modifier = Modifier
                                .size(1000.dp),
                            listOfPsi = result.listOfPsi,
                            listOfTau = result.listOfTau,
                            scale = sliderPosition.toInt()
                        )
                    }
                }
            }
        }
    }
}