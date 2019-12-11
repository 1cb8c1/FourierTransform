import org.knowm.xchart.QuickChart
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.XYSeries

fun main(){
    //val inputSignal = Signal(mySin(1.0))
    val inputSignal = Signal(mySinComposition(1.0,1.0,8.0,0.2))
    val range = 0..1
    val xInputData = steps(128,range)
    val yInputData = sampler(128,range,inputSignal)
    normalChart(xInputData,yInputData,"Input")

    val samplesCount = 32
    val xSamplingData = steps(samplesCount,range)
    val ySamplingData = sampler(samplesCount,range,inputSignal)
    dottedChart(xSamplingData,ySamplingData,"Samples")

    val dft = DFT(ySamplingData)
    val yDFT = dft.magnitudes
    val xDFT = dft.sidedCoefficients.mapIndexed{ index: Int, it -> index.toDouble()}
    dottedChart(xDFT,yDFT,"DFT")

    val outputSignal = dft.signal()
    val xOutputData = steps(128,range)
    val yOutputData = sampler(128,range,outputSignal)
    normalChart(xOutputData,yOutputData,"Output")
}


