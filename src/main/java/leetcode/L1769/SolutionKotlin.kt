package leetcode.L1769

import kotlin.math.abs

fun minOperations(boxes: String) : IntArray {
    val n = boxes.length

    val arr = IntArray(n)

    for (i in 0 until n) {

        var sum = 0
        for (j in boxes.indices) {
            if (boxes[j] == '1') {
                sum += abs(j - i)
            }
        }
        arr[i] = sum
    }

    return arr
}

fun main() {
    val boxes = "001011"
    minOperations(boxes).also { println(it.contentToString()) }
}