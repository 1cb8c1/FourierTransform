import org.knowm.xchart.QuickChart
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.XYSeries

fun dottedChart(xData: List<Double>, yData: List<Double>, title: String){
    val chart = XYChartBuilder().xAxisTitle("X").yAxisTitle("Y").title(title).build()
    chart.styler.defaultSeriesRenderStyle = XYSeries.XYSeriesRenderStyle.Scatter
    chart.styler.markerSize = 16

    chart.addSeries("sin",xData,yData)
    SwingWrapper(chart).displayChart()
}

fun normalChart(xData: List<Double>, yData: List<Double>, title: String){
    val chart = QuickChart.getChart(title,"X","Y"," ",xData,yData)
    SwingWrapper(chart).displayChart()
}