var cmdList = {
    jvm: function () {
        sendCmd('jvm');
    },
    dashboard: function () {
        sendCmd('dashboard');
    },
    sysprop: function () {
        sendCmd('sysprop');
    },
    sysenv: function () {
        sendCmd('sysenv');
    },
    vmoption: function () {
        sendCmd('vmoption');
    },
    logger: function () {
        sendCmd('logger');
    },
    mbean: function () {
        sendCmd('mbean');
    },
    allThread: function () {
        sendCmd('thread');
    },
    top5BusyThread: function () {
        sendCmd('thread -n 5');
    },
    blockThread: function () {
        sendCmd('thread -b');
    },
    top5In10sThread: function () {
        sendCmd('thread -n 5 -i 10000');
    },
    waitingThread: function () {
        sendCmd('thread --state waiting');
    },
    runingThread: function () {
        sendCmd('thread --state runnable');
    },
};

function sendCmd(cmd) {
    ws.send(JSON.stringify({action: 'read', data: ''}));
    ws.send(JSON.stringify({action: 'read', data: cmd}));
    ws.send(JSON.stringify({action: 'read', data: '\n'}));
}


