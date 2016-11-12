package cm.ioc.model;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface Component {
	public String value() default "";
}