import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val q = LinkedList<Int>()

fun main() {
    val n = br.readLine().toInt()

    for (i in 1..n) {
        val command = br.readLine().split(' ')
        when (command[0]) {
            "push" -> {
                q.add(command[1].toInt())
            }
            "pop" -> {
                if (q.isNotEmpty()) bw.write("${q.pollFirst()}\n") else bw.write("-1\n")
            }
            "size" -> {
                bw.write("${q.size}\n")
            }
            "empty" -> {
                if (q.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }
            "front" -> {
                if (q.isNotEmpty()) bw.write("${q.peekFirst()}\n") else bw.write("-1\n")
            }
            else -> {
                if (q.isNotEmpty()) bw.write("${q.peekLast()}\n") else bw.write("-1\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}


