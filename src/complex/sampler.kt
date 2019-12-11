package complex

import Signal

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