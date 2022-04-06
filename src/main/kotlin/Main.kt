// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import core.PsiSelectionWay
import core.calculateSumByRectangles
import ui.App
import kotlin.math.pow

fun main() = application {

    val func: (Float) -> Float = { x -> 4f.pow(x) }

    val result = calculateSumByRectangles(
        func = func,
        limits = -3f to 2f,
        nCount = 10 + 1,
        psiSelectionWay = PsiSelectionWay.MIDDLE
    )


    Window(onCloseRequest = ::exitApplication) {
        App(result, func)
    }
}
