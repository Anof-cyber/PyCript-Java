package com.pycript;

import java.util.Optional;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.core.ByteArray;
import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.http.message.params.HttpParameter;
import burp.api.montoya.http.message.params.ParsedHttpParameter;
import burp.api.montoya.ui.Selection;
import burp.api.montoya.ui.editor.RawEditor;
import burp.api.montoya.ui.editor.extension.EditorCreationContext;
import burp.api.montoya.ui.editor.extension.ExtensionProvidedHttpRequestEditor;
import burp.api.montoya.utilities.Base64EncodingOptions;
import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.ui.Selection;
import java.awt.Component;

class RequestHttpRequestEditor implements ExtensionProvidedHttpRequestEditor {

    private final MontoyaApi api;
    private final RawEditor requestEditor;
    private HttpRequestResponse requestResponse;


    RequestHttpRequestEditor (MontoyaApi api, EditorCreationContext creationContext) {
        this.api = api;
        requestEditor = api.userInterface().createRawEditor();
    }

    @Override
    public HttpRequest getRequest()
    {
        
        HttpRequest request;
        request = requestResponse.request();
        return request;
    }

    @Override
    public void setRequestResponse(HttpRequestResponse requestResponse)
    {
        this.requestResponse = requestResponse;

    }

    @Override
    public boolean isEnabledFor(HttpRequestResponse requestResponse)
    {
        

        return true;
    }

    @Override
    public String caption()
    {
        return "PyCript";
    }

    @Override
    public Component uiComponent()
    {
        return requestEditor.uiComponent();
    }

    @Override
    public Selection selectedData()
    {
        return requestEditor.selection().isPresent() ? requestEditor.selection().get() : null;
    }

    @Override
    public boolean isModified()
    {
        return requestEditor.isModified();
    }

    
}
