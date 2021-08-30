package de.medieninformatik.rezepteapp02;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Datenbank-Klasse nach dem Singleton-Entwurfsmuster
 * Es gibt nur eine Datenbank dessen Instanz geholt werden kann
 */
public class RezepteDatenbank {


    /**
     * finale Instanz auf die RezepteDatenbank Klasse
     */
    private static final RezepteDatenbank datenbank = new RezepteDatenbank();

    /**
     *
     */
    private List<Rezepte> rezepteList = new ArrayList<>();

    /**
     * privater Konstruktor nach Singleton-Pattern
     */
    private RezepteDatenbank() {
        this.rezepteList = rezepteList;
        initRezepteList();
    }

    /**
     *  Hier werden aktuell die Rezepte eingetragen und anschließend mittels .add einer Array-List
     *  hinzugefügt.
     */

    private void initRezepteList() {

        Rezepte fisch01 = new Rezepte("Lachstatar", "250 \tg \tLachs (geräuchert)\n" +
                "0.5 \tBund \tDill\n" +
                "0.5 \tBund \tKoriander\n" +
                "1 \tEL \tOlivenöl\n" +
                "2 \tEL \tZitronen (Saft)\n" +
                "2 \tStk \tSchalotten\n" +
                "1 \tPrise \tPfeffer\n" +
                "1 \tPrise \tSalz\n",
                "Schnell, einfach und lecker!", "Für das Lachstatar mit Räucherlachs, den Fisch sehr klein schneiden. Schalotten schälen und ebenfalls fein würfeln. Dill und Koriander waschen, abtropfen lassen und klein schneiden.\n" +
                "Alles in einer Schüssel gut vermengen und mit Zitronensaft, Öl, Salz und Pfeffer abschmecken.\n" +
                "Im Kühlschrank gut durchziehen lassen ca. 2 Stunden.\n", R.drawable.fisch01_thumb);

        Rezepte fleisch01 = new Rezepte("Entrecôte", "\n" +
                "Für die Bratkartoffeln:\n" +
                "\n" +
                "1 Packung Bratkartoffel\n" +
                "80 g Zwiebel, rot\n" +
                "1 EL Rosmarinnadel\n" +
                "1 EL Thymianblatt\n" +
                "Salz\n" +
                "Pfeffer, grob, bunt\n" +
                "\n" +
                "Für das Paprikagemüse:\n" +
                "\n" +
                "400 g Paprika\n" +
                "80 g Zwiebel\n" +
                "1 Knoblauchzehe\n" +
                "1 EL Olivenöl, kalt gepresst\n" +
                "Salz\n" +
                "Pfeffer\n" +
                "100 ml Gemüsefond\n" +
                "1 EL Petersilie\n" +
                "40 g Olive\n" +
                "\n" +
                "Für die Kräuter:\n" +
                "\n" +
                "2 Knoblauchzehe\n" +
                "2 EL Petersilie\n" +
                "1 EL Thymianblatt\n" +
                "1 EL Rosmarinnadel\n" +
                "1 EL Salbei\n" +
                "2 EL Olivenöl, kalt gepresst\n" +
                "\n" +
                "Für das Fleisch:\n" +
                "\n" +
                "800 g Entrecôte oder Rumpsteak vom Rind\n" +
                "Salz\n" +
                "Pfeffer\n" +
                "1 EL Worcester-Sauce\n" +
                "4 EL Sherry, medium\n" +
                "1/2 TL Pfefferkorn, grün\n" +
                "2 EL Olivenöl, kalt gepresst",

                "Der Klassiker vom Rind", "1\n" +

                "Vom Entrecôte die Fettschicht und die Sehnen entfernen. Für die Marinade Worcestersauce, Sherry, zerdrückte Pfefferkörner und Öl in einer Schüssel mischen, das Fleisch damit rundherum einpinseln, zugedeckt im Kühlschrank 30 Minuten marinieren.\n" +
                "\n" +
                "2\n" +
                "Für die Kräutermischung den Knoblauch schälen und fein hacken. Petersilie, Thymian, Rosmarin und Salbei waschen, trocken schütteln, fein schneiden und mit dem Knoblauch vermischen.\n" +
                "\n" +
                "3\n" +
                "Den Backofen auf 240 Grad Ober-/Unterhitze (Umluft 220 Grad) vorheizen. Fleisch mit Salz und Pfeffer würzen. Auf dem Rost mit untergestellter Fettpfanne das Entrecôte im Ofen auf der mittleren Schiene 15 Minuten anbraten, die Hitze auf 180 Grad Ober-/Unterhitze (Umluft 160 Grad) reduzieren und das Fleisch weitere 15-20 Minuten im Ofen garen. 5 Minuten vor Ende der Garzeit das Fleisch herausnehmen und die kurz zuvor in Öl angeschwitzte Kräutermischung auf dem Entrecôte verstreichen, anschließend im Ofen fertig garen. Das Fleisch sollte „medium“ (ca. 55 °C Kerntemperatur) sein. In Alufolie wickeln und 15-20 Minuten ruhen lassen.\n" +
                "\n" +
                "4\n" +
                "Paprika von Kernen, Stielansatz und weißen Trennwänden befreien und in Streifen schneiden. Oder die tiefgekühlten Paprikastreifen antauen lassen. Zwiebeln und Knoblauch schälen, beides fein würfeln. Petersilie fein hacken. Oliven in Scheiben schneiden.\n" +
                "\n" +
                "5\n" +
                "Olivenöl in einer Pfanne erhitzen, Zwiebeln und Knoblauch zugeben und farblos anschwitzen, Paprika zufügen, kurz mit anschwitzen, mit Salz und Pfeffer würzen, Gemüsefond angießen und in etwa 5 Minuten bissfest garen. Petersilie und Oliven untermischen.\n" +
                "\n" +
                "6\n" +
                "Bratkartoffeln nach Packungsanweisung zubereiten. In den letzten Minuten die geschälte und in feine Ringe geschnittenen Zwiebeln und die gehackten Kräuter untermischen. Mit Salz und Pfeffer abschmecken.\n" +
                "\n" +
                "7\n" +
                "Das Entrecôte in Scheiben schneiden, anrichten und mit dem Paprikagemüse und den Bratkartoffeln servieren. Die Festtagsvariante bereiten Sie zu, wenn Sie sich an unser Entrecôte-Rezept mit Spekulatiusknödeln und Rotweinsoße halten.\n",
                R.drawable.fleisch01staek_thumb);

        Rezepte fleisch02 = new Rezepte("Schnitzel Wiener Art", "4 \tStk \tKalbsschnitzel (à 160 g)\n" +
                "150 \tg \tgriffiges Mehl\n" +
                "2 \tStk \tEier\n" +
                "300 \tg \tSemmelbrösel\n" +
                "1 \tStk \tZitrone\n" +
                "1 \tPrise \tSalz\n" +
                "1 \tPrise \tSalz\n" +
                "2 \tEL \tBackfett, Öl od. Butterschmalz",
                "Genau wie das Original",
                "Schnitzel zwischen Frischhaltefolie behutsam klopfen. Fleisch beidseitig salzen, in Mehl wenden, abklopfen, durch die Eier ziehen und in den Bröseln wenden.\n" +
                        "Schnitzel ca. 2 Finger hoch Backfett goldgelb backen. Während des Backens die Pfanne ein wenig rütteln, damit die Schnitzel gleichmäßig goldbraun werden. Schnitzel herausheben, auf Küchenpapier abtropfen lassen.\n" +
                        "Zitrone in Spalten schneiden und die fertigen Wiener Schnitzel mit Zitronenspalten garnieren.",
                R.drawable.fleisch02schnitzel_thumb);

        Rezepte pasta01 = new Rezepte("Pasta Pesto verde", "Für 4 Portionen\n" +
                "\n" +
                "500 g Pasta\n" +
                "Salz\n" +
                "80 g italienischer Hartkäse (z.B. Pecorino Romano oder Parmigiano Reggiano)\n" +
                "2 Bund Basilikum (80-100 g)\n" +
                "2 EL Olivenöl\n" +
                "300 Milliliter Gemüsefond (oder -brühe)\n" +
                "Pfeffer (\"weiß)\n" +
                "4 Knoblauchzehen\n" +
                "2 grüne Paprikas (200 g)",
                "Ein italienischer Klassiker", "Nudeln nach Packungsanweisung in Salzwasser bissfest kochen.\n" +
                "Käse fein reiben. Basilikum abspülen, trocken schleudern und grob hacken. Käse, Basilikum, Salz, Öl und 75 ml Gemüsefond in einen hohen Becher geben und mit einem Stabmixer pürieren. Pesto mit Pfeffer abschmecken.\n" +
                "Knoblauch abziehen und fein würfeln. Paprikaschote vierteln; Stängel, Kerne und Trennwände entfernen. Paprikaviertel abspülen und in 2 cm große Stücke schneiden.\n" +
                "Knoblauch, Paprikastücke und restlichen Gemüsefond in einem kleinen Topf einmal aufkochen und 3 Minuten zugedeckt dünsten.\n" +
                "Abgetropfte Nudeln und Paprika mit Sud und Pesto verrühren und sofort anrichten.",
                R.drawable.pasta02pestoverde_thumb);

        Rezepte pasta02 = new Rezepte("Pasta Carbonara", "250 g Pasta\n" +
                "150 g Speck\n" +
                "2 Eier\n" +
                "200 ml Sahne Alternativ Milch\n" +
                "80 g Parmesan gerieben\n" +
                "Salz, Pfeffer, Muskat",
                "Herzhaft, würzig, parmesanig.", "Spaghetti nach Packungsanweisung al dente garen.\n" +
                "In der Zwischenzeit Speck in einer großen Pfanne braten, beiseite stellen.\n" +
                "Eier, Sahne und Parmesan verquirlen. Mit Salz, Pfeffer und Muskat würzen.\n" +
                "Nudeln direkt aus dem Nudelwasser zum Speck in die Pfanne geben und Eimischung hinzufügen. Alles vermischen, dann bei sehr kleiner Hitze unter Rühren vermischen, bis die Sauce anzieht. Noch einmal abschmecken und genießen.", R.drawable.pasta01carbonara_thumb);

        Rezepte salat01 = new Rezepte("Nudelsalat italiano", "500 g Farfalle\n" +
                "40 g Pinienkerne\n" +
                "250 g Feta\n" +
                "250 g Cocktailtomaten\n" +
                "1 Bund Basilikum\n" +
                "20 ml Olivenöl\n" +
                "1 Prise Salz\n" +
                "1 Prise Pfeffer (schwarz, gemahlen)\n" +
                "200 g Crème fraîche\n" +
                "1 Stk Knoblauchzehen (zerdrückt) ",
                "Der Hit zu jedem Grillfest", "Die Nudeln werden in kochendem Salzwasser laut Packungsanleitung bissfest gekocht, anschließend werden sie in einem Sieb abgeseiht und mit dem Öl übergossen.\n" +
                "Das Ganze gut umrühren damit die Nudeln nicht aneinander kleben bleiben. In der Zwischenzeit werden die Tomaten gewaschen und halbiert.\n" +
                "Im Anschluss werden die Basilikumblätter vom Stängel gezupft und fein gehackt. Die Crème fraîche wird mit Salz, Knoblauch sowie Pfeffer gut abgeschmeckt.\n" +
                "Dann werden die Pinienkerne in einer Pfanne ohne Öl für 3 Minuten angebraten, dabei immer wieder umrühren damit nichts anbrennt.\n" +
                "Zum Schluss werden alle Zutaten in einer Schüssel vermengt und der Feta wird mit den Händen grob dazu gebröselt.\n", R.drawable.salat01_thumb);

        Rezepte test = new Rezepte("Test", "500 g Farfalle\n" +
                "40 g Pinienkerne\n" +
                "250 g Feta\n" +
                "250 g Cocktailtomaten\n" +
                "1 Bund Basilikum\n" +
                "20 ml Olivenöl\n" +
                "1 Prise Salz\n" +
                "1 Prise Pfeffer (schwarz, gemahlen)\n" +
                "200 g Crème fraîche\n" +
                "1 Stk Knoblauchzehen (zerdrückt) ",
                "Der Hit zu jedem Grillfest", "Die Nudeln werden in kochendem Salzwasser laut Packungsanleitung bissfest gekocht, anschließend werden sie in einem Sieb abgeseiht und mit dem Öl übergossen.\n" +
                "Das Ganze gut umrühren damit die Nudeln nicht aneinander kleben bleiben. In der Zwischenzeit werden die Tomaten gewaschen und halbiert.\n" +
                "Im Anschluss werden die Basilikumblätter vom Stängel gezupft und fein gehackt. Die Crème fraîche wird mit Salz, Knoblauch sowie Pfeffer gut abgeschmeckt.\n" +
                "Dann werden die Pinienkerne in einer Pfanne ohne Öl für 3 Minuten angebraten, dabei immer wieder umrühren damit nichts anbrennt.\n" +
                "Zum Schluss werden alle Zutaten in einer Schüssel vermengt und der Feta wird mit den Händen grob dazu gebröselt.\n", R.drawable.test);


        rezepteList.add(fisch01);
        rezepteList.add(fleisch01);
        rezepteList.add(fleisch02);
        rezepteList.add(pasta01);
        rezepteList.add(pasta02);
        rezepteList.add(salat01);

        //Wiederholung der Rezepte zum Test der Scrollbarkeit
        rezepteList.add(fisch01);
        rezepteList.add(fleisch01);
        rezepteList.add(fleisch02);
        rezepteList.add(pasta01);
        rezepteList.add(test);

    }

    public static RezepteDatenbank getInstance(){
        Log.i("success", "Datenbank-Instanz erfolgreich übergeben");
        return datenbank;}

    /**
     * ermöglicht direkten Zugriff auf die Liste in der Datenbank-Instanz
     * perspektivisch plane ich hier die Anbindung an eine Web-Datenbank
     * @return
     */
    public  List<Rezepte> getList(){
        return rezepteList;
    }
}
