package pl.bigbook.exchanger.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bigbook.exchanger.CurrencyRate;
import pl.bigbook.exchanger.Pair;
import pl.bigbook.exchanger.Vendor;

/**
 * Unit Tests for CurrencyService
 */
@ContextConfiguration(locations = "classpath:META-INF/spring/AppContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyServiceTest {


    @Before
    public void setUp() {}


    public void getLastCurrencyRateForVendorTest() {

        //given
        VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
        Vendor vendor = vendorServiceImpl.getVendorById(1);

        PairService pairService = new PairService();
        //@todo change to currency type
        Pair pair = pairService.getPairById(1);

        //when
        CurrencyRate currencyRate = CurrencyServiceImpl.getLastCurrencyRateForVendor(vendor, pair);

        //then
        Assert.assertEquals("message", "EURPLN", currencyRate.getPair());
        Assert.assertEquals("message", "WALUTOMAT", currencyRate.getVendor());
        Assert.assertEquals("message", "2.0000", currencyRate.getRate());
    }

    public void updateExchangeRate(){

    }

}
