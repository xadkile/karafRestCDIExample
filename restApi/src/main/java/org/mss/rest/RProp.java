package org.mss.rest;


import org.osgi.service.cdi.annotations.BeanPropertyType;
import org.osgi.service.component.annotations.ComponentPropertyType;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@BeanPropertyType // for CDI
@ComponentPropertyType //for DS
public @interface RProp {
    // for "osgi.jaxrs.resource" property
    boolean osgi_jaxrs_resource() default true;
}
