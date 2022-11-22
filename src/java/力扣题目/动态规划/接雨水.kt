package 力扣题目.动态规划

import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    var leftMaxArr :IntArray? = null
    var rightMaxArr :IntArray? = null
    fun trap(height: IntArray): Int {
        leftMaxHeight(height)
        rightMaxHeight(height)
        var sum = 0
        for (index in height.indices) {
            sum+=currentMaxWater(height,index)
        }
        return sum
    }
    fun leftMaxHeight(height: IntArray):Int{
        leftMaxArr = IntArray(height.size)
        var max:Int = 0
        for(i in height.indices){
            max = max(max,height[i])
            leftMaxArr!![i] = max
        }
        return max
    }
    fun rightMaxHeight(height: IntArray):Int{
        var max:Int = 0
        rightMaxArr = IntArray(height.size)
        for(i in height.indices.reversed()){
            max = max(max,height[i])
            rightMaxArr!![i] = max
        }
        return max
    }
    //当前下标能装多少水
    fun currentMaxWater(height: IntArray,index:Int):Int{
        val waterHeight = min(leftMaxArr!![index], rightMaxArr!![index])
        val button = height[index]
        return if(button>=waterHeight){
            0
        }else{
            waterHeight-button
        }
    }
}

