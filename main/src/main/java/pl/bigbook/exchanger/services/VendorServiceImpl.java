package pl.bigbook.exchanger.services;

import org.springframework.dao.DataAccessException;
import pl.bigbook.exchanger.Vendor;
import pl.bigbook.exchanger.dao.VendorDao;

import javax.inject.Inject;


public class VendorServiceImpl implements VendorService {

    @Inject
    private VendorDao vendorDao;

    public Vendor getVendorById(int id) {
        return new Vendor();
    }

    public Vendor addNewVendor(Vendor vendorInputData) throws Exception {
        Vendor vendorOutputData;

        try {
            vendorOutputData = vendorDao.addVendor(vendorInputData);
        }
        catch (DataAccessException e){
            throw new Exception("Nie można było dodać vendora ponieważ: "+e.getMessage());
        }
        catch (Exception e){
            throw new Exception("Nieznany bład: "+e.getMessage());
        }

        return vendorOutputData;
    }
}
