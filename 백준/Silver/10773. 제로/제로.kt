
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val nums = ArrayList<Int>()

fun main() {
    val k = br.readLine().toInt()

    for (i in 1..k) {
        val num = br.readLine().toInt()
        if (num == 0) nums.removeLast() else nums.add(num)
    }

    bw.write("${nums.sum()}")

    bw.flush()
    bw.close()
    br.close()
}

