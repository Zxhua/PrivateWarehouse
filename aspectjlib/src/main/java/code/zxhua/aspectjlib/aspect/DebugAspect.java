package code.zxhua.aspectjlib.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by Zxhua on 2018/1/12 0012.
 */
@Aspect
public class DebugAspect {

    private static final String TAG = "Aspect-DebugTrace";

    private static final String POINTCUT_METHOD =
            "execution(@code.zxhua.aspectjlib.ann.DebugTrace * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace()")
    public Object annotationPointCutMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Log.d(TAG, className + ",method:(" + methodName + ")");
        return joinPoint.proceed();
    }
}
