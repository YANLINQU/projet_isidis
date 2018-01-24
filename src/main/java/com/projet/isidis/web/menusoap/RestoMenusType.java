
package com.projet.isidis.web.menusoap;

import javax.xml.bind.annotation.*;


/**
 * <p>RestoMenusType complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="RestoMenusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tablecommande" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MenusAll" type="{http://iaws/resto/menus/projet}MenusAllType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestoMenusType", namespace = "http://iaws/resto/menus/projet", propOrder = {
    "name",
    "tablecommande",
    "menusAll"
})
@XmlRootElement(name = "RestoMenus")
public class RestoMenusType {

    @XmlElement(namespace = "http://iaws/resto/menus/projet", required = true)
    protected String name;
    @XmlElement(namespace = "http://iaws/resto/menus/projet", required = true)
    protected String tablecommande;
    @XmlElement(name = "MenusAll", namespace = "http://iaws/resto/menus/projet", required = true)
    protected MenusAllType menusAll;

    /**
     * \u83b7\u53d6name\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * \u8bbe\u7f6ename\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * \u83b7\u53d6tablecommande\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTablecommande() {
        return tablecommande;
    }

    /**
     * \u8bbe\u7f6etablecommande\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTablecommande(String value) {
        this.tablecommande = value;
    }

    /**
     * \u83b7\u53d6menusAll\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link MenusAllType }
     *     
     */
    public MenusAllType getMenusAll() {
        return menusAll;
    }

    /**
     * \u8bbe\u7f6emenusAll\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link MenusAllType }
     *     
     */
    public void setMenusAll(MenusAllType value) {
        this.menusAll = value;
    }

}
