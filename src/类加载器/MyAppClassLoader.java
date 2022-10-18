package 类加载器;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;

public class MyAppClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        String s = name.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        String s = name.replaceAll("\\.", "\\\\" );
        try {
            byte[] bytes = Files.readAllBytes(Path.of("C:\\Users\\SWQXDBA\\IdeaProjects\\shuati\\out\\production\\力扣", s+".class"));
            return defineClass(name,bytes,0,bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            if(!name.startsWith("类加载器")){
              return   getParent().loadClass(name);
            }
            Class<?> loadedClass = findLoadedClass(name);
            if(loadedClass!=null){
                return loadedClass;
            }
            System.out.println("load new class: "+name );
            return findClass(name);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyAppClassLoader classLoader = new MyAppClassLoader();
        Class<?> loadClass = classLoader.loadClass("类加载器.LoadClass");
        Object o1 = loadClass.getDeclaredConstructor().newInstance();

        System.out.println(o1.getClass().getClassLoader());

        MyAppClassLoader classLoader2 = new MyAppClassLoader();
        Class<?> loadClass2 = classLoader2.loadClass("类加载器.LoadClass");
        Object o2 = loadClass2.getDeclaredConstructor().newInstance();

        System.out.println(o2.getClass().getClassLoader());


        Class<LoadClass> loadClass3 = LoadClass.class;
        Object o3 = loadClass3.getDeclaredConstructor().newInstance();

        System.out.println(o3.getClass().getClassLoader());

        System.out.println(o1.getClass()==loadClass);
        System.out.println(o1.getClass()==o2.getClass());
        System.out.println(o1.getClass()==o3.getClass());
        System.out.println(o2.getClass()==o3.getClass());
    }
}
