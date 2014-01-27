package pl.bigbook.exchanger.adapters;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.bigbook.exchanger.Currency;
import pl.bigbook.exchanger.CurrencyRate;
import pl.bigbook.exchanger.Pair;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

/**
 * Created by Komp on 26.01.14.
 */
public class NbpAdapter implements VendorAdapter{


    public static final String NBP_XML_URL = "http://www.nbp.pl/kursy/xml/LastC.xml";
    public static final String BID_PRICE_FIELD = "kurs_kupna";
    public static final String SELLING_PRICE_FIELD = "kurs_sprzedazy";
    public static final String CONVERTION_RATE_FIELD = "przelicznik";
    public static final String CURRENCY_NAME_FIELD = "nazwa_waluty";
    public static final String CURRENCY_SYMBOL_FIELD = "kod_waluty";
    private InputStream document;

    @Override
    public void setTargetCurrency() {

    }

    @Override
    public void getDocument(Currency currency) throws IOException {
        URL target = new URL(getDocumentUrl());
        this.document = target.openStream();
        try {
            parseXmlDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private void parseXmlDocument() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(this.document);
        NodeList nodes = document.getElementsByTagName("pozycja");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Current Element :" + node.getNodeName());

            Element element = (Element) node;
            System.out.println("Kod waluty"+element.getElementsByTagName("kod_waluty").item(0).getTextContent() );
        }
        
    }

    private NbpRateDTO transformElementToNbpRateDTO(Element element){
        NbpRateDTO nbpRateDTO = new NbpRateDTO();

        nbpRateDTO.setBidPrice(new Double( element.getElementsByTagName(BID_PRICE_FIELD).item(0).getTextContent() ) );
        nbpRateDTO.setSellingPrice(new Double(element.getElementsByTagName(SELLING_PRICE_FIELD).item(0).getTextContent()) );
        nbpRateDTO.setConvertionRate (new Double(element.getElementsByTagName(CONVERTION_RATE_FIELD).item(0).getTextContent()));
        nbpRateDTO.setCurrencyName( element.getElementsByTagName(CURRENCY_NAME_FIELD).item(0).getTextContent() );
        nbpRateDTO.setCurrencySymbol(element.getElementsByTagName(CURRENCY_SYMBOL_FIELD).item(0).getTextContent());

        return nbpRateDTO;
    }

    private String getDocumentUrl() {
        return NBP_XML_URL;
    }

    @Override
    public CurrencyRate getCurrentRate(Pair pair) {
        return null;
    }

    @Override
    public List<CurrencyRate> getCurrencies() {
        return null;
    }
}
