package tim.experiment.coroutines.logic

import java.time.LocalDateTime

class LogicClass(
    private val logicClassSecond: LogicClassSecond,
) {

    suspend fun calculate(id: Int) {
        logicClassSecond.calculate(id)
    }
}

class LogicClassSecond(
    private val httpClient: HttpClient
) {
    suspend fun calculate(id: Int) {

        val response = httpClient.call(id)
        someWork(response)

    }

}

fun someWork(isBigRequest: Boolean): Any {
    if (isBigRequest) {
        return killCpu()
    }
    return isBigRequest
}

fun killCpu(int: Int = LocalDateTime.now().toString().hashCode()): Int {
    println("kill cpu")
    var tmp = int
    repeat(1_000_000_000) {// current value depends on your cpu performance
        tmp = tmp.hashCode() + (System.currentTimeMillis() % 17).toInt()
    }
    return tmp
}
