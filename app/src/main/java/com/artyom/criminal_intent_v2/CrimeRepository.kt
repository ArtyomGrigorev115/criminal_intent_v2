package com.artyom.criminal_intent_v2

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.artyom.criminal_intent_v2.database.CrimeDataBase
import com.artyom.criminal_intent_v2.database.migration_1_2
import java.io.File
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context){

    private val database : CrimeDataBase = Room.databaseBuilder(context.applicationContext,  CrimeDataBase::class.java, DATABASE_NAME).addMigrations(
        migration_1_2).build()

    private val crimeDao = database.crimeDao()
    private val executor = Executors.newSingleThreadExecutor()
    private val filesDir = context.applicationContext.filesDir

    //fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    //fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    fun updateCrime(crime: Crime) {
        executor.execute {
            crimeDao.updateCrime(crime)
        }
    }

    fun addCrime(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(crime)
        }
    }

    fun getPhotoFile(crime: Crime): File = File(filesDir, crime.photoFileName)

    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }
        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}