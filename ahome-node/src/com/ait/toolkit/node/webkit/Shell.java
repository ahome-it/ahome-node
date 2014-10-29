package com.ait.toolkit.node.webkit;

import com.google.gwt.core.client.JavaScriptObject;

public class Shell extends JavaScriptObject {

	protected Shell() {

	}

	public final native void openExternal(String value)/*-{
		this.openExternal(value);
	}-*/;

	public final native void openItem(String value)/*-{
		this.openItem(value);
	}-*/;

	public native void showItemInFolder(String value)/*-{
		this.showItemInFolder(value);
	}-*/;

}
