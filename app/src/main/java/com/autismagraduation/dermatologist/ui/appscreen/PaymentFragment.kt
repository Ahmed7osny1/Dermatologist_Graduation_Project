package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.databinding.FragmentPaymentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class PaymentFragment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BtnPaymentSheet.setOnClickListener {

            val dialog = BottomSheetDialog(requireActivity())

            val view = layoutInflater.inflate(R.layout.bottom_sheet_cart, null)


            val btnClose = view.findViewById<ImageView>(R.id.cancel)
            val btnPayment = view.findViewById<Button>(R.id.pay)

            btnClose.setOnClickListener {

                dialog.dismiss()
            }

            btnPayment.setOnClickListener {
                Toast.makeText(activity,"payment",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            dialog.setCancelable(false)

            dialog.setContentView(view)

            dialog.show()

        }

    }


}