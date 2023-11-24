package com.example.demo.api;

import com.example.demo.business.CadeauService;
import com.example.demo.dao.Cadeau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CadeauController {

    @Autowired
    CadeauService cadeauService;

    @GetMapping("cadeaux")
    public List<CadeauDTO> getAll(){
        List<Cadeau> entities = cadeauService.getCadeaux();
        List<CadeauDTO> dtos = new ArrayList<>();
        for(Cadeau entity : entities)
            dtos.add(CadeauMapper.convertFromEntityToDto(entity));

        return dtos;
    }

    @PostMapping("cadeaux")
    @ResponseStatus( HttpStatus.CREATED )
    public void addCadeau(@RequestBody CadeauPostDTO dto){
        Cadeau entity = CadeauMapper.convertFromDtoToEntity(dto);
        cadeauService.addCadeau(entity);
    }

    @GetMapping("cadeaux/{id}")
    public ResponseEntity<CadeauDTO> getOne(@PathVariable("id") Integer id){
        Optional<Cadeau> optional = cadeauService.getCadeauById(id);
        if(optional.isPresent()){
            Cadeau cadeau = optional.get();
            CadeauDTO dto = CadeauMapper.convertFromEntityToDto(cadeau);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("cadeaux/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        Optional<Cadeau> optional = cadeauService.getCadeauById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            cadeauService.deleteCadeau(id);
            return ResponseEntity.ok().build();
        }
    }
}
