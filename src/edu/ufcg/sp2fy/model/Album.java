package edu.ufcg.sp2fy.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Album representa um conjunto de informações sobre uma coleção de músicas além de armazenar um
 * conjunto ordenado de {@link Musica}
 * @author Juan
 *
 */
public class Album implements Comparable<Album>{
	
	private String artista;
	private String titulo;
	private int ano;
	private ArrayList<Musica> musicas;
	
	/**
	 * Construtor de Album que espera informações básicas de um álbum (excluindo o conjunto de {@link Musica}
	 * @param artista
	 * @param titulo
	 * @param ano
	 * @throws Exception
	 */
	public Album(String artista, String titulo, int ano) throws Exception{
		setArtista(artista);
		setTitulo(titulo);
		setAno(ano);
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

	@Override
	public String toString() {
		String retorno = "Artista = " + artista + 
			   "\nTítulo = " + titulo + 
			   "\nAno = " + ano + 
			   "\n---------------------------";
		
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = (Musica) iterator.next();
			
			retorno += "\n" + musica.toString();
		}
		
		return retorno;
	}

	/**
	 * Retorna um booleano representando se a {@link Musica} foi adicionada com sucesso.
	 * Uma {@link Musica} é adicionada com sucesso se ela não for nula e se o ArrayList
	 * suportar sua adição.
	 * @param musica 
	 * @return true se a música foi adicionada.
	 */
	public boolean adicionaMusica(Musica musica){
		if (musica == null){
			return false;
		}
		return musicas.add(musica);
	}
	
	/**
	 * Retorna um booleano representando se a {@link Musica} foi removido com sucesso.
	 * Uma {@link Musica} é removida com sucesso se ela não for nula e se o ArrayList
	 * suportar sua remoção.
	 * @param posicao
	 * @return true se a música foi removida.
	 */
	public boolean removeMusica(int pos){
		
		try{
			musicas.remove(pos - 1);
		} catch(IndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	
	
	/**
	 * Retorna a faixa localizada da {@link Musica} adicionada na lista.
	 * Entende-se "faixa localizada" como um contador que facilita a interação
	 * com o usuário, pois o 0 não é intuitivo como número de faixa.
	 * @param faixa int que representa a faixa a ser retornada
	 * @return musica
	 * @exception caso esteja fora do range.
	 */
	public Musica pesquisaFaixa(int faixa) throws IndexOutOfBoundsException{
		return (musicas.get(faixa - 1));
	}
	
	
	/**
	 * Retorna um inteiro que representa o somatório da duração de todas as músicas
	 * desse álbum. Se não existir músicas, é retornado o valor padrão, 0.
	 * @return total de duração
	 */
	public int getDuracaoTotal(){
		int total = 0;
		
		Iterator<Musica> iterator = musicas.iterator();
		while(iterator.hasNext()){
			total += iterator.next().getDuracao();
		}
		return total;
	}
	
	/**
	 * Certifica-se a existência de um objeto {@link Musica} com o atributo título igual ao passado como parâmetro
	 * de entrada.
	 * @param titulo Texto que representa o título a ser pesquisado no conjunto
	 * @return true se existir e false caso contrário.
	 */
	public boolean contemMusica(String titulo){
		if (titulo == null || titulo.trim().equals("")){
			return false;
		}
		
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = iterator.next();
			if (musica.isTituloEquals(titulo)){
				return true;
			}
		}
		return false;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) throws Exception{
		if (artista == null || artista.trim().equals("")){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().equals("")){
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws Exception {
		if (ano < 1900){
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		this.ano = ano;
	}

	@Override
	public int compareTo(Album o) {
		return new Integer(o.getAno());
	}
	
	public int quantidadeFaixas(){
		return musicas.size();
	}
	
	public Musica getMusica(String titulo){
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = (Musica) iterator.next();
			if (musica.isTituloEquals(titulo)){
				return musica;
			}
		}
		return null;
	}
	
	
}
