/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.node.dev.debug;

import java.util.Arrays;
import java.util.List;

import com.ait.toolkit.node.core.GwtNodeBootstrap;
import com.ait.toolkit.node.core.node.fs.Fs;
import com.ait.toolkit.node.core.node.process.Process;
import com.ait.toolkit.node.core.node.util.Util;
import com.ait.toolkit.node.dev.debug.DebugLog.Level;

/**
 * An OOPHM debugger
 * 
 * 
 */
public class DebugMain extends GwtNodeBootstrap {

    private static String getArg(List<String> argList, String argName) {
        int index = argList.indexOf(argName);
        if (index != -1 && index < argList.size() - 1) {
            return argList.get(index + 1);
        }
        return null;
    }
    
    private HostChannel channel;
    
    @Override
    public Integer main(String... args) {
        //grab params
        List<String> argList = Arrays.asList(args);
        int port;
        try {
            port = Integer.parseInt(getArg(argList, "-port"));
        } catch (Exception e) {
            Util.get().log("Unable to obtain integer-based -port parameter");
            return 1;
        }
        String host = getArg(argList, "-host");
        if (host == null) {
            host = "127.0.0.1";
        }
        String module = getArg(argList, "-module");
        if (module == null) {
            Util.get().log("Unable to obtain module name");
            return 1;
        }
        String logFile = getArg(argList, "-logFile");
        String logLevel = getArg(argList, "-logLevel");
        //create log
        DebugLog log = new DebugLog(
                logFile == null ? Process.get().stdout() : Fs.get().createWriteStream(logFile),
                logLevel == null ? Level.INFO : Level.valueOf(logLevel));
        //create the channel
        channel = new HostChannel(module, host, port);
        //create session handler
        SessionHandler session = new SessionHandler(channel, log);
        //start the channel
        channel.start(session);
        return null;
    }
}
