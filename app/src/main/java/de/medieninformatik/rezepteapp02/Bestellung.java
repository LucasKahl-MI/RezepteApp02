package de.medieninformatik.rezepteapp02;

import java.time.LocalDateTime;

public class Bestellung {

    private String appKontoID;
    private LocalDateTime bestellDatum;
    private double bestellSumme;


    public void setBestellung(String appKontoID, double bestellSumme ,LocalDateTime bestellDatum) {
        this.appKontoID = appKontoID;
        this.bestellSumme = bestellSumme;
        this.bestellDatum = bestellDatum;
    }

    public Bestellung(){}

    public Bestellung(String appKontoID, double bestellSumme ,LocalDateTime bestellDatum) {
        this.appKontoID = appKontoID;
        this.bestellSumme = bestellSumme;
        this.bestellDatum = bestellDatum;
    }

    public String getAppKontoID(){
        return appKontoID;
    }

    public double getBestellSumme() {
        return bestellSumme;
    }

    public LocalDateTime getBestellDatum() {
        return bestellDatum;
    }

}
