package com.artyom.criminal_intent_v2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

import com.artyom.criminal_intent_v2.Crime

@Database(entities = [Crime::class], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDataBase : RoomDatabase() {

    abstract fun crimeDao(): CrimeDao

}