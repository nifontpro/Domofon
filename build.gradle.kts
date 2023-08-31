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
	}
}

tasks.register("clean", Delete::class) {
	delete(rootProject.layout.buildDirectory)
}