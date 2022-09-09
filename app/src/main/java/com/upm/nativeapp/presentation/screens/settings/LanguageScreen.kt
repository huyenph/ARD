package com.upm.nativeapp.presentation.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.upm.nativeapp.R
import com.upm.nativeapp.domain.model.LanguageModel
import com.upm.nativeapp.presentation.MainViewModel
import com.upm.nativeapp.presentation.components.BaseScaffold
import com.upm.nativeapp.presentation.components.NormalAppBar
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

@Composable
fun LanguageScreen(navController: NavHostController? = null, mainViewModel: MainViewModel) {
    val languages = mainViewModel.fetchLanguages(LocalContext.current).toMutableStateList()
    BaseScaffold(
        topBar = {
            NormalAppBar(
                title = R.string.language,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(id = R.string.app_actions_description)
                        )
                    }
                },
                onNavIconClicked = { navController?.popBackStack() }
            )
        }
    ) { _ ->
        LazyColumn(modifier = Modifier) {
            items(items = languages, key = { language -> language.locale }) { language ->
                LanguageItem(
                    language = language,
                    onSelected = { selectedLanguage ->
                        mainViewModel.onLanguageChange(selectedLanguage)
                        navController?.popBackStack()
                    })
                Divider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LanguageItem(language: LanguageModel, onSelected: (LanguageModel) -> Unit) {
    ListItem(
        modifier = Modifier.clickable(onClick = { onSelected(language) }),
        text = { Text(text = language.language) },
        secondaryText = { Text(text = language.description) },
        trailing = { Icon(imageVector = Icons.Outlined.Check, contentDescription = null) }
    )
}

@Preview(showBackground = true)
@Composable
private fun OnLanguageScreenPreview() {
    UpmTheme {
        LanguageScreen(mainViewModel = MainViewModel())
    }
}