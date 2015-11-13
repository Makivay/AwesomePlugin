package ru.Makivay.ao.models;

import ru.Makivay.ao.ElementEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * Created by Kmatveev on 13.11.2015.
 */
@XmlRootElement
public class ElementModel {

    @XmlElement
    String string;

    @XmlElement
    Date date;

    @XmlElement
    String action;

    public ElementModel(String string, Date date, String action) {
        this.string = string;
        this.date = date;
        this.action = action;
    }

    public ElementModel(ElementEntity elementEntity) {
        this.string = elementEntity.getString();
        this.date = elementEntity.getDate();
        this.action = elementEntity.getAction();
    }
}
