apply {
	from("$rootDir/base-module.gradle")
}

dependencies {
	"implementation"(project(Modules.baseDomain))
	"implementation"(Realm.base)
}
