package com.revature.pcc.model;

import org.junit.*;
import static org.junit.Assert.*;

public class ConsumerTest {

	public static Basket marketBasket;
	public static Consumer consumer;

	@BeforeClass
	public static void setUpBeforeClass() {
		ConsumerTest.marketBasket = new Basket();
		ConsumerTest.consumer = new Consumer(ConsumerTest.marketBasket);
	}

	@Before
	public void setUp() {
		while (!ConsumerTest.marketBasket.isFull()) {
			ConsumerTest.marketBasket.getGoodList().add(new Good());
		}
	}

	@After
	public void tearDown() {
		ConsumerTest.marketBasket.getGoodList().clear();
	}

	@Test
	public void testConsumeOneNormal() {
		int size = ConsumerTest.consumer.consumeAGood();
		assertEquals(size, ConsumerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testConsumeOneToEmpty() {
		ConsumerTest.marketBasket.getGoodList().clear();
		ConsumerTest.marketBasket.getGoodList().add(new Good());
		assertFalse(ConsumerTest.marketBasket.getGoodList().isEmpty());
		int size = ConsumerTest.consumer.consumeAGood();
		assertEquals(size, ConsumerTest.marketBasket.getGoodList().size());
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
	}

	@Test
	public void testConsumeOneToUnderflow() {
		ConsumerTest.marketBasket.getGoodList().clear();
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
		int size = ConsumerTest.consumer.consumeAGood();
		assertEquals(-1, size);
		assertEquals(0, ConsumerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testConsumeFiveNormal() {
		int amount = ConsumerTest.consumer.consumeGoods(5);
		assertEquals(5, amount);
		assertEquals(95, ConsumerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testConsumeThirtyNormal() {
		int amount = ConsumerTest.consumer.consumeGoods(30);
		assertEquals(30, amount);
		assertEquals(70, ConsumerTest.marketBasket.getGoodList().size());
	}

	@Test
	public void testConsumeManyToEmpty() {
		assertFalse(ConsumerTest.marketBasket.getGoodList().isEmpty());
		int amount = ConsumerTest.consumer.consumeGoods(100);
		assertEquals(100, amount);
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
	}

	@Test
	public void testConsumeManyToPartialUnderflow() {
		while (ConsumerTest.marketBasket.getGoodList().size() > 50) {
			ConsumerTest.marketBasket.getGoodList().remove(ConsumerTest.marketBasket.getGoodList().size() - 1);
		}
		assertFalse(ConsumerTest.marketBasket.getGoodList().isEmpty());
		int amount = ConsumerTest.consumer.consumeGoods(70);
		assertEquals(50, amount);
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
	}

	@Test
	public void testConsumeManyToTotalUnderflow() {
		ConsumerTest.marketBasket.getGoodList().clear();
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
		int amount = ConsumerTest.consumer.consumeGoods(50);
		assertEquals(0, amount);
		assertTrue(ConsumerTest.marketBasket.getGoodList().isEmpty());
	}

}
