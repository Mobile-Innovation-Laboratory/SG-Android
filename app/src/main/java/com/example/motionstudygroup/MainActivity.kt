package com.example.motionstudygroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.motionstudygroup.feature.BookDetailScreen
import com.example.motionstudygroup.feature.HomeScreen
import com.example.motionstudygroup.feature.LoginScreen
import com.example.motionstudygroup.ui.theme.MotionStudyGroupTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MotionStudyGroupTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginScreen,
                ){
                    composable<LoginScreen>{
                        LoginScreen(navController)
                    }
                    composable<HomeScreen> {
                        HomeScreen(navController)
                    }
                    composable<BookDetail>{
                        val args = it.toRoute<BookDetail>()
                        BookDetailScreen(args)
                    }
                }
            }
        }
    }
}

@Serializable
object LoginScreen

@Serializable
object HomeScreen

@Serializable
data class BookDetail(val bookTitle : String, val bookDesc : String)



