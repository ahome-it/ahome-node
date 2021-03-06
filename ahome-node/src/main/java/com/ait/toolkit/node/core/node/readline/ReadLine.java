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
package com.ait.toolkit.node.core.node.readline;

import com.ait.toolkit.node.core.JavaScriptFunction;
import com.ait.toolkit.node.core.JavaScriptReturningFunction;
import com.ait.toolkit.node.core.node.Global;
import com.ait.toolkit.node.core.node.NodeJsModule;
import com.ait.toolkit.node.core.node.event.EventEmitter;
import com.ait.toolkit.node.core.node.event.ParameterlessEventHandler;
import com.ait.toolkit.node.core.node.event.StringEventHandler;
import com.ait.toolkit.node.core.node.stream.ReadableStream;
import com.ait.toolkit.node.core.node.stream.WritableStream;
import com.google.gwt.core.client.JsArrayString;

/**
 * The node.js <a href="http://nodejs.org/docs/v0.5.6/api/readline.html">readline</a> module.
 */

public class ReadLine extends EventEmitter implements NodeJsModule {

	private static ReadLine instance;

	public static ReadLine get() {
		if (instance == null) {
			instance = Global.get().require("readline");
		}
		return instance;
	}

	protected ReadLine() {
	}

	public final void onLine(StringEventHandler handler) {
		on("line", handler);
	}

	public final void onClose(ParameterlessEventHandler handler) {
		on("close", handler);
	}

	public final native Interface createInterface(ReadableStream input, WritableStream output) /*-{
		return this.createInterface(input, output);
	}-*/;

	public final Interface createInterface(ReadableStream input, WritableStream output, Completer completer) {
		return createInterface(input, output, completer.getNativeFunction());
	}

	public final native Interface createInterface(ReadableStream input, WritableStream output, JavaScriptReturningFunction<JsArrayString> completer) /*-{
		return this.createInterface(input, output, completer);
	}-*/;

	public final void question(String query, QuestionCallback callback) {
		question(query, callback.getNativeFunction());
	}

	public final native void question(String query, JavaScriptFunction callback) /*-{
		this.question(query, callback);
	}-*/;

	public final native void close() /*-{
		this.close();
	}-*/;

	public final native void pause() /*-{
		this.pause();
	}-*/;

	public final native void resume() /*-{
		this.resume();
	}-*/;

	// TODO: write()

}
