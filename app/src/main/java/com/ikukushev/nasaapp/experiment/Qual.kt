package com.ikukushev.nasaapp.experiment

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class FalseBoolean

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class TrueBoolean