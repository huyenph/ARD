package com.hpcompose.ard.presentation.rally

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hpcompose.ard.presentation.rally.ui.accounts.AccountsScreen
import com.hpcompose.ard.presentation.rally.ui.accounts.SingleAccountScreen
import com.hpcompose.ard.presentation.rally.ui.bills.BillsScreen
import com.hpcompose.ard.presentation.rally.ui.components.RallyTabRow
import com.hpcompose.ard.presentation.rally.ui.overview.OverviewScreen
import com.hpcompose.ard.presentation.ui.theme.UpmTheme

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun RallyApp() {
    UpmTheme {
//        var currentScreen: RallyDestination by remember { mutableStateOf(Overview) }
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        // Fetch your currentDestination
        val currentDestination = currentBackStack?.destination
        // Change the variable to this and use Overview as a backup screen if this returns null
        val currentScreen =
            rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview
        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    // Pass the callback like this,
                    // defining the navigation action when a tab is selected:
                    onTabSelected = { newScreen -> navController.navigateSingleTopTo(newScreen.route) },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Overview.route,
                modifier = Modifier.padding(innerPadding),
            ) {
                composable(route = Overview.route) {
                    OverviewScreen(
                        onClickSeeAllAccounts = {
                            navController.navigateSingleTopTo(Accounts.route)
                        },
                        onClickSeeAllBills = {
                            navController.navigateSingleTopTo(Bills.route)
                        },
                        onAccountClick = { accountType ->
                            print("accountType: $accountType")
                            navController.navigateSingleTopTo("${SingleAccount.route}/$accountType")
                        }
                    )
                }
                composable(route = Accounts.route) {
                    AccountsScreen(
                        onAccountClick = { accountType ->
                            navController.navigateSingleTopTo("${SingleAccount.route}/$accountType")
                        }
                    )
                }
                composable(route = Bills.route) {
                    BillsScreen()
                }
                composable(
                    route = SingleAccount.routeWithArgs,
                    arguments = SingleAccount.arguments,
                    deepLinks = SingleAccount.deepLinks,
                ) { navBackStackEntry ->
                    // Retrieve the passed argument
                    val accountType = navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
                    // Pass accountType to SingleAccountScreen
                    SingleAccountScreen(accountType = accountType)
                }
            }
//            Box(Modifier.padding(innerPadding)) {
//                currentScreen.screen()
//            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }