package pl.bigbook.exchanger;

import org.junit.Assert;
import org.junit.Before;
import pl.bigbook.exchanger.services.CurrencyServiceImpl;
import pl.bigbook.exchanger.services.PairService;
import pl.bigbook.exchanger.services.VendorServiceImpl;


public class CurrencyServiceTest {


    @Before
    public void setUp() {

    }


    public void getLastCurrencyRateForVendor() {

        //given
        VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
        Vendor vendor = vendorServiceImpl.getVendorById(1);

        PairService pairService = new PairService();
        Pair pair = pairService.getPairById(1);


        //when
        CurrencyRate currencyRate = CurrencyServiceImpl.getLastCurrencyRateForVendor(vendor, pair);

        //then
        Assert.assertEquals("message", "EURPLN", currencyRate.getPair());
        Assert.assertEquals("message", "WALUTOMAT", currencyRate.getVendor());
        Assert.assertEquals("message", "2.0000", currencyRate.getRate());
    }


}
