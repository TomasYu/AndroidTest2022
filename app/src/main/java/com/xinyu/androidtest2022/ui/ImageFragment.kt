package com.xinyu.androidtest2022.ui

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.xinyu.androidtest2022.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false).also {
            it.findViewById<ImageView>(R.id.mdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }

            it.findViewById<ImageView>(R.id.hdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }

            it.findViewById<ImageView>(R.id.xhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}  width ${it.width} height ${it.height}")
            }

            it.findViewById<ImageView>(R.id.xxhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }
            it.findViewById<ImageView>(R.id.xxxhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }


        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ImageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        private const val TAG = "ImageFragment"
    }
}
/**
 *
 在mdpi的机器上 mdpi正常显示 其他都会缩小
1 - 1.5 - 2 - 3 - 4
2022-09-21 13:01:19.729 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size mdpi 3835200
2022-09-21 13:01:19.729 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size hdpi 1705600
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xhdpi 960000  width 0 height 0
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xxhdpi 425600
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xxxhdpi 240000

https://blog.csdn.net/zhujiangtaotaise/article/details/112907477


 */