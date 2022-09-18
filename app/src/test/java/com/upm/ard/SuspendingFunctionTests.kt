package com.upm.ard

import com.upm.ard.domain.usecase.AuthUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class SuspendingFunctionTests {
    private suspend fun fetchData(): String {
        delay(1000L)
        return "Hello world"
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = fetchData()
        assertEquals("Hello world", data)
    }
}