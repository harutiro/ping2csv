import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.Inet4Address
import java.net.InetAddress

class GetPing {
    fun getPing(address: String): Int {
        return try {
            val processBuilder = ProcessBuilder("ping", "-c", "1", "-W", "50", address)
            val process = processBuilder.start()

            // プロセスの終了を待つ
            val exitCode = process.waitFor()

            return exitCode
        } catch (e: IOException) {
            e.printStackTrace()
            return -1
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return -1
        }
    }

    fun generateHostsFromNetworkAddress(networkAddress: String, subnetMask: Int): List<String> {
        val network = Inet4Address.getByName(networkAddress).address
        val hostBits = 32 - subnetMask

        val hosts = mutableListOf<String>()

        // ホスト部のビットをすべて0から2^hostBits - 1まで繰り返す
        for (i in 0 until (1 shl hostBits)) {
            val hostBytes = ByteArray(4)

            // ネットワークアドレスのビット
            for (j in 0 until 4) {
                hostBytes[j] = (network[j] + (i shr (24 - 8 * j) and 0xFF)).toByte()
            }

            val hostAddress = InetAddress.getByAddress(hostBytes).hostAddress
            hosts.add(hostAddress)
        }

        return hosts
    }

    @OptIn(ObsoleteCoroutinesApi::class)
    suspend fun survivalByNetAddress(networkAddress: String, subnetMask: Int): Int = coroutineScope {
        var survivalCount = 0

        val hosts = generateHostsFromNetworkAddress(networkAddress, subnetMask)
        val jobs = mutableListOf<Deferred<Int>>()

        val dispatcher = newFixedThreadPoolContext(100, "ping-thread-pool")

        // コルーチンを実行
        val results = hosts.map { host ->
            async(dispatcher) {
                val result = getPing(host)
                println("$host: $result")
                if (result == 0) {
                    survivalCount++
                }
                result // Deferred<Int> を返す
            }
        }.awaitAll()

        return@coroutineScope survivalCount
    }
}
