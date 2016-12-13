package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Musica;

public class MusicaTest {
	public Musica musica;

	@Before
	public void setUp() throws Exception{
		musica = new Musica("R U mine", 4, "Rock");
	}

	@Test
	public void testEquals() {
		try {
			Musica m = new Musica("R U mine", 4, "Rock");
			
			m.setGenero("indie");
			// O parâmetro genero é mudado para garantir que não seja levado em conta na igualdade
			assertTrue(m.equals(musica)); 
			
			m.setDuracao(1);
			assertFalse(m.equals(musica));
			
			m.setDuracao(4);
			assertTrue(m.equals(musica));
			
			m.setTitulo("E");
			assertFalse(m.equals(musica));
		
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test(expected = Exception.class)
	public void testConstrutorComTituloInvalido() throws Exception{
		new Musica(null, 1, "i");
	}
	
	@Test(expected = Exception.class)
	public void testConstrutorComTituloVazio() throws Exception{
		new Musica("", 1, "i");
	}
	
	@Test(expected = Exception.class)
	public void testConstrutorComAnoInvalido() throws Exception{
		new Musica("pn", 0, "i");
	}
	
	@Test
	public void testIsTituloEquals(){
		assertTrue(musica.isTituloEquals("R U mine"));
		assertFalse(musica.isTituloEquals(""));
		assertFalse(musica.isTituloEquals(null));
		assertFalse(musica.isTituloEquals("soad"));
		
	}
}
