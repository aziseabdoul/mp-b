package com.aa.mp.controllers;

import com.aa.mp.dtos.TypeOfLeaveDto;
import com.aa.mp.services.TypeOfLeaveService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/leaves")
public class TypeOfLeaveController {

    private final TypeOfLeaveService service;

    public TypeOfLeaveController(TypeOfLeaveService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeOfLeaveDto> getAll() {
        return service.getAll();
    }
}
