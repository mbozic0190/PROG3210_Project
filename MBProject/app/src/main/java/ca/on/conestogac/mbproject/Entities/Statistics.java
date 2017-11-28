package ca.on.conestogac.mbproject.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mirko on 11/27/2017.
 */

@Entity(tableName = "statistics",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Commander.class,
                        parentColumns = "id",
                        childColumns = "commanderId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = { @Index(value = "id")}
)
public class Statistics {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int userId;
    public int commanderId;


    public Statistics(int userId, int commanderId) {
        this.userId = userId;
        this.commanderId = commanderId;
    }
}
