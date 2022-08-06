package com.iprayforgod.common_data.di

import com.iprayforgod.common_data.service.preferences.SaveUserService
import com.iprayforgod.core.di.qualifiers.IoDispatcher
import com.iprayforgod.core.data.repository.logger.LoggerRepository
import com.iprayforgod.core.data.repository.parser.ParserRepository
import com.iprayforgod.core.data.repository.preference.PreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SaveServiceModule {

    @Provides
    @Singleton
    fun provideSaveUserService(
        parserRepository: ParserRepository,
        preferenceRepository: PreferenceRepository,
        logService: LoggerRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): SaveUserService {
        return SaveUserService(
            parserRepo = parserRepository,
            prefRepo = preferenceRepository,
            log = logService,
            dispatcher = dispatcher
        )
    }
}
