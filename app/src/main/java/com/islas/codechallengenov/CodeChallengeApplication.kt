package com.islas.codechallengenov

import android.app.Application
import com.islas.codechallengenov.core.di.networkModule
import com.islas.codechallengenov.core.di.repositoryModule
import com.islas.codechallengenov.core.di.sourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class CodeChallengeApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@CodeChallengeApplication)
            modules(
                repositoryModule,
                sourceModule,
                networkModule
            )
        }
    }
}