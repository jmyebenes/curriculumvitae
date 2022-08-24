package com.jmyebenes.curriculum.core

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<I, O> {
    suspend fun execute(input: I): O = withContext(dispatcher) { useCaseFunction(input) }

    protected abstract suspend fun useCaseFunction(input: I): O

    protected open val dispatcher: CoroutineDispatcher = Dispatchers.IO
}



//abstract class BaseUseCase<in P, R> : CoroutineScope {
//
//    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, t ->
//        run {
//            t.printStackTrace()
//        }
//    }
//
//    private var job = Job()
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job + coroutineExceptionHandler
//
////    val errorMessage: String
////        get() = onErrorMessage()
//
//    operator fun invoke(params: P, ioDispatcher: CoroutineDispatcher = Dispatchers.IO, onResult: (R) -> Unit = {}) =
//        launch(coroutineContext) {
//            val job = async(ioDispatcher) {
//                run(params)
//            }
//            onResult(job.await())
//        }
//
//    abstract suspend fun run(params: P): R
////    abstract fun onErrorMessage(): String
//
//}