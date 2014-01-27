package pl.bigbook.exchanger.adapters;

import pl.bigbook.exchanger.Currency;
import pl.bigbook.exchanger.CurrencyRate;
import pl.bigbook.exchanger.Pair;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Komp on 26.01.14.
 */
public interface VendorAdapter {

    //@todo zastanowić się
    public void setTargetCurrency();

    /**
     * Pobiera dokument zawierający kursy
     *
     * @param currency
     */
    public void getDocument(Currency currency) throws IOException;

    /**
     * Zwraca kurs dla pary
     *
     * @param pair
     * @return
     */
    public CurrencyRate getCurrentRate(Pair pair);

    /**
     * Zwraca wszystkie kursy
     *
     * @return List<CurrencyRate>
     */
    public List<CurrencyRate> getCurrencies();
}
