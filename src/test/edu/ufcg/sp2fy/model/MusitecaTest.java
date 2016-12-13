package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Album;
import edu.ufcg.sp2fy.model.Musica;
import edu.ufcg.sp2fy.model.Musiteca;

public class MusitecaTest {
	private Musiteca musiteca;
	private Musica musica;
	private Album album;
	
	@Before
	public void initMusiteca() throws Exception{
		musiteca = new Musiteca();
		musica = new Musica("RUM", 3, "ROCK");
		album = new Album("AM", "AM", 2012);
		musiteca.addAlbum(album);
		musiteca.addAlbumFavorito("Gostei", album);
	}
	
	@Test
	public void testAdd() throws Exception{
		assertFalse(musiteca.addAlbum(album));
		assertTrue(musiteca.addAlbum(new Album("d", "a", 1990)));
		assertFalse(musiteca.addAlbum(null));
	}
	
	@Test
	public void testAddFavoritos() throws Exception{
		assertFalse(musiteca.addAlbumFavorito("Gostei", album));
		assertTrue(musiteca.addAlbumFavorito("Correr", album));
		assertFalse(musiteca.addAlbumFavorito(null, album));
		assertFalse(musiteca.addAlbumFavorito("", album));
		assertFalse(musiteca.addAlbumFavorito("Gostei", null));
	}
	
	@Test
	public void testRemove() throws Exception{
		assertTrue(musiteca.removeAlbum(album));
		assertFalse(musiteca.removeAlbum(new Album("d", "a", 1990)));
		assertFalse(musiteca.removeAlbum(null));
	}
	
	@Test
	public void testRemoveFavoritos() throws Exception{
		assertTrue(musiteca.removeAlbumFavorito("Gostei"));
		assertFalse(musiteca.removeAlbumFavorito("Correr"));
		assertFalse(musiteca.removeAlbumFavorito(null));
	}
	
	@Test
	public void testIsInConjunto() throws Exception{
		assertTrue(musiteca.isInList(album));
		assertFalse(musiteca.isInList(new Album("d", "a", 1990)));
		assertFalse(musiteca.isInList(null));
	}
	
	@Test
	public void testIsInConjuntoFavoritos() throws Exception{
		assertTrue(musiteca.isInListFavoritos(album));
		assertFalse(musiteca.isInListFavoritos(new Album("d", "a", 1990)));
		assertFalse(musiteca.isInListFavoritos(null));
	}
}
