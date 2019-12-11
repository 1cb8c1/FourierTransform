fun main(){
    val signal = Signal(mySin(5.0))
    val values = sampler(16, 0..1, signal)
    values.forEach{println("%.3f".format(it))}
    val dft = DFT(values)
    println("Fourier Coefficients")
    dft.magnitudes.forEach { println("%.3f".format(it)) }

}


