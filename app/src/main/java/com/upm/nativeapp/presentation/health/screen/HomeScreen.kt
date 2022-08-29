package com.upm.nativeapp.presentation.health.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.health.component.AlignYourBodyRow
import com.upm.nativeapp.presentation.health.component.FavoriteCollectionsGrid
import com.upm.nativeapp.presentation.health.component.HomeSection
import com.upm.nativeapp.presentation.health.component.SearchBar
import com.upm.nativeapp.presentation.ui.theme.UpmAndroidTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun OnHomeScreenPreview() {
    UpmAndroidTheme { HomeScreen() }
}