fun sampler(samplesCount: Int, range: IntRange, signal: Signal): MutableList<Double> {
    val step = (range.last-range.first).toDouble()/samplesCount.toDouble()
    var t = range.first.toDouble()
    val values = mutableListOf<Double>()
    for(i in 0 until samplesCount){
        values.plusAssign(signal.getAmplitude(t))
        t+= step
    }
    return values
}

fun steps(samplesCount: Int, range: IntRange): MutableList<Double> {
    val step = (range.last-range.first).toDouble()/samplesCount.toDouble()
    var t = range.first.toDouble()
    val steps = mutableListOf<Double>()
    for(i in 0 until samplesCount){
        steps.plusAssign(t)
        t+= step
    }
    return steps
}