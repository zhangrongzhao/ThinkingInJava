package com.thinkingInJava.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

//Produce a sequence of File objects that match a regular expression in either a local directory or by walking a directory tree.
public final class Directory {
     public static File[] local(File dir,final String regex){
         return dir.listFiles(new FilenameFilter(){
             private Pattern pattern=Pattern.compile(regex);
             public boolean accept(File dir,String name){
                 return pattern.matcher(name).matches();
             }
         });
     }
     public static File[] local(String path,final String regex){
         return local(new File(path),regex);
     }
     //A two-tuple for returning a pair of objects
    public static class TreeInfo implements Iterable<File>{
         public List<File> files=new ArrayList<File>();
         public List<File> dirs=new ArrayList<File>();
         //The default iterable element is the file list:
         public Iterator<File> iterator(){
             return files.iterator();
         }
         void addAll(TreeInfo other){
             files.addAll(other.files);
             dirs.addAll(other.dirs);
         }
         public String toString(){
             return "dirs:"+PPrint.pformat(dirs)+"\n\nfiles"+PPrint.pformat(files);
             //return "dirs:"+dirs+"\n\nfiles"+files;
         }
     }
     public static TreeInfo walk(String start,String regex){
         return recurseDirs(new File(start),regex);
     }
     public static TreeInfo walk(File start,String regex){
         return recurseDirs(start,regex);
     }
     public static TreeInfo walk(File start){
         return recurseDirs(start,".*");
     }
     public static TreeInfo walk(String start){
         return recurseDirs(new File(start),".*");
     }
     static TreeInfo recurseDirs(File startDir,String regex){
         TreeInfo result=new TreeInfo();
         for(File item:startDir.listFiles()){
             if(item.isDirectory()){
                 result.dirs.add(item);
                 result.addAll(recurseDirs(item,regex));
             }else{
                 if(item.getName().matches(regex)){
                     result.files.add(item);
                 }
             }
         }
         return result;
     }
     //Simple validation test:
    public static void main(String[] args){
         if(args.length==0){
             System.out.println(walk("."));
         }else{
             for(String arg:args){
                 System.out.println(walk(arg));
             }
         }
    }
}
