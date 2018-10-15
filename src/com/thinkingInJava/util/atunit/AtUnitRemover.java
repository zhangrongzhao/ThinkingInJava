package com.thinkingInJava.util.atunit;

import com.sun.tools.classfile.RuntimeAnnotations_attribute;
import com.thinkingInJava.util.BinaryFile;
import com.thinkingInJava.util.ClassNameFinder;
import com.thinkingInJava.util.ProcessFiles;
import sun.management.MethodInfo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;

//Displays @Unit in complied class files.if first argument is "-r",
// @Unit annotations are removed.
//{Args:...}
//{Requires:javassist.byteCode.ClassFile}
//You must install the Javassist library from
//http://sourceforge.net/projects/jboss
public class AtUnitRemover  implements ProcessFiles.Strategy {
    private static boolean remove=false;
    public static void main(String[] args)throws Exception{
        if(args.length>0&&args[0].equals("-r")){
            remove=true;
            String[] nargs=new String[args.length-1];
            System.arraycopy(args,1,nargs,0,nargs.length);
            args=nargs;
        }
        new ProcessFiles(new AtUnitRemover(),"class").start(args);
    }

    public void process(File cFile){
        boolean modified=false;
        try{
            String cName=ClassNameFinder.thisClass(BinaryFile.read(cFile));
            if(!cName.contains(".")){
                return;//Ignore unpackaged classes
            }
//            ClassPool cPool=ClassPool.getDefault();
//            CtClass ctClass=cPool.get(cName);
//            for(CtMethod method:ctClass.getDeclaredMethods()){
//                 MethodInfo mi=method.getMethodInfo();
//                 AnnotationsAttribute attr=(AnnotationsAttribute)mi.getAttribute(AnnotationsAttribute.visibleTag);
//                 if(attr==null){continue;}
//                 for(Annotation ann:attr.getAnnotations()){
//                     if(ann.getTypeName().startsWith("com.thinkingInJava.util.atunit")){
//                         System.out.println(ctClass.getName()+" Method; "+mi.getName()+" "+ann);
//                     }
//                     if(remove){
//                         ctClass.removeMethod(method);
//                         modified=true;
//                     }
//                 }
//            }
//            //Fields are not removed in this version(see text.)
//            if(modified){
//                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(cFile)));
//                ctClass.detach();
//            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
