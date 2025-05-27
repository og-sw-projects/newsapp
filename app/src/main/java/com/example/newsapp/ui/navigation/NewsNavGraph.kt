package com.example.newsapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.ui.screen.detail.ArticleDetailScreen
import com.example.newsapp.ui.screen.main.MainScreen
import com.example.newsapp.ui.screen.main.MainViewModel

@Composable
fun NewsNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(
                onArticleClick = { article ->
                    mainViewModel.selectArticle(article)
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
        composable(Screen.Detail.route) {
            val article = mainViewModel.selectedArticle.collectAsState().value
            if (article != null) {
                ArticleDetailScreen(article = article, navController = navController)
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No article data available.", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
