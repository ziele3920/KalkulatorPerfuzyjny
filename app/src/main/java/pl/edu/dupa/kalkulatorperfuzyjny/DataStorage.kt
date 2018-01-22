package pl.edu.dupa.kalkulatorperfuzyjny

/**
 * Created by Ziolo on 1/22/2018.
 */
class DataStorage {
    companion object {
        private val veinCanulies: Array<VeinCanule> = arrayOf(
                VeinCanule(0, 3, 12, 14, 18),
                VeinCanule(3, 5, 14, 16, 18),
                VeinCanule(5, 8, 16, 16, 20),
                VeinCanule(8, 10, 16, 18, 22),
                VeinCanule(10, 12, 18, 18, 24),
                VeinCanule(12, 15, 18, 20, 26),
                VeinCanule(15, 20, 20, 20, 26),
                VeinCanule(20, 25, 20, 24, 28),
                VeinCanule(25, 30, 24, 24, 28),
                VeinCanule(30, 35, 24, 28, 30),
                VeinCanule(35, 40, 26, 28, 34),
                VeinCanule(40, 45, 28, 28, 34),
                VeinCanule(45, 55, 30, 32, 36),
                VeinCanule(55, 65, 32, 34, 40),
                VeinCanule(65, 70, 34, 36, 40)
        )

        private val arteryCanulies: Array<ArteryCanule> = arrayOf(
                ArteryCanule(0, 3, "3/16", 0.6f, 8),
                ArteryCanule(3, 5, "3/16", 0.9f, 10),
                ArteryCanule(5, 10, "3/16", 1.5f, 12),
                ArteryCanule(10, 15, "1/4", 2.5f, 14),
                ArteryCanule(15, 22, "1/4", 3f, 16),
                ArteryCanule(22, 29, "3/8", 4f, 18),
                ArteryCanule(29, 45, "3/8", 6.5f, 20),
                ArteryCanule(45, 80, "3/8", 0f, 22),
                ArteryCanule(81, 120, "3/8", 0f, 24)
        )

        private val volumeIndexes: Array<VolumeIndex> = arrayOf(
                VolumeIndex(0, 10, 85),
                VolumeIndex(10, ,20, 80),
                VolumeIndex(20, 30, 75),
                VolumeIndex(30, 40, 70),
                VolumeIndex(40, 50, 65),
                VolumeIndex(50, Int.MAX_VALUE, 60)
        )

        fun getVeinCannule(bodyWeight: Int): VeinCanule? {
            var estimatedIndex = Math.round(0.00003 * Math.pow(bodyWeight.toDouble(), 3.toDouble()) - 0.006 * Math.pow(bodyWeight.toDouble(), 2.toDouble()) + 0.4633 * bodyWeight - 0.1715).toInt()
            if(estimatedIndex >= veinCanulies.size)
                estimatedIndex = veinCanulies.size - 1
            if(veinCanulies[estimatedIndex].minBodyWeight <= bodyWeight && veinCanulies[estimatedIndex].maxBodyWeight >= bodyWeight)
                return veinCanulies[estimatedIndex]
            if(estimatedIndex > 0 && veinCanulies[estimatedIndex-1].minBodyWeight <= bodyWeight && veinCanulies[estimatedIndex-1].maxBodyWeight >= bodyWeight)
                return veinCanulies[estimatedIndex-1]
            if(estimatedIndex < veinCanulies.size-1 && veinCanulies[estimatedIndex+1].minBodyWeight <= bodyWeight && veinCanulies[estimatedIndex+1].maxBodyWeight >= bodyWeight)
                return veinCanulies[estimatedIndex+1]
            return null
        }

        fun getArteryCannule(bodyWeight: Int): ArteryCanule? {
            var estimatedIndex = Math.round(0.00003 * Math.pow(bodyWeight.toDouble(), 3.toDouble()) - 0.004 * Math.pow(bodyWeight.toDouble(), 2.toDouble()) + 0.31 * bodyWeight + 0.174).toInt()
            if(estimatedIndex >= arteryCanulies.size)
                estimatedIndex = arteryCanulies.size - 1
            if(arteryCanulies[estimatedIndex].minBodyWeight <= bodyWeight && arteryCanulies[estimatedIndex].maxBodyWeight >= bodyWeight)
                return arteryCanulies[estimatedIndex]
            if(estimatedIndex > 0 && arteryCanulies[estimatedIndex-1].minBodyWeight <= bodyWeight && arteryCanulies[estimatedIndex-1].maxBodyWeight >= bodyWeight)
                return arteryCanulies[estimatedIndex-1]
            if(estimatedIndex < arteryCanulies.size-1 && arteryCanulies[estimatedIndex+1].minBodyWeight <= bodyWeight && arteryCanulies[estimatedIndex+1].maxBodyWeight >= bodyWeight)
                return arteryCanulies[estimatedIndex+1]
            return null
        }

        fun getVolumeIndex(bodyWeight: Int): VolumeIndex {
            var estimatedIndex = Math.round(-0.5 * bodyWeight + 85).toInt()
            if(estimatedIndex >= volumeIndexes.size)
                estimatedIndex = volumeIndexes.size - 1
            if(volumeIndexes[estimatedIndex].minBodyWeight <= bodyWeight && volumeIndexes[estimatedIndex].maxBodyWeight >= bodyWeight)
                return volumeIndexes[estimatedIndex]
            if(estimatedIndex > 0 && volumeIndexes[estimatedIndex-1].minBodyWeight <= bodyWeight && volumeIndexes[estimatedIndex-1].maxBodyWeight >= bodyWeight)
                return volumeIndexes[estimatedIndex-1]
            if(estimatedIndex < volumeIndexes.size-1 && volumeIndexes[estimatedIndex+1].minBodyWeight <= bodyWeight && volumeIndexes[estimatedIndex+1].maxBodyWeight >= bodyWeight)
                return volumeIndexes[estimatedIndex+1]

        }
    }



}