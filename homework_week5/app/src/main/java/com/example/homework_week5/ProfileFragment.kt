package com.example.homework_week5

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.homework_week5.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view.context).load("https://giaydantuong.edu.vn/wp-content/uploads/2023/04/anh-gai-dep-lam-avatar-che-mat-1.jpg").into(view.findViewById(R.id.str1))
        Glide.with(view.context).load("https://thethaodonga.com/wp-content/uploads/2023/05/hinh-anh-qua-bong-da-dep-2.jpg").into(view.findViewById(R.id.str2))
        Glide.with(view.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP9sS46s10n9BQM_ghd4yYsHULiuxZU6cW7bZVoJyNug&s").into(view.findViewById(R.id.str3))

        Glide.with(view.context).load("https://cdn.vjshop.vn/tin-tuc/5-cach-cai-thien-bo-cuc-anh-phong-canh-thong-qua-phoi-sang-lau/cai-thien-anh-phong-canh-bang-phuong-phap-chup-phoi-sang-lau.jpg").into(view.findViewById(R.id.img1))
        Glide.with(view.context).load("https://vcdn1-dulich.vnecdn.net/2021/10/23/49483719-10115915-image-a-11-1634848573982.jpg?w=460&h=0&q=100&dpr=2&fit=crop&s=5C4xYePyL8zH2aZ3P_Zimg").into(view.findViewById(R.id.img2))
        Glide.with(view.context).load("https://static-images.vnncdn.net/files/publish/2022/12/25/2022-12-14t000000z-170963964-up1eice1h8c86-rtrmadp-3-soccer-worldcup-fra-mar-report-229.jpg").into(view.findViewById(R.id.img3))

        Glide.with(view.context).load("https://cdnphoto.dantri.com.vn/YAfcu9nd4T5dX06hhpaf19_QvY8=/thumb_w/960/2021/05/15/co-gai-noi-nhu-con-vi-anh-can-cuoc-xinh-nhu-mong-nhan-sac-ngoai-doi-con-bat-ngo-hon-2-1621075314070.jpg").into(view.findViewById(R.id.img4))
        Glide.with(view.context).load("https://thethaodonga.com/wp-content/uploads/2023/05/hinh-anh-qua-bong-da-dep-2.jpg").into(view.findViewById(R.id.img5))
        Glide.with(view.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP9sS46s10n9BQM_ghd4yYsHULiuxZU6cW7bZVoJyNug&s").into(view.findViewById(R.id.img7))

        Glide.with(view.context).load("https://cdn.vn.alongwalk.info/vn/wp-content/uploads/2023/02/15170250/image-top-100-anh-gai-xinh-tik-tok-cute-dang-yeu-thoi-thuong-cuc-hot-167643017042558.jpg").into(view.findViewById(R.id.img6))

        Glide.with(view.context).load("https://giaydantuong.edu.vn/wp-content/uploads/2023/04/anh-gai-dep-lam-avatar-che-mat-1.jpg").into(view.findViewById(R.id.img10))
        Glide.with(view.context).load("https://thethaodonga.com/wp-content/uploads/2023/05/hinh-anh-qua-bong-da-dep-2.jpg").into(view.findViewById(R.id.img11))
        Glide.with(view.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP9sS46s10n9BQM_ghd4yYsHULiuxZU6cW7bZVoJyNug&s").into(view.findViewById(R.id.img12))

    }
}