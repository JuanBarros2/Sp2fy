package edu.ufcg.sp2fy.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
	private HashSet<Album> conjuntoAlbuns;
	private HashSet<Album> favoritos;
	private HashMap<String, Playlist> playlists;
	
	public Musiteca() {
		conjuntoAlbuns = new HashSet<Album>();
		favoritos = new HashSet<Album>();
		playlists = new HashMap<String, Playlist>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjuntoAlbuns == null) ? 0 : conjuntoAlbuns.hashCode());
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
		if (conjuntoAlbuns == null) {
			if (other.conjuntoAlbuns != null)
				return false;
		} else if (!conjuntoAlbuns.equals(other.conjuntoAlbuns))
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
		if (album == null){
			return false;
		}
		return conjuntoAlbuns.add(album);
	}
	
	/**
	 * Responsável por adicionar uma música a uma playlist. 
	 * É recebido o nome da playlist, o nome do album e o número da faixa. Com o nome, é verificado se já existe um,
	 * senão existir, é criado. É pesquisado o primeiro album com o respectivo nome e então é selecionado a faixa.
	 * @param nomePlaylist
	 * @param nomeAlbum
	 * @param faixa
	 * @return true se foi adicionada com sucesso.
	 * @throws Exception
	 * @throws IndexOutOfBoundsException
	 */
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
		if (album == null || !conjuntoAlbuns.contains(album)){
			return false;
		}
		return conjuntoAlbuns.remove(album);
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
	 * Retorna o primeiro {@link Album} encontrado no conjunto com o título passado.
	 * @param nome representa o parametro a ser usado na comparação.
	 * @return album
	 * @throws Exception caso não encontrado
	 */
	public Album findAlbum(String nome) throws Exception{
		Iterator<Album> iterator = conjuntoAlbuns.iterator();
		
		while (iterator.hasNext()) {
			Album album = iterator.next();
			if (album.equalsTitulo(nome)){
				return album;
			}
		}
		throw new Exception("Album nao pertence ao Perfil especificado");
	}
	
	/**
	 * Retorna o {@link Album} favorito encontrado no conjunto dos favoritos com o título passado.
	 * @param nome representa o parametro a ser usado na comparação.
	 * @return album
	 * @throws Exception caso não encontrado
	 */
	public Album findAlbumFavorito(String nome) throws Exception{
		Iterator<Album> iterator = favoritos.iterator();
		
		while (iterator.hasNext()) {
			Album album = iterator.next();
			if (album.equalsTitulo(nome)){
				return album;
			}
		}
		throw new Exception("Album nao pertence ao Perfil especificado");
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
		return conjuntoAlbuns.contains(album);
	}
	
	/**
	 * Retorna uma playlist se existir a chave passada.
	 * @param chave nome da playlist a ser retornada
	 * @return Se existir, é retornada a playlist, senão null.
	 */
	public Playlist getPlaylist(String chave){
		if (chave == null || chave.trim().equals("")){
			return null;
		}
		return playlists.get(chave);
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
		
		return favoritos.contains(album);
	}
	
	/**
	 * Responsável por ordenar e imprimir os albuns.
	 */
	public void sortedAlbuns(){
		Iterator<Album> iterator = favoritos.iterator();
		
		ArrayList<Album> aux = new ArrayList<Album>();
		while (iterator.hasNext()) {
			Album album = (Album) iterator.next();
			aux.add(album);
		}
		Collections.sort(aux);
		
		sysoAlbum(aux);
	}
	
	/**
	 * Responsável por ordenar e imprimir os albuns favoritos.
	 */
	public void sortedAlbunsFavoritos(){
		Iterator<Album> iterator = favoritos.iterator();
		
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
