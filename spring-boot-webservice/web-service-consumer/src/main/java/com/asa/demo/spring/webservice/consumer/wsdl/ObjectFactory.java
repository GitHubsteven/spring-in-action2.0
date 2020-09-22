//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.0 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.22 时间 10:34:49 AM CST 
//


package com.asa.demo.spring.webservice.consumer.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.asa.demo.spring.webservice.consumer.wsdl package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListCountryRequest_QNAME = new QName("http://asa.com/demo/spring/webservice/productor/wsdl", "listCountryRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.asa.demo.spring.webservice.consumer.wsdl
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryRequest }
     */
    public GetCountryRequest createGetCountryRequest() {
        return new GetCountryRequest();
    }

    /**
     * Create an instance of {@link GetCountryResponse }
     */
    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }

    /**
     * Create an instance of {@link Country }
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Void }
     */
    public Void createVoid() {
        return new Void();
    }

    /**
     * Create an instance of {@link ListCountryResponse }
     */
    public ListCountryResponse createListCountryResponse() {
        return new ListCountryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link Void }{@code >}
     */
    @XmlElementDecl(namespace = "http://asa.com/demo/spring/webservice/productor/wsdl", name = "listCountryRequest")
    public JAXBElement<Void> createListCountryRequest(Void value) {
        return new JAXBElement<Void>(_ListCountryRequest_QNAME, Void.class, null, value);
    }

}
