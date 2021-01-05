package com.aa.mp.services;

import com.aa.mp.dtos.TypeOfLeaveDto;
import com.aa.mp.model.TypeOfLeave;
import com.aa.mp.repositories.TypeOfLeaveJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOfLeaveServiceImpl implements TypeOfLeaveService {

    private final TypeOfLeaveJpaRepository repository;

    public TypeOfLeaveServiceImpl(TypeOfLeaveJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TypeOfLeaveDto> getAll() {
        List<TypeOfLeave> typeOfLeaves = repository.findAll();
        List<TypeOfLeaveDto> result = new ArrayList<>();
        for (TypeOfLeave typeOfLeave : typeOfLeaves) {
            TypeOfLeaveDto dto = new TypeOfLeaveDto();
            dto.setLeaveType(typeOfLeave.getLeaveType());
            result.add(dto);
        }
        return result;
    }
}
