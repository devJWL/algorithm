import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
var n = 0
var m = 0

fun main() {
    n = br.readLine().toInt()
    val set = br.readLine().split(" ").map(String::toInt).toHashSet()
    m = br.readLine().toInt()

    br.readLine().split(" ").map(String::toInt).toList().forEach {
        bw.write(
            when(set.contains(it)) {
            true -> "1\n"
            else -> "0\n"
        })
    }

    br.close()
    bw.flush()
    bw.close()
}