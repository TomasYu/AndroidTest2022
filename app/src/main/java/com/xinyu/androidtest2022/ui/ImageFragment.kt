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
            it.findViewById<ImageView>(R.id.dpi)?.apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")

            }

            it.findViewById<ImageView>(R.id.mdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }

            it.findViewById<ImageView>(R.id.hdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
//                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.byteCount}")
            }

            it.findViewById<ImageView>(R.id.xhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}  ")
            }

            it.findViewById<ImageView>(R.id.xxhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
            }
            it.findViewById<ImageView>(R.id.xxxhdpi).apply {
                val bitmapDrawable = drawable as BitmapDrawable
                Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount}")
//                post {
//                    Log.d(TAG,"size $tag ${bitmapDrawable.bitmap.allocationByteCount} width $width height $height")
//                }
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
 ???mdpi???????????? mdpi???????????? ??????????????????  ????????????????????????
1 - 1.5 - 2 - 3 - 4
2022-09-21 13:01:19.729 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size mdpi 3835200
2022-09-21 13:01:19.729 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size hdpi 1705600
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xhdpi 960000  width 0 height 0
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xxhdpi 425600
2022-09-21 13:01:19.730 10545-10545/com.xinyu.androidtest2022 D/ImageFragment: size xxxhdpi 240000

https://blog.csdn.net/zhujiangtaotaise/article/details/112907477

???????????????
width * ????????????dpi/???????????????dpi * height * ????????????dpi/???????????????dpi * 4
??????560 ???dpi  ??????????????????????????????xxhdpi
width*560/480*height*560/480*4




????????????????????? ???????????????????????????  ??????????????? ????????????200m ?????????????????????100px ??????????????? ???OOM??????OOM

??????density : 420  ??????????????????????????? ????????????  ?????????   ??????????????????????????????????????????
2022-09-21 15:18:09.335 29223-29223/com.xinyu.androidtest2022 D/ImageFragment: size mdpi 3835200
2022-09-21 15:18:09.335 29223-29223/com.xinyu.androidtest2022 D/ImageFragment: size hdpi 3835200

2022-09-21 15:18:09.335 29223-29223/com.xinyu.androidtest2022 D/ImageFragment: size xhdpi 3835200

2022-09-21 15:18:09.335 29223-29223/com.xinyu.androidtest2022 D/ImageFragment: size xxhdpi 3220800
2022-09-21 15:18:09.335 29223-29223/com.xinyu.androidtest2022 D/ImageFragment: size xxxhdpi 1811700

??????dpi ??? 440   440 / 480


dpi560 api 22
2022-09-21 17:09:21.511 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size dpi 46989600
2022-09-21 17:09:21.511 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size mdpi 46989600
2022-09-21 17:09:21.512 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size hdpi 20876800
2022-09-21 17:09:21.512 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size xhdpi 11743200
2022-09-21 17:09:21.512 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size xxhdpi 5219200
2022-09-21 17:09:21.512 5982-5982/com.xinyu.androidtest2022 D/ImageFragment: size xxxhdpi 2935800

 30?????????  ?????????dpi????????????????????????   ??????????????????????????????????????????

022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size dpi 3835200
2022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size mdpi 3835200
2022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size hdpi 3835200
2022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size xhdpi 3835200
2022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size xxhdpi 3220800
2022-09-21 17:22:09.273 14195-14195/com.xinyu.androidtest2022 D/ImageFragment: size xxxhdpi 1811700

https://blog.csdn.net/baidu_40389775/article/details/124112935
 */