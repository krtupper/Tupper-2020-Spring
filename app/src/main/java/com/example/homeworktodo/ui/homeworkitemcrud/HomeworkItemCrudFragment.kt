package com.example.homeworktodo.ui.homeworkitemcrud

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworktodo.R
import kotlinx.android.synthetic.main.homework_item_crud_fragment.*

class HomeworkItemCrudFragment : Fragment() {

    companion object {
        fun newInstance() = HomeworkItemCrudFragment()
    }

    private lateinit var viewModel: HomeworkItemCrudViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.homework_item_crud_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeworkItemCrudViewModel::class.java)
        // TODO: Use the ViewModel

        SaveButton.setOnClickListener {
            val homeworkTitle = HomeworkTitleTextView.text.toString()
            val homeworkDescription = HomeworkDescriptionTextView.text.toString()
            val homeworkDueDate = HomeworkDateTextView.text.toString()
            val homeworkPriority = HomeworkPriorityTextView.text.toString()
            val homeworkPoints = HomeworkPointsTextView.text.toString()
            val homeworkPercentage = HomeworkPercentageTextView.text.toString()


    }

}
