package ru.nb.door_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.HttpClient
import ru.nb.door_data.repo.DoorRepoImpl
import ru.nb.door_domain.repo.DoorRepo

@Module
@InstallIn(ViewModelComponent::class)
//@InstallIn(SingletonComponent::class)
object DoorDataModule {

	@Provides
	@ViewModelScoped
//	@Singleton
	fun providePeopleRepository(httpClient: HttpClient): DoorRepo {
		return DoorRepoImpl(httpClient)
	}

}