package core

/**
 *  Function that returns math func coordinates in different dots.
 */
fun getFunctionDots(func: (Float) -> Float, limits: Pair<Float, Float>, dotsCount: Int): List<Pair<Float, Float>> {
    val returnList: MutableList<Pair<Float, Float>> = mutableListOf()
    for (i in 0..dotsCount) {
        val x = limits.first + (i * (limits.second - limits.first)) / dotsCount
        val f = func(x)
        returnList.add(x to f)
    }
    return returnList
}