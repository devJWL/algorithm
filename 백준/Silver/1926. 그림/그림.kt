import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val size = br.readLine().split(' ').map(String::toInt).toIntArray()
    val n = size[0]
    val m = size[1]
    val paper = Array(n) { IntArray(m) {0} }
    val visited = Array(n) { BooleanArray(m) {false} }

    for (y in 0..<n) {
        val line = br.readLine().split(' ').map(String::toInt).toIntArray()
        for (x in line.indices) {
            paper[y][x] = line[x]
        }
    }

    var dy = arrayOf(0, 0, -1, 1)
    var dx = arrayOf(-1, 1, 0, 0)

    var count = 0
    var max = 0

    for (r in 0 ..<n) {
        for (c in 0 ..<m) {
            if (paper[r][c] == 0) continue
            if (visited[r][c]) continue

            val q = LinkedList<Pair<Int, Int>>()
            ++count
            var size = 1
            visited[r][c] = true
            q.add(Pair(r, c))

            while(q.isNotEmpty()) {
                val (y, x) = q.removeFirst()

                for (dir in 0..<4) {
                    val ny = y + dy[dir]
                    val nx = x + dx[dir]

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue
                    if (paper[ny][nx] == 0) continue
                    if (visited[ny][nx]) continue

                    ++size
                    visited[ny][nx] = true
                    q.add(Pair(ny, nx))
                }
            }
            max = max.coerceAtLeast(size)
        }
    }
    
    bw.write("$count\n$max")

    bw.flush()
    bw.close()
    br.close()
}


