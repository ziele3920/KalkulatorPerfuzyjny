package pl.edu.dupa.kalkulatorperfuzyjny

import android.app.Activity


/**
 * Created by Ziolo on 1/22/2018.
 */
class PerfusionCalculator {

    fun calculateBodySurfaceArea(bodyWeight: Int, bodyHeight: Int): Double {
        return Math.sqrt(bodyHeight.toDouble() * bodyWeight / 3600)
    }

    fun calculateVeinCannuleSize(bodyWeight: Int): VeinCanule? {
        return DataStorage.getVeinCannule(bodyWeight)
    }

    fun calculateArteryCannuleSize(bodyWeight: Int): ArteryCanule? {
        return DataStorage.getArteryCannule(bodyWeight)
    }

    fun calculatePumpFluentPerMin(bodySurfaceArea: Float, bodyWeight: Int): Double? {
        val VI = DataStorage.getVolumeIndex(bodyWeight) ?: return null
        return bodySurfaceArea * VI.Vl.toDouble()
    }

    fun calculateCirculatingBloodVolume(bodyWeight: Int): Double? {
        val VI = DataStorage.getVolumeIndex(bodyWeight) ?: return null
        return bodyWeight * VI.Vl.toDouble()
    }

    fun calculateHemodilutionIndicator(primingVolume: Int, bodyWeight: Int): Double? {
        val tbv = calculateCirculatingBloodVolume(bodyWeight) ?: return null
        return primingVolume / (tbv + primingVolume) * 100
    }

    fun calculateKKCZ(patientHematocrit: Int, primingVolume: Int, bodyWeight: Int): Double? {
        val tbv = calculateCirculatingBloodVolume(bodyWeight) ?: return null
        val htCpb = (patientHematocrit * tbv) / (tbv + primingVolume)
        return (0.01 * htCpb * (primingVolume + tbv) - tbv * patientHematocrit) / 0.7
    }

    fun calculateHt(kkcz: Double): Double {

        return 0.toDouble()
    }
}