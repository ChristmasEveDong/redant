package com.redant.web;

import com.redant.core.bean.BeanContext;
import com.redant.core.netty.NettyServer;
import com.redant.core.router.RouterContext;

/**
 * 服务端启动入口
 * @author gris.wang
 * @create 2017-10-20
 */
public class ServerBootstrap {

    public static void main(String[] args) {

        BeanContext.initBeans();
        RouterContext.initRouters();

        NettyServer nettyServer = new NettyServer();
        nettyServer.start();
    }

}