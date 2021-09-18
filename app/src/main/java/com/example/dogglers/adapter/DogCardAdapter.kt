/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource


class DogCardAdapter(private val context: Context, private val layout: Int)
    : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dataset = DataSource.dogs

    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val ageTextView: TextView = view.findViewById(R.id.item_age)
        val hobbiesTextView: TextView = view.findViewById(R.id.item_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        return if (layout == 1){
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            DogCardViewHolder(adapterLayout)
        } else {
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            DogCardViewHolder(adapterLayout)
        }
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context.resources
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.titleTextView.text = resources.getString(R.string.dog_name, item.name)
        holder.ageTextView.text = resources.getString(R.string.dog_age, item.age)
        holder.hobbiesTextView.text = resources.getString(R.string.dog_hobbies, item.hobbies)

    }
}
