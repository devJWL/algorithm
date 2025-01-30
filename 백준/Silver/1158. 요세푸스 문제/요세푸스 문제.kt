
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val q = LinkedList<Int>()

    for (i in 1..n) {
        q.add(i)
    }

    bw.write("<")
    for (i in 1..<k) {
        q.add(q.pollFirst())
    }
    bw.write("${q.pollFirst()}")

    while(q.size > 0) {
        for (i in 1..< k) {
            q.add(q.pollFirst())
        }
        bw.write(", ${q.pollFirst()}")
    }
    bw.write(">")

    bw.flush()
    bw.close()
    br.close()
}

