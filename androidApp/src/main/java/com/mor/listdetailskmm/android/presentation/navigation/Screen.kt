package com.mor.listdetailskmm.android.presentation.navigation

sealed class Screen(
    val route: String,
){
    object ModelList: Screen("modelList")

    object ModelDetail: Screen("modelDetail")
}