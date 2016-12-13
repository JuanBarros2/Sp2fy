package edu.ufcg.sp2fy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Uma Playlist é um conjunto de músicas, não necessariamente de um só artista
 * que são dispostos em uma sequência.
 * @author Juan
 *
 */
public class Playlist {
	private String chave;
	private ArrayList<Musica> musicas;

	public Playlist(String chave) throws Exception {
		if (chave == null || chave.trim().equals("")){
			throw new Exception("Chave inválida");
		}
		this.chave = chave;
		musicas = new ArrayList<Musica>();
	}
	
	/**
	 * Retorna um booleano representando se a {@link Musica} foi adicionada com sucesso.
	 * Uma {@link Musica} é adicionada com sucesso se ela não for nula e se o ArrayList
	 * suportar sua adição.
	 * @param musica 
	 * @return true se a música foi adicionada.
	 */
	public boolean addMusica(Musica musica){
		if (musica == null){
			return false;
		}
		return musicas.add(musica);
	}
	
	/**
	 * Retorna um booleano representando se a {@link Musica} foi removido com sucesso.
	 * Uma {@link Musica} é removida com sucesso se ela não for nula e se o ArrayList
	 * suportar sua remoção.
	 * @param musica Objeto a ser removido
	 * @return true se a música foi removida.
	 */
	public boolean removeMusica(Musica musica){
		if (musica == null || !musicas.contains(musica)){
			return false;
		}
		return musicas.remove(musica);
	}
	
	/**
	 * Retorna um booleano representando se a {@link Musica} foi removido com sucesso.
	 * Uma {@link Musica} é removida com sucesso se ela não for nula e se o ArrayList
	 * suportar sua remoção.
	 * @param nome Nome da música a ser removida
	 * @return true se a música foi removida.
	 */
	public boolean removeMusicaPorNome(String nome){
		if (nome == null){
			return false;
		}
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = iterator.next();
			if (musica.isTituloEquals(nome)){
				return musicas.remove(musica);
			}
		}
		return false;
	}
	
	/**
	 * Recebe uma {@link Musica} e retorna se ela existir na lista.
	 * @param musica Objeto a ser verificado se existe
	 * @return se existir true, senão false.
	 */
	public boolean pesquisaMusica(Musica musica){
		if (musica == null){
			return false;
		}
		return (pesquisaMusicaPorNome(musica.getTitulo()));
	}
	/**
	 * Recebe um nome de {@link Musica} e retorna se ela existir na lista.
	 * @param nome Nome a ser verificado se existe
	 * @return se existir, é retornada, senão nulo.
	 */
	public boolean pesquisaMusicaPorNome(String nome){
		if (nome == null){
			return false;
		}
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = iterator.next();
			if (musica.isTituloEquals(nome)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retorna um inteiro que representa o somatório da duração de todas as músicas
	 * dessa playlist. Se não existir músicas, é retornado o valor padrão, 0.
	 * @return total de duração
	 */
	public int getDuracao(){
		int total = 0;
		
		Iterator<Musica> iterator = musicas.iterator();
		while(iterator.hasNext()){
			total += iterator.next().getDuracao();
		}
		return total;
	}	

}
