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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (other.artista != null && artista.equals(other.artista))
			if (other.titulo != null && titulo.equals(other.titulo))
				return true;
		return false;
	}


	public boolean addMusica(Musica musica){
		return musicas.add(musica);
	}
	
	public int getDuracao(){
		int total = 0;
		for(Musica musica : musicas){
			total += musica.getDuracao();
		}
		return total;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
	
	
}
