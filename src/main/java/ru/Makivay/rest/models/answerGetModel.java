package ru.Makivay.rest.models;

import ru.Makivay.ao.models.ElementModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Kmatveev on 13.11.2015.
 */
@XmlRootElement
public class answerGetModel {

    @XmlElement
    public long size;

    @XmlElement
    public List<ElementModel> list;

    public answerGetModel(long size, List<ElementModel> list) {
        this.size = size;
        this.list = list;
    }
}
