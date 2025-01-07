package leetcode.L1408

class SolutionKT {
    fun stringMatching(words: Array<String>): List<String> {
        words.sortBy { it.length }
        val list = mutableListOf<String>()

        for (i in 0 until words.size - 1) {
            for (j in i + 1 until words.size) {
                if (words[j].contains(words[i])) {
                    list.add(words[i])
                    break
                }
            }
        }
        return list
    }
}

fun main() {
    val solutionKt = SolutionKT()
    val words: Array<String> = arrayOf("leetcode", "et", "code")
    solutionKt.stringMatching(words)
    println(solutionKt.stringMatching(words))
}