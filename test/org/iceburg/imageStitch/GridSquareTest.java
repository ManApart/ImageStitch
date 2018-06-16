package org.iceburg.imageStitch;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridSquareTest {
	
	@Test
	public void testParseFileNameNotValid(){
		
		GridSquare square = new GridSquare(null, null);
		square.parseFileName();
		assertFalse(square.isValid());
		
		square = new GridSquare("", null);
		square.parseFileName();
		assertFalse(square.isValid());
		
		square = new GridSquare("test", null);
		square.parseFileName();
		assertFalse(square.isValid());
		
		square = new GridSquare("test.jpg", null);
		square.parseFileName();
		assertFalse(square.isValid());
		
		square = new GridSquare("test-2-6.jpg", null);
		square.parseFileName();
		assertTrue(square.isValid());
	}
	@Test
	public void testParseFileName(){
		
		GridSquare square = new GridSquare("test-0-0.jpg", null);
		square.parseFileName();
		assertEquals("test", square.getTapestryName());
		assertEquals(0, square.getX());
		assertEquals(0, square.getY());
		
		square = new GridSquare("auridon-10-5.jpg", null);
		square.parseFileName();
		assertEquals("auridon", square.getTapestryName());
		assertEquals(10, square.getX());
		assertEquals(5, square.getY());
	}

}
