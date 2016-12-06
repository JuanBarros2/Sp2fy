package edu.ufcg.sp2fy.model;

import java.util.ArrayList;

public class Album {
	
	private String artista;
	private String titulo;
	private int ano;
	private ArrayList<Musica> musicas;
	
	public Album(String artista, String titulo, int ano) throws Exception{
		if (artista == null || artista.equals("")){
			throw new Exception("Esse artista não é válido");
		} else if (titulo == null || titulo.equals("")){
			throw new Exception("Esse título não é válido");
		} else if (ano <= 1800){
			throw new Exception("Ano de lançamento inválido");
		}
		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;
		this.musicas = new ArrayList<Musica>();
	}
	
	
	
}
