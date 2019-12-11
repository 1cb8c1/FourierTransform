import kotlin.math.PI
import kotlin.math.sin

class Signal {
    fun getAmplitude(t: Double): Double {
        val x = t*360
        return sin(degreesToRad(x))
    }
    private fun radToDegrees(rad: Double): Double = (rad*180)/ PI
    private fun degreesToRad(degree: Double): Double = (degree*PI)/180
}