package com.akman.springbootdemo.rest_api.controller;

import com.akman.springbootdemo.model.User;
import com.akman.springbootdemo.service.userservice.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Api(tags = {"User"})
@SwaggerDefinition(tags = {
        @Tag(name = "User", description = "User controller")
})
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Test save")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/test-save", method = RequestMethod.GET)
    public ResponseEntity<User> testSave() {
        return ResponseEntity.ok(userService.saveUser());
    }

    @ApiOperation(value = "Test list")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/test-list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> testList() {
        return ResponseEntity.ok(userService.listUsers());
    }
}