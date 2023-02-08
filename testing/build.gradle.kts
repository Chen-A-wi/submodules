plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.awilab.testing"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":submodules:common"))

    api(libs.junit.jupiter)
    api(libs.junit4)
    api(libs.androidx.test.ext)
    api(libs.androidx.test.espresso.core)
    api(libs.truth)
    api(libs.junit5.api)
    api(libs.junit5.jupiter.engine)
    api(libs.junit5.params)
    api(libs.junit5.vintage.engine)
}