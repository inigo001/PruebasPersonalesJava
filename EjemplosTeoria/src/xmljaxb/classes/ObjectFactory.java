//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.06.08 a las 09:29:51 AM CEST 
//


package xmljaxb.classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xmljaxb.classes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ordutegia_QNAME = new QName("", "ordutegia");
    private final static QName _Kokapena_QNAME = new QName("", "kokapena");
    private final static QName _Xetrs89_QNAME = new QName("", "xetrs89");
    private final static QName _Seriezenbakia_QNAME = new QName("", "seriezenbakia");
    private final static QName _Probintzia_QNAME = new QName("", "probintzia");
    private final static QName _Yetrs89_QNAME = new QName("", "yetrs89");
    private final static QName _Helbidea_QNAME = new QName("", "helbidea");
    private final static QName _Udalerria_QNAME = new QName("", "udalerria");
    private final static QName _Erakunde_QNAME = new QName("", "erakunde");
    private final static QName _Modelo_QNAME = new QName("", "modelo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xmljaxb.classes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Row }
     * 
     */
    public Row createRow() {
        return new Row();
    }

    /**
     * Create an instance of {@link Rows }
     * 
     */
    public Rows createRows() {
        return new Rows();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ordutegia")
    public JAXBElement<String> createOrdutegia(String value) {
        return new JAXBElement<String>(_Ordutegia_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "kokapena")
    public JAXBElement<String> createKokapena(String value) {
        return new JAXBElement<String>(_Kokapena_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xetrs89")
    public JAXBElement<Float> createXetrs89(Float value) {
        return new JAXBElement<Float>(_Xetrs89_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seriezenbakia")
    public JAXBElement<String> createSeriezenbakia(String value) {
        return new JAXBElement<String>(_Seriezenbakia_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "probintzia")
    public JAXBElement<String> createProbintzia(String value) {
        return new JAXBElement<String>(_Probintzia_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "yetrs89")
    public JAXBElement<Float> createYetrs89(Float value) {
        return new JAXBElement<Float>(_Yetrs89_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "helbidea")
    public JAXBElement<String> createHelbidea(String value) {
        return new JAXBElement<String>(_Helbidea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "udalerria")
    public JAXBElement<String> createUdalerria(String value) {
        return new JAXBElement<String>(_Udalerria_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erakunde")
    public JAXBElement<String> createErakunde(String value) {
        return new JAXBElement<String>(_Erakunde_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "modelo")
    public JAXBElement<String> createModelo(String value) {
        return new JAXBElement<String>(_Modelo_QNAME, String.class, null, value);
    }

}
