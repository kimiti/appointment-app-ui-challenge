package com.example.appointmentappuichallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appointmentappuichallenge.ui.MainScreen
import com.example.appointmentappuichallenge.ui.theme.AppointmentAppUIChallengeTheme
import com.example.appointmentappuichallenge.ui.theme.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppointmentAppUIChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash"){
                            SplashScreen()
                        }
                        composable("main") {
                            MainScreen()
                        }
                    }
                }
            }
        }
    }
}

