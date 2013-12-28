package pl.bigbook.exchanger;

import org.junit.Assert;
import org.junit.Before;
import pl.bigbook.exchanger.services.CurrencyService;
import pl.bigbook.exchanger.services.PairService;
import pl.bigbook.exchanger.services.VendorService;
import pl.bigbook.exchanger.Pair;


public class CurrencyServiceTest {


    @Before
    public void setUp(){

    }


    public void getLastCurrencyRateForVendor(){

     //given
     VendorService vendorService = new VendorService();
     Vendor vendor = vendorService.getVendorById(1);

     PairService pairService = new PairService();
     Pair pair = pairService.getPairById(1);


     //when
     CurrencyRate currencyRate = CurrencyService.getLastCurrencyRateForVendor(vendor, pair);

     //then
    Assert.assertEquals("message", "EURPLN", currencyRate.getPair());
    Assert.assertEquals("message", "WALUTOMAT", currencyRate.getVendor());
    Assert.assertEquals("message", "2.0000", currencyRate.getRate());
    }



}
