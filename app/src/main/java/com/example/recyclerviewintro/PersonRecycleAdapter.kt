package com.example.recyclerviewintro

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonRecycleAdapter(val context: Context, val persons: List<Person>) :
                    RecyclerView.Adapter<PersonRecycleAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    // hur många items finns det i vår datamängd
    override fun getItemCount(): Int {
        Log.d("!!!Adapter", "ItemCount")

        return persons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        Log.d("!!!Adapter", "OnCreateViewHolder")


        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("!!!Adapter", "OnBindViewHolder: $position")


        // när en list_view ska visas så tar vi rätt person från vår lista
        val person = persons[position]

        // sätter vi in den personens uppgifter i vår view
        holder.nameTextView.text = person.name
        holder.ageTextView.text = person.age.toString()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        // när en viewholder skapas letar vi reda på två textviews som finns
        // inne i vår itemview
        val nameTextView = itemView.findViewById<TextView>(R.id.textViewName)
        val ageTextView = itemView.findViewById<TextView>(R.id.textViewAge)
    }

}