package pl.bigbook.exchanger;

/**
 * Created with IntelliJ IDEA.
 * User: brutus
 * Date: 28.12.13
 * Time: 23:45
 * To change this template use File | Settings | File Templates.
 */
public class CurrencyRate {
    private Double rate;
    private Pair pair;
    private Vendor vendor;

    public Pair getPair() {
        return pair;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Double getRate() {
        return rate;
    }
}
