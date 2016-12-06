package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Musica;
import junit.framework.AssertionFailedError;

public class MusicaTest {
	public Musica musica;

	@Before
	public void init() throws Exception{
		musica = new Musica("R U mine", 4, "Rock");
	}

	@Test
	public void testEquals() {
		try {
			Musica m = new Musica("R U mine", 4, "Rock");
			m.setGenero("indie");
			assertTrue(m.equals(musica));
			m.setDuracao(1);
			assertFalse(m.equals(musica));
			m.setDuracao(4);
			assertTrue(m.equals(musica));
			m.setTitulo("E");
			assertFalse(m.equals(musica));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testConstrutor(){
		try {
			Musica m = new Musica(null, 0, "i");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
