package 力扣题目.剑指offer

import kotlin.math.max

fun main() {
    val grid = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))

    maxValue(grid)
}

fun maxValue(grid: Array<IntArray>): Int {
    val temp = Array<IntArray>(grid.size) {
        IntArray(grid[0].size)
    }

    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    return getMax(grid, temp, grid.size - 1, grid[0].size - 1)
}


fun getMax(grid: Array<IntArray>, temp: Array<IntArray>, x: Int, y: Int): Int {

    if (x < 0 || y < 0 || x > grid.size || y > grid[0].size) return 0
    if (temp[x][y] != 0) return temp[x][y]

    val v1 = getMax(grid, temp, x - 1, y)

    val v2 = getMax(grid, temp, x, y - 1)
    val maxVal = max(v1, v2)

    temp[x][y] = maxVal + grid[x][y]

    return temp[x][y]

}