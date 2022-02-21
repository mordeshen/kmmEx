package com.mor.listdetailskmm.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver


class DriverFactory {
    actual fun createDriver(): SqlDriver{
        return NativeSqliteDriver(ModelDb.Schema,"items.db")
    }
}