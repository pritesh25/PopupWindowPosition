package com.example.viewposition

import org.junit.Test

class SampleUnit {
    @Test
    fun addition_isCorrect() {

        val list = arrayOf(2, 3, 4, 5, 6, 7, 8)

        val vTotal = list.size
        println("vTotal = $vTotal")
        val x = vTotal / 2
        val y = x + 1
        var negativeValue = 0
        println("x = $x")
        println("y = $y")

        if (vTotal % 2 == 0) {
            println("count is even")
            for (i in 0 until vTotal) {
                print(" i at $i   ")
                if (list[i] > y) {
                    if (negativeValue == 0) {
                        negativeValue = list[i - 1] - 1
                        println("-ve -$negativeValue")
                    } else {
                        negativeValue--
                        println("-ve -$negativeValue")
                    }
                } else {
                    println("+ve  ${list[i]}")
                }
            }
        } else {
            println("count is odd")
            for (i in 0 until vTotal) {
                print(" i at $i   ")
                if (list[i] > y) {
                    if (negativeValue == 0) {
                        negativeValue = list[i - 1]
                        println("-ve -$negativeValue")
                    } else {
                        negativeValue--
                        println("-ve -$negativeValue")
                    }
                } else {
                    println("+ve  ${list[i]}")
                }
            }
        }
    }
}