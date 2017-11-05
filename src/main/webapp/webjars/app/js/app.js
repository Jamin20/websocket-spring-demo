var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/webSocket/webSocketEndPoint');
    stompClient = Stomp.over(socket);
    var headers={
        username:'admin',
        password:'admin'
    };
    stompClient.connect(headers, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/demo1/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).userId, JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/topic/demo1/twoWays', function (greeting) {
            showGreeting(JSON.parse(greeting.body).userId, JSON.parse(greeting.body).content);
        });
    });

}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/demo1/hello/10086", {}, JSON.stringify({'message': $("#message").val()}));
}

function showGreeting(userId, message) {
    $("#greetings").append("<tr><td> Hi, 这是来自 " + userId + " 的消息: " + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});

