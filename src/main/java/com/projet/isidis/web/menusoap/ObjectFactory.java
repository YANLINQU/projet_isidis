
package com.projet.isidis.web.menusoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.projet.isidis.web.menusoap package. 
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

    private final static QName _RestoMenus_QNAME = new QName("http://iaws/resto/menus/projet", "RestoMenus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.projet.isidis.web.menusoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MenusRequest }
     * 
     */
    public MenusRequest createMenusRequest() {
        return new MenusRequest();
    }

    /**
     * Create an instance of {@link RestoMenusType }
     * 
     */
    public RestoMenusType createRestoMenusType() {
        return new RestoMenusType();
    }

    /**
     * Create an instance of {@link MenusType }
     * 
     */
    public MenusType createMenusType() {
        return new MenusType();
    }

    /**
     * Create an instance of {@link MenusAllType }
     * 
     */
    public MenusAllType createMenusAllType() {
        return new MenusAllType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestoMenusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/resto/menus/projet", name = "RestoMenus")
    public JAXBElement<RestoMenusType> createRestoMenus(RestoMenusType value) {
        return new JAXBElement<RestoMenusType>(_RestoMenus_QNAME, RestoMenusType.class, null, value);
    }

}
