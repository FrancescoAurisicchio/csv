import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Lettore {

   private String filename;
   private List<String[]> file;

    Lettore(){}

    Lettore(String filename) throws IOException, CsvException {
        this.filename = filename;
        try (CSVReader reader = new CSVReader(new FileReader(this.filename))) {
            this.file = reader.readAll();}
    }

    /**
     * Metodo che ritorna tutti i valori di persone
     * @return
     */
    public List<String[]> getFile() {
        return file;
    }

    /**
     * Metodo che ritorna il valore in quella specifica posizione
     * Nel caso i sia minore o uguale a zero ritorna due stringhe di errore
     * Nel caso in cui i sia maggiore della dimensione massima ritorna un'altra stringa di errore
     * @param i la posizione di cui vogliamo la riga
     * @return
     */
    public String[] getFile(int i) {
        if (i>0 && i<file.size()) {
            return file.get(i); }
        else {
            if (i<=0){
                String[] meserr = new String[1];
                if(i==0){
                meserr[0] = "non puoi puntare a zero, quello e' l header";
                return meserr;}
                else {
                    meserr[0] = "Dimensione minima non raggiunta";
                    return meserr;
                }
            }
            else {
                String[] messer = new String[1];
                messer[0] = "dimensione massima superata";
                return messer;
            }
        }
    }
    /**
     * Imposta il percorso del file e lo legge
     * @param filename
     * @throws IOException
     * @throws CsvException
     */
    public void readFileName(String filename) throws IOException, CsvException {
        this.filename = filename;
        try (CSVReader reader = new CSVReader(new FileReader(this.filename))) {
            this.file = reader.readAll();}
    }
}