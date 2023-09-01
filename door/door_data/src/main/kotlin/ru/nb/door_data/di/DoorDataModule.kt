package ru.nb.door_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import ru.nb.door_data.repo.DbRepo
import ru.nb.door_data.repo.DoorRepoImpl
import ru.nb.door_data.repo.RestRepo
import ru.nb.door_domain.repo.DoorRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DoorDataModule {

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
	fun providePeopleRepo(restRepo: RestRepo, dbRepo: DbRepo): DoorRepo {
		return DoorRepoImpl(restRepo = restRepo, dbRepo = dbRepo)
	}

}