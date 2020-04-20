import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val length = Integer.parseInt(StringTokenizer(br.readLine()).nextToken())
    var answerArr = Array(length, {0})
    for (i in 0..length-1){
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val x1 = st.nextToken().toDouble()
        val y1 = st.nextToken().toDouble()
        val r1 = st.nextToken().toDouble()
        val x2 = st.nextToken().toDouble()
        val y2 = st.nextToken().toDouble()
        val r2 = st.nextToken().toDouble()

        if(x1==x2 && y1==y2){
            if(r1==r2)
                answerArr[i] = -1
            else
                answerArr[i] = 0
            continue
        }

        val distance = Math.sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))

        if(distance > r1 + r2)
            answerArr[i] = 0
        else if(distance == r1 + r2 || distance == Math.abs(r1 - r2))
            answerArr[i] = 1
        else if(distance < r1 + r2 && distance > Math.abs(r1 - r2))
            answerArr[i] = 2
        else if(distance < r1 + r2 && distance < Math.abs(r1 - r2))
            answerArr[i] = 0
    }

    for (i in 0..answerArr.size-1)
        println(answerArr[i])
    br.close()
}
