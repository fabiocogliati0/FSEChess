import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.ChessBoardConfiguration;
import model.Configuration;
import model.Constants;

import org.junit.Before;
import org.junit.Test;


public class QueenTest {
	
	Configuration conf;
	
	@Before
	public void createConfiguration(){
		conf = new ChessBoardConfiguration();
		
		
		//tiro fuori le regine
		conf = conf.swap(6, 4, 5, 4);	//pedone davanti al re bianco avanti di uno
		conf = conf.swap(1, 4, 2, 4);	//pedone davanti al re nero avanti di uno
		conf = conf.swap(7, 3, 5, 5);	//metto la regina bianca in 5 5
		conf = conf.swap(0, 3, 3, 6);	//metto la regina nera in 3 6	
		
	}
	
	@Test
	public void TestNormalMove1(){
		//muovo la regina in orizzontale di 2
		assertTrue(conf.isLegalMove(5, 5, 5, 7));
	}
	
	@Test
	public void TestNormalMove2(){
		//muovo la regina in verticale di 2
		assertTrue(conf.isLegalMove(5, 5, 3, 5));
	}
	
	@Test
	public void TestNormalMove3(){
		//muovo la regina in obliquo di 2
		assertTrue(conf.isLegalMove(5, 5, 3, 7));
	}

	@Test
	public void TestChessWithQueen(){
		//provo uno scacco
		assertTrue(conf.isLegalMove(5, 5, 1, 5));
		conf = conf.swap(5, 5, 1, 5);
		assertTrue(conf.isChessConfiguration(Constants.blackColor));
	}
	
	@Test
	public void TestIllegalMove1(){
		//provo a muovere la regina come un cavallo
		assertFalse(conf.isLegalMove(5, 5, 3, 4));
	}

	@Test
	public void TestIllegalMove2(){
		//provo a muovere la regina in orizzontale di 2 ma in 5 4 c'è un pedone
		assertFalse(conf.isLegalMove(5, 5, 5, 3));
	}
}
