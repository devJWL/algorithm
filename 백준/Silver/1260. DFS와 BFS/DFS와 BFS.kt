import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
lateinit var map: Array<LinkedList<Int>>
lateinit var visited: BooleanArray

fun dfs(start: Int) {
    bw.write("$start ")
    visited[start] = true
    for (next in map[start]) {
        if (visited[next]) continue
        dfs(next)
    }
}

fun bfs(start: Int) {
    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val curr = queue.pollFirst()
        bw.write("$curr ")
        for (next in map[curr]) {
            if (visited[next]) continue
            queue.add(next)
            visited[next] = true
        }
    }
}

fun main() {
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n + 1) { LinkedList<Int>() }
    visited = BooleanArray(n + 1) {false}

    for (i in 1..m) {
        val (e1, e2) = br.readLine().split(" ").map { it.toInt() }
        map[e1].add(e2)
        map[e2].add(e1)
    }

    for (i in 1..n) {
        map[i].sort()
    }

    dfs(v)
    bw.newLine()
    visited.fill(false)
    bfs(v)

    bw.flush()
    bw.close()
    br.close()
}