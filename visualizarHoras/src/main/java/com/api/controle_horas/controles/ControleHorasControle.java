package com.api.controle_horas.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controle_horas.modelos.dto.ControleHorasDto;
import com.api.controle_horas.modelos.dto.RegistrosHorasDto;
import com.api.controle_horas.servicos.BuscadorControleHoras;

@RestController
@RequestMapping("/registros")
@CrossOrigin(origins = "*")
public class ControleHorasControle {
  
  @Autowired
  BuscadorControleHoras buscador;

  @GetMapping("/tarefa/{tarefa_id}")
  public RegistrosHorasDto buscarPorTarefa(@PathVariable Long tarefa_id){
    return buscador.buscarPorTarefa(tarefa_id);
  }
  
  @GetMapping("/{id}")
  public ControleHorasDto buscarPorId(@PathVariable Long id){
    return buscador.buscarPorId(id);
  }

  @GetMapping
  public List<ControleHorasDto> buscarTodos(){
    return buscador.buscarTodos();
  }

  // Endpoints de escrita removidos para serviço somente leitura (visualizar)
}
