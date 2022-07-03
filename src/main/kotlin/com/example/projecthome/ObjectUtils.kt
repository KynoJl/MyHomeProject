package com.example.projecthome

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

const val DEPTH = 10
const val DEFAULT_SIZE = 2

val easyRandom = EasyRandomParameters()
    .overrideDefaultInitialization(true)
    .randomizationDepth(DEPTH)
    .collectionSizeRange(DEFAULT_SIZE, DEFAULT_SIZE)
    .let(::EasyRandom)

inline operator fun <reified T> EasyRandom.invoke(): T = easyRandom.nextObject(T::class.java)
