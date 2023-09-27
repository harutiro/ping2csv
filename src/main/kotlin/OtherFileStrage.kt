
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.PrintWriter
import java.nio.file.Paths
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

class OtherFileStorage(fileName:String) {

    val fileAppend : Boolean = true //true=追記, false=上書き
    val extension : String = ".csv"
    val baceTime: OffsetDateTime = OffsetDateTime.now()
    val filePath = Paths.get("").toAbsolutePath().toString().plus("/Data").plus("/").plus(fileName).plus(extension)
    val dimention: Int = 0

    init {
        if(dimention != 0){
            writeText(firstLog(dimention),filePath)
        }
    }

    fun doLog(text: String) {
        writeText(baceTime.toString().plus(",").plus(text), filePath)
    }

    //CSV一行目の出力をする。
    private fun firstLog(dimension: Int):String {
        return when (dimension) {
            0 -> ("")
            1 -> ("time,count")
            else -> {
                var result: String = baceTime.toString()
                for (i in 0 until dimension) result = result.plus(",").plus(i)
                result
            }
        }
    }

    //外部ストレージにファイル出力をする関数
    private fun writeText(text:String, path:String){
        val fil = FileWriter(path,fileAppend)
        val pw = PrintWriter(BufferedWriter(fil))
        pw.println(text)
        pw.close()
    }
}