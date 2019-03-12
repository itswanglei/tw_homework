package main.java.company.tools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassUtil {
    public static void printMethodMessage(Object object) {
        //要获取类的信息，首先要获取类的类类型
        Class clazz = object.getClass();
        System.out.println("类的名称是：" + clazz.getName());

        /* Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限 */
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            //1. 获取注解
            Annotation[] ann = methods[i].getAnnotations();
            for (Annotation a : ann) {
                System.out.println(a);
            }
            //2. 获取权限修饰符
            String str = Modifier.toString(methods[i].getModifiers());
            System.out.print(str + " ");
            //3. 得到方法的返回值类型的类类型
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //4. 得到方法的名称
            System.out.print(methods[i].getName() + "(");
            //5.获取参数类型-->得到的是参数列表的类型的类类型
            Class[] paramTypes = methods[i].getParameterTypes();
            //解析数组
            for (int j = 0; j < paramTypes.length; j++) {
                if (j == 1 || j == paramTypes.length - 1) {
                    System.out.print(paramTypes[j].getName() + " args" + j);
                } else {
                    System.out.print(paramTypes[j].getName() + " args" + j + ",");
                }
            }
            System.out.print(")");
            //6.获取异常类型
            Class[] exps = methods[i].getExceptionTypes();
            if (exps.length != 0) {
                System.out.print(" throws ");
            }
            for (int k = 0; k < exps.length; k++) {
                System.out.print(exps[k].getName() + " ");
            }
            System.out.println();
        }
    }

    public static void printFieldMessage(Object object) {
        //获取类的类类型
        Class clazz = object.getClass();
        System.out.println("类的名称是：" + clazz.getName());

        /* 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields获取的是该类自己声明的成员变量的信息 */
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取每个属性的权限修饰符
            int i = field.getModifiers();
            String modifier = Modifier.toString(i);
            //得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(modifier + " "+ typeName + " " + fieldName);
        }
    }

    /*获取对象的构造函数的信息*/
    public static void printConMessage(Object object) {
        //获取类的类类型
        Class clazz = object.getClass();
        System.out.println("类的名称是：" + clazz.getName());

        /* 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructors获取所有的public的构造函数
         * getDeclaredConstructors得到所有的构造函数 */
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            //获取构造函数的参数列表--->得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class clazz1 : paramTypes) {
                System.out.print(clazz1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
