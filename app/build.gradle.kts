plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("plugin.serialization")
	id("com.google.dagger.hilt.android")
	id("kotlin-kapt")
//	id("realm-android")
	id("io.realm.kotlin")
}

kapt {
	correctErrorTypes = true
}

android {
	namespace = ProjectConfig.appId
	compileSdk = ProjectConfig.compileSdk

	defaultConfig {
		applicationId = ProjectConfig.appId
		minSdk = ProjectConfig.minSdk
		targetSdk = ProjectConfig.targetSdk
		versionCode = ProjectConfig.versionCode
		versionName = ProjectConfig.versionName

//		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		testInstrumentationRunner = "ru.nb.starwars.HiltTestRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
//		sourceCompatibility = JavaVersion.VERSION_1_8
//		targetCompatibility = JavaVersion.VERSION_1_8

		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
//		jvmTarget = "1.8"
		jvmTarget = "17"
	}

	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs> {
//	kotlinOptions {
//		jvmTarget = "1.8"
//	}
//}

dependencies {
	implementation(project(Modules.cameraData))
	implementation(project(Modules.cameraDomain))
	implementation(project(Modules.cameraPresenter))

	implementation(project(Modules.doorData))
	implementation(project(Modules.doorDomain))
	implementation(project(Modules.doorPresenter))

	implementation(DaggerHilt.hiltAndroid)
	kapt(DaggerHilt.hiltCompiler)

	implementation(AndroidX.coreKtx)
	implementation(Compose.activityCompose)

	implementation(platform(Compose.bom))
	implementation(Compose.ui)
	implementation(Compose.uiGraphics)
	implementation(Compose.uiToolingPreview)
	implementation(Compose.material3)
	implementation(Compose.materialIcon)
	implementation(Compose.viewModelCompose)
	implementation(Compose.navigation)
	implementation(Compose.hiltNavigationCompose)
	implementation(Compose.coilCompose)

	implementation(Kotlin.serialization)
	implementation(KTor.core)
	implementation(KTor.android)
	implementation(KTor.negotiation)
	implementation(KTor.json)
	implementation(KTor.kotlinJson)
	implementation(KTor.logging)

//	kapt(Room.roomCompiler)
//	implementation(Room.roomKtx)
//	implementation(Room.roomRuntime)

	implementation(Realm.base)

	testImplementation(Testing.junit4)
	androidTestImplementation(Testing.junitAndroidExt)
	androidTestImplementation(Testing.espresso)

	androidTestImplementation(platform(Compose.bom))
	androidTestImplementation(Testing.composeUiTest)
	androidTestImplementation(Testing.coroutines)
	androidTestImplementation(Testing.turbine)
	debugImplementation(Testing.uiTooling)
	debugImplementation(Testing.manifest)

	androidTestImplementation(Testing.hiltTesting)
	kaptAndroidTest(DaggerHilt.hiltCompiler)
}