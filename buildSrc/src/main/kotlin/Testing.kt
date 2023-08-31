object Testing {
	private const val junitVersion = "4.13.2"
	const val junit4 = "junit:junit:$junitVersion"

	private const val junitAndroidExtVersion = "1.1.5"
	const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

	private const val coroutinesTestVersion = "1.7.1"
	const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

	const val composeUiTest = "androidx.compose.ui:ui-test-junit4"

	const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
	const val uiTooling = "androidx.compose.ui:ui-tooling"
	const val manifest = "androidx.compose.ui:ui-test-manifest"

	const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

	private const val testRunnerVersion = "1.5.2"
	const val testRunner = "androidx.test:runner:$testRunnerVersion"

	const val turbine = "app.cash.turbine:turbine:1.0.0"

}