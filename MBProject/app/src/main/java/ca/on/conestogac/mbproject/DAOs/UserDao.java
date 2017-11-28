package ca.on.conestogac.mbproject.DAOs;

/**
 * Created by mirko on 11/27/2017.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import ca.on.conestogac.mbproject.Entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void addUser(User user);

    @Query("select * from user")
    public List<User> getAllUser();

    @Query("select * from user where name = :userName")
    public User getUser(String userName);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Query("delete from user")
    void removeAllUsers();
}
