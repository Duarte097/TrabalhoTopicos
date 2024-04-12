package br.edu.utfpr.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.todoapi.dto.GatewayDTO;
import br.edu.utfpr.todoapi.exception.NotFoundException;
import br.edu.utfpr.todoapi.model.Gateway;
import br.edu.utfpr.todoapi.repository.GatewayRepository;

@Service
public class GatewayService {
    @Autowired
    private GatewayRepository gatewayRepository;

    /**
     * Inserir uma pessoa no DB.
     * @return
     */
    public Gateway create(GatewayDTO dto) {
        var gateway = new Gateway();
        BeanUtils.copyProperties(dto, gateway);

        // Persistir no Banco de dados
        return gatewayRepository.save(gateway);
    }

    /**
     * Buscar no banco de dados todas.
     * @return
     */
    public List<Gateway> getAll() {
        return gatewayRepository.findAll();
    }

    /**
     * Buscar uma pessoa pelo ID.
     * @param id
     * @return
     */
    public Optional<Gateway> getById(long id) {
        return gatewayRepository.findById(id);
    }


    public Gateway update(long id, GatewayDTO dto) throws NotFoundException {
        var res = gatewayRepository.findById(id);

        if(res.isEmpty()) {
            throw new NotFoundException("Gateway " + id + " não existe.");
        }

        var gateway = res.get();
        gateway.setNome(dto.nome());
        gateway.setDescricao(dto.descricao());
        gateway.setEndereco(dto.endereco());

        return gatewayRepository.save(gateway);
    }

    public void delete(long id) throws NotFoundException {
        var res = gatewayRepository.findById(id);

        if(res.isEmpty()) {
            throw new NotFoundException("Gateway " + id + " não existe.");
        }

        gatewayRepository.delete(res.get());
    }

}
