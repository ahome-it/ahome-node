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
package com.ait.toolkit.node.core.node.dgram;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js address object
 * 
 * 
 */
public class Address extends JavaScriptObject {

    protected Address() {
    }
    
    public final native String getAddress() /*-{
        return this.address;
    }-*/;
    
    public final native Integer getPort() /*-{
        return this.port;
    }-*/;
}
