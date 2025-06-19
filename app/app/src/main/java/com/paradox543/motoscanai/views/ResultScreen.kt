package com.paradox543.motoscanai.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Analysis Result") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text("Detected Model: Honda City")
            Text("Damage: Front Bumper Scratch")
            Text("Severity: Repaint")
            Text("Estimated Cost: ₹2,500")

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                navController.popBackStack("home", inclusive = false)
            }) {
                Text("Back to Home")
            }
        }
    }
}
