package com.trocajogo.Jogo.TempJogoBusca;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;
import com.trocajogo.Usuario.UsuarioDTO;

@XmlRootElement(name = "TempJogoBusca")
public class TempJogoBuscaDTO {

    public UsuarioDTO usuario;
    public List<JogoPlataformaDTO> plataforma = new ArrayList<JogoPlataformaDTO>(); 
	 
}
