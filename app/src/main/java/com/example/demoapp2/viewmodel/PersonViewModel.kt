package com.example.demoapp2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.demoapp2.dataclass.Person

class PersonViewModel: ViewModel() {

    var personList = mutableListOf(
        Person(1,"Keerthi",23),
        Person(2, "Krish", 43),
        Person(3, "Siva", 5),
        Person(4,"Mani",22),
        Person(5, "Kandan",35),
        Person(6,"lanash", 21),
        Person(7,"Sangavi", 99)
    )

}