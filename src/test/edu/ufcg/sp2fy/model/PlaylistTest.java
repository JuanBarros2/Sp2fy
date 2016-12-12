package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Musica;
import edu.ufcg.sp2fy.model.Playlist;

public class PlaylistTest {
	
	private Playlist playlist;
	
	@Before
	public void initTest() throws Exception{
		playlist = new Playlist("Malhar");
	}

	@Test(expected = Exception.class)
	public void testConstrutorNulo() throws Exception {
		new Playlist(null);
	}
	
	@Test(expected = Exception.class)
	public void testConstrutorVazio() throws Exception {
		new Playlist("");
	}
	
	@Test
	public void testGetDuracao(){
		assertEquals(0, playlist.getDuracao());

		try {
			playlist.addMusica(new Musica("DIWN", 4, "Indie"));
			playlist.addMusica(new Musica("RUM", 4, "Rock"));
			assertEquals(8, playlist.getDuracao());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test 
	public void testAddMusica() throws Exception{
		assertTrue(playlist.addMusica(new Musica("DIWN", 4, "Indie")));
		assertFalse(playlist.addMusica(new Musica("DIWN", 4, "Indie")));
	}
	
	@Test
	public void testPesquisaFaixa() throws Exception{
		assertFalse(playlist.pesquisaMusica(null));
		Musica musica = new Musica("DIWN", 4, "Indie");
		playlist.addMusica(musica);
		assertTrue(playlist.pesquisaMusicaPorNome("DIWN"));
		assertTrue(playlist.pesquisaMusica(musica));
	}
	
	@Test
	public void testRemoveMusica() throws Exception{
		Musica musica = new Musica("SA", 3, "suhais");
		assertFalse(playlist.removeMusica(null));
		playlist.addMusica(musica);
		assertTrue(playlist.removeMusica(musica));
		
		assertFalse(playlist.removeMusicaPorNome(null));
		playlist.addMusica(musica);
		assertTrue(playlist.removeMusicaPorNome("SA"));
	}

}
