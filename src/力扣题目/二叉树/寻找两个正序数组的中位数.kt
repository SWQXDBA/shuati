package 力扣题目.二叉树

class 寻找两个正序数组的中位数 {
    class Solution {
        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            var list = mutableListOf<Int>()
            list.addAll(nums1.asList())
            list.addAll(nums2.asList())
            list.sort()
            if (list.size % 2 == 0) {
                val num1 = list[list.size / 2 - 1].toDouble()
                val num2 = list[list.size / 2].toDouble()
                return (num1 + num2) / 2
            } else {
                return list[list.size / 2].toDouble()
            }

        }
    }
}