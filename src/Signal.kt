import kotlin.math.PI
import kotlin.math.sin

fun radToDegrees(rad: Double): Double = (rad*180)/ PI
fun degreesToRad(degree: Double): Double = (degree*PI)/180

fun mySin(frequency: Double) = { t: Double ->
        val x = 360*frequency
        sin(degreesToRad(t*x))
    }

class Signal(val f: (Double) -> Double) {
    fun getAmplitude(t: Double): Double {
        return f(t)
    }
}

