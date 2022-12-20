package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.DataAdapter
import com.autismagraduation.dermatologist.data.DataUsed
import com.autismagraduation.dermatologist.databinding.FragmentDataBinding


class DataFragment : Fragment() {

    private lateinit var myArray: ArrayList<DataUsed>
    private lateinit var binding: FragmentDataBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.dataRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<DataUsed>()

// normal skin

        //all skin type
        myArray.add(
            DataUsed(
                R.drawable.hyalu,
                "HYALU COLLAGEN",
                "Eye Cream",
                "To moisturize the area around the eye and protect\n"+" it from wrinkles and lines resulting from the dryness of the area around the eye.\n\n"+
                        "It also helps to lighten the circles around the eye and make the area around the eye brighter, livelier, and a more youthful appearance.\n\n" +
                        "Hyalu Collagen Eye Moisturizing Cream is enriched with caffeine, hyaluronic acid and marine collagen.\n\n" +
                        "I mean, it will be very suitable for moisturizing and nourishing an area under the eye, and resisting wrinkles, fine lines, dark circles and bloating.\n\n" +
                        "I mean, if you suffer from circles, we will know the cause and treat it with the use of the cream, which will improve the shape of the circles due to caffeine.\n\n" +
                        "And we can use it even if there are no circles for hydration and freshness due to hyaluronic acid.\n\n"
            )
        )

        //all skin type
        myArray.add(
            DataUsed(
                R.drawable.seram,
                "INFINITY ANTI_ACING\nDAY SERUM",
                "Maximum protection Against Environmental Agressions",
                "Infinity Hyaluronic Collagen for instant deep hydration, plumper, smoother and younger-looking skin; Because it contains hyaluronic acid and marine collagen by 2%, which will take care of moisturizing your skin and make it smoother and younger.\n\n" +
                        "And not only will it help moisturize and glow the skin and make it elastic; No, it will also protect her from the harmful rays of the sun, because it contains an SPF 30 sun protection factor\n\n" +
                        "It will also help to release collagen in the skin and make it firm and elastic, thus delaying the appearance of fine lines and wrinkles.\n\n" +
                        "How to use it:\n" +
                        "———————\n" +
                        "1- We wash the skin well with your beautiful lotion, according to your skin type. If your skin is oily or mixed, choose a lotion that says Foaming gel, and if your skin is dry, choose a lotion that says Cream.\n\n" +
                        "2-We put hyaluronic acid serum on soggy or semi-wet skin from the inside out.\n\n" +
                        "(Clean and dewy skin, which will greatly help in increasing the absorption of hyaluronic acid in the layers of the skin).\n" +
                        "You will see the best results after 28 days\n"
            )
        )

//dry skin
        //dry &&&& sensitive
        myArray.add(
            DataUsed(
                R.drawable.onsen,
                "ONSEN",
                "Infinity HYALU  Collagen Cleanser",
                "It cleanses the skin well and removes impurities.\n\n"+"It contains strong moisturizers, suitable for dry skin, leaving it soft and moisturized, especially those who suffer from peeling, especially with the winter season.\n\n" +
                        "It will help with freshness and hydration, and your skin will feel so lively, and it will help fill the expression lines with the serum."
            )
        )

//oil skin

        myArray.add(
            DataUsed(
                R.drawable.sebaclaroil,
                "SEBACLAR_HAYAH",
                "TONIC LOTION SKIN",
                "The lotion cleanses the skin from impurities and removes dirt and dust accumulated on the skin,\n"+" thus preventing clogged pores from the impurities \n"+"that accumulate on your skin, which causes problems for your skin, such as pimples and blackheads.\n\n" +
                        "Peace be upon you, if your skin is oily and you used a lotion with acids, zinc, biotin and other effective materials through which you can reach the maximum degree of cleansing the skin and pores.\n\n" +
                        "It will also be antibacterial and inflammatory and regulate fatty secretions."
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.belclinicoil,
                "BEL CLINIC",
                "AGENT TONIC",
                "The toner is the gentle hand that plumps your skin and restores the acidic pH that the skin loves.\n\n" +
                        "It also helps to reduce the size of wide pores, gives freshness and moisturizes the skin.\n\n" +
                        "It is used twice a day, morning and evening, after washing with cotton swabs, and does not rinse.\n\n" +
                        "The toner completes the lotion. As the conditioner moisturizes your hair after you wash it with shampoo.\n\n" +
                        "The lotion cleanses deeply and removes impurities, but it disturbs the skin’s pH and causes dryness in the skin.\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.exfoliating,
                "INFINITY",
                "Infinity Vitamin C Exfoliating Cleanser",
                "It deeply cleanses the skin and contains a percentage of exfoliants that help in lightening with the vitamin C serum from it; If your skin has traces of pills or pigmentation.\n\n" +
                        "How to use the lotion: \n" +
                        "————————————\n\n" +
                        "It is applied to wet skin with a circular massage, then rinsed well morning and evening.\n\n"
            )
        )

        //oil &&&&&& sensitive
        myArray.add(
            DataUsed(
                R.drawable.acrom,
                "Akren",
                "Akren Cleanser",
                "It deeply cleanses the skin, removes impurities, and regulates the secretion of sebum.\n\n"+
                        "It is intended for skin that suffers from pimples, especially pimples under the skin.\n\n"
            )
        )

//mix skin


//sensitive skin



        val adapter = DataAdapter(myArray)
        binding.dataRecycleView.adapter = adapter

        adapter.setonItemClickListener(object: DataAdapter.onItemClickListener {

            override fun dataAction(position: Int) {
                val action = DataFragmentDirections.actionDataFragmentToDataUsedFragment(
                    myArray[position]
                )
                Navigation.findNavController(requireView()).navigate(action)
            }

        })

    }
}