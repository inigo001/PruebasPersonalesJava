//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.06.08 a las 09:29:51 AM CEST 
//


package xmljaxb.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}erakunde"/>
 *         &lt;element ref="{}helbidea" minOccurs="0"/>
 *         &lt;element ref="{}udalerria"/>
 *         &lt;element ref="{}probintzia"/>
 *         &lt;element ref="{}xetrs89"/>
 *         &lt;element ref="{}yetrs89"/>
 *         &lt;element ref="{}kokapena" minOccurs="0"/>
 *         &lt;element ref="{}ordutegia" minOccurs="0"/>
 *         &lt;element ref="{}seriezenbakia"/>
 *         &lt;element ref="{}modelo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "erakunde",
    "helbidea",
    "udalerria",
    "probintzia",
    "xetrs89",
    "yetrs89",
    "kokapena",
    "ordutegia",
    "seriezenbakia",
    "modelo"
})
@XmlRootElement(name = "row")
public class Row {

    @XmlElement(required = true)
    protected String erakunde;
    protected String helbidea;
    @XmlElement(required = true)
    protected String udalerria;
    @XmlElement(required = true)
    protected String probintzia;
    protected float xetrs89;
    protected float yetrs89;
    protected String kokapena;
    protected String ordutegia;
    @XmlElement(required = true)
    protected String seriezenbakia;
    @XmlElement(required = true)
    protected String modelo;
    @XmlAttribute(name = "num")
    protected Short num;

    /**
     * Obtiene el valor de la propiedad erakunde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErakunde() {
        return erakunde;
    }

    /**
     * Define el valor de la propiedad erakunde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErakunde(String value) {
        this.erakunde = value;
    }

    /**
     * Obtiene el valor de la propiedad helbidea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelbidea() {
        return helbidea;
    }

    /**
     * Define el valor de la propiedad helbidea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelbidea(String value) {
        this.helbidea = value;
    }

    /**
     * Obtiene el valor de la propiedad udalerria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUdalerria() {
        return udalerria;
    }

    /**
     * Define el valor de la propiedad udalerria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUdalerria(String value) {
        this.udalerria = value;
    }

    /**
     * Obtiene el valor de la propiedad probintzia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProbintzia() {
        return probintzia;
    }

    /**
     * Define el valor de la propiedad probintzia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProbintzia(String value) {
        this.probintzia = value;
    }

    /**
     * Obtiene el valor de la propiedad xetrs89.
     * 
     */
    public float getXetrs89() {
        return xetrs89;
    }

    /**
     * Define el valor de la propiedad xetrs89.
     * 
     */
    public void setXetrs89(float value) {
        this.xetrs89 = value;
    }

    /**
     * Obtiene el valor de la propiedad yetrs89.
     * 
     */
    public float getYetrs89() {
        return yetrs89;
    }

    /**
     * Define el valor de la propiedad yetrs89.
     * 
     */
    public void setYetrs89(float value) {
        this.yetrs89 = value;
    }

    /**
     * Obtiene el valor de la propiedad kokapena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKokapena() {
        return kokapena;
    }

    /**
     * Define el valor de la propiedad kokapena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKokapena(String value) {
        this.kokapena = value;
    }

    /**
     * Obtiene el valor de la propiedad ordutegia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdutegia() {
        return ordutegia;
    }

    /**
     * Define el valor de la propiedad ordutegia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdutegia(String value) {
        this.ordutegia = value;
    }

    /**
     * Obtiene el valor de la propiedad seriezenbakia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeriezenbakia() {
        return seriezenbakia;
    }

    /**
     * Define el valor de la propiedad seriezenbakia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeriezenbakia(String value) {
        this.seriezenbakia = value;
    }

    /**
     * Obtiene el valor de la propiedad modelo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define el valor de la propiedad modelo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(String value) {
        this.modelo = value;
    }

    /**
     * Obtiene el valor de la propiedad num.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNum() {
        return num;
    }

    /**
     * Define el valor de la propiedad num.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNum(Short value) {
        this.num = value;
    }

}
