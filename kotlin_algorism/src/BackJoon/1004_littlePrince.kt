import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val length = Integer.parseInt(StringTokenizer(br.readLine()).nextToken())
    var answerArr = Array(length, {0})
    for (i in 0..length-1){
        var answer = 0
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val x1 = st.nextToken().toDouble()
        val y1 = st.nextToken().toDouble()
        val x2 = st.nextToken().toDouble()
        val y2 = st.nextToken().toDouble()

        val planetLength = Integer.parseInt(StringTokenizer(br.readLine()).nextToken())
        for (i in 0..planetLength-1){
            val input = br.readLine();
            val st = StringTokenizer(input, " ")
            val cx = st.nextToken().toDouble()
            val cy = st.nextToken().toDouble()
            val r = st.nextToken().toDouble()
            var xFlag = false
            if(x1 >= cx - r && x1 <= cx + r){
                if(r.pow(2) - (x1-cx).pow(2) >= 0){
                    if(y1 > Math.sqrt(r.pow(2) - (x1-cx).pow(2)) * (-1) + cy && y1 < Math.sqrt(r.pow(2) - (x1-cx).pow(2)) + cy) {
                        answer++
                        xFlag = true
                    }
                } else {
                    if(y1 < Math.sqrt(r.pow(2) - (x1-cx).pow(2)) * (-1) + cy && y1 > Math.sqrt(r.pow(2) - (x1-cx).pow(2)) + cy) {
                        answer++
                        xFlag = true
                    }
                }
            }
            if(x2 >= cx - r && x2 <= cx + r){
                if(r.pow(2) - (x2-cx).pow(2) >= 0){
                    if(y2 > Math.sqrt(r.pow(2) - (x2-cx).pow(2)) * (-1) + cy && y2 < Math.sqrt(r.pow(2) - (x2-cx).pow(2)) + cy) {
                        if(xFlag)
                            answer--
                        else
                            answer++
                    }
                } else {
                    if(y2 < Math.sqrt(r.pow(2) - (x2-cx).pow(2)) * (-1) + cy && y2 > Math.sqrt(r.pow(2) - (x2-cx).pow(2)) + cy) {
                        if(xFlag)
                            answer--
                        else
                            answer++
                    }
                }
            }
        }
        answerArr[i] = answer
    }
    for (i in 0..answerArr.size-1)
        println(answerArr[i])
    br.close()
}