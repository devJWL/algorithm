import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val st: Stack<Int> = Stack()
val data = ArrayList<Int>()
val answer = ArrayList<Char>()
fun main() {

    val n = br.readLine().toInt()
    var idx = 0

    for (i in 1..n) {
        data.add(br.readLine().toInt())
    }

    for (i in 1..n) {
        st.push(i)
        answer.add('+')

        while(st.isNotEmpty() && st.peek() == data[idx]) {
            st.pop()
            answer.add('-')
            ++idx
        }
    }

    if (st.isEmpty()) {
        for (ch in answer) {
            bw.write("$ch\n")
        }
    } else {
        bw.write("NO\n")
    }

    bw.flush()
    bw.close()
    br.close()
}


