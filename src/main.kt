fun main(){
    val signal = Signal(mySin(1.0))
    val values = sampler(160, 0..1, signal)
    values.forEach{println("%.3f".format(it))}
    val dft = DFT(values)
    println("\nFourier Coefficients")
    dft.sidedCoefficients.forEach { println(it) }

    println("\nAngle")
    println(dft.sidedCoefficients[1].phase())

}


