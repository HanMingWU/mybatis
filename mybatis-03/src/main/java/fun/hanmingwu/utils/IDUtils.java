package fun.hanmingwu.utils;




import org.junit.Test;

import java.util.UUID;

public class IDUtils {
    public static String getId(){
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s;
    }
    @Test
    public void testId(){
        String id = IDUtils.getId();
        System.out.println(id);
    }

}

