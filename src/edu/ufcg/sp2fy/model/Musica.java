package edu.ufcg.sp2fy.model;

public class Musica {
	
	private String titulo;
	private int duracao;
	private String genero;
	
	
	public Musica(String titulo, int duracao, String genero) throws Exception {
		
		if (titulo == null || titulo.equals("")){
			throw new Exception("O título não é válido");
		} else if (duracao <= 0){
			throw new Exception("A duração não pode ser negativa");
		} else if (genero == null || genero.equals("")){
			throw new Exception("O gênero não é válido");
		}
		
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Musica))
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (titulo != null && titulo.equalsIgnoreCase(other.getTitulo()))
			return true;
		return false;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	

}
