package com.example.homeworktodo.ui.homeworkitemcrud

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworktodo.HomeworkItemCrudActivity
import com.example.homeworktodo.HomeworkManager
import com.example.homeworktodo.R
import kotlinx.android.synthetic.main.homework_item_crud_fragment.*
import kotlinx.android.synthetic.main.homework_item_crud_fragment.view.*

class HomeworkItemCrudFragment : Fragment() {

    companion object {
        fun newInstance() = HomeworkItemCrudFragment()
    }

    private lateinit var viewModel: HomeworkItemCrudViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.homework_item_crud_fragment, container, false)

        val homeworkItem = (activity as HomeworkItemCrudActivity).homeworkItem

        homeworkItem?.let {
            val title = it.homeworkTitle
            val description = it.homeworkDescription

            view.HomeworkTitleTextView.setText(title)
            view.HomeworkDescriptionTextView.setText(description)
        }


       /* val percentage =  HomeworkPercentageTextView.text.toString()
        val finalPercentage = Integer.parseInt(percentage)

        val date =  HomeworkDateTextView.text.toString()
        val finalDate = Integer.parseInt(date)

        val points =  HomeworkPointsTextView.text.toString()
        val finalPoints = Integer.parseInt(points)

        val priority =  HomeworkPriorityTextView.text.toString()
        val finalPriority= Integer.parseInt(priority)


        view.HomeworkPriorityTextView.setText(finalPriority)
        view.HomeworkDateTextView.setText(finalDate)
        view.HomeworkPercentageTextView.setText(finalPercentage)
        view.HomeworkPointsTextView.setText(finalPoints)*/

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeworkItemCrudViewModel::class.java)
        // TODO: Use the ViewModel

        SaveButton.setOnClickListener {
            val homeworkTitle = HomeworkTitleTextView.text.toString()
            val homeworkDescription = HomeworkDescriptionTextView.text.toString()
            val homeworkDueDate = HomeworkDateTextView.text.toString()
            val homeworkPriority = Integer.valueOf(HomeworkPriorityTextView.text.toString())//HomeworkPriorityTextView.text.get
            val homeworkPoints = Integer.valueOf(HomeworkPointsTextView.text.toString())
            val homeworkPercentage = Integer.valueOf(HomeworkPercentageTextView.text.toString())

            HomeworkManager.addHomework(homeworkTitle,homeworkDescription,homeworkDueDate,homeworkPriority,homeworkPoints, homeworkPercentage)
            requireActivity().finish()
        }

    }
}
