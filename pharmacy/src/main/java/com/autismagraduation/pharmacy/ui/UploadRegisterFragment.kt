package com.autismagraduation.pharmacy.ui

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.data.ApiClient
import com.autismagraduation.pharmacy.data.RegisterRequest
import com.autismagraduation.pharmacy.data.RegisterResponse
import com.autismagraduation.pharmacy.databinding.FragmentUploadRegisterBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class UploadRegisterFragment : Fragment() {

    private var optionMenu = arrayOf<String>("Take photo","Choose from gallery","Exit")
    private var bitmap: Bitmap? = null
    private var uri: Uri? = null
    private var imagePart: MultipartBody.Part? = null
    private var inputStream: InputStream? = null
    private lateinit var binding: FragmentUploadRegisterBinding
    private lateinit var discription: String
    private lateinit var apiClient: ApiClient
    private val args :UploadRegisterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUploadRegisterBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imagemain.setOnClickListener {

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

        discription = binding.description.editText?.text.toString()

        binding.signupIn.setOnClickListener {

            if (createAccount()){
                Log.d("image","${imagePart}")

                apiClient.getApiService().register(
                    RegisterRequest(
                        name = args.name,
                        email = args.email,
                        password = args.password,
                        phone_number = args.phone,
                        location = args.address,
                        description = discription,
                        //pharmacy_image = imagePart
                    )
                ).enqueue(object : Callback<RegisterResponse> {

                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {

                        Log.d("Auth", "respoonse: ${response}");
                        Toast.makeText(
                            requireContext(), "${response.body()?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                        if(response.body()?.success == true) {
                            Navigation.findNavController(view).navigate(
                                R.id.action_uploadRegisterFragment_to_loginFragment
                            )
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>,
                                           t: Throwable) {
                        // Error logging in
                        Log.d("Auth", "${t.message}");
                        Toast.makeText(requireContext(), "${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }
        }

    }



    private fun createAccount(): Boolean {

        discription = binding.description.editText?.text.toString()

       if (discription.isEmpty()){

                Toast.makeText(requireContext(), "Please Enter your Description",
                    Toast.LENGTH_LONG).show()

       }else return true
        return false
    }

    private fun chooseImage(context: UploadRegisterFragment) {

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

    fun getRealPathFromURI(context: Context, uri: Uri): String? {
        var filePath: String? = null
        val wholeID = DocumentsContract.getDocumentId(uri)
        val id = wholeID.split(":")[1]
        val column = arrayOf(MediaStore.Images.Media.DATA)
        val sel = MediaStore.Images.Media._ID + "=?"
        val cursor: Cursor? = context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column, sel, arrayOf(id), null)
        if (cursor != null) {
            val columnIndex = cursor.getColumnIndex(column[0])
            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex)
            }
            cursor.close()
        }
        return filePath
    }

    fun createPartFromUri(context: Context, uri: Uri, partName: String): MultipartBody.Part {
        val file = File(getRealPathFromURI(context, uri))
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }

    fun createPartFromFile(file: File, partName: String): MultipartBody.Part {
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }

    fun bitmapToFile(bitmap: Bitmap): File {
        val file = File(requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES),
            "image.jpg")
        file.createNewFile()
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val byteArray = stream.toByteArray()
        val fos = FileOutputStream(file)
        fos.write(byteArray)
        fos.close()
        return file
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                uri = data.data!!


                inputStream =
                    requireActivity().contentResolver.openInputStream(uri!!)!!
                bitmap = BitmapFactory.decodeStream(inputStream)
                binding.myImageView.setImageBitmap(bitmap)
            }
        } else if (requestCode == 3 && resultCode == Activity.RESULT_OK) {
            bitmap = data?.extras?.get("data") as Bitmap
            binding.myImageView.setImageBitmap(bitmap)

        }
    }

}