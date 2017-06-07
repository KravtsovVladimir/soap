package com.soap.config;

import com.soap.Repository;
import com.soap.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE = "http://com/soap";

    @Autowired
    private Repository repository;

    @PayloadRoot(localPart = "GetUserByIDRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetUserByIDResponse getUserById(@RequestPayload GetUserByIDRequest request) {
        GetUserByIDResponse response = new GetUserByIDResponse();
        response.setUser(repository.getById(request.getId()));
        return response;
    }

    @PayloadRoot(localPart = "RemoveUserByIDRequest", namespace = NAMESPACE)
    @ResponsePayload
    public RemoveUserByIDResponse removeUserById(@RequestPayload RemoveUserByIDRequest request) {
        RemoveUserByIDResponse response = new RemoveUserByIDResponse();
        response.setIsRemoved(repository.remove(request.getId()));
        return response;
    }

    @PayloadRoot(localPart = "SaveUserRequest", namespace = NAMESPACE)
    @ResponsePayload
    public SaveUserResponse saveUser(@RequestPayload SaveUserRequest request) {
        SaveUserResponse response = new SaveUserResponse();
        response.setIsCreated(repository.save(request.getUser()));
        return response;
    }

    @PayloadRoot(localPart = "GetAllUsersRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        response.setUser(repository.getAll());
        return response;
    }
}
