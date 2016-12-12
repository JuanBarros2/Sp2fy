package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Album;
import edu.ufcg.sp2fy.model.Musica;

public class AlbumTest {
	private Album album;

	@Before
	public void initAlbum() {
		try {
			album = new Album("Artic Monkeys", "AM", 2012);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test(expected = Exception.class)
	public void testSetTitulo() throws Exception{
		album.setTitulo(null);
	}
	
	@Test(expected = Exception.class)
	public void testSetAno() throws Exception{
		album.setAno(0);
	}
	
	@Test(expected = Exception.class)
	public void testSetArtista() throws Exception{
		album.setArtista(null);
	}
	
	@Test
	public void testGetDuracao(){
		assertEquals(0, album.getDuracao());

		try {
			album.addMusica(new Musica("DIWN", 4, "Indie"));
			album.addMusica(new Musica("RUM", 4, "Rock"));
			assertEquals(8, album.getDuracao());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testIsInAlbum(){
		assertFalse(album.isInAlbum("aa"));
		assertFalse(album.isInAlbum(null));
		
		try {
			album.addMusica(new Musica("DIWN", 4, "Indie"));
			assertTrue(album.isInAlbum("DIWN"));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test 
	public void testAddMusica() throws Exception{
		assertTrue(album.addMusica(new Musica("DIWN", 4, "Indie")));
		assertFalse(album.addMusica(new Musica("DIWN", 4, "Indie")));
	}
	
	@Test
	public void testPesquisaFaixa() throws Exception{
		assertNull(album.pesquisaFaixa(1));
		album.addMusica(new Musica("DIWN", 4, "Indie"));
		assertNotNull(album.pesquisaFaixa(1));
	}
	
	@Test
	public void testRemoveMusica() throws Exception{
		Musica musica = new Musica("SA", 3, "suhais");
		assertFalse(album.removeMusica(null));
		album.addMusica(musica);
		assertTrue(album.removeMusica(musica));
	}
	

}
