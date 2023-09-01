buildscript {
	repositories {
		google()
		mavenCentral()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:8.1.1") // For update
		classpath(Build.hiltAndroidGradlePlugin)
		classpath(Build.kotlinGradlePlugin)
		classpath(Build.kotlinSerializationPlugin)
//		classpath(Build.realmGradlePlugin)
	}
}

plugins {
	id("io.realm.kotlin") version "1.10.0" apply false
}

tasks.register("clean", Delete::class) {
	delete(rootProject.layout.buildDirectory)
}