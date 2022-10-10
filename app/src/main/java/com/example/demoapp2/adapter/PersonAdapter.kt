package com.example.demoapp2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp2.R
import com.example.demoapp2.dataclass.Person
import com.example.demoapp2.diffutil.PersonDiffUtil

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    //private lateinit var oldPersonList: List<Person>
    private var oldPersonList= listOf<Person>()

    fun setPersonList(personList: List<Person>){
        //this.oldPersonList = personList
    }

    inner class PersonViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_person,parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val id = holder.view.findViewById<TextView>(R.id.id_txt_view)
        val name = holder.view.findViewById<TextView>(R.id.name_txt_view)
        val age = holder.view.findViewById<TextView>(R.id.age_txt_view)
        id.text = "${oldPersonList[position].id}. "
        name.text = oldPersonList[position].name
        age.text = "AGE - ${oldPersonList[position].age}"
    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    fun setPersonData(newPersonList: List<Person>){
        println("old list is $oldPersonList")
        println("new list is $newPersonList")
        val diffUtil = PersonDiffUtil(oldPersonList, newPersonList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldPersonList = newPersonList
        diffResult.dispatchUpdatesTo(this)
    }
}