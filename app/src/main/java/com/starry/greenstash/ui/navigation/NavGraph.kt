/**
 * MIT License
 *
 * Copyright (c) [2022 - Present] Stɑrry Shivɑm
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package com.starry.greenstash.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.starry.greenstash.ui.screens.backups.BackupScreen
import com.starry.greenstash.ui.screens.home.composables.HomeScreen
import com.starry.greenstash.ui.screens.info.composables.GoalInfoScreen
import com.starry.greenstash.ui.screens.input.composables.InputScreen
import com.starry.greenstash.ui.screens.settings.composables.AboutScreen
import com.starry.greenstash.ui.screens.settings.composables.OSLScreen
import com.starry.greenstash.ui.screens.settings.composables.SettingsScreen
import com.starry.greenstash.ui.screens.welcome.composables.WelcomeScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)

    ) {
        /** Welcome Screen */
        composable(
            route = Screens.WelcomeScreen.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
        ) {
            WelcomeScreen(navController = navController)
        }

        /** Home Screen */
        composable(
            route = DrawerScreens.Home.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
        ) {
            HomeScreen(navController)
        }

        /** Goal Info Screen */
        composable(
            route = Screens.GoalInfoScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))

            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            arguments = listOf(
                navArgument(GOAL_INFO_ARG_KEY) {
                    type = NavType.StringType
                },
            ),
        ) { backStackEntry ->
            val goalId = backStackEntry.arguments!!.getString(GOAL_INFO_ARG_KEY)!!
            GoalInfoScreen(goalId = goalId, navController)
        }


        /** Input Screen */
        composable(
            route = Screens.InputScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))

            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            arguments = listOf(navArgument(EDIT_GOAL_ARG_KEY) {
                nullable = true
                defaultValue = null
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val editGoalId = backStackEntry.arguments!!.getString(EDIT_GOAL_ARG_KEY)
            InputScreen(editGoalId, navController)
        }

        /** Backup Screen */
        composable(
            route = DrawerScreens.Backups.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))

            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            BackupScreen(navController)
        }

        /** Settings Screen */
        composable(
            route = DrawerScreens.Settings.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))

            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))

            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            SettingsScreen(navController)
        }

        /** Open Source Licenses Screen */
        composable(
            route = Screens.OSLScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
        ) {
            OSLScreen(navController = navController)
        }

        /** About Screen */
        composable(
            route = Screens.AboutScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 }, animationSpec = tween(
                        durationMillis = 300, easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
        ) {
            AboutScreen(navController = navController)
        }

    }
}