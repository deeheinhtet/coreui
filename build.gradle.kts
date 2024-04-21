plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.22"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "coreui"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
            api(libs.koin.core)
            api(libs.koin.test)
            api(libs.mvvm.core) // only ViewModel, EventsDispatcher, Dispatchers.UI
            api(libs.mvvm.flow)
            api(projects.shared.coreCommon)
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        }
        commonTest.dependencies {
        }

        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material3)
            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.ui.tooling)
            api(libs.koin.android)
        }
        iosMain.dependencies{}
    }
}

android {
    namespace = "com.dee.coreui"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}
