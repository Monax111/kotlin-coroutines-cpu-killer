package tim.experiment.coroutines.logic

import kotlinx.coroutines.delay

class HttpClient {
    suspend fun call(id: Int): Boolean {
        delay(1000)
        return (id % 25) == 0
    }
}