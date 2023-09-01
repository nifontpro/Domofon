apply {
	from("$rootDir/base-module.gradle")
}

dependencies {
	"implementation"(project(Modules.baseData))
	"implementation"(project(Modules.baseDomain))
	"implementation"(project(Modules.doorDomain))

	"implementation" (Kotlin.serialization)
	"implementation" (KTor.core)

	"kapt"(Room.roomCompiler)
	"implementation"(Room.roomKtx)
	"implementation"(Room.roomRuntime)
}
