package com.nvi.identity.service.external.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;


public class SOAPConnector extends WebServiceGatewaySupport {

    @Value("${nvi.identity-verification.soapAction}")
    private String soapAction;

    @Value("${nvi.identity-verification.url}")
    private String url;

    public Object callWebService(Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(url,
                                                             request,
                                                             webServiceMessage -> ((SoapMessage) webServiceMessage).setSoapAction(
                                                                     soapAction));
    }
}
