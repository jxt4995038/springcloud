package com.example.account.websocket;

import com.example.account.model.WebSocketMessageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
//访问服务端的url地址
@ServerEndpoint(value = "/websocket/{id}")
public class WebSocketServer {
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private static Logger log = LogManager.getLogger(WebSocketServer.class);

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Value("${eureka.instance.ip-address}")
//    private String ip;
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam(value = "id") String id, Session session) {
        this.session = session;
        webSocketSet.put(id, this);     //加入set中
        addOnlineCount();           //在线数加1
//        log.info("用户"+id+"加入！当前在线人数为" + getOnlineCount());

//        String userId = null;
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        if ((securityContext.getAuthentication()) != null && ((securityContext.getAuthentication().getPrincipal()) instanceof UserInfo)) {
//            UserInfo userInfo = (UserInfo) securityContext.getAuthentication().getPrincipal();
//            userId = userInfo.getUserId();
//        }
//        //存入redis中,key为orderId+"_"userId++
//        String key = id+"_"+userId;
//        stringRedisTemplate.opsForValue().set(key,ip);
//        try {
//            sendMessage("连接成功");
//        } catch (IOException e) {
//            log.error("websocket IO异常");
//        }
    }

    /**
     * 连接关闭调用的方法
     */
	@OnClose
    public void onClose(@PathParam(value = "id") String id) {
        webSocketSet.remove(id);  //从set中删除
        subOnlineCount();           //在线数减1
//        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());


    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        String s = "";
        try {
            s = session.getRequestURI().toString();
            s = s.substring(s.lastIndexOf("/")+1);

        }catch (Exception e){
            log.error("websocket获取用户id失败");
        }
        try {
            WebSocketMessageModel model = new WebSocketMessageModel();
            model.setType(0);
            model.setContent("心跳监测");
            sendtoUser(model,s);
        }catch (Exception e){
            log.error("websocket推送信息失败");
        }

        //可以自己约定字符串内容，比如 内容|0 表示信息群发，内容|X 表示信息发给id为X的用户
//        String sendMessage = message.split("[|]")[0];
//        String sendUserId = message.split("[|]")[1];
//        try {
//            if(sendUserId.equals("0"))
//                sendtoAll(sendMessage);
//            else
//                sendtoUser(sendMessage,sendUserId);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(WebSocketMessageModel message) throws IOException, EncodeException {
        this.session.getBasicRemote().sendText(message.toString());
//        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送信息给指定ID用户，如果用户不在线则返回不在线信息给自己
     * @param message
     * @param sendUserId
     * @throws IOException
     */
    public void sendtoUser(WebSocketMessageModel message,String sendUserId) throws IOException, EncodeException {
        if (webSocketSet.get(sendUserId) != null) {
            webSocketSet.get(sendUserId).sendMessage(message);
        }
//        else {
//            //如果用户不在线则返回不在线信息给自己
//            sendtoUser("当前用户不在线",id);
//        }
    }

    /**
     * 发送信息给所有人
     * @param message
     * @throws IOException
     */
    public void sendtoAll(WebSocketMessageModel message) throws IOException, EncodeException {
        for (String key : webSocketSet.keySet()) {
            try {
                webSocketSet.get(key).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}

