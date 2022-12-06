package suvorov.testtaskmobile

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import suvorov.testtaskmobile.di.*

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                interactorModule,
                preferencesModule,
                viewModelModule
            )
        }
    }
}