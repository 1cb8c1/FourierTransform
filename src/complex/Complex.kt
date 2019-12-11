package complex

import degreesToRad
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

fun toComplex(modulus: Double, angle: Double): Complex {
    val newReal = modulus * sin((PI * angle)*180)
    val newIm = modulus * cos((PI * angle)/180)
    return Complex(newReal,newIm)
}
fun euler(exponent: Double): Complex {
    return Complex(cos(degreesToRad(exponent)),sin(degreesToRad(exponent)))
}

class Complex(val real: Double, val im: Double) : Cloneable {
    operator fun plus(c: Complex): Complex {
        return Complex(real + c.real, im + c.im)
    }

    operator fun minus(c: Complex): Complex{
        return Complex(real - c.real, im - c.im)
    }

    operator fun times(c: Complex): Complex {
        val newReal = real*c.real - im*c.im
        val newIm = real*c.im + im*c.real
        return Complex(newReal,newIm)
    }

    operator fun times(d: Double): Complex{
        return Complex(real*d,im*d)
    }

    operator fun div(c: Complex): Complex{
        if(c.real*c.real + c.im*c.im == 0.0){
            throw error("Dividing complex number by 0")
        }
        val newReal = (real*c.real + im*c.im)/(c.real*c.real + c.im*c.im)
        val newIm = (im*c.real - real*c.im)/(c.real*c.real + c.im*c.im)
        return Complex(newReal,newIm)
    }

    fun abs(): Double{
        return sqrt(real*real + im*im)
    }

    fun cos(): Double{
        return real/abs()
    }

    fun sin(): Double{
        return im/abs()
    }

    override fun toString(): String{
        return "%.3f".format(real) + (if(im >= 0) "+" else "") + "%.3f".format(im) + "i"
    }

    override fun clone(): Complex{
        return Complex(real, im)
    }
}