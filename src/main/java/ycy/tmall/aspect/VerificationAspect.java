package ycy.tmall.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ycy.tmall.annotation.Nullable;
import ycy.tmall.exception.ParameterException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * 数据校验，配合自定义注解使用
 * 默认所有参数不为空，若可以为空 在参数前加 @Nullable 注解
 */
@Aspect
@Component
public class VerificationAspect {

    /**
     * 声明切面
     * 所有controller下以Controller结尾的类中的所有public方法
     */
    @Pointcut("execution(public * ycy.tmall.controller.*.*Controller.*(..))")
    public void joinPointInAllController() {
    }

    @Before("joinPointInAllController()")
    public void checkParameter(JoinPoint point) throws ParameterException {
        //1.获取切入点方法参数
        Object[] args = point.getArgs();
        //.2获取切入方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //3.获取该方法所有参数
        Parameter[] parameters = method.getParameters();
        //4.保存需要校验的参数(未用@Nullable注解标注的参数)
        ArrayList<Object> argsWithoutNullable = new ArrayList<>();
        //5.对需要校验的参数进行验证
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Annotation[] annotations = parameter.getDeclaredAnnotationsByType(Nullable.class);
            if (annotations.length < 1) {
                argsWithoutNullable.add(args[i]);
            }
        }
        for (Object o:argsWithoutNullable
             ) {if (o==null){
throw new ParameterException("非法请求，参数不全");
        }
            
        }
    }
}
