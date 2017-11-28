package ca.on.conestogac.mbproject.Entities;

/**
 * Created by mirko on 11/2/2017.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String password;


    public User( String name, String password) {
        this.name = name;
        this.password  = password;
    }

}
