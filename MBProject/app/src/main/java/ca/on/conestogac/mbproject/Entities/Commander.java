package ca.on.conestogac.mbproject.Entities;

/**
 * Created by mirko on 11/4/2017.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity
public class Commander {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;


    public Commander(String name) {
        this.name = name;
    }

}
