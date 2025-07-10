package com.paradox543.motoscanai.views

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.contract.ActivityResultContracts.TakePicturePreview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanScreen(navController: NavController) {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var capturedImage by remember { mutableStateOf<Bitmap?>(null) }

    // Gallery Picker
    val pickImage = rememberLauncherForActivityResult(GetContent()) {
        imageUri = it
        capturedImage = null
    }

    // Camera Capture
    val takePicture = rememberLauncherForActivityResult(TakePicturePreview()) {
        if (it != null) {
            capturedImage = it
            imageUri = null
        }
    }

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
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Upload or Capture an Image")
            Spacer(modifier = Modifier.height(16.dp))

            // Show selected or captured image
            when {
                imageUri != null -> {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = null,
                        modifier = Modifier.size(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                capturedImage != null -> {
                    Image(
                        bitmap = capturedImage!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                else -> {
                    Text("No Image Selected")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { pickImage.launch("image/*") }) {
                    Text("Pick from Gallery")
                }
                Button(onClick = { takePicture.launch(null) }) {
                    Text("Capture Photo")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("result") },
                enabled = imageUri != null || capturedImage != null
            ) {
                Text("Analyze Image")
            }
        }
    }
}
