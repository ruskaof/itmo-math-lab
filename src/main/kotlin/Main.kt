// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import core.*
import ui.Axes
import ui.CustomCheckBox
import ui.Func

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
                            list = getFunctionDots(func = func, limits = -100f to 100f, 10_000),
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

fun main() = application {
    val func: (Float) -> Float = { x -> x * x * x }
    val result = calculateSumByRectangles(func = func, -10f to 10f, 40, PsiSelectionWay.LEFT)


    Window(onCloseRequest = ::exitApplication) {
        App(result, func)
    }
}
