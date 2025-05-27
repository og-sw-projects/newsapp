# NewsApp

A modern Android news reader app built with Jetpack Compose, integrating NewsAPI for fetching top headlines. Features include:

- Clean, Material3 UI with smooth navigation
- Pull-to-refresh and pagination support
- Robust error and empty state handling
- ViewModel architecture with Hilt dependency injection
- Paging 3 for efficient data loading
- Unit tests for ViewModel

## Features

- Display latest top headlines in a scrollable list
- View article details with full content
- Pull to refresh articles
- Infinite scrolling with Paging 3
- Error messages and retry option
- Empty state UI for no results

## Tech stack

- Kotlin & Jetpack Compose
- AndroidX Navigation Compose
- Hilt for dependency injection
- Paging 3 library
- Retrofit + OkHttp for networking
- Coroutine Flows
- Material3 design system
- MockK, Turbine for testing

### Prerequisites

- Android Studio Meerkat Feature Drop or later
- Android SDK 31+
- Java 17
- Kotlin 1.9+
- Gradle 8.2+

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/<your-repo>.git
   cd <your-repo>
   ```
2. Build and run the app on your device or emulator.

### Running tests

Run unit tests with:
```bash
./gradlew test
```
