package code.zxhua.processinglib;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;

import code.zxhua.processinglib.ann.ActivityMap;

import static javax.lang.model.element.Modifier.*;

@SupportedAnnotationTypes("code.zxhua.processinglib.ann.ActivityMap")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ActivityProcesser extends AbstractProcessor {

    private static final String PAGECONFIG = "PageConfig.java";

    private HashMap<String, String> pageMap = new HashMap<>();


    private Filer mFiler;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();
        System.out.println("ActivityProcesser 注解处理器初始化完成.....");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(new FileOutputStream(PAGECONFIG));

            for (Element t : roundEnv.getElementsAnnotatedWith(ActivityMap.class)) {
                Name clazzName = t.getSimpleName();
                Class<? extends Element> aClass = t.getClass();

                ActivityMap activityMap = t.getAnnotation(ActivityMap.class);
                String pageName = activityMap.value();

                System.out.println("ActivityProcessor -- ClassName ==" + clazzName + ",Class==" + aClass + ",pageName==" + pageName);
                pageMap.put(clazzName.toString(), pageName);
            }

            generateJavaFile(pageMap);

        } catch (Exception e) {
            System.out.println(e.getClass() + ":" + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    private void generateJavaFile(Map<String, String> nameMap) {
        //generate constructor
        MethodSpec.Builder constructorBuidler = MethodSpec.constructorBuilder()
                .addModifiers(PUBLIC)
                .addStatement("routeMap = new $T<>()", HashMap.class);
        for (String key : nameMap.keySet()) {
            String name = nameMap.get(key);
            constructorBuidler.addStatement("routeMap.put(\"$N\", \"$N\")", key, name);
        }
        MethodSpec constructorName = constructorBuidler.build();

        //generate getActivityRouteName method
        MethodSpec routeName = MethodSpec.methodBuilder("getActivityName")
                .addModifiers(PUBLIC)
                .returns(String.class)
                .addParameter(String.class, "routeName")
                .beginControlFlow("if (null != routeMap && !routeMap.isEmpty())")
                .addStatement("return (String)routeMap.get(routeName)")
                .endControlFlow()
                .addStatement("return \"\"")
                .build();

        //generate class
        TypeSpec typeSpec = TypeSpec.classBuilder("AnnotationRoute$Finder")
                .addModifiers(PUBLIC)
                .addMethod(constructorName)
                .addMethod(routeName)
//                .addSuperinterface(Provider.class)
                .addField(HashMap.class, "routeMap", PRIVATE)
                .build();


        JavaFile javaFile = JavaFile.builder("code.lib.apt.route", typeSpec)
                                    .build();
        try {
            javaFile.writeTo(mFiler);
            System.out.println("AnnotationRoute$Finder builder complete");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("AnnotationRoute$Finder builder failure");
        }
    }

}
