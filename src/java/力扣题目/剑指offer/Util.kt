package 力扣题目.剑指offer

//fun canIndex(x:Int,y:Int,xMax:Int,yMax:Int)= x < 0 || y < 0 || x >= xMax || y >= yMax
fun canIndex(x: Int, y: Int, xMax: Int, yMax: Int) = (x in 0 until xMax) && (y in 0 until yMax)