import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val editor = LinkedList<Char>()

fun main() {

    br.readLine().forEach { editor.add(it) }
    val iter = editor.listIterator(editor.size)
    val m = br.readLine().toInt()

    for (i in 1..m) {
        val command = br.readLine()
        when (command[0]) {
            'L' -> {
                if (iter.hasPrevious()) { iter.previous() }
            }
            'D' -> {
                if (iter.hasNext()) { iter.next() }
            }
            'B' -> {
                if (iter.hasPrevious()) {
                    iter.previous()
                    iter.remove()
                }
            }
            else -> {
                iter.add(command[2])
            }
        }
    }

    editor.forEach { bw.write("$it") }

    bw.flush()
    bw.close()
    br.close()
}

/*
왼쪽으로 이동 -> 현재 pos > 0이면 pos 1 감소
오른쪽으로 이동 -> 현재 pos < size pos 1 증가
삭제 -> pos > 0 일때 pos-1 위치를 지우고 pos 1 감소
삽입 -> 현재 위치에 추가 하고 pos 1증가
 */
