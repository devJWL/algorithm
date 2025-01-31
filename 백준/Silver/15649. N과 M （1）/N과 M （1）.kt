import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var n = 0
var m = 0
val buffer = StringBuffer()
lateinit var used: BooleanArray

fun BT(cnt: Int) {
    if (cnt == m) {
        for (ch in buffer) {
            bw.write("$ch ")
        }
        bw.newLine()
    }

    for (i in 1.. n) {
        if (used[i]) continue
        used[i] = true
        buffer.append(i)
        BT(cnt + 1)
        used[i] = false
        buffer.deleteCharAt(buffer.length - 1)
    }
}

fun main() {
    val input = StringTokenizer(br.readLine()," ")
    n = input.nextToken().toInt()
    m = input.nextToken().toInt()
    used = BooleanArray(n + 1) {false}

    BT(0)

    bw.flush()
    bw.close()
    br.close()
}