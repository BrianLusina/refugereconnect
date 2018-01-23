package com.reconnect.refuge.di.qualifiers

import javax.inject.Qualifier

/**
 * @author lusinabrian on 22/08/17.
 * @Notes Qualifier used by Dagger to 'differentiate' this String from others provided by Dagger
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseQualifier
