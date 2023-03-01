plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id("de.mannodermaus.android-junit5")
}

android {
	namespace = "com.awilab.network"
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
	api(libs.okhttp)
	api(libs.retrofit)
	api(libs.retrofit.moshi)
	implementation(project(":submodules:common"))
	testImplementation(project(":submodules:testing"))
}