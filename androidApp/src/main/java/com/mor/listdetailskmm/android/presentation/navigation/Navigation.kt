package com.mor.listdetailskmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.mor.listdetailskmm.android.presentation.model_details.ModelDetailsScreen
import com.mor.listdetailskmm.android.presentation.model_details.ModelDetailsViewModel
import com.mor.listdetailskmm.android.presentation.model_list.ModelListScreen
import com.mor.listdetailskmm.android.presentation.model_list.ModelListViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ModelList.route) {
        composable(route = Screen.ModelList.route) { navBackStackEntry ->
            // in the future, the hilt-navigation-compose artifact will simplify this
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: ModelListViewModel = viewModel("ModelListViewModel", factory)
            ModelListScreen(
                onSelectModel = { modelId ->
                    navController.navigate("${Screen.ModelDetail.route}/$modelId")
                }
            )
        }
        composable(
            route = Screen.ModelDetail.route + "/{modelId}",
            arguments = listOf(navArgument("modelId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: ModelDetailsViewModel = viewModel("ModelDetailsViewModel", factory)
            ModelDetailsScreen(
                model = viewModel.model.value
            )
        }
    }
}
