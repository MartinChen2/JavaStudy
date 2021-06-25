package org.goodStudy.test;

import javax.management.Query;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.test
 * @Date 2021/6/23 4:18 下午
 * @Version 1.0
 */
public class TestSTL {

    /**
     * 测试队列功能
     */
    public void testQueue(){
        Queue queue = new LinkedBlockingQueue();
//        PriorityQueue queue = new PriorityQueue<>();
        for (int i = 0; i < 20; i++){
            queue.offer("i = " + i);
        }

        System.out.println("-------遍历数据--------");
        for (Object value : queue) {
            System.out.println(value);
        }

        System.out.println("-------取数据--------");
        Object val = queue.remove();
        while (val != null){
            System.out.println(val);
            val = queue.poll();
        }
    }

    /**
     * 测试栈
     */
    public void testStack(){
        Stack stack = new Stack();

        for (int i = 0; i < 20; i++){
            stack.push(i);
        }

        System.out.println("-------------获取数据-----------");

        Object val = stack.pop();
        while (val != null){
            System.out.println(val);
            if (stack.empty()){
                val = null;
            } else {
                val = stack.pop();
            }
        }
    }

    public void testVector(){
        Vector vector = new Vector();
        vector.add(1);
//        Set set = new HashSet();
//        Set set = new LinkedHashSet();
        Set set = new TreeSet();
//        Collections.sort();
        set.add("aaa");
        set.contains(1);
    }

    public void testHashTable(){
        Hashtable hashtable = new Hashtable();
        hashtable.put(1,2);

        HashMap hashMap = new HashMap();
        hashMap.put(1, 2);
        hashMap.put("ding", "dda");
    }

    public static void main(String[] args) {
        TestSTL test = new TestSTL();
        test.testQueue();
//        test.testStack();
    }
}
