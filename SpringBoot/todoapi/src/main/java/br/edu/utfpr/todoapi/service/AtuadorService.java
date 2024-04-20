package br.edu.utfpr.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.todoapi.dto.AtuadorDTO;
import br.edu.utfpr.todoapi.exception.NotFoundException;
import br.edu.utfpr.todoapi.model.Atuador;
import br.edu.utfpr.todoapi.repository.AtuadorRepository;

@Service
public class AtuadorService {
    @Autowired
    private AtuadorRepository atuadorRepository;

    /**
     * Inserir uma Dispositivo no DB.
     * @return
     */
    public Atuador create(AtuadorDTO dto) {
        var atuador = new Atuador();
        BeanUtils.copyProperties(dto, atuador);

        // Persistir no Banco de dados
        return atuadorRepository.save(atuador);
    }

    /**
     * Buscar no banco de dados todas.
     * @return
     */
    public List<Atuador> getAll() {
        return atuadorRepository.findAll();
    }

    /**
     * Buscar uma pessoa pelo ID.
     * @param id
     * @return
     */
    public Optional<Atuador> getById(long id) {
        return atuadorRepository.findById(id);
    }


    public Atuador update(long id, AtuadorDTO dto) throws NotFoundException {
        var res = atuadorRepository.findById(id);

        if(res.isEmpty()) {
            throw new NotFoundException("Atuador " + id + " não existe.");
        }

        var atuador = res.get();
        atuador.setNome(dto.nome());
        //atuador.setDescricao(dto.descricao());

        return atuadorRepository.save(atuador);
    }

    public void delete(long id) throws NotFoundException {
        var res = atuadorRepository.findById(id);

        if(res.isEmpty()) {
            throw new NotFoundException("Atuador " + id + " não existe.");
        }

        atuadorRepository.delete(res.get());
    }

}
