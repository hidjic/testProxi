package proxybanque.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import proxybanque.service.ServiceCompte;

public class OperationsBanqueTests {
	ServiceCompte servC = new ServiceCompte();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Début des tests :");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fin des tests");

	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Nouveau test :");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test terminé");

	}

	@Test
	public void testDebiter() {
		assertEquals(2000, ServiceCompte.debiter(500, 2500),0);
	}

	@Test
	public void testCrediter() {
		assertEquals(3000, ServiceCompte.crediter(500, 2500), 0);
	}

}
