package com.paradox543.motoscanai.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Scan Vehicle") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Upload or Capture Image (To be implemented)")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navController.navigate("result") // Later: run ML, then navigate
            }) {
                Text("Analyze Image")
            }
        }
    }
}
