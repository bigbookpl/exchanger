package pl.bigbook.exchanger.adapters;

import org.w3c.dom.Element;

import java.rmi.NotBoundException;

public class NbpRateDTO {

    private String currencyName;
    private Double convertionRate;
    private String currencySymbol;
    private Double bidPrice;
    private Double sellingPrice;

    public NbpRateDTO(String currencyName, Double convertionRate, String currencySymbol, Double bidPrice, Double sellingPrice) {
        this.currencyName = currencyName;
        this.convertionRate = convertionRate;
        this.currencySymbol = currencySymbol;
        this.bidPrice = bidPrice;
        this.sellingPrice = sellingPrice;
    }

    public NbpRateDTO() {
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getConvertionRate() {
        return convertionRate;
    }

    public void setConvertionRate(Double convertionRate) {
        this.convertionRate = convertionRate;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
