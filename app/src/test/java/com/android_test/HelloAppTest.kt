package com.android_test

import com.android_test.koin.HelloApplication
import com.android_test.koin.HelloMessageData
import com.android_test.koin.HelloService
import com.android_test.koin.mainModule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class HelloAppTest:KoinTest {

    private val model by inject<HelloMessageData>()
    private val service by inject<HelloService>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(mainModule)
    }

    @Test
    fun `unit test`() {
        val helloApp = HelloApplication()
        helloApp.sayHello()

        assertEquals(service, helloApp.helloService)
        assertEquals("Hey, ${model.message}", service.hello())
    }
}