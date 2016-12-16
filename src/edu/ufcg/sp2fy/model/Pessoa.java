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
	 * @see {@link Musiteca#adicionaPlaylist(String, String, int)}
	 */
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa)
			throws Exception, IndexOutOfBoundsException {
		return musiteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}

	/**
	 * @see {@link Musiteca#isInConjunto(Album)}
	 */
	public boolean isInConjunto(Album album) {
		return musiteca.isInConjunto(album);
	}

	/**
	 * @see {@link Musiteca#getPlaylist(String)}
	 */
	public Playlist getPlaylist(String chave) {
		return musiteca.getPlaylist(chave);
	}

	/**
	 * @see {@link Musiteca#isInListFavoritos(Album)}
	 */
	public boolean isInListFavoritos(Album album) {
		return musiteca.isInListFavoritos(album);
	}


	/**
	 *@see {@link Musiteca#addAlbumFavorito(String, Album)}
	 */
	public boolean adicionaAlbumFavorito(Album album){
		return musiteca.addAlbumFavorito(album);
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
	public boolean removeAlbumFavorito(Album album) {
		return musiteca.removeAlbumFavorito(album);
	}

	/**
	 * @see {@link Musiteca#isInConjunto(Album)}
	 */
	public boolean isInList(Album album) {
		return musiteca.isInConjunto(album);
	}

	/**
	 * @see {@link Musiteca#isInListFavoritos(Album)}
	 */
	public boolean isInConjuntoFavoritos(Album album) {
		return musiteca.isInListFavoritos(album);
	}
	
	/**
	 * @see {@link Musiteca#findAlbumFavorito(String)}
	 */
	public Album findAlbumFavorito(String nome) throws Exception {
		return musiteca.findAlbumFavorito(nome);
	}

	/**
	 * @see {@link Musiteca#sortedAlbuns()}
	 */
	public void sortedAlbuns() {
		musiteca.sortedAlbuns();
	}

	/**
	 * @see {@link Musiteca#sortedAlbunsFavoritos()}
	 */
	public void sortedAlbunsFavoritos() {
		musiteca.sortedAlbunsFavoritos();
	}
	
}
