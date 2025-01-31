import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
lateinit var trace: Array<IntArray>

fun bfs(n: Int, m: Int) {
    val dy = arrayOf(0, 0, -1, 1)
    val dx = arrayOf(-1, 1, 0, 0)
    val queue = LinkedList<Pair<Int, Int>>()

    queue.offer(Pair(0, 0))
    visited[0][0] = true
    trace[0][0] = 1

    while(queue.isNotEmpty()) {

        val (y, x) = queue.poll()
        if (y == n - 1 && x == m - 1) return
        for (dir in 0..<4) {
            val ny = y + dy[dir]
            val nx = x + dx[dir]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue
            if (map[ny][nx] == '0') continue
            if (visited[ny][nx]) continue

            visited[ny][nx] = true
            trace[ny][nx] = trace[y][x] + 1
            queue.offer(Pair(ny, nx))
        }
    }
}

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n){ CharArray(m) }
    trace = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) {false} }

    for (y in 0..<n){
        val line = br.readLine()
        map[y] = line.toCharArray()
    }

    bfs(n, m)

    bw.write("${trace[n-1][m-1]}")

    bw.flush()
    bw.close()
    br.close()
}


