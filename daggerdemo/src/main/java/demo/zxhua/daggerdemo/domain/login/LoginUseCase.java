package demo.zxhua.daggerdemo.domain.login;

import demo.zxhua.daggerdemo.domain.UseCase;
import demo.zxhua.daggerdemo.domain.bean.LoginEntity;
import demo.zxhua.daggerdemo.domain.login.repository.LoginRepository;
import io.reactivex.Completable;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public class LoginUseCase implements UseCase<LoginEntity> {
    private final LoginRepository loginRepository;

    public LoginUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Completable execute(LoginEntity parameter) {
        return loginRepository.login(parameter);
    }
}
