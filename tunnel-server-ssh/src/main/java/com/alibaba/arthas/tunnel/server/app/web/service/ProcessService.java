package com.alibaba.arthas.tunnel.server.app.web.service;

import com.alibaba.arthas.tunnel.server.app.web.response.dto.request.PidRequest;
import com.alibaba.arthas.tunnel.server.app.web.response.dto.response.ProcessPageResponse;
import com.alibaba.arthas.tunnel.server.app.web.response.dto.response.ProcessResponse;
import com.alibaba.arthas.tunnel.server.ssh.AttachRemote;
import com.alibaba.arthas.tunnel.server.utils.InetAddressUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    private static final String ArthasJarRoot = "/root/project/3.5.0/arthas";

    public ProcessPageResponse getProcessList(String ip) {
        String cmd = "source /etc/profile;jps -l";
        List<String> list = AttachRemote.execute(ip, cmd);
        ProcessPageResponse response = new ProcessPageResponse();
        response.setTotal(list.size());
        response.setItems(Lists.newArrayList());
        for (int i = 0; i < list.size(); i++) {
            ProcessResponse item = new ProcessResponse();
            item.setId(i + 1);
            String[] str = list.get(i).split(" ");
            item.setPid(Integer.parseInt(str[0]));
            item.setName(str[1]);
            response.getItems().add(item);
        }
        return response;
    }

    public void attach(PidRequest request) {
        String cmd = String.format("source /etc/profile; java -jar  %s/arthas-client.jar -c stop", ArthasJarRoot);
        List<String> result = AttachRemote.execute(request.getIp(), cmd);
        System.out.println(result);
        String localIp = InetAddressUtil.getInetAddress();
        cmd = String.format("source /etc/profile; java -jar %s %s --tunnel-server ws://%s:7777/ws --agent-id '%s' --session-timeout 300 --attach-only",
                ArthasJarRoot + "/arthas-boot.jar", request.getPid(), localIp, localIp);
        result = AttachRemote.execute(request.getIp(), cmd);
        System.out.println(result);
    }
}