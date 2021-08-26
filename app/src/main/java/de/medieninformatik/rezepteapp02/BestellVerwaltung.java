package de.medieninformatik.rezepteapp02;

import java.time.LocalDateTime;

public interface BestellVerwaltung {

   Bestellung saveBestellung (Bestellung bestellung);

   Bestellung findAppKontoID(String appKontoId);


}
