package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ufcg.sp2fy.model.Album;

public class AlbumTest {

	@Test
	public void testConstrutor() {
		try {
			Album albumtest = new Album("Juan", "AM",1992);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
