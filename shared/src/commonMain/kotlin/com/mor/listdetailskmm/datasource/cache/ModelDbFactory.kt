package com.mor.listdetailskmm.datasource.cache

import com.squareup.sqldelight.db.SqlDriver

class ModelDbFactory(
    private val driverFactory: DriverFactory
) {
    fun createDb(): ModelDb{
        return ModelDb(driverFactory.createDriver())
    }
}

expect class DriverFactory{
    fun createDriver(): SqlDriver
}