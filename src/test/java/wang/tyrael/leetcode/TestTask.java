package wang.tyrael.leetcode;

import wang.tyrael.leetcode.geometry.pointsonaline.Solution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class TestTask implements Runnable{
    private Object toTest;
    private String methodName;
    private Object[] params;

    private Object answer;

    public TestTask(Object toTest, String methodName, Object[] params, Object answer) {
        this.toTest = toTest;
        this.methodName = methodName;
        this.params = params;
        this.answer = answer;
    }

    public void initParams(Object... params){
        this.params = params;
    }

    @Override
    public void run() {
        Class[] parameterTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            parameterTypes[i] = params[i].getClass();
            System.out.println("parameterTypes[i]:" + parameterTypes[i]);
        }
        Method method = null;
        try {
            method = toTest.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Object result;
        try {
            result = method.invoke(toTest, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        TestStatic.assertResult(answer, result);
    }
}
