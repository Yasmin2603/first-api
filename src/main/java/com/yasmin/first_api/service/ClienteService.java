package com.yasmin.first_api.service;

import com.yasmin.first_api.domain.Cliente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Cliente> listarTodos()
    {
        return clientes;
    }

    public Cliente salvar(String nome, String email)
    {
        Cliente cliente =  new Cliente();

        cliente.setId(proximoId);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setDataCadastro(LocalDate.now());
        proximoId++;

        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscar(long id)
    {
        for(int i=0; i< clientes.size(); i++)
        {
            Cliente clienteExistente = clientes.get(i);

            if(id == clienteExistente.getId())
            {
                return clienteExistente;
            }
        }
        return null;
    }


    public String deletar(long id)
    {
        for(int i=0; i< clientes.size(); i++)
        {
            Cliente clienteExistente = clientes.get(i);

            if(id == clienteExistente.getId())
            {
                clientes.remove(i);
                return "Cliente " + id + " deletado!";
            }
        }
        return null;
    }

    public Cliente atualizar(long id, String nomeNovo, String emailNovo)
    {
        for(int i=0; i< clientes.size(); i++)
        {
            Cliente clienteExistente = clientes.get(i);

            if(id == clienteExistente.getId())
            {
                if (nomeNovo != null && !nomeNovo.trim().isEmpty()) {
                    clienteExistente.setNome(nomeNovo);
                }

                if (emailNovo != null && !emailNovo.trim().isEmpty()) {
                    clienteExistente.setEmail(emailNovo);
                }

                return clienteExistente;
            }
        }
        return null;
    }
}
