package com.example.androiddevchallenge.composables

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.AppState
import com.example.androiddevchallenge.NetworkImage
import com.example.androiddevchallenge.viewModel.HomeViewModel
import com.jarroyo.jetpackcomposekmp.R
import com.jarroyo.sharedcodeclient.domain.model.Breed

@Composable
fun HomeComposable(appState: AppState, homeViewModel: HomeViewModel) {
    //val activity = (LifecycleOwnerAmbient.current as ComponentActivity)
    val animalList: List<Breed>? by homeViewModel.animalListLiveData.observeAsState()

    /*Column() {
        animalList?.let {
            for (animal in it) {
                Card(Modifier.fillMaxWidth().padding(8.dp),elevation = 4.dp){
                    Text(animal.name)
                }
            }
        }
    }*/
    LazyColumn(contentPadding = PaddingValues(bottom=10.dp),
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = animalList ?: emptyList(), itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    NetworkImage(
                        url = item.image ?: "",
                        Modifier.fillMaxWidth(),
                        circularRevealedEnabled = true
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(item.name)
                    }
                }
            }
        })
    }
    /*ScrollableColumn(modifier = Modifier.padding(16.dp)) {
        animalList?.let {
            for (animal in it) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(16.dp),
                    ){
                        NetworkImage(
                            url = animal.image ?: "",
                            Modifier
                                .fillMaxWidth()
                                .aspectRatio(2.0f),
                            circularRevealedEnabled = true
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 20.sp,
                                color = Color.Black, text = "${animal.name}",
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                onClick = { appState.currentScreen = CurrentScreen.DETAIL; appState.animalSelected = animal}, ) {
                                Text(text = "Detail")
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
            }
        }
    }*/
}