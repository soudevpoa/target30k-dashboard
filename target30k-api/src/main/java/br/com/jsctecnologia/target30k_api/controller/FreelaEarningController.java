package br.com.jsctecnologia.target30k_api.controller;

import br.com.jsctecnologia.target30k_api.model.FreelaEarning;
import br.com.jsctecnologia.target30k_api.repository.FreelaEarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/earnings")
@CrossOrigin(origins = "*") // Isso aqui é vital para o React conseguir acessar a API depois
public class FreelaEarningController {

    @Autowired
    private FreelaEarningRepository repository;

    @GetMapping
    public List<FreelaEarning> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public FreelaEarning create(@RequestBody FreelaEarning earning) {
        return repository.save(earning);
    }
}