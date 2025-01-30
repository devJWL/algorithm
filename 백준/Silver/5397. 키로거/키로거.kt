import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {

    val n = br.readLine().toInt()

    for (i in 1..n) {
        val input = br.readLine()
        val editor = LinkedList<Char>()
        val iter = editor.listIterator()

        input.forEach {
            when (it) {
                '<' -> {
                    if (iter.hasPrevious()) { iter.previous() }
                }
                '>' -> {
                    if (iter.hasNext()) { iter.next() }
                }
                '-' -> {
                    if (iter.hasPrevious()) {
                        iter.previous()
                        iter.remove()
                    }
                }
                else -> {iter.add(it)}
            }
        }
        editor.forEach { bw.write("$it") }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

