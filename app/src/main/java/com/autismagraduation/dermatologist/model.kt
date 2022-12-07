package com.autismagraduation.dermatologist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [model.newInstance] factory method to
 * create an instance of this fragment.
 */
class model : Fragment() {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_model, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment model.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                model().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}




//import android.Manifest
//import android.app.AlertDialog
//import android.content.Context
//import android.content.DialogInterface
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.provider.MediaStore
//import android.widget.Button
//import android.widget.ImageView
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import java.io.InputStream
//
//class model : AppCompatActivity() {
//
//    var optionMenu = arrayOf<String>("Take photo","Choose from gallery","Exit")
//    var  mBtn:Button?=null
//    var  mImg:ImageView?=null
//    var  pickImage=100
//    var imageUri:Uri?=null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_model)
//
//        init()
//        setOnClickListener()
//    }
//
//    fun init(){
//
//        mBtn=findViewById(R.id.button) as Button
//        mImg=findViewById(R.id.imagemain) as ImageView
//    }
//
//    fun setOnClickListener(){
//        mBtn!!.setOnClickListener({
//
//            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=(PackageManager.PERMISSION_GRANTED)){
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
//            }
//            else if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
//                (PackageManager.PERMISSION_GRANTED)){
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),2)
//            }
//            else if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=(PackageManager.PERMISSION_GRANTED)){
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),3)
//            }
//            else{
//                chooseImage(this)
//            }
//        })
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when(requestCode){
//            requestCode->{
//                chooseImage(this)
//            }
//        }
//    }
//
//    fun chooseImage(context: Context){
//
//        //create dialog for showing the optionMenu
//        val builder = AlertDialog.Builder(context)
//
//        //set items in builder
//        builder.setItems(optionMenu, DialogInterface.OnClickListener { dialogInterface, i ->
//            if (optionMenu[i].equals("Take photo")) {
//                //open the camera
//                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivityForResult(intent,3)
//
//            } else if (optionMenu[i].equals("Choose from gallery")){
//                //choose from external storage
//                var intent = Intent(
//                    Intent.ACTION_PICK,
//                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//
//                )
//                startActivityForResult(intent,1)
//
//            } else if (optionMenu[i].equals("Exit")){
//                dialogInterface.dismiss()
//            }
//        });
//        builder.show()
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode==1 && resultCode== RESULT_OK){
//            if (data!=null){
//                var uri : Uri = data.getData()!!
//
//                var inputStream: InputStream? =getContentResolver().openInputStream(uri)
//                var bitmap:Bitmap=BitmapFactory.decodeStream(inputStream)
//                mImg!!.setImageBitmap(bitmap)
//            }
//        }
//        else if (requestCode==3 && resultCode== RESULT_OK){
//            var bitmap:Bitmap= data?.getExtras()?.get("data") as Bitmap
//            mImg!!.setImageBitmap(bitmap)
//
//        }
//    }
//
//}