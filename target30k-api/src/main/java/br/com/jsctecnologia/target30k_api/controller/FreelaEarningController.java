package br.com.jsctecnologia.target30k_api.controller;

import br.com.jsctecnologia.target30k_api.dto.EarningRequestDTO;
import br.com.jsctecnologia.target30k_api.dto.EarningResponseDTO;
import br.com.jsctecnologia.target30k_api.service.EarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/earnings")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class FreelaEarningController {

    @Autowired
    private EarningService service;

    @GetMapping
    public List<EarningResponseDTO> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    public EarningResponseDTO salvar(@RequestBody EarningRequestDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EarningResponseDTO>> getByMonth(
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(service.getEarningsByMonth(month, year));
    }
}