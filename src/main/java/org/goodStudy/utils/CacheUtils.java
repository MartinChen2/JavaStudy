package org.goodStudy.utils;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.Util
 * @Date 2023/1/6 16:43
 * @Version 1.0
 */
public class CacheUtils {
    public static void main(String[] args) {
        // Cache
        Cache<Object, Object> cache1 = Caffeine.newBuilder()
                //初始数量
                .initialCapacity(10)
                //最大条数
                .maximumSize(10)
                //expireAfterWrite和expireAfterAccess同时存在时，以expireAfterWrite为准
                //最后一次写操作后经过指定时间过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                //最后一次读或写操作后经过指定时间过期
//                .expireAfterAccess(1, TimeUnit.SECONDS)
                //监听缓存被移除
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object o, @Nullable Object o2, RemovalCause removalCause) {
                        System.out.println("o = " +  o);
                        System.out.println("o2 = " +  o2);
                        System.out.println("removalCause = " +  removalCause);
                        if("1".equals(o)){

                        }
                    }
                })
                //记录命中
                .recordStats()
                .build();

        cache1.put("1","张三");


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    //张三
//                    System.out.println(cache1.getIfPresent("1"));
//                    //存储的是默认值
//                    System.out.println(cache1.get("2",o -> "默认值"));
//                    System.out.println(cache1.stats());
//                    try {
//                        Thread.sleep( 2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        List<String> arrays = new ArrayList<>();
        arrays.add("11");
        arrays.add("22");
        arrays.add("33");
        arrays.add("44");
        arrays.add("55");
        arrays.add("66");
        // LoadingCache
        LoadingCache<String, String> loadingCache = Caffeine.newBuilder()
                //创建缓存或者最近一次更新缓存后经过指定时间间隔，刷新缓存；refreshAfterWrite仅支持LoadingCache
                .refreshAfterWrite(6, TimeUnit.SECONDS)
                .expireAfterWrite(6, TimeUnit.SECONDS)
                .expireAfterAccess(6, TimeUnit.SECONDS)
                .maximumSize(6)
                //根据key查询数据库里面的值，这里是个lamba表达式
                .build(new CacheLoader<String, String>() {
                    @Override
                    public @Nullable String load(String s) throws Exception {
                        return String.valueOf(arrays.get(Integer.valueOf(s)));
                    }
                });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //张三
                    //存储的是默认值
                    System.out.println(loadingCache.get("2"));
                    System.out.println(loadingCache.stats());
                    try {
                        Thread.sleep( 2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // AsyncLoadingCache
        AsyncLoadingCache<String, String> asyncLoadingCache = Caffeine.newBuilder()
                //创建缓存或者最近一次更新缓存后经过指定时间间隔刷新缓存；仅支持LoadingCache
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                //根据key查询数据库里面的值
                .buildAsync(key -> {
                    Thread.sleep(1000);
                    return new Date().toString();
                });

        //异步缓存返回的是CompletableFuture
        CompletableFuture<String> future = asyncLoadingCache.get("1");
        future.thenAccept(System.out::println);




    }
}
