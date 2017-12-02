package ca.on.conestogac.mbproject.Database;

/**
 * Created by mirko on 11/27/2017.
 */

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import ca.on.conestogac.mbproject.Entities.Statistics;
import ca.on.conestogac.mbproject.Entities.User;
import ca.on.conestogac.mbproject.Entities.Commander;
import ca.on.conestogac.mbproject.DAOs.UserDao;
import ca.on.conestogac.mbproject.DAOs.CommanderDao;
import ca.on.conestogac.mbproject.DAOs.StatisticsDao;

@Database(entities = {User.class,  Commander.class, Statistics.class
}, version = 16, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract CommanderDao commanderDao();
    public abstract StatisticsDao statisticsDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "userdatabase")
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the exercise, allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
