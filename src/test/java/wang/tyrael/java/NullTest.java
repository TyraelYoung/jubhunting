package wang.tyrael.java;

import org.junit.Test;

public class NullTest {
    @Test
    public void testInstanceOf(){
        if (null instanceof String){
            System.out.println("null instanceof String: true");
        }else{
            System.out.println("null instanceof String: false");
        }
    }

    @org.junit.Test
    public void testSwitch(){
        String s = null;
        switch (s){
            case "a":
                break;
        }
    }
}
