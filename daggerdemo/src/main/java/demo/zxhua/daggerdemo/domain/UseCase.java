package demo.zxhua.daggerdemo.domain;

        import io.reactivex.Completable;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public interface UseCase<P> {
    Completable execute(P parameter);
}
