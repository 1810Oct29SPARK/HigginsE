package com.revature.pcc.model;

import org.junit.*;
import static org.junit.Assert.*;

public class ProducerTest {

	private static Basket marketBasket;
	private static Producer producer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ProducerTest.marketBasket = new Basket();
		ProducerTest.producer = new Producer(ProducerTest.marketBasket);
	}

	@Before
	public void setUp() {
		ProducerTest.marketBasket.getGoodList().clear();
	}

	@Test
	public void testProduceOneNormal() {
		int size = ProducerTest.producer.produceAGood();
		assertEquals(size, ProducerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testProduceOneToFull() {
		while (ProducerTest.marketBasket.getGoodList().size() < 99) {
			ProducerTest.marketBasket.getGoodList().add(new Good());
		}
		assertFalse(ProducerTest.marketBasket.isFull());
		int size = ProducerTest.producer.produceAGood();
		assertEquals(size, ProducerTest.marketBasket.getGoodList().size());
		assertTrue(ProducerTest.marketBasket.isFull());
	}

	@Test
	public void testProduceOneToOverflow() {
		while (ProducerTest.marketBasket.getGoodList().size() < 100) {
			ProducerTest.marketBasket.getGoodList().add(new Good());
		}
		assertTrue(ProducerTest.marketBasket.isFull());
		int size = ProducerTest.producer.produceAGood();
		assertEquals(-1, size);
		assertEquals(100, ProducerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testProduceFiveNormal() {
		int amount = ProducerTest.producer.produceGoods(5);
		assertEquals(5, amount);
		assertEquals(5, ProducerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testProduceThirtyNormal() {
		int amount = ProducerTest.producer.produceGoods(30);
		assertEquals(30, amount);
		assertEquals(30, ProducerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testProduceManyToFull() {
		while (ProducerTest.marketBasket.getGoodList().size() < 50) {
			ProducerTest.marketBasket.getGoodList().add(new Good());
		}
		assertFalse(ProducerTest.marketBasket.isFull());
		int amount = ProducerTest.producer.produceGoods(50);
		assertEquals(50, amount);
		assertEquals(100, ProducerTest.marketBasket.getGoodList().size());
		assertTrue(ProducerTest.marketBasket.isFull());
	}

	@Test
	public void testProduceManyToPartialOverflow() {
		while (ProducerTest.marketBasket.getGoodList().size() < 70) {
			ProducerTest.marketBasket.getGoodList().add(new Good());
		}
		int amount = ProducerTest.producer.produceGoods(50);
		assertEquals(30, amount);
		assertEquals(100, ProducerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testProduceManyToTotalOverflow() {
		while (ProducerTest.marketBasket.getGoodList().size() < 100) {
			ProducerTest.marketBasket.getGoodList().add(new Good());
		}
		assertTrue(ProducerTest.marketBasket.isFull());
		int amount = ProducerTest.producer.produceGoods(50);
		assertEquals(0, amount);
		assertEquals(100, ProducerTest.marketBasket.getGoodList().size());
	}

}
