package tim.experiment.coroutines

import kotlinx.coroutines.*
import tim.experiment.coroutines.logic.HttpClient
import tim.experiment.coroutines.logic.LogicClass
import tim.experiment.coroutines.logic.LogicClassSecond
import tim.experiment.coroutines.logic.killCpu
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {

    val httpClient = HttpClient()
    val logicSecond = LogicClassSecond(httpClient)
    val logic = LogicClass(logicSecond)

    println(measureTime {
        killCpu()
    })

    runBlocking {

        val scope = CoroutineScope(Dispatchers.Default)

        repeat(100) {
            scope.launch {
                println("start $it request")
                logic.calculate(it)
                println("finish $it request")
            }
        }
    }
}