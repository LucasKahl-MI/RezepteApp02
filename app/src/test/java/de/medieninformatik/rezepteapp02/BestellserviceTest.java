package de.medieninformatik.rezepteapp02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BestellserviceTest {

    private BestellVerwaltung verwaltung;
    private Bestellservice bestellService;

    @BeforeEach
    void initService(){
        verwaltung = Mockito.mock(BestellVerwaltung.class);
        bestellService = new Bestellservice(verwaltung);
    }

    @Test
    void saveBestellungTest() {

        Bestellung bestellung1 = new Bestellung("2", 78.99, LocalDateTime.now());

        when(verwaltung.saveBestellung(any(Bestellung.class))).then(AdditionalAnswers.returnsFirstArg());
        Bestellung gespeicherteBestellung = bestellService.erzeugeBestellung(bestellung1);
        assertNotNull(gespeicherteBestellung.getBestellDatum());

        assertEquals(gespeicherteBestellung.getAppKontoID(), "2");
        assertEquals(gespeicherteBestellung.getBestellSumme(), 78.99);


        System.out.println("Die AppKontoID ist: " + gespeicherteBestellung.getAppKontoID());
        System.out.println("Bestelldatum: " + gespeicherteBestellung.getBestellDatum());
        System.out.println("Rechnungssumme: " + gespeicherteBestellung.getBestellSumme());
    }
}