package edu.iesam.dam2024.app

import android.app.Application
import edu.iesam.dam2024.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class IesamApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@IesamApp)
            //modules() un modulo van a ser clases en las que implementemos instancias?
            modules(AppModule().module)
        }
    }
}