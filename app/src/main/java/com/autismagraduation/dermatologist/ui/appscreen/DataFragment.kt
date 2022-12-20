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
                "\nTo moisturize the area around the eye and protect\n"+" it from wrinkles and lines resulting from the dryness of the area around the eye.\n\n"+
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
                "\nIt cleanses the skin well and removes impurities.\n\n"+"It contains strong moisturizers, suitable for dry skin, leaving it soft and moisturized, especially those who suffer from peeling, especially with the winter season.\n\n" +
                         "It will help with freshness and hydration, and your skin will feel so lively, and it will help fill the expression lines with the serum."
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.qu,
                "QV Cream",
                "Replenishes dry skin",
                "\n\n\nA cream that treats dry skin and cracked hands and feet.\n\n" +
                         "It contains panthenol, zinc oxide and glycerin.\n\n" +
                         "\n"+
                         "His method: - Apply twice a day.\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.infinity,
                "INFINITY",
                "Infinity Moisturizing Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                         "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                         "(Dry skin loves moisture.)\n" +
                         " \n" +
                         "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                         "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.skular,
                "SKYKUR",
                "Skin Skykur Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.sosoft,
                "A V O N ",
                "Sovesoft Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.pluscreamr,
                "PLUS CREAM",
                "Frescura Relajante",
                "\n\n\nDry skin moisturizing cream\n\n" +
                         "Hipantene plus Cream\n"+
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.carwhite,
                "CARO WHITE",
                "Creme De Beaute Eclaircissante",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.vano,
                "VANO",
                "Cream Macro",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.stairline,
                "Straline",
                "Emollient Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.emollient,
                "Emollient",
                "Shaan Emollient Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.atoderm,
                "ATODERM PP",
                "Atoderm intensive baume",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.mondd,
                "MONDD",
                "Mondo Cream",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.derm,
                "DERM",
                "Creme Hydratante Survitaminee",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.eva,
                "EVA",
                "Doll",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.nive,
                "NINEA",
                "Monouku",
                "\n\n\nDry skin moisturizing cream\n\n" +
                        "((For dry and atopic skin))\n" +
                        "  - - - - - - - - - - - - - - - -\n\n" +
                        "(Dry skin loves moisture.)\n" +
                        " \n" +
                        "The cream to moisturize the face and hands and care for dry and damaged skin.\n\n\n" +
                        "Its advantage is that its formula is light and absorbs quickly from the skin for daily care of dry and severely dry skin.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.ceravecream,
                "Cerave Cream",
                "For dry and very dry skin",
                "\n\n\nA cream that protects and treats skin prone to dryness, such as the hands and elbows.\n\n\n" +
                        "It also treats skin redness, sunburn, and irritated skin.\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.emolientowy,
                "Emotopic Cream",
                "Pharmaceris Emotopic Emollient Cream",
                "Polish cream used to care for dry and very dry skin.\n\n" +
                         "Moisturizing and soothing for the skin treats the roughness of the skin.\n\n" +
                         "It is used for all ages.\n\n" +
                         "Used 3 times a day for face, hand or body.\n\n" +
                         "It contains a combination of moisturizing elements from Canola Oil & Sodium Hyaluronate & Hemp Oil\n\n" +
                         "It also contains omega 3, 6, 9 and vitamin E, which give the skin softness and hydration for a long time.\n\n" +
                         "It is also suitable for soothing sensitive, inflamed skin due to exposure to external environmental factors.\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.cept,
                "Cetaphil cream",
                "Nourishes & Soothes & Protects",
                "\n\nMoisturizing cream for dry and very dry skin and severe dehydration.\n\n" +
                         "Moisturizing cream for rash-prone skin.\n\n" +
                         "A cream that nourishes, soothes and protects the skin.\n\n" +
                         "Perfume free and also suitable for sensitive skin.\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.vaseline,
                "Vaseline",
                "Lip Therapy",
                "\nLip balm if your lips are dry and flaky, especially with the onset of winter\n\n" +
                        "Literally very strong moisturizing, no matter how dry your lips are,\n"+
                        "because they contain shea butter, coconut oil, panthenol, cocoa butter, their texture is light and their scent is very sweet and very calm\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.lipshaan,
                "SHAAN",
                "LIB BALM",
                "\nLip balm if your lips are dry and flaky, especially with the onset of winter\n\n" +
                        "Literally very strong moisturizing, no matter how dry your lips are,\n" +
                        " because they contain shea butter, coconut oil, panthenol, cocoa butter, their texture is light and their scent is very sweet and very calm\n\n"
            )
        )




