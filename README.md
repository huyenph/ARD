# UPM Android - The application using Jetpack Components, Hilt, Compose, etc.

## Project Structure

📦nativeapp
 ┣ 📂common
 ┃ ┣ 📂extensions
 ┃ ┃ ┣ 📜Constants.kt
 ┃ ┃ ┣ 📜Keyboard.kt
 ┃ ┃ ┣ 📜Network.kt
 ┃ ┃ ┣ 📜String.kt
 ┃ ┃ ┣ 📜Utils.kt
 ┃ ┃ ┗ 📜ViewBinding.kt
 ┃ ┗ 📂helper
 ┃ ┃ ┣ 📜LiveEvent.kt
 ┃ ┃ ┗ 📜SingleLiveEvent.kt
 ┣ 📂data
 ┃ ┣ 📂datasource
 ┃ ┃ ┗ 📜AuthDataSource.kt
 ┃ ┣ 📂local
 ┃ ┃ ┣ 📂persistence
 ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┣ 📜ConfigEntity.kt
 ┃ ┃ ┃ ┃ ┗ 📜UserEntity.kt
 ┃ ┃ ┃ ┣ 📜AppDao.kt
 ┃ ┃ ┃ ┗ 📜AppDatabase.kt
 ┃ ┃ ┗ 📂storage
 ┃ ┃ ┃ ┣ 📜SharedPreferencesStorage.kt
 ┃ ┃ ┃ ┗ 📜Storage.kt
 ┃ ┗ 📂remote
 ┃ ┃ ┣ 📂adapter
 ┃ ┃ ┃ ┣ 📜NetworkResponse.kt
 ┃ ┃ ┃ ┣ 📜NetworkResponseAdapter.kt
 ┃ ┃ ┃ ┣ 📜NetworkResponseAdapterFactory.kt
 ┃ ┃ ┃ ┗ 📜NetworkResponseCall.kt
 ┃ ┃ ┣ 📂helper
 ┃ ┃ ┃ ┣ 📜HttpError.kt
 ┃ ┃ ┃ ┗ 📜HttpInterceptor.kt
 ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┗ 📜ErrorResponse.kt
 ┃ ┃ ┣ 📜ApiClient.kt
 ┃ ┃ ┣ 📜ApiParams.kt
 ┃ ┃ ┗ 📜ApiService.kt
 ┣ 📂di
 ┃ ┣ 📜DatabaseModule.kt
 ┃ ┣ 📜NetworkModule.kt
 ┃ ┗ 📜StorageModule.kt
 ┣ 📂domain
 ┃ ┣ 📂model
 ┃ ┃ ┣ 📜AppConfigModel.kt
 ┃ ┃ ┗ 📜BaseModel.kt
 ┃ ┣ 📂repository
 ┃ ┃ ┗ 📜AuthRepository.kt
 ┃ ┗ 📂usecase
 ┃ ┃ ┗ 📜AuthUseCase.kt
 ┣ 📂presentation
 ┃ ┣ 📂components
 ┃ ┃ ┣ 📜BaseScaffold.kt
 ┃ ┃ ┣ 📜NormalAppBar.kt
 ┃ ┃ ┗ 📜UpmTextField.kt
 ┃ ┣ 📂graph
 ┃ ┃ ┣ 📜UpmDestination.kt
 ┃ ┃ ┗ 📜UpmNavHost.kt
 ┃ ┣ 📂health
 ┃ ┃ ┣ 📂component
 ┃ ┃ ┃ ┣ 📜AlignYourBodyElement.kt
 ┃ ┃ ┃ ┣ 📜AlignYourBodyRow.kt
 ┃ ┃ ┃ ┣ 📜FavoriteCollectionCard.kt
 ┃ ┃ ┃ ┣ 📜FavoriteCollectionsGrid.kt
 ┃ ┃ ┃ ┣ 📜HomeSection.kt
 ┃ ┃ ┃ ┣ 📜MySootheApp.kt
 ┃ ┃ ┃ ┣ 📜SearchBar.kt
 ┃ ┃ ┃ ┗ 📜SootheBottomNavigation.kt
 ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┗ 📜DrawableStringPair.kt
 ┃ ┃ ┗ 📂screen
 ┃ ┃ ┃ ┗ 📜HomeScreen.kt
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂activity
 ┃ ┃ ┗ 📂viewmodel
 ┃ ┣ 📂rally
 ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┗ 📜RallyData.kt
 ┃ ┃ ┣ 📂ui
 ┃ ┃ ┃ ┣ 📂accounts
 ┃ ┃ ┃ ┃ ┗ 📜AccountsScreen.kt
 ┃ ┃ ┃ ┣ 📂bills
 ┃ ┃ ┃ ┃ ┗ 📜BillsScreen.kt
 ┃ ┃ ┃ ┣ 📂components
 ┃ ┃ ┃ ┃ ┣ 📜CommonUI.kt
 ┃ ┃ ┃ ┃ ┣ 📜DetailsScreen.kt
 ┃ ┃ ┃ ┃ ┣ 📜RallyAlertDialog.kt
 ┃ ┃ ┃ ┃ ┣ 📜RallyAnimatedCircle.kt
 ┃ ┃ ┃ ┃ ┗ 📜RallyTabRow.kt
 ┃ ┃ ┃ ┗ 📂overview
 ┃ ┃ ┃ ┃ ┗ 📜OverviewScreen.kt
 ┃ ┃ ┣ 📜RallyApp.kt
 ┃ ┃ ┗ 📜RallyDestinations.kt
 ┃ ┣ 📂screens
 ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┣ 📂components
 ┃ ┃ ┃ ┃ ┣ 📜AuthAppBar.kt
 ┃ ┃ ┃ ┃ ┣ 📜FormDivider.kt
 ┃ ┃ ┃ ┃ ┗ 📜SocialLogin.kt
 ┃ ┃ ┃ ┣ 📜AuthScreen.kt
 ┃ ┃ ┃ ┣ 📜SignInForm.kt
 ┃ ┃ ┃ ┗ 📜SignUpForm.kt
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┗ 📜MainScreen.kt
 ┃ ┃ ┗ 📂settings
 ┃ ┃ ┃ ┣ 📜LanguageScreen.kt
 ┃ ┃ ┃ ┗ 📜SettingsScreen.kt
 ┃ ┣ 📂ui
 ┃ ┃ ┗ 📂theme
 ┃ ┃ ┃ ┣ 📜Color.kt
 ┃ ┃ ┃ ┣ 📜Shape.kt
 ┃ ┃ ┃ ┣ 📜Theme.kt
 ┃ ┃ ┃ ┗ 📜Type.kt
 ┃ ┣ 📂wellness
 ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┗ 📜WellnessTask.kt
 ┃ ┃ ┣ 📂viewmodel
 ┃ ┃ ┃ ┗ 📜WellnessViewModel.kt
 ┃ ┃ ┣ 📜WaterCounter.kt
 ┃ ┃ ┣ 📜WellnessScreen.kt
 ┃ ┃ ┣ 📜WellnessTaskItem.kt
 ┃ ┃ ┗ 📜WellnessTaskList.kt
 ┃ ┣ 📜BaseViewModel.kt
 ┃ ┣ 📜MainActivity.kt
 ┃ ┗ 📜MainViewModel.kt
 ┗ 📜UpmApplication.kt
