package com.evanadwyer.auth.data.di

import com.evanadwyer.auth.data.AuthRepositoryImplementation
import com.evanadwyer.auth.data.EmailPatternValidator
import com.evanadwyer.auth.domain.AuthRepository
import com.evanadwyer.auth.domain.PatternValidator
import com.evanadwyer.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImplementation).bind<AuthRepository>()
}