package edu.ufcg.sp2fy.model;

public class Pessoa {
	private String nome;
	private Musiteca musiteca;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musiteca == null) ? 0 : musiteca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (musiteca == null) {
			if (other.musiteca != null)
				return false;
		} else if (!musiteca.equals(other.musiteca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public Pessoa(String nome) {
		musiteca = new Musiteca();
		this.nome = nome;
	}
	
	/**
	 * Responsável por adicionar um album à coleção do usuário.
	 * @param album recebe o álbum a ser adicionado
	 * @return verdadeiro se a adição for executado com sucesso
	 */
	public boolean adicionaAlbum(Album album) {
		return musiteca.addAlbum(album);
	}
	
	/**
	 * Remove um {@link Album} específico da coleção do usuário.
	 * @param album
	 * @return verdadeiro se a remoção for executada com sucesso.
	 */
	public boolean removeAlbum(Album album){
		return musiteca.removeAlbum(album);
	}
	
	
}
