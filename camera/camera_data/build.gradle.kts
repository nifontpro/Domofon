apply {
	from("$rootDir/base-module.gradle")
}

dependencies {
	"implementation"(project(Modules.cameraDomain))

	"implementation" (Kotlin.serialization)
	"implementation" (KTor.core)

	"kapt"(Room.roomCompiler)
	"implementation"(Room.roomKtx)
	"implementation"(Room.roomRuntime)
}
