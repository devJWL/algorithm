
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val st:Stack<Int> = Stack()

fun main() {

    val n = br.readLine().toInt()

    for (i in 1..n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "push" -> {
                st.push(command[1].toInt())
            }
            "pop" -> {
                if (st.isEmpty()) bw.write("-1\n") else bw.write("${st.pop()}\n")
            }
            "size" -> {
                bw.write("${st.size}\n")
            }
            "empty" -> {
                if (st.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }
            else -> {
                if (st.isEmpty()) bw.write("-1\n") else bw.write("${st.peek()}\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

