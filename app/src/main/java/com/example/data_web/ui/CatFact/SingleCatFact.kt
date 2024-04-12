package com.example.data_web.ui.CatFact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun SingleCatFact(){
    val viewModel = viewModel<CatFactsViewModel>()

    Box {
        Column(
            Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = viewModel.currentCatFactString)
            Row (
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ){
                Button(onClick = { viewModel.likeCatFact() }) {
                    Text(text = "Like")
                }
                Button(onClick = { viewModel.getRandomFact() }) {
                    Text(text = "Next")
                }
            }

            Text(text = "Saved catfacts: ${viewModel.likedCatFacts.size}", Modifier.padding(10.dp))

            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(viewModel.likedCatFacts) { catFact ->
                    Text(text = catFact.fact)
                }
            }
        }
    }
}