//oil skin

        myArray.add(
            DataUsed(
                R.drawable.sebaclar,
                "SEBACLAR_HAYAH",
                "TONIC LOTION SKIN",
                "\n\nThe lotion cleanses the skin from impurities and removes dirt and dust accumulated on the skin,\n"+
                         "thus preventing clogged pores from the impurities that accumulate on your skin, which causes problems for your skin, such as pimples and blackheads.\n\n" +
                         "Peace be upon you, if your skin is oily and you used a lotion with acids, zinc, biotin and other effective materials through which you can reach the maximum degree of cleansing the skin and pores.\n\n" +
                         "It will also be antibacterial and inflammatory and regulate fatty secretions.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.vicy,
                "VICHY",
                "Liftactiv Specialist B3 Serum",
                "It is vitamin B3 Something like this is greatness and has wonderful effects on the skin.\n\n" +
                         "Scientifically proven to be niacinamide\n" +
                         "brightens the complexion,reduces pores,reduces fat secretion\n" +
                         "It has an anti-inflammatory and anti-bacterial effect,reduces the appearance of fine lines , improves skin elasticity\n\n" +
                         "Also called nicotinamide, it is the active form of niacin or vitamin B3, but idiomatically, this name is given to both of them.\n\n" +
                         "This is an organic compound, which is involved in many vital processes in the human body, including the formation of one of the most important compounds in the energy conversion process, which are NAD and NADP enzymes.\n" +
                         "\n" +
                         "Ok, what does he do for the skin?\n" +
                         "Equation of the deficiency of nicotinamide \"responsible for the formation of energy compounds\" in the skin associated with aging.\n\n" +
                         "Regulating the production of ceramides, the “lipid barrier” in the skin, and improving the condition of the skin barrier.\n\n" +
                         "Stimulating the collagen production process.\n" +
                         "Organizing the cell growth process for its final form in a healthy way.\n" +
                         "It resists the effect of ultraviolet radiation on immune and molecular interactions.\n\n" +
                         "Reducing the formation of pigmentation in the skin by preventing the transfer of melanin from the constituent cells to the surface cell layer.\n" +
                         "Regulate the secretion of fats associated with inflammatory pimples and reduce the symptoms of inflammation, thus improving the shape of the pores.\n\n" +
                         "Anti-photoaging \"sun exposure\""
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.soothing,
                "Soothing Gel",
                "With Almond Oil,Allontion and Vitamin E",
                "\n\nA moisturizer for oily skin with aloe vera, chamomile and vitamin E with a lip balm (gift)\n\n" +
                        " to moisturize and nourish lips and treat dry, peeling lips, especially with the onset of winter,\n\n" +
                        " because they are rich in panthenol, cocoa butter and honey.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.belclinic,
                "BEL CLINIC",
                "AGENT TONIC",
                "\n\nThe toner is the gentle hand that plumps your skin and restores the acidic pH that the skin loves.\n\n" +
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
                "\n\nIt deeply cleanses the skin and contains a percentage of exfoliants that help in lightening with the vitamin C serum from it; If your skin has traces of pills or pigmentation.\n\n" +
                        "How to use the lotion: \n" +
                        "————————————\n\n" +
                        "It is applied to wet skin with a circular massage, then rinsed well morning and evening.\n\n"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.biogreen,
                "BIODERAM",
                "Bioderma Sensibo H2O Micellar Water Makeup Remover ",
                "\n\nMicellar makeup remover water gently cleanses and removes makeup and impurities from the face and eyes without irritating the skin.\n\n" +
                         "Your skin feels fresh, clean and clear\n\n" +
                         "Free of fragrances and does not cause allergies\n\n" +
                         "How to use :\n" +
                         "Put it on a piece of cotton, then remove makeup from the face and eyes, then dry gently"
            )
        )

        //oil &&&&&& sensitive
        myArray.add(
            DataUsed(
                R.drawable.acrom,
                "Akren",
                "Akren Cleanser",
                "\n\nIt deeply cleanses the skin, removes impurities, and regulates the secretion of sebum.\n\n"+
                         "It is intended for skin that suffers from pimples, especially pimples under the skin.\n\n"
            )
        )

//mix skin


//sensitive skin

        myArray.add(
            DataUsed(
                R.drawable.biored,
                "BIODERAM",
                "Bioderma Sensibo H2O Micellar Water Makeup Remover ",
                "\n\nMicellar makeup remover water gently cleanses and removes makeup and impurities from the face and eyes without irritating the skin.\n\n" +
                        "Your skin feels fresh, clean and clear\n\n" +
                        "Free of fragrances and does not cause allergies\n\n" +
                        "How to use :\n" +
                        "Put it on a piece of cotton, then remove makeup from the face and eyes, then dry gently"
            )
        )

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