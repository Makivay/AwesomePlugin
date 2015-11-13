package ru.Makivay.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;

import java.sql.Date;

/**
 * Created by Kmatveev on 12.11.2015.
 */

@Preload
public interface ElementEntity extends Entity {

    String getString();

    void setString(String string);

    Date getDate();

    void setDate(Date date);

    String getAction();

    void setAction(String action);
}
