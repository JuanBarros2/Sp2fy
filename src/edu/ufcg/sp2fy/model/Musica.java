package edu.ufcg.sp2fy.model;

/**
 * Musica representa informações relevantes sobre uma música para o problema proposto. 
 * Nela, é contida informações sobre qual é o título, qual é a duração da música e qual
 * é o seu gênero.
 * @author Juan
 *
 */
public class Musica {
	
	private String titulo;
	private int duracao;
	private String genero;
	
	/**
	 * Construtor que espera todos os parâmetros na criação de Musica.
	 * @param titulo Nome da música
	 * @param duracao Tempo da músicas em minutos
	 * @param genero Gênero específico da música
	 * @throws Exception Se os parâmetros não obedecerem às regras de negócio, é lançada uma Exception
	 **/
	public Musica(String titulo, int duracao, String genero) throws Exception {		
		setTitulo(titulo);
		setDuracao(duracao);
		setGenero(genero);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "\"" + titulo + "\" - " + duracao
				+ ":00 - "+ genero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().equals("")){
			throw new Exception("O título não é válido");
		}
		this.titulo = titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) throws Exception{
		if (duracao <= 0){
			throw new Exception("A duração não pode ser negativa");
		}
		this.duracao = duracao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) throws Exception {
		if (genero == null || genero.trim().equals("")){
			throw new Exception("O gênero não é válido");
		}
		this.genero = genero;
	}
	
	/**
	 * Recebe um título e compara se é igual ao seu atributo título.
	 * @param titulo
	 * @return true se os títulos coincidirem.
	 */
	public boolean isTituloEquals(String titulo){
		return this.titulo.equals(titulo);
	}
	
	
	

}
