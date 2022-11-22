package 力扣题目.其他

//这题其实可以dp
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val set = wordDict.toHashSet()
    cache = mutableMapOf<String,Boolean>();
    return internal(s,set)
}
var cache = mutableMapOf<String,Boolean>()
fun internal(s: String,set:Set<String>): Boolean {

    for (i in s.indices){
        val substr = s.substring(0..i)
        if(set.contains(substr)){
            if(i==s.length-1){
                println("end")
                return true
            }
            val otherStr = s.substring(i+1 until s.length)

            val match:Boolean = cache[otherStr] ?: internal(otherStr,set)
            if(match){
                cache[otherStr] = true
                return true
            }else{
                cache[otherStr] = false
            }
        }
    }
    return false
}
fun main() {

    println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")))
}