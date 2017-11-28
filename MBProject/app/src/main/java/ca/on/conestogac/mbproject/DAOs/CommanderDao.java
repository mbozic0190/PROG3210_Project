package ca.on.conestogac.mbproject.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.on.conestogac.mbproject.Entities.Commander;


/**
 * Created by mirko on 11/27/2017.
 */

@Dao
public interface CommanderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCommander(Commander commander);

    @Query("select * from commander")
    public List<Commander> getAllCommanders();

    @Query("select * from commander where id = :commanderId")
    public List<Commander> getCommander(long commanderId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCommander(Commander commander);

    @Query("delete from commander")
    void removeAllCommader();
}
