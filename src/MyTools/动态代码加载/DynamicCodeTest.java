package MyTools.动态代码加载;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class DynamicCodeTest {
    public static void compile(String className, String code) {
        File tempFile = null;
        try {
            tempFile = new File(className + ".java");
            FileWriter fileWriter = new FileWriter(tempFile);
            fileWriter.write(code);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);


        Iterable<? extends JavaFileObject> compilationUnits1 =
                fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(tempFile));

        String flag = "-d";
        try {
            //获取路径
            File classPath = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).toURI());
            //添加分隔符
            String outDir = classPath.getAbsolutePath() + File.separator;
            Iterable<String> options = Arrays.asList(flag, outDir);

            System.out.println(outDir);
            final JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, compilationUnits1);
            task.call();


            //final Class<?> aClass = Class.forName("MyTools.动态代码加载."+className);
            //  System.out.println(aClass);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        compile("CompileTest", "package MyTools.动态代码加载;\n" +
                "\n" +
                "public class CompileTest {\n" +
                "}\n");
    }
}
