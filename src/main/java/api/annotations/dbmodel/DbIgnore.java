package api.annotations.dbmodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库忽略字段
 * @author zimu
 * @date 2016-11-05 15:26:19 中国标准时间
 */
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DbIgnore {

}
