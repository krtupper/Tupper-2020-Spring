package com.example.homeworktodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworktodo.models.HomeworkItem
import com.example.homeworktodo.ui.homeworkitemcrud.HomeworkItemCrudFragment

class HomeworkItemCrudActivity : AppCompatActivity() {
    var homeworkItem:HomeworkItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homework_item_crud_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeworkItemCrudFragment.newInstance())
                .commitNow()
            val bundleExtra = intent.getSerializableExtra("homeworkItem")
            bundleExtra?.let {
                homeworkItem = it as HomeworkItem
            }
        }
    }

}
