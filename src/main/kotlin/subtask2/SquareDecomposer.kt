package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    private val result: MutableList<Int>? = mutableListOf()

    fun decomposeNumber(number: Int): Array<Int>? {

        searcher(number * number, number - 1)

        // 5 - element in try range
        return if (number < 5)
            null
        else
            result!!.toTypedArray()
    }

    private fun searcher(kvValue: Int, endPoint: Int): Int? {

        for(x in endPoint downTo 1) {

            if(kvValue - x * x < 0)
                return null

            if(kvValue - x * x == 0) {
                result?.add(x)
                return x
            }

            var element = sqrt((kvValue - x * x).toDouble()).toInt()
            if(element >= x) element = x - 1


            if (searcher(kvValue - x * x, element) != null) {
                result?.add(x)
                return x
            }

        }

        return null
    }

}
