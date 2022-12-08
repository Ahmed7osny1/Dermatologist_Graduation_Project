package com.autismagraduation.dermatologist.ui.appscreen

import android.Manifest
import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.autismagraduation.dermatologist.databinding.FragmentModelBinding
import java.io.InputStream

class Model : Fragment() {

    private var optionMenu = arrayOf<String>("Take photo","Choose from gallery","Exit")
    private lateinit var binding: FragmentModelBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentModelBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != (PackageManager.PERMISSION_GRANTED)
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            } else if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) !=
                (PackageManager.PERMISSION_GRANTED)
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    2
                )
            } else if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.CAMERA
                ) != (PackageManager.PERMISSION_GRANTED)
            ) {
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(Manifest.permission.CAMERA), 3)
            } else {
                chooseImage(this)
            }
        }

    }

    private fun chooseImage(context: Model) {

        //create dialog for showing the optionMenu
        val builder = AlertDialog.Builder(requireContext())

        //set items in builder
        builder.setItems(optionMenu, DialogInterface.OnClickListener { dialogInterface, i ->
            if (optionMenu[i] == "Take photo") {
                //open the camera
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 3)

            } else if (optionMenu[i] == "Choose from gallery") {
                //choose from external storage
                val intent = Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI

                )
                startActivityForResult(intent, 1)

            } else if (optionMenu[i] == "Exit") {
                dialogInterface.dismiss()
            }
        });
        builder.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            requestCode -> {
                chooseImage(this)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                val uri: Uri = data.data!!

                val inputStream: InputStream? =
                    requireActivity().contentResolver.openInputStream(uri)
                val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
                binding.imagemain.setImageBitmap(bitmap)
            }
        } else if (requestCode == 3 && resultCode == RESULT_OK) {
            val bitmap: Bitmap = data?.extras?.get("data") as Bitmap
            binding.imagemain.setImageBitmap(bitmap)

        }
    }

}