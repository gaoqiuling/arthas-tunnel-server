package com.alibaba.arthas.tunnel.server.ssh;

import com.google.common.collect.Lists;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AttachRemote {
    private final static String userName = "root";

    public static List<String> execute(String ip, String cmd) {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());

        Session session = null;
        try {
            ssh.connect(ip);
            ssh.authPublickey(userName);
            session = ssh.startSession();
            final Command command = session.exec(cmd);
            String out = IOUtils.readFully(command.getInputStream()).toString();
            return Arrays.asList(out.split("\n"));
        } catch (Exception e) {
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (IOException e) {
                // Do Nothing
            }
        }
        try {
            ssh.disconnect();
        } catch (Exception e) {

        }
        return Lists.newArrayList();
    }
}
