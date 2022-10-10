package com.example.demoapp2.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.demoapp2.dataclass.Person

class PersonDiffUtil(
    private val oldPersonList: List<Person>,
    private val newPersonList: List<Person>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldPersonList.size
    }

    override fun getNewListSize(): Int {
        return newPersonList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersonList[oldItemPosition] == newPersonList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldPersonList[oldItemPosition].id != newPersonList[newItemPosition].id -> {
                false
            }
            oldPersonList[oldItemPosition].name != newPersonList[newItemPosition].name -> {
                false
            }
            oldPersonList[oldItemPosition].age != newPersonList[newItemPosition].age -> {
                false
            }
            else -> true
        }
    }
}