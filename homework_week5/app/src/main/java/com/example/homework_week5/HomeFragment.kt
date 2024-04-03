package com.example.homework_week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.homework_week5.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val userList = mutableListOf<User>(
        User("https://gcs.tripi.vn/public-tripi/tripi-feed/img/474015QSt/anh-gai-xinh-1.jpg"),
        User("https://i.pinimg.com/236x/39/f9/18/39f9189cffd60ad8a341e01031f53b62.jpg"),
        User("https://top10tphcm.com/wp-content/uploads/2023/02/gai-dep-nhat-viet-nam-6.jpg"),
        User("https://storage.googleapis.com/cdn-entrade/bovagau-meme/screenshot_150_1683189265"),
        User("https://genk.mediacdn.vn/2018/10/19/photo-1-15399266837281100315834-15399271585711710441111.png"),
        User("https://bizweb.dktcdn.net/100/438/408/files/la-bai-meme-yody-vn-1.jpg?v=1690426294710"),
        User("https://hoanghamobile.com/tin-tuc/wp-content/uploads/2023/07/anh-meme-9-1.jpg"),
        User("https://catscanman.net/wp-content/uploads/2023/02/a6390f619690577266dacb3e1a361239.jpg")
    )

    private val listPost = mutableListOf<Post>(
        Post(
            "https://gcs.tripi.vn/public-tripi/tripi-feed/img/474015QSt/anh-gai-xinh-1.jpg",
            "Trần Như Quỳnh",
            "Nghệ An",
            "https://i.pinimg.com/736x/05/e8/da/05e8dac6dd3b289e26c11c766956a785.jpg"
        ),

        Post(
            "https://i.pinimg.com/236x/39/f9/18/39f9189cffd60ad8a341e01031f53b62.jpg",
            "Đào Phương Thảo",
            "Hà Nội",
            "https://bizweb.dktcdn.net/100/438/408/files/meme-meo-cute-yody-vn-1.jpg?v=1690276113335"
        ),

        Post(
            "https://top10tphcm.com/wp-content/uploads/2023/02/gai-dep-nhat-viet-nam-6.jpg",
            "Nguyễn Gia Linh",
            "Đà Nẵng",
            "https://i.pinimg.com/736x/f2/3f/64/f23f647b8d208ec50cd2c5b9e4f9b089.jpg"
        )
    )

    private val userAdapter = UserAdapter(userList)
    private val postAdapter = PostAdapter(listPost)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recylerView1.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        binding.recylerView1.adapter = userAdapter

        binding.recylerView2.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.recylerView2.adapter = postAdapter

    }

}



