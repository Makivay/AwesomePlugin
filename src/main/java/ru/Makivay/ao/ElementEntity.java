package ru.Makivay.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;

/**
 * Created by Kmatveev on 12.11.2015.
 */

@Preload
public interface ElementEntity extends Entity {

    String getString();

    void setString(String string);

    String getDate();

    void setDate(String date);

    String getAction();

    void setAction(String action);
}
