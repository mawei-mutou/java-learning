package date20200221;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/2/21
 * time        : 13:51
 * description :
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SxtField {
    int length();
    String columnName();
    String type();
}
