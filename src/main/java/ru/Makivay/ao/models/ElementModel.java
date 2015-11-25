package ru.Makivay.ao.models;

import ru.Makivay.ao.ElementEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kmatveev on 13.11.2015.
 */
@XmlRootElement
public class ElementModel {

    @XmlElement
    int id;

    @XmlElement
    String string;

    @XmlElement
    String date;

    @XmlElement
    String action;

    public ElementModel(int id, String string, String date, String action) {
        this.id = id;
        this.string = string;
        this.date = date;
        this.action = action;
    }

    public ElementModel(ElementEntity elementEntity) {
        this.id = elementEntity.getID();
        this.string = elementEntity.getString();
        this.date = elementEntity.getDate();
        this.action = elementEntity.getAction();
    }
}
