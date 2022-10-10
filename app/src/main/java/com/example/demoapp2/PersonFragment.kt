package com.example.demoapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp2.adapter.PersonAdapter
import com.example.demoapp2.dataclass.Person
import com.example.demoapp2.viewmodel.PersonViewModel

class PersonFragment : Fragment() {

    private var  adapter = PersonAdapter()
    private val viewModel : PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

//        var personList = mutableListOf(
//            Person(1,"Keerthi",23),
//            Person(2, "Krish", 43),
//            Person(3, "Siva", 5),
//            Person(4,"Mani",22),
//            Person(5, "Kandan",35),
//            Person(6,"lanash", 21),
//            Person(7,"Sangavi", 99)
//        )

        val person1 = Person(1, "Keerthi", 25)
        val person2 = Person(2, "Siva", 23)
        val person3 = Person(3, "Mani", 32)

        //adapter.setPersonList(viewModel.personList)
//        adapter.setPersonData(viewModel.personList)
        adapter.setPersonData(listOf(person1, person2, person3))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)



        val addBtn = view.findViewById<Button>(R.id.addBtn)
        val removeBtn = view.findViewById<Button>(R.id.removeBtn)

        addBtn.setOnClickListener {
            //viewModel.personList.add(Person(4, "New person", 1))
//            val newList = viewModel.personList
//            newList.add(Person(4, "New person", 1))
//            adapter.setPersonData(newList)
//            personList.add(Person(101, "New Person", 2022))
            adapter.setPersonData(listOf(person1, Person(0, "New Person", 9), person2, person3))
        }

        removeBtn.setOnClickListener {
//            viewModel.personList.removeAt(2)
//            val newList = viewModel.personList
//            adapter.setPersonData(newList)
//            personList.removeAt(2)
            adapter.setPersonData(listOf(person1, person2, person3))
        }
    }

}