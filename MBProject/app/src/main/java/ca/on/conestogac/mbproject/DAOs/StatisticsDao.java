package ca.on.conestogac.mbproject.DAOs;

/**
 * Created by mirko on 11/27/2017.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.on.conestogac.mbproject.Entities.Statistics;

@Dao
public interface StatisticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStatistics(Statistics statistics);

    @Query("SELECT * FROM statistics WHERE userId=:userId")
    List<Statistics> findTrophiesForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateStatistics(Statistics statistics);

    @Query("delete from statistics where id = :id")
    void delete(long id);
}
