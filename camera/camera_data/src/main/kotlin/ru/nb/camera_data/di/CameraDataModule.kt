package ru.nb.camera_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.HttpClient
import ru.nb.camera_data.repo.CameraRepoImpl
import ru.nb.camera_domain.repo.CameraRepo

@Module
@InstallIn(ViewModelComponent::class)
//@InstallIn(SingletonComponent::class)
object CameraDataModule {

	@Provides
	@ViewModelScoped
//	@Singleton
	fun providePeopleRepository(httpClient: HttpClient): CameraRepo {
		return CameraRepoImpl(httpClient)
	}

}