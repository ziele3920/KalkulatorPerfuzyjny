package pl.edu.dupa.kalkulatorperfuzyjny


/**
 * Created by Ziolo on 1/22/2018.
 */
class PerfusionCalculator {

    fun calculateBodySurface(bodyWeight: Int, bodyHeight: Int): Double {
        return Math.sqrt(bodyHeight.toDouble() * bodyWeight / 3600)
    }

    fun calculateVeinCannuleSize(bodyWeight: Int): VeinCanule? {
        return DataStorage.getVeinCannule(bodyWeight)
    }

    fun calculateArteryCannuleSize(bodyWeight: Int): ArteryCanule? {
        return DataStorage.getArteryCannule(bodyWeight)
    }

    fun calculatePumpFluentPerMin(bodySurface: Float): Double {

        return 0.toDouble()
    }

    fun calculateCirculatingBloodVolume(bodyWeight: Int): Double {

        return 0.toDouble()
    }

    fun calculateHemodilutionIndicator(): Double {

        return 0.toDouble()
    }

    fun calculateKKCZ(): Double {

        return 0.toDouble()
    }

    fun calculateHt(kkcz: Double): Double {

        return 0.toDouble()
    }
}