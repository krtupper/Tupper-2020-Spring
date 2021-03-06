package com.example.homeworktodo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.example.homeworktodo.HomeworkItemFragment.OnListFragmentInteractionListener
import com.example.homeworktodo.models.HomeworkItem

import kotlinx.android.synthetic.main.fragment_homeworkitem.view.*

/**
 * [RecyclerView.Adapter] that can display a [HomeworkItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class HomeworkItemRecyclerViewAdapter(
    private val mValues: List<HomeworkItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<HomeworkItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as HomeworkItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_homeworkitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.homeworkTitle
        holder.mContentView.text = item.homeworkDescription
        //holder.mContentView.text = item.homeworkDueDate
       // holder.mContentView.integer = item.homeworkPercentage
       // holder.mContentView.text = item.homeworkDueDate
        //holder.mContentView.text = item.homeworkDueDate
       // holder.mContentView.text = item.homeworkDueDate

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
