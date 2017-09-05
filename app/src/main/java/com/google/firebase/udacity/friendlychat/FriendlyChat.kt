package com.google.firebase.udacity.friendlychat

import android.app.Application

import timber.log.Timber

class FriendlyChat : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
