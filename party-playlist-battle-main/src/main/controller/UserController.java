package com.party.playlist.battle.controller;












import com.fasterxml.jackson.core.JsonProcessingException;
import com.party.playlist.battle.domain.User;
import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.http.ResponseHandler;
import com.party.playlist.battle.service.UserService;
import com.party.playlist.battle.util.Constants;
















public class UserController {
    private final RequestContext context;
    private UserService userService;

    public UserController(RequestContext context) {
        this.context = context;
        this.userService = new UserService();
    }

    public String mapHttpMethods() throws JsonProcessingException {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().endsWith("/users/auth")) {
                final User authenticate = userService.authenticate(context.getRequestBody());
                return ResponseHandler.response("User "+authenticate.getUsername()+"  Login Successfully",
                        "200", "Success");
            }
            if(context.getPath().endsWith("/users")){
                final User user = userService.registerUser(context.getRequestBody());
                return ResponseHandler.response("User created with  with username " + user.getUsername(),
                        "201", "Created");
            }

        }
        return ResponseHandler.response("Resource not found",
                "404", "NotFound");
    }


}
