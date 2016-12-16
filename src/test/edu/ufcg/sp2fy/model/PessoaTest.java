package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Album;
import edu.ufcg.sp2fy.model.Musica;
import edu.ufcg.sp2fy.model.Pessoa;

public class PessoaTest {
	private Pessoa pessoa;

	@Before
	public void setUp() throws Exception{
		pessoa = new Pessoa("Juan");
		Album album = new Album("AM", "AM", 1992);
		for (int i = 0; i != 2; i++){
			album.adicionaMusica(new Musica("DIWN", 3, "Rock"));
		}
		pessoa.adicionaAlbum(album);
		pessoa.adicionaAlbumFavorito(album);
	}

	@Test
	public void testToString() {
		assertEquals("Nome = Juan", pessoa.toString());
	}
	
	/* Não foram implementados os testes para todos os casos visto que a grande parte são
	 * métodos delegados e já estão sendo testados em musiteca.
	 */

	
}
