package fi.metropolia.bibeks.labexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.metropolia.bibeks.labexercises.ui.theme.LabExercisesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabExercisesTheme {
                    HelloWorld2()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloWorld2() {
    var isToggleOn by rememberSaveable { mutableStateOf(true) }
    var textFieldText by rememberSaveable { mutableStateOf("") }
    var lastInput by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Big box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .shadow(10.dp)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.BottomCenter
        ) {
            val displayText = if (lastInput.isEmpty()) {
                if (isToggleOn) {
                    stringResource(R.string.hello_world)
                } else {
                    stringResource(R.string.goodbye)
                }
            } else {
                "Hello $lastInput!"
            }

            Text(
                text = displayText,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.TopCenter)
            )

            // Smaller box
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.3f)
                    .padding(10.dp)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string._2), fontSize = 20.sp, color = Color.White)
            }
        }

        // Space between the big box and the button
        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        // Text field
        TextField(
            value = textFieldText,
            onValueChange = { textFieldText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Space
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.1f)
        )

        // Click me button
        Button(
            onClick = {
                lastInput = textFieldText
                if (textFieldText.isEmpty()) {
                    isToggleOn = !isToggleOn
                } else {
                    textFieldText = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(stringResource(R.string.click_me), modifier = Modifier.padding(start = 8.dp))
        }
    }
}














