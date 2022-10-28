package com.hspedu.qqserver.service;

import com.hspedu.Utility.Utility;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @version 1.0
 * @Author Ace
 * @create 2022/10/27 14:50
 */
public class SendNewsToAllService implements Runnable {
    @Override
    public void run() {

        // 为了可以多次推送新闻，使用while
        while (true){
            System.out.println("请输入服务器要推送的新闻/消息[输入exit退出推送服务]");
            String news = Utility.readString(100);
            if("exit".equals(news)){
                break;
            }
            // 构建一个消息，群发消息
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 说：" + news);

            // 遍历当前所有的通信线程，得到socket，并发送message
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUser = iterator.next().toString();
                ServerConnectClientThread serverConnectClientThread = hm.get(onLineUser);
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
