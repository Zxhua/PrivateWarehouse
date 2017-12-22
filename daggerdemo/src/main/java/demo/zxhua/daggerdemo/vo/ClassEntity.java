package demo.zxhua.daggerdemo.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import demo.zxhua.daggerdemo.R;

/**
 * Created by Zxhua on 2017/12/20 0020.
 */
@Entity
public class ClassEntity extends BaseVO {
    @PrimaryKey
    public int classId;
    @ColumnInfo(name = "class_name")
    public String className;

    @Override
    public int getViewType() {
        return R.layout.item_class;
    }
}
