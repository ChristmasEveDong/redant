package com.redant.core.session;

import com.redant.core.TemporaryDataHolder;
import io.netty.channel.ChannelHandlerContext;

/**
 * Session管理器
 * @author houyi.wh
 * @date 2017/11/6
 */
public class SessionManager {

    private SessionManager(){

    }


    //======================================

    /**
     * 判断session是否存在
     * @return
     */
    public static boolean containsSession(){
        ChannelHandlerContext context = TemporaryDataHolder.loadContext();
        return SessionHelper.instange().containsSession(context);
    }

    /**
     * 添加一个session
     * @param session
     */
    public static void addSession(HttpSession session){
        ChannelHandlerContext context = TemporaryDataHolder.loadContext();
        SessionHelper.instange().addSession(context, session);
    }

    /**
     * 获取一个session
     * @return
     */
    public static HttpSession getSession(){
        ChannelHandlerContext context = TemporaryDataHolder.loadContext();
        return SessionHelper.instange().getSession(context);
    }

    /**
     * 获取一个session，获取不到时自动创建一个
     * @param createIfNull
     * @return
     */
    public static HttpSession getSession(boolean createIfNull){
        ChannelHandlerContext context = TemporaryDataHolder.loadContext();
        return SessionHelper.instange().getSession(context,createIfNull);
    }

    /**
     * 清除过期的session
     * 需要在定时器中执行该方法
     */
    public static void clearExpireSession(){
        SessionHelper.instange().clearExpireSession();
    }

}
