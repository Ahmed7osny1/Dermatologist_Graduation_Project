package com.autismagraduation.dermatologist.`object`

import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.DataUsed

object SetDataHerbs {

    fun getDataHerbs(): ArrayList<DataUsed> {

        val herbsData: ArrayList<DataUsed> = arrayListOf()

        herbsData.add(
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

        return herbsData
    }

}