import kotlin.math.PI
import kotlin.math.sin

fun radToDegrees(rad: Double): Double = (rad*180)/ PI
fun degreesToRad(degree: Double): Double = (degree*PI)/180

fun mySin(frequency: Double) = { t: Double ->
        val x = 360*frequency
        sin(degreesToRad(t*x))
    }

fun mySinComposition(freq1: Double, mag1: Double, freq2: Double, mag2: Double) = { t: Double ->
    val x1 = 360*freq1
    val x2 = 360*freq2
    mag1*sin(degreesToRad(t*x1)) + mag2*sin(degreesToRad(t*x2))
}

class Signal(val f: (Double) -> Double) {
    fun getAmplitude(t: Double): Double {
        return f(t)
    }
}

