import complex.Complex
import complex.sampler

fun main(){
    val signal = Signal()
    val values = sampler(8,0..1,signal)
    values.forEach{println("%.3f".format(it))}
}