package com.jmyebenes.curriculum.core

import kotlinx.coroutines.*

class ConcurrencyManager {

    private val jobList: MutableList<Job> = mutableListOf()

    fun launch(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        fullException: Boolean,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        val job = if (fullException) Job() else SupervisorJob()
        val scope = CoroutineScope(dispatcher + job)
        synchronized(jobList) {
            jobList.add(job)
            job.invokeOnCompletion {
                synchronized(jobList) {
                    jobList.remove(job)
                }
            }
        }
        scope.launch { block.invoke(this) }
        return job
    }

    fun cancelPendingTasks() {
        synchronized(jobList) {
            val jobPending = mutableListOf<Job>()
            jobPending.addAll(jobList)
            jobPending.forEach { if (it.isActive) it.cancel() }
            jobList.clear()
        }
    }

    fun cancelTask(job: Job) {
        synchronized(jobList) {
            if (jobList.remove(job)) {
                job.cancel()
            }
        }
    }
}