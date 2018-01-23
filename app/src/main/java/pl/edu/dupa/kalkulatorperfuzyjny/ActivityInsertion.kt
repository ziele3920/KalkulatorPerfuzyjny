package pl.edu.dupa.kalkulatorperfuzyjny

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insertion.*

class ActivityInsertion : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)
        buttonCalculate.setOnClickListener {
            val calculator = PerfusionCalculator()
            val bodyHeight = editHeight.text.toString().toInt()
            val bodyMass = editMass.text.toString().toInt()
            val primingVolume = editPrimingVolume.text.toString().toInt()
            val patientHematocrit = editPateintHematocrit.text.toString().toInt()

            val formatString = "%.2f"

            val arteryCanule = calculator.calculateArteryCannuleSize(bodyMass)
            if (arteryCanule != null) {
                textArtertCSize.text = arteryCanule.canuleSize.toString()
                textLineFluent.text = arteryCanule.lineSize + " " + arteryCanule.fluent.toString()
            }

            val veinCanule = calculator.calculateVeinCannuleSize(bodyMass)
            if(veinCanule != null) {
                textVeinSVCIVC.text = veinCanule.SVC.toString() + "/" + veinCanule.IVC.toString()
                textVeinCommon.text = veinCanule.commonSize.toString()
            }

            val circulatingBlood = calculator.calculateCirculatingBloodVolume(bodyMass)
            if(circulatingBlood != null)
                textCirculatingBlood.text = formatString.format(circulatingBlood)

            val bsa = calculator.calculateBodySurfaceArea(bodyMass, bodyHeight)

            if(bsa != null) {
                val pumpF = calculator.calculatePumpFluentPerMin(bsa.toFloat(), bodyMass)
                if(pumpF != null)
                    textPump.text = formatString.format(pumpF)
            }

            val htCPB = calculator.calculateHtCPB(bodyMass, patientHematocrit, primingVolume)
            if(htCPB != null)
                textHtCPB.text = formatString.format(htCPB)

            val KKCZ = calculator.calculateKKCZ(primingVolume, bodyMass, patientHematocrit)
            if(KKCZ != null)
                textKKCZ.text = formatString.format(KKCZ)

            val hemodilutyInd = calculator.calculateHemodilutionIndicator(primingVolume, bodyMass)
            if(hemodilutyInd != null)
                textHemodilutiInd.text = formatString.format(hemodilutyInd)
        }
    }
}
