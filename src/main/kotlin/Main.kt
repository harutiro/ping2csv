import model.BuildList

suspend fun main(args: Array<String>) {
    val getPing = GetPing()
    while(true){
        BuildList.builds.forEach { buildList ->
            buildList.forEach{build ->
                val result = getPing.survivalByNetAddress(build.address, build.subnetMask)
                val otherFileStorage = OtherFileStorage(build.name)
                otherFileStorage.doLog(result.toString())
                println("${build.name}の生存数: $result")
                println("生存数: $result")
            }
        }
    }
}