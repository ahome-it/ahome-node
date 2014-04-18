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
package com.ait.toolkit.node.core.node;

import com.ait.toolkit.node.core.meta.GwtNodeFunction;
import com.ait.toolkit.node.core.meta.GwtNodeObject;
import com.ait.toolkit.node.core.meta.GwtNodeProperty;
import com.ait.toolkit.node.core.node.process.Process;
import com.ait.toolkit.node.core.node.stdio.Console;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js
 * <a href="http://nodejs.org/docs/v0.5.6/api/globals.html">global</a>
 * namespace.
 * 
 * 
 */
@GwtNodeObject("global")
public class Global extends JavaScriptObject {
    
    public static final native Global get() /*-{
        return global;
    }-*/;

    protected Global() {
    }
    
    @GwtNodeProperty
    public final Process process() {
        return Process.get();
    }

    @GwtNodeProperty
    public final Console console() {
        return Console.get();
    }
    
    @GwtNodeFunction
    public final native <T extends JavaScriptObject & NodeJsModule> T require(String name) /*-{
        return require(name);
    }-*/;
    
    @GwtNodeFunction("require.resolve")
    public final native String requireResolve(String name) /*-{
        return require.resolve(name);
    }-*/;
    
    @GwtNodeProperty("require.cache")
    public final native <T extends JavaScriptObject> T requireCache() /*-{
        return require.cache;
    }-*/;
    
    //TODO: add compat annotation
    public final native String filename() /*-{
        return __filename;
    }-*/;

    //TODO: add compat annotation
    public final native String dirname() /*-{
        return __dirname;
    }-*/;
    
    @GwtNodeProperty
    public final native <T extends JavaScriptObject & NodeJsModule> T module() /*-{
        return module;
    }-*/;
    
    @GwtNodeProperty
    public final native JavaScriptObject exports() /*-{
        return exports;
    }-*/;
}
