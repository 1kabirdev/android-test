package com.android_test.koin

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mainModule = module {
    singleOf(::HelloMessageData)
    singleOf(::HelloServiceImpl) { bind<HelloService>() }
}

class HelloMessageData {
    val message: String = "Hello Koin!"
}

class HelloApplication : KoinComponent {
    val helloService: HelloService by inject()
    fun sayHello() = println(helloService.hello())
}

fun main() {
    startKoin {
        printLogger()
        modules(mainModule)
    }
    HelloApplication().sayHello()
}

interface HelloService {
    fun hello(): String
}

class HelloServiceImpl(private val helloMessageData: HelloMessageData) : HelloService {
    override fun hello() = "Hey, ${helloMessageData.message}"
}