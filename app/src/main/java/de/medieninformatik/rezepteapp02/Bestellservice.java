package de.medieninformatik.rezepteapp02;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Bestellservice {
    private BestellVerwaltung bestellVerwaltung;

    public Bestellservice(BestellVerwaltung verwaltung){
        this.bestellVerwaltung =verwaltung;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)

    public Bestellung erzeugeBestellung(Bestellung bestellung){

        return bestellVerwaltung.saveBestellung(bestellung);
    }
}
