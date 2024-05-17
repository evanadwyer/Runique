package com.evanadwyer.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.evanadwyer.analytics.presentation.AnalyticsDashboardScreenRoot
import com.evanadwyer.analytics.presentation.di.analyticsPresentationModule
import com.evanadwyer.anaytics.data.di.analyticsModule
import com.evanadwyer.core.presentation.designsystem.RuniqueTheme
import com.google.android.play.core.splitcompat.SplitCompat
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(
            listOf(
                analyticsPresentationModule,
                analyticsModule
            )
        )
        SplitCompat.installActivity(this)

        setContent {
            RuniqueTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "analytics_dashboard"
                ) {
                    composable("analytics_dashboard") {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = {
                                finish()
                            }
                        )
                    }
                }
            }
        }
    }
}