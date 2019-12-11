import complex.Complex
import complex.euler

class DFT(samples: List<Double>) {
    val samplesSize = samples.size
    val sidedCoefficients = getSidedCoefficients(samples)
    val magnitudes = initMagnitudes()
    fun getSidedCoefficients(samples: List<Double>): List<Complex>{
        val coefficients = mutableListOf<Complex>()
        for(k in 0 until samples.size/2){
            var complex = Complex(0.0,0.0)
            samples.forEachIndexed { n: Int, sample ->
                complex += euler((2*180*k*n).toDouble()/samples.size.toDouble()*(-1)) * sample
            }
            coefficients.plusAssign(complex * 2.0)
        }
        return coefficients.toList()
    }

    private fun initMagnitudes(): List<Double>{
        val magnitudes = mutableListOf<Double>()
        sidedCoefficients.forEach {
            magnitudes.plusAssign(it.abs()/samplesSize)
        }
        return magnitudes.toList()
    }
}