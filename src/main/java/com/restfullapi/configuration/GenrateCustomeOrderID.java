package com.restfullapi.configuration;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.annotations.IdGeneratorType;

/**
 * This annotation is used to specify a custom identifier generator for 
 * order IDs in Hibernate entities.
 */
@Target({ElementType.FIELD}) // Specifies that this annotation can be applied to fields.
@Retention(RetentionPolicy.RUNTIME) // Indicates that this annotation will be available at runtime for reflection.
@IdGeneratorType(OrderIdGenrator.class) // Specifies the class that will generate the ID for the annotated field.
public @interface GenrateCustomeOrderID {

}
