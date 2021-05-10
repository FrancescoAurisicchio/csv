import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LettoreTest {
    /**
     * Test che controlla se il valore inserito e' buono
     * @throws IOException
     * @throws CsvException
     */
    @org.junit.jupiter.api.Test
    void getFile() throws IOException, CsvException {
        Lettore lettore = new Lettore("/home/francesco/Scrivania/csv/persone.csv");
        String[] risulato = lettore.getFile(1);
        assertTrue(risulato[0]!= "non puoi puntare a zero, quello e' l header");
        assertTrue(risulato[0]!= "Dimensione minima non raggiunta");
        assertTrue(risulato[0]!= "dimensione massima superata");
    }

    /**
     * Test che controlla se il valore inserito e' zero
     * @throws IOException
     * @throws CsvException
     */
    @org.junit.jupiter.api.Test
    void getFilePointTo0() throws IOException, CsvException {
        Lettore lettore = new Lettore("/home/francesco/Scrivania/csv/persone.csv");
        String[] risulato = lettore.getFile(0);
        assertTrue(risulato[0]== "non puoi puntare a zero, quello e' l header");
    }

    /**
     * Test che controlla se il valore inserito e' piu' grande della dimensione massima
     * @throws IOException
     * @throws CsvException
     */
    @org.junit.jupiter.api.Test
    void getFilePointMax() throws IOException, CsvException {
        Lettore lettore = new Lettore("/home/francesco/Scrivania/csv/persone.csv");
        String[] risulato = lettore.getFile(15);
        assertTrue(risulato[0]== "dimensione massima superata");
    }

    /**
     * Test che controlla se il valore inserito e' negativo
     * @throws IOException
     * @throws CsvException
     */
    @org.junit.jupiter.api.Test
    void getFilePointMeno0() throws IOException, CsvException {
        Lettore lettore = new Lettore("/home/francesco/Scrivania/csv/persone.csv");
        String[] risulato = lettore.getFile(-2);
        assertTrue(risulato[0]== "Dimensione minima non raggiunta");
    }
}