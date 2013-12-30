package pl.bigbook.exchanger.services;

import org.springframework.stereotype.Service;
import pl.bigbook.exchanger.Vendor;
import pl.bigbook.exchanger.dao.VendorDao;

import javax.inject.Inject;

@Service
public class VendorServiceImpl implements VendorService {

    @Inject
    private VendorDao vendorDao;

    public Vendor getVendorById(int id) {
        return new Vendor();
    }

    public Vendor addNewVendor(Vendor vendor) throws Exception {


        return new Vendor();
    }
}
