package com.example.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Student

class StudentRecyclerViewAdapter(
   private val clickListener: (Student) -> Unit
) : RecyclerView.Adapter<StudentViewHOlder>() {

    private val studentList = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHOlder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return StudentViewHOlder(listItem)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHOlder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    fun setList(students: List<Student>) {
        studentList.clear()
        studentList.addAll(students)
    }

}


class StudentViewHOlder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(student: Student, clickListener: (Student) -> Unit) {
        val nameTextView = view.findViewById<TextView>(R.id.tvName)
        val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
        nameTextView.text = student.name
        emailTextView.text = student.email
        view.setOnClickListener {
            clickListener(student)
        }
    }
}