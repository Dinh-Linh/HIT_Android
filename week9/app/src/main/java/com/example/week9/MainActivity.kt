package com.example.week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val listStudent = mutableListOf<Student>(
        Student("Dinh Linh", 20, "Nghe An"),
        Student("Minh Quan", 21, "Ha Noi"),
        Student("Chua Nghi ra ten", 19, "Da Nang")
    )
    private val studentAdapter = StudentAdapter(listStudent)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //binding.recyclerView.adapter = studentAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        /*   val apiStudent = RetrofitClient.getClient().create(StudentAPI::class.java)


           apiStudent.getAllStudent().enqueue(
               object : Callback<List<Student>> {
                   override fun onResponse(
                       call: Call<List<Student>>,
                       response: Response<List<Student>>
                   ) {
                       if (response.isSuccessful) {
                           binding.recyclerView.adapter = response.body()?.let { StudentAdapter(it) }
                       } else {

                       }
                   }

                   override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                       Toast.makeText(this@MainActivity, "Don't get data from api", Toast.LENGTH_LONG)
                           .show()
                   }

               }
           )*/
        val apiStudent = RetrofitClient.getClient().create(StudentAPI::class.java)
        binding.search.setOnClickListener {
            val id = binding.studentId.text.toString()
            apiStudent.getStudentById(id).enqueue(object : Callback<Student> {
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    if (response.isSuccessful) {
                        val student = response.body()
                        with(binding) {
                            name.text = student?.name
                            address.text = student?.address
                            age.text = student?.age.toString()
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "Not found", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {

                }

            })
        }

        binding.create.setOnClickListener {
            val student = Student(
                name = "Haha",
                age = 18,
                address = "Khong bic"
            )
            apiStudent.createStudent(student).enqueue(object : Callback<Student> {
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@MainActivity, "Add successful", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {

                }
            })
        }
    }
}

