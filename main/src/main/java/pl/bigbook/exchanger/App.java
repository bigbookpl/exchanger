package pl.bigbook.exchanger;

import pl.bigbook.exchanger.adapters.NbpAdapter;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        NbpAdapter nbp = new NbpAdapter();
        nbp.getDocument(new Currency());
    }
}
