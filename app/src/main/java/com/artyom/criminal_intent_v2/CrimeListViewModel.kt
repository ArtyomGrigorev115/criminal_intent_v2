package com.artyom.criminal_intent_v2

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

   /* val crimes = mutableListOf<Crime>()
    init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }*/

    private val crimeRepository = CrimeRepository.get()
   // val crimes = crimeRepository.getCrimes()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }

}