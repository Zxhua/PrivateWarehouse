package demo.zxhua.daggerdemo.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import demo.zxhua.daggerdemo.vo.ClassEntity;

/**
 * Created by Zxhua on 2017/12/20 0020.
 */
@Dao
public abstract class ClassDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(ClassEntity... classEntities);

    @Query("SELECT * FROM classentity")
    public abstract LiveData<List<ClassEntity>> load();


}
