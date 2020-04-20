import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var dpArr = Array(41, {0})

fun main(args: Array<String>){
    dpArr[1] = 1
    val br = BufferedReader(InputStreamReader(System.`in`))
    val length = Integer.parseInt(StringTokenizer(br.readLine()).nextToken())
    var answerArr = Array(length, {" "})
    for (i in 0..length-1){
        val input = br.readLine()
        val st = StringTokenizer(input, "")
        val n = Integer.parseInt(st.nextToken())
        if(n == 0){
            answerArr[i] = "1 0"
        }else if(n == 1){
            answerArr[i] = "0 1"
        } else {
            fibonacci(n)
            answerArr[i] = "${dpArr[n-1]} ${dpArr[n]}"
        }
    }
    for (i in 0..answerArr.size-1)
        println(answerArr[i])
    br.close()
}

fun fibonacci(n: Int): Int {
    if(n == 0){
        dpArr[0] = 0
        return 0
    } else if(n == 1) {
        dpArr[0] = 1
        return 1
    }
    if(dpArr[n] != 0){
        return dpArr[n]
    } else {
        dpArr[n] = fibonacci(n-1) + fibonacci(n-2)
        return dpArr[n]
    }
}