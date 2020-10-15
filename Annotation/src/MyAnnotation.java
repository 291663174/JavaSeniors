import static java.lang.annotation.ElementType.*;

import java.lang.annotation.*;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-01 11:20
 **/
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD, PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";

}
