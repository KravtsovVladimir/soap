package com.soap.config;

import com.soap.Repository;
import com.soap.dto.GetUserByIDRequest;
import com.soap.dto.GetUserByIDResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String GET_USER_NAMESPACE = "http://com/soap";

    @Autowired
    private Repository repository;

    @PayloadRoot(localPart = "GetUserByIDRequest", namespace = GET_USER_NAMESPACE)
    @ResponsePayload
    public GetUserByIDResponse getUserById(@RequestPayload GetUserByIDRequest request) {
        GetUserByIDResponse response = new GetUserByIDResponse();
        response.setUser(repository.getById(request.getId()));
        return response;
    }
}
