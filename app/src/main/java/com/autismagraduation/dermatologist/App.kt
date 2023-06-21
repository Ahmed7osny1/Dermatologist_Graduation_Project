package com.autismagraduation.dermatologist

import android.app.Application
import android.content.res.Resources


class App : Application() {
    companion object {
        private lateinit var resourcess: Resources

        fun getAppResources(): Resources {
            return resourcess
        }
    }

    override fun onCreate() {
        super.onCreate()
        resourcess = resources
    }
}