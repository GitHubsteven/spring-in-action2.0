//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.22 时间 10:23:31 AM CST 
//


package com.asa.demo.spring.webservice.productor.wsdl;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countries" type="{http://asa.com/demo/spring/webservice/productor/wsdl}country" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "countries"
})
@XmlRootElement(name = "listCountryResponse")
public class ListCountryResponse {

    @XmlElement(required = true)
    protected List<Country> countries;

    /**
     * Gets the value of the countries property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countries property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountries().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Country }
     *
     *
     */
    public List<Country> getCountries() {
        if (countries == null) {
            countries = new ArrayList<Country>();
        }
        return this.countries;
    }

}
