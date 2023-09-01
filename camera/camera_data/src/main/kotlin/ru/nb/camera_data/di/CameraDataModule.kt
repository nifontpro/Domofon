package ru.nb.camera_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import ru.nb.camera_data.repo.CameraRepoImpl
import ru.nb.camera_data.repo.DbRepo
import ru.nb.camera_data.repo.RestRepo
import ru.nb.camera_domain.repo.CameraRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CameraDataModule {

	@Provides
	@Singleton
	fun provideRestRepo(httpClient: HttpClient): RestRepo {
		return RestRepo(httpClient = httpClient)
	}

	@Provides
	@Singleton
	fun provideDbRepo(realm: Realm): DbRepo {
		return DbRepo(realm = realm)
	}


	@Provides
	@Singleton
	fun providePeopleRepo(restRepo: RestRepo, dbRepo: DbRepo): CameraRepo {
		return CameraRepoImpl(restRepo = restRepo, dbRepo = dbRepo)
	}

}