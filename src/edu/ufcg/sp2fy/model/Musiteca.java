package edu.ufcg.sp2fy.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Uma Musiteca guarda
 * um conjunto de {@link Album} ordenados e um mapa com Albuns favoritos.
 * Cada album favorito é linkado com uma String que representa o nome dessa
 * playlist e facilita a pesquisa nela.
 * @author Juan
 *
 */
public class Musiteca {
	private ArrayList<Album> conjunto;
	private HashMap<String, Album> favoritos;
	private HashMap<String, Playlist> playlists;
	
	public Musiteca() {
		conjunto = new ArrayList<Album>();
		favoritos = new HashMap<String, Album>();
		playlists = new HashMap<String, Playlist>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjunto == null) ? 0 : conjunto.hashCode());
		result = prime * result + ((favoritos == null) ? 0 : favoritos.hashCode());
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
		Musiteca other = (Musiteca) obj;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		if (favoritos == null) {
			if (other.favoritos != null)
				return false;
		} else if (!favoritos.equals(other.favoritos))
			return false;
		return true;
	}
	
	/**
	 * Adiciona um album à lista de albuns.
	 * @param album
	 * @return true se o album for adicionado e false caso contrário.
	 */
	public boolean addAlbum(Album album){
		if (album == null || conjunto.contains(album)){
			return false;
		}
		return conjunto.add(album);
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception, IndexOutOfBoundsException{
		Playlist playlist = playlists.get(nomePlaylist);
		if (playlist == null){
			playlist = new Playlist(nomePlaylist);
		}
		
		Album album = findAlbum(nomeAlbum);
		Musica musica = album.pesquisaFaixa(faixa);
		
		if (playlist.addMusica(musica)){
			playlists.put(nomePlaylist, playlist);
			return true;
		}
		
		return false;
	}

	/**
	 * Retorna o primeiro {@link Album} encontrado no conjunto com o título passado.
	 * @param nome representa o parametro a ser usado na comparação.
	 * @return album
	 * @throws Exception caso não encontrado
	 */
	public Album findAlbum(String nome) throws Exception{
		Iterator<Album> iterator = conjunto.iterator();
		
		while (iterator.hasNext()) {
			Album album = iterator.next();
			if (album.getTitulo().equalsIgnoreCase(nome)){
				return album;
			}
		}
		throw new Exception("Album nao pertence ao Perfil especificado");
	}
	
	/**
	 * Adiciona um album à lista de albuns favoritos.
	 * @param album
	 * @return true se o album for adicionado e false caso contrário.
	 */
	public boolean addAlbumFavorito(String chave, Album album){
		if (album == null  || chave == null || favoritos.containsKey(chave) || chave.equals("")){
			return false;
		}
		favoritos.put(chave, album);
		return favoritos.containsKey(chave);
	}
	
	/**
	 * Remove um album à lista de albuns.
	 * @param album
	 * @return true se o album for removido e false caso contrário.
	 */
	public boolean removeAlbum(Album album){
		if (album == null || !conjunto.contains(album)){
			return false;
		}
		return conjunto.remove(album);
	}

	/**
	 * Remove um album à lista de albuns favoritos.
	 * @param album
	 * @return true se o album for removido e false caso contrário.
	 */
	public boolean removeAlbumFavorito(String chave){
		if (chave == null || !favoritos.containsKey(chave)){
			return false;
		}
		favoritos.remove(chave);
		return !favoritos.containsKey(chave);
	}
	
	/**
	 * Certifica-se a existência de um objeto {@link Album} no conjunto de albuns.
	 * @param album 
	 * @return true se existir e false caso contrário.
	 */
	public boolean isInConjunto(Album album){
		if (album == null){
			return false;
		}
		
		Iterator<Album> iterator = conjunto.iterator();
		while (iterator.hasNext()) {
			Album correnteAlbum = iterator.next();
			if (correnteAlbum.equals(album)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Certifica-se a existência de um objeto {@link Album} no conjunto de albuns favoritos.
	 * @param album 
	 * @return true se existir e false caso contrário.
	 */
	public boolean isInConjuntoFavoritos(Album album){
		if (album == null){
			return false;
		}
		
		Iterator<String> iterator = favoritos.keySet().iterator();
		while (iterator.hasNext()) {
			String keyAlbum = iterator.next();
			if (favoritos.get(keyAlbum).equals(album)){
				return true;
			}
		}
		return false;
	}
	
	
}
