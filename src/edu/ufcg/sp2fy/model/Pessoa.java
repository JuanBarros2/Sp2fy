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
	
	@Override
	public String toString() {
		return "Nome = " + nome;
	}

	/**
	 *@see {@link Musiteca#addAlbum(Album)}
	 */
	public boolean adicionaAlbum(Album album) {
		return musiteca.addAlbum(album);
	}
	
	/**
	 * @see {@link Musiteca#removeAlbum(Album)}
	 */
	public boolean removeAlbum(Album album){
		return musiteca.removeAlbum(album);
	}
	
	/**
	 *@see {@link Musiteca#addAlbumFavorito(String, Album)}
	 */
	public boolean adicionaAlbumFavorito(String nomeAlbum, Album album){
		return musiteca.addAlbumFavorito(nomeAlbum, album);
	}
	

	/**
	 *@see {@link Musiteca#findAlbum(String)}
	 */
	public Album findAlbum(String nome) throws Exception {
		return musiteca.findAlbum(nome);
	}

	/**
	 * @see {@link Musiteca#removeAlbumFavorito(String)}
	 */
	public boolean removeAlbumFavorito(String chave) {
		return musiteca.removeAlbumFavorito(chave);
	}

	/**
	 * @see {@link Musiteca#isInList(Album)}
	 */
	public boolean isInList(Album album) {
		return musiteca.isInList(album);
	}

	/**
	 * @see {@link Musiteca#isInListFavoritos(Album)}
	 */
	public boolean isInConjuntoFavoritos(Album album) {
		return musiteca.isInListFavoritos(album);
	}
	
	
	
}
