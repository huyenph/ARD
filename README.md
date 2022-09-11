# UPM Android - The application using Jetpack Components, Hilt, Compose, etc.

## Project Structure

📦src
 ┣ 📂common
 ┃ ┣ 📂extensions
 ┃ ┗ 📂helper
 ┣ 📂data
 ┃ ┣ 📂datasource
 ┃ ┣ 📂local
 ┃ ┃ ┣ 📂persistence
 ┃ ┃ ┗ 📂storage
 ┃ ┗ 📂remote
 ┃ ┃ ┣ 📂adapter
 ┃ ┃ ┣ 📂helper
 ┃ ┃ ┣ 📂response
 ┃ ┃ ┣ 📜ApiClient.kt
 ┃ ┃ ┣ 📜ApiParams.kt
 ┃ ┃ ┗ 📜ApiService.kt
 ┣ 📂di
 ┣ 📂domain
 ┃ ┣ 📂model
 ┃ ┣ 📂repository
 ┃ ┗ 📂usecase
 ┣ 📂presentation
 ┃ ┣ 📂components
 ┃ ┣ 📂graph
 ┃ ┣ 📂screens
 ┃ ┣ 📂ui
 ┃ ┃ ┗ 📂theme
 ┃ ┃ ┃ ┣ 📜Color.kt
 ┃ ┃ ┃ ┣ 📜Shape.kt
 ┃ ┃ ┃ ┣ 📜Theme.kt
 ┃ ┃ ┃ ┗ 📜Type.kt
 ┃ ┣ 📜BaseViewModel.kt
 ┃ ┣ 📜MainActivity.kt
 ┃ ┗ 📜MainViewModel.kt
 ┗ 📜UpmApplication.kt
