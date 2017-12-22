package demo.zxhua.daggerdemo.vo;

import demo.zxhua.daggerdemo.R;

/**
 * Created by Zxhua on 2017/12/19 0019.
 */

public class StudentEntity extends BaseVO {
    public int color;

    public String stuName;

    public String stuAge;

    public String birthday;



    @Override
    public int getViewType() {
        return R.layout.item_stu_grid;
    }
}
