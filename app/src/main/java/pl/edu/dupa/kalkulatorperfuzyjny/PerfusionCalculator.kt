package pl.edu.dupa.kalkulatorperfuzyjny

/**
 * Created by Ziolo on 1/22/2018.
 */
class PerfusionCalculator {

    fun calculateBodySurfaceArea(bodyWeight: Int, bodyHeight: Int): Double {
        return Math.pow(bodyHeight.toDouble()/100, 0.725) * Math.pow(bodyWeight.toDouble(), 0.425) * 0.007184
    }

    fun calculateVeinCannuleSize(bodyWeight: Int): VeinCanule? {
        return DataStorage.getVeinCannule(bodyWeight)
    }

    fun calculateArteryCannuleSize(bodyWeight: Int): ArteryCanule? {
        return DataStorage.getArteryCannule(bodyWeight)
    }

    fun calculatePumpFluentPerMin(bodySurfaceArea: Float, bodyWeight: Int): Double? {
        val CI = DataStorage.getArteryCannule(bodyWeight) ?: return null
        return bodySurfaceArea * CI.fluent.toDouble()
    }

    fun calculateCirculatingBloodVolume(bodyWeight: Int): Double? {
        val VI = DataStorage.getVolumeIndex(bodyWeight) ?: return null
        return bodyWeight * VI.Vl.toDouble()
    }

    fun calculateHemodilutionIndicator(primingVolume: Int, bodyWeight: Int): Double? {
        val tbv = calculateCirculatingBloodVolume(bodyWeight) ?: return null
        return primingVolume / (tbv + primingVolume) * 100
    }

    fun calculateKKCZ(primingVolume: Int, bodyWeight: Int, patientHematocrit: Int): Double? {
        val tbv = calculateCirculatingBloodVolume(bodyWeight) ?: return null
        val htCPB = calculateHtCPB(bodyWeight, patientHematocrit, primingVolume) ?: return null
        return (0.01 * htCPB * (primingVolume + tbv) - tbv * 0.01 * patientHematocrit) / 0.7
    }

    fun calculateHtCPB(bodyWeight: Int, patientHematocrit: Int, primingVolume: Int): Double? {
        val tbv = calculateCirculatingBloodVolume(bodyWeight) ?: return null
        return (patientHematocrit * tbv) / (tbv + primingVolume)
    }
}
