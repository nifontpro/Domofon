apply {
	from("$rootDir/base-module.gradle")
}

dependencies {
	"implementation"(project(Modules.baseData))
	"implementation"(project(Modules.baseDomain))
	"implementation"(project(Modules.doorDomain))

	"implementation" (Kotlin.serialization)
	"implementation" (KTor.core)
	"implementation" (Realm.core)
}
