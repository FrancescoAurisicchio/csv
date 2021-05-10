import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        Lettore nomelettore = new Lettore(); //istanzia un oggetto lettore
        String fileName = "/home/francesco/Scrivania/csv/persone.csv"; //da a filename il percorso per arrivare a persone
        nomelettore.readFileName(fileName); //legge il valore di persone
        List<String[]> r = nomelettore.getFile(); //crea una lista di stringhe chiamata r e gli passa i valori di persone
        r.forEach(x -> System.out.println(Arrays.toString(x))); //Output dei valori di persone
        System.out.println(Arrays.toString(nomelettore.getFile(1))); //Output del valore nella posizione i
        System.out.println(r.size()); //Output della dimensione di r
    }
}
