package Annotation;

// ClassDocumentation.java
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ClassDocumentation {
    String value() default "";
}
