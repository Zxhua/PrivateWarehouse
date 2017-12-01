package demo.zxhua.daggerdemo.domain.login.repository;


import demo.zxhua.daggerdemo.domain.bean.LoginEntity;
import io.reactivex.Completable;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public interface LoginRepository {

    Completable login(LoginEntity loginEntity);
}
