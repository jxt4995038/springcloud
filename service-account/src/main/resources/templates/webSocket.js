var lockReconnect = false;//避免重复连接

function createWebSocket(wsUrl){
    try {
        ws = new WebSocket(wsUrl);
        websocketInit();
    } catch (e) {
        console.log('catch');
        websocketReconnect(wsUrl);
    }
}

function websocketInit () {
    // 建立 web socket 连接成功触发事件
    ws.onopen = function (evt) {
        onOpen(evt);
    };
    // 断开 web socket 连接成功触发事件
    ws.onclose = function (evt) {
        onClose(evt);
        websocketReconnect(wsUrl);

    };
    // 接收服务端数据时触发事件
    ws.onmessage = function (evt) {
        onMessage(evt);
    };
    // 通信发生错误时触发
    ws.onerror = function (evt) {
        websocketReconnect(wsUrl);
        onError(evt);
    };
};

function onOpen(evt) {
    console.log("建立链接");
    // var sendData = { test: 'test' };        // 正常的请求数据
    // sendData = JSON.stringify(sendData);
    // ws.send(sendData);
    //心跳检测重置
    heartCheck.start();
}

function onClose(evt) {
    console.log("连接已关闭...");
}

function onMessage(evt) {
    // console.log('接收消息: ' + evt.data);
    var data = JSON.parse(evt.data);
    handleMsg(data);
    //拿到任何消息都说明当前连接是正常的
    heartCheck.start();
}

function websocketReconnect(url) {
    if (lockReconnect) {       // 是否已经执行重连
        return;
    };
    lockReconnect = true;
    //没连接上会一直重连，设置延迟避免请求过多
    tt && clearTimeout(tt);
    var tt = setTimeout(function () {
        createWebSocket(url);
        lockReconnect = false;
    }, 5000);
}

//心跳检测
var heartCheck = {
    timeout: 30000,
    timeoutObj: null,
    serverTimeoutObj: null,
    start: function () {
        // console.log('start');
        var self = this;
        this.timeoutObj && clearTimeout(this.timeoutObj);
        this.serverTimeoutObj && clearTimeout(this.serverTimeoutObj);
        this.timeoutObj = setTimeout(function () {
            //发送测试信息，后端收到后，返回一个消息，
            ws.send("1");
            self.serverTimeoutObj = setTimeout(function () {
                ws.close();
            }, self.timeout);
        }, this.timeout)
    }
}

function onError(evt) {
    console.log('通信错误：' + evt.data);
}
