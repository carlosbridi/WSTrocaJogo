package com.trocajogo.Jogo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;

@XmlRootElement(name = "Jogo")
public class JogoDTO extends JogoBase {
	
	public List<JogoPlataformaDTO> jogoPlataforma = new ArrayList<JogoPlataformaDTO>(); 
}
