package edu.ufcg.sp2fy.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Uma Musiteca guarda
 * um conjunto de {@link Album} ordenados e um mapa com Albuns favoritos.
 * Cada album favorito é linkado com uma String que representa o nome dessa
 * playlist e facilita a pesquisa nela.
 * @author Juan
 *
 */
public class Musiteca {
	private ArrayList<Album> listaAlbuns;
	private ArrayList<Album> favoritos;
	private HashMap<String, Playlist> playlists;
	
	public Musiteca() {
		listaAlbuns = new ArrayList<Album>();
		favoritos = new ArrayList<Album>();
		playlists = new HashMap<String, Playlist>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaAlbuns == null) ? 0 : listaAlbuns.hashCode());
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
		if (listaAlbuns == null) {
			if (other.listaAlbuns != null)
				return false;
		} else if (!listaAlbuns.equals(other.listaAlbuns))
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
		if (album == null || listaAlbuns.contains(album)){
			return false;
		}
		return listaAlbuns.add(album);
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
		Iterator<Album> iterator = listaAlbuns.iterator();
		
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
	public boolean addAlbumFavorito(Album album){
		if (album == null){
			return false;
		}
		return favoritos.add(album);
	}
	
	/**
	 * Remove um album à lista de albuns.
	 * @param album
	 * @return true se o album for removido e false caso contrário.
	 */
	public boolean removeAlbum(Album album){
		if (album == null || !listaAlbuns.contains(album)){
			return false;
		}
		return listaAlbuns.remove(album);
	}

	/**
	 * Remove um album à lista de albuns favoritos.
	 * @param album
	 * @return true se o album for removido e false caso contrário.
	 */
	public boolean removeAlbumFavorito(Album album){
		if (album == null || !favoritos.contains(album)){
			return false;
		}
		return favoritos.remove(album);
	}
	
	/**
	 * Certifica-se a existência de um objeto {@link Album} no conjunto de albuns.
	 * @param album 
	 * @return true se existir e false caso contrário.
	 */
	public boolean isInList(Album album){
		if (album == null){
			return false;
		}
		
		Iterator<Album> iterator = listaAlbuns.iterator();
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
	public boolean isInListFavoritos(Album album){
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
	
	/**
	 * Responsável por ordenar e imprimir os albuns.
	 */
	public void sortedAlbuns(){
		Collections.sort(listaAlbuns);
		sysoAlbum(listaAlbuns);
	}
	
	/**
	 * Responsável por ordenar e imprimir os albuns favoritos.
	 */
	public void sortedAlbunsFavoritos(){
		Set conjunto = favoritos.entrySet();
		Iterator<Album> iterator = conjunto.iterator();
		
		ArrayList<Album> aux = new ArrayList<Album>();
		while (iterator.hasNext()) {
			Album album = (Album) iterator.next();
			aux.add(album);
		}
		Collections.sort(aux);
		
		sysoAlbum(aux);
	}
	
	/**
	 * Método responsável por imprimir a lista de albuns.
	 * @param albuns
	 */
	private void sysoAlbum(ArrayList<Album> albuns){
		for (Iterator iterator = albuns.iterator(); iterator.hasNext();) {
			Album album = (Album) iterator.next();
			System.out.println(album + "\n\n\n");
		}
	}
	
}
