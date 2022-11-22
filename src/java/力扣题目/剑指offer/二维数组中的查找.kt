package 力扣题目.剑指offer

fun main() {
    findNumberIn2DArray(arrayOf(intArrayOf(1, 10)), 0)
}

fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {

    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    var x = matrix[0].size - 1
    var y = 0
    while (x >= 0 && y < matrix.size) {
        val current = matrix[y][x]
        if (current == target) return true
        if (current < target) y++
        if (current > target) x--
    }
    return false
}