package com.hspedu.qqframe;

import com.hspedu.qqserver.service.QQServer;

/**
 * @version 1.0
 * @Author Ace
 * @create 2022/10/12 18:53
 * 该类创建QQServer，启动后台的服务
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
