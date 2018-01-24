
package com.projet.isidis.web.menusoap;

import javax.xml.bind.annotation.*;


/**
 * <p>MenusType complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="MenusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_menu">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nomme">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Fruits de mer"/>
 *               &lt;enumeration value="BBQ"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="image">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="../../images/Fruitsdemer.jpg"/>
 *               &lt;enumeration value="../../images/BBQ.jpg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="prix">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="15.30"/>
 *               &lt;enumeration value="18.30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MenusType", namespace = "http://iaws/resto/menus/projet", propOrder = {
    "idMenu",
    "nomme",
    "image",
    "prix"
})
@XmlRootElement(name = "Menus")
public class MenusType {

    @XmlElement(name = "id_menu", namespace = "http://iaws/resto/menus/projet", required = true)
    protected String idMenu;
    @XmlElement(namespace = "http://iaws/resto/menus/projet", required = true)
    protected String nomme;
    @XmlElement(namespace = "http://iaws/resto/menus/projet", required = true)
    protected String image;
    @XmlElement(namespace = "http://iaws/resto/menus/projet", required = true)
    protected String prix;

    /**
     * \u83b7\u53d6idMenu\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMenu() {
        return idMenu;
    }

    /**
     * \u8bbe\u7f6eidMenu\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMenu(String value) {
        this.idMenu = value;
    }

    /**
     * \u83b7\u53d6nomme\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomme() {
        return nomme;
    }

    /**
     * \u8bbe\u7f6enomme\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomme(String value) {
        this.nomme = value;
    }

    /**
     * \u83b7\u53d6image\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * \u8bbe\u7f6eimage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * \u83b7\u53d6prix\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrix() {
        return prix;
    }

    /**
     * \u8bbe\u7f6eprix\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrix(String value) {
        this.prix = value;
    }

}
