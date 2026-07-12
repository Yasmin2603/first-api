package com.yasmin.first_api.controller;
import org.springframework.http.ResponseEntity;

import com.yasmin.first_api.domain.Cliente;
import com.yasmin.first_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping()
    public List listarTodos()
    {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Long id)
    {
        Cliente buscarCliente =  clienteService.buscar(id);
        if (buscarCliente != null)
        {
            return ResponseEntity.ok(buscarCliente);
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente dados)
    {
        if (dados.getNome() != null && !dados.getNome().trim().isEmpty() && dados.getEmail() != null && !dados.getEmail().trim().isEmpty()) {
            return ResponseEntity.ok(clienteService.salvar(dados.getNome(), dados.getEmail()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") long id, @RequestBody Cliente dados)
    {
        Cliente clienteAtualizado = clienteService.atualizar(id, dados.getNome(), dados.getEmail());
        if (clienteAtualizado != null)
        {
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") long id)
    {
        String clienteDeletado = clienteService.deletar(id);
        if(clienteDeletado != null)
        {
            return ResponseEntity.ok(clienteDeletado);
        }

        return ResponseEntity.notFound().build();

    }

}
