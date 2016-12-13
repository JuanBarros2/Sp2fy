package test.edu.ufcg.sp2fy.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ufcg.sp2fy.model.Pessoa;

public class PessoaTest {
	private Pessoa pessoa;

	@Before
	public void setUp(){
		pessoa = new Pessoa("Juan");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
