package com.andredupont.usersApp.controllers;

import com.andredupont.usersApp.entities.Role;
import com.andredupont.usersApp.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles(){
        return new ResponseEntity<List<Role>>(roleService.getRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable("roleId") Long roleId, @RequestBody Role role){
        return new ResponseEntity<Role>(roleService.updateRole(roleId, role), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable(name = "roleId") Long roleId){
        roleService.deleteRole(roleId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
