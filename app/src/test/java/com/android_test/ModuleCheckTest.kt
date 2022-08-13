package com.android_test

import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules

@Category(CheckModuleTest::class)
class ModuleCheckTest: AutoCloseKoinTest() {

    @Test
    fun checkModules(): Unit = checkModules {
        modules(com.android_test.koin.mainModule)
    }
}