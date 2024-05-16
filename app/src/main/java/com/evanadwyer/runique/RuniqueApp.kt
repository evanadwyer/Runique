package com.evanadwyer.runique

import android.app.Application
import com.evanadwyer.auth.data.di.authDataModule
import com.evanadwyer.auth.presentation.di.authViewModelModule
import com.evanadwyer.core.data.di.coreDataModule
import com.evanadwyer.core.database.di.databaseModule
import com.evanadwyer.run.location.di.locationModule
import com.evanadwyer.run.network.di.networkModule
import com.evanadwyer.run.presentation.di.runPresentationModule
import com.evanadwyer.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule
            )
        }
    }
}