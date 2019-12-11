fun main(){
    val signal = Signal(mySin(1.0))
    val values = sampler(8, 0..1, signal)
    values.forEach{println("%.3f".format(it))}
    val dft = DFT(values)
    println("\nFourier Coefficients")
    dft.sidedCoefficients.forEach { println(it) }

    val signal2 = dft.signal()
    val values2 = sampler(8,0..1,signal2)

    println("\nNew signal:")
    values2.forEach{println("%.3f".format(it))}
}


