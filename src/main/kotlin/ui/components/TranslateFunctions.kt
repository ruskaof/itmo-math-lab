package ui

fun translateCoordinateY(y: Float, canvasHeight: Float, scale: Int): Float {
    return -y * scale + canvasHeight / 2
}

fun translateCoordinateX(x: Float, canvasWidth: Float, scale: Int): Float {
    return x * scale + canvasWidth / 2
}