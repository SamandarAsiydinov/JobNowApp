package com.samsdk.myfirstproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.samsdk.myfirstproject.databinding.ItemLayoutBinding
import com.samsdk.myfirstproject.model.Job

class JobAdapter(
) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    lateinit var onClick: (Job) -> Unit

    inner class JobViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var jobs: List<Job>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        return JobViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        holder.binding.apply {
            imageView.setImageResource(job.image)
            textJob.text = job.jobTitle
            textCompany.text = job.company
            textDate.text = job.time
            textLocation.text = job.location
        }
        holder.itemView.setOnClickListener {
            onClick.invoke(job)
        }
    }

    override fun getItemCount(): Int {
        return jobs.size
    }
}