package demo.zxhua.daggerdemo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import demo.zxhua.daggerdemo.vo.ClassEntity;

/**
 * Created by Zxhua on 2017/12/20 0020.
 */
@Database(entities = {ClassEntity.class}, version = 1)
public abstract class AppDb extends RoomDatabase {
    abstract public ClassDao classDao();
}
