package com.thinkingInJava.chapter20.annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

//APT-based annotation processing.
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env){
        return new InterfaceExtractorProcessor(env);
    }
    public Collection<String> supportedAnnotationTypes(){
        return Collections.singleton("annotations.ExtractInterface");
    }
    public Collection<String> supportedOptions(){
        return Collections.emptySet();
    }
}
