package com.yasmin.first_api.controller;
import com.yasmin.first_api.domain.user.Cliente;
import com.yasmin.first_api.dto.CreateCliente;
import com.yasmin.first_api.dto.UpdateCliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

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
    public List<Cliente> listarTodos()
    {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar
            (@PathVariable("id") String id)
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
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid CreateCliente dados)
    {
        Cliente novoCliente = clienteService.salvar(dados.name(), dados.email());
        return ResponseEntity.ok(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") String id, @RequestBody @Valid UpdateCliente dados)
    {
        Cliente clienteAtualizado = clienteService.atualizar(id, dados.name(), dados.email());

        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") String id)
    {
        String clienteDeletado = clienteService.deletar(id);
        if(clienteDeletado != null)
        {
            return ResponseEntity.ok(clienteDeletado);
        }

        return ResponseEntity.notFound().build();

    }

}
