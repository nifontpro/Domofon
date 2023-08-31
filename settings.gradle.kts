@file:Suppress("UnstableApiUsage")
pluginManagement {
		repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "Domofon"

include(":app")

include(":camera")
include(":camera:camera_data")
include(":camera:camera_domain")
include(":camera:camera_presenter")

include(":door")
include(":door:door_data")
include(":door:door_domain")
include(":door:door_presenter")
 