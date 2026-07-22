package com.yasmin.first_api.service;

import com.yasmin.first_api.domain.user.Cliente;
import com.yasmin.first_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos()
    {
        return clienteRepository.findAll();
    }

    public Cliente salvar(String name, String email)
    {
        Cliente cliente =  new Cliente();

        cliente.setName(name);
        cliente.setEmail(email);
        cliente.setCreatedAt(LocalDateTime.now());

        return clienteRepository.save(cliente);
    }

    public Cliente buscar(String id)
    {
        return clienteRepository.findById(id).orElse(null);
    }


    public String deletar(String id)
    {
        if (clienteRepository.existsById(id))
        {
            clienteRepository.deleteById(id);
            return "Cliente " + id + " deletado!";
        }
        else
        {
            return null;
        }

    }

    public Cliente atualizar(String id, String nomeNovo, String emailNovo)
    {
            Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

            if(clienteExistente != null)
            {
                if (nomeNovo != null && !nomeNovo.trim().isEmpty()) {
                    clienteExistente.setName(nomeNovo);
                }

                if (emailNovo != null && !emailNovo.trim().isEmpty()) {
                    clienteExistente.setEmail(emailNovo);
                }

                return clienteRepository.save(clienteExistente);
            }

        return null;
    }
}
