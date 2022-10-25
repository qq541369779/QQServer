package com.hspedu.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/**
 * @version 1.0
 * @Author Ace
 * @create 2022/10/12 17:13
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    // 添加线程对象到 hm 集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    // 根据userId,返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    // 这里编写方法，遍历 hashmap的key
    public static String getOnlineUser() {
        // 遍历集合，遍历hashmap的key，使用的是迭代器
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
}
