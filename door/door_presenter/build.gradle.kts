apply {
	from("$rootDir/compose-module.gradle")
}

dependencies {
	"implementation"(project(Modules.baseDomain))
	"implementation"(project(Modules.doorDomain))
}