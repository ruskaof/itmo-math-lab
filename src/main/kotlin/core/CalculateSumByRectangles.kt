package core

import kotlin.random.Random

fun calculateSumByRectangles(
    func: (Float) -> Float,
    limits: Pair<Float, Float>,
    nCount: Int,
    psiSelectionWay: PsiSelectionWay
) : RectSumResult {
    val listOfTau = getFunctionDots(func = func, limits = limits, dotsCount = nCount)
    val listOfPsi = mutableListOf<Pair<Float, Float>>()

    for (i in 0 until listOfTau.size - 1) {
        when (psiSelectionWay) {
            PsiSelectionWay.LEFT -> listOfPsi.add(listOfTau[i])
            PsiSelectionWay.MIDDLE -> listOfPsi.add((listOfTau[i].first + listOfTau[i + 1].first) / 2 to func((listOfTau[i].first + listOfTau[i + 1].first) / 2))
            PsiSelectionWay.RIGHT -> listOfPsi.add(listOfTau[i+1])
            PsiSelectionWay.RANDOM -> run {
                val selectedX = listOfTau[i].first + Random.nextFloat() * (listOfTau[i+1].first - listOfTau[i].first)
                println(selectedX)
                listOfPsi.add(selectedX to func(selectedX))
            }
        }
    }


    var sum = 0f

    for (i in listOfPsi.indices) {
        sum += listOfPsi[i].second * (listOfTau[i+1].first - listOfTau[i].first)
    }

    return RectSumResult(listOfTau, listOfPsi, sum)
}

data class RectSumResult(
    val listOfTau: List<Pair<Float, Float>>,
    val listOfPsi: List<Pair<Float, Float>>,
    val sum: Float
)