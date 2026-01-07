# SesDrawer - Advanced Navigation Drawer

SesDrawer is a modern Android application built with **Jetpack Compose** that demonstrates a dynamic, API-driven Navigation Drawer following Material 3 design principles.

## 🚀 Features

- **Dynamic Data Fetching**: Fetches navigation items and user profiles from a remote REST API using Retrofit.
- **Custom Profile Section**: Displays user avatar and name in a stylized card layout.
- **Smart Grid Menu**: Organizes drawer items into a responsive 2-column grid.
- **"See More" Logic**: Limits the "Apps" section to 4 items initially, with a smooth expansion toggle to show all items.
- **Interactive Dashboard**: A clean, modern home screen with a welcome greeting, getting started guide, and quick statistics.
- **Robust Error Handling**: Includes loading states, null-safety for API responses, and a "Retry" mechanism for network failures.

## 🛠 Tech Stack

- **UI**: Jetpack Compose (Material 3)
- **Networking**: Retrofit 2 & OkHttp 3
- **JSON Parsing**: GSON
- **Image Loading**: Coil
- **Architecture**: MVVM (Model-View-ViewModel)
- **Asynchrony**: Kotlin Coroutines & Flow
- **Navigation**: Compose Navigation

## 📋 Prerequisites

- Android Studio Koala or newer.
- JDK 17 or 21.
- Android API Level 24+ (Min SDK) / 36 (Compile SDK).

## ⚙️ Installation & Setup

1. **Clone the Project**:
   ```bash
   git clone <repository-url>
   ```

2. **Open in Android Studio**:
   Launch Android Studio and select "Open" to navigate to the project folder.

3. **Gradle Sync**:
   Wait for the project to sync. If you encounter SDK issues, ensure you have **Android SDK 35/36** installed via the SDK Manager.

4. **API Configuration**:
   The app is pre-configured to hit the following endpoint:
   `https://demo.socialnetworking.solutions/sesapi/navigation`

   Parameters used:
   - `restApi`: Sesapi
   - `sesapi_platform`: 1
   - `auth_token`: B179086bb56c32731633335762

## 🏗 Project Structure

- **`data/`**: Contains `NavigationModels` (JSON mapping), `ApiService` (Retrofit interface), and `NavigationRepository`.
- **`viewmodel/`**: Contains `DrawerViewModel` for state management and `DrawerUiState` for handling Success/Error/Loading.
- **`ui/drawer/`**: The core UI for the drawer, including `DrawerScreen` and `DrawerContent`.
- **`ui/component/`**: Reusable Compose components like `ProfileSection`, `AppsSection`, and `DrawerGridItem`.
- **`MainScreen.kt`**: The primary dashboard layout that hosts the `ModalNavigationDrawer`.

## 🏃 How to Run

1. Connect an Android device or launch an Emulator.
2. Click the **Run** button in Android Studio.
3. The app will launch directly into the **Dashboard**. 
4. Click the **Menu Icon** (top-left) or the **"Open Drawer"** button to see the dynamic navigation drawer.

## 🛠 Troubleshooting

- **API returned empty response**: This usually means the `auth_token` provided by the server has expired. Verify the token in `NavigationRepository.kt`.
- **Unresolved References (GET/Retrofit)**: Perform a `File > Invalidate Caches > Invalidate and Restart` to fix IDE indexing issues.
- **Build Errors**: Ensure your `build.gradle.kts` matches the `compileSdk = 36` requirement for the latest Android 15 libraries.

---
*Created for the Social Networking Solutions (SNS) Navigation Task.*
