package demo.zxhua.daggerdemo.ui.listener

import demo.zxhua.daggerdemo.vo.ClassEntity
import demo.zxhua.daggerdemo.vo.StudentEntity

/**
 * Created by Zxhua on 2017/12/20 0020.
 */

open interface StuItemClickListener {
    open fun onClickListener(studentEntity: StudentEntity)
}


open interface ClassItemClickListener {
    open fun onClickListener(classEntity: ClassEntity)
}

open interface AddItemClickListener {
    open fun onClickListener(type: String)
}

open interface AddClassClickListener {
    open fun onClickListener(className: String)
}