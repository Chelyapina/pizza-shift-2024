package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalpizzashift2024.R
import com.example.finalpizzashift2024.ui.theme.CartViewModel
import com.example.finalpizzashift2024.ui.theme.Typography

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Cart : Routes("cart")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val cartViewModel: CartViewModel = viewModel()
    val pizzaRes by cartViewModel.dataCart.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.main_page_title),
                        style = Typography.headlineLarge,
                        textAlign = TextAlign.Left,
                        modifier = modifier.padding(16.dp)
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = stringResource(id = R.string.home),
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(stringResource(id = R.string.home)) },
                    selected = false,
                    onClick = { navController.navigate(Routes.Home.route) }
                )
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = stringResource(id = R.string.cart),
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(stringResource(id = R.string.cart)) },
                    selected = false,
                    onClick = { navController.navigate(Routes.Cart.route) }
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            NavHost(navController = navController, startDestination = Routes.Home.route) {
                composable(Routes.Home.route) {
                    HomeScreen(
                        navController = navController,
                        pizzaRes = pizzaRes
                    )
                }
                composable(Routes.Cart.route) {
                    CartScreen(
                    )
                }
            }
        }
    }
}
