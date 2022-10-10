package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class validate the function `static double getCumulativePercentages(KeyedValues values)`
 * of the class `DataUtilities`.
 * It is expected that the function returns a KeyedValues instance that 
 * contains the cumulative percentage values for the data in another KeyedValues instance
 * which is passed as the input argument.
 * 
 * We tested the function for different combination of positive and negative values, single element and 
 * empty arrays.
 * 
 * @author Group#4
 *
 */
public class DataUtilitiesGetCumulativePercentagesTest {
	
	Mockery mockingContext;
	KeyedValues keyValues;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'getCumulativePercentages' of the class DataUtilities has been started.");
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();	
		keyValues = mockingContext.mock(KeyedValues.class);
	}

	@Test
	public void getCumulativePercentagesForFourPositiveValues() {
		
		// List: {2,2,2,2}
		// Cumulative Percentages: {2/8, 4/8, 6/8, 8/8} 
		
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(4));
				// returning the values 
				allowing(keyValues).getValue(0);
				will(returnValue(2));
				allowing(keyValues).getValue(1);
				will(returnValue(2));
				allowing(keyValues).getValue(2);
				will(returnValue(2));
				allowing(keyValues).getValue(3);
				will(returnValue(2));
				// converting indices to keys 
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				allowing(keyValues).getKey(1);
				will(returnValue(1));
				allowing(keyValues).getKey(2);
				will(returnValue(2));
				allowing(keyValues).getKey(3);
				will(returnValue(3));
			}
		});
		// exercise
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues); 
		// verify
		
		assertEquals(0.25, result.getValue(0));
		assertEquals(0.5, result.getValue(1));
		assertEquals(0.75, result.getValue(2));
		assertEquals(1.0, result.getValue(3));
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void getCumulativePercentagesForSinglePositiveValues() {
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(1));
				allowing(keyValues).getValue(0);
				will(returnValue(2));				
				allowing(keyValues).getKey(0);
				will(returnValue(0));
			}
		});
		// exercise
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues); 
		// verify
		
		assertEquals("If I pass only one value I expect 1.0 as Cumulative Percentage", 1.0, result.getValue(0));
		// tear-down: NONE in this test method
	}

	@Test
	public void getCumulativePercentagesForSingleNullValues() {
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(1));
				allowing(keyValues).getValue(0);
				will(returnValue(null));				
				allowing(keyValues).getKey(0);
				will(returnValue(0));
			}
		});
		// exercise
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues); 
		// verify
		assertEquals("If I pass only one null value I expect NaN as Cumulative Percentage", Double.NaN, result.getValue(0));
		// tear-down: NONE in this test method
	}
	
	@Test
	public void getCumulativePercentagesForEmptyValues() {
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(0));
			}
		});
		// exercise
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues); 
		// verify
		
		assertEquals(0, result.getItemCount());
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void getCumulativePercentagesForFirstThreeRowsAreZero(){
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(4));
				// {0,0,0,2}
				allowing(keyValues).getValue(0);
				will(returnValue(0));
				allowing(keyValues).getValue(1);
				will(returnValue(0));
				allowing(keyValues).getValue(2);
				will(returnValue(0));
				allowing(keyValues).getValue(3);
				will(returnValue(2));
				//
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				allowing(keyValues).getKey(1);
				will(returnValue(1));
				allowing(keyValues).getKey(2);
				will(returnValue(2));
				allowing(keyValues).getKey(3);
				will(returnValue(3));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
		// All must be zero expect the last one.
		assertEquals(0.0, result.getValue(0));
		assertEquals(0.0, result.getValue(1));
		assertEquals(0.0, result.getValue(2));
		assertEquals(1.0, result.getValue(3));
	}
	
	@Test
	public void getCumulativePercentagesForLastThreeRowsAreZero(){
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(4));
				//
				allowing(keyValues).getValue(0);
				will(returnValue(2));
				allowing(keyValues).getValue(1);
				will(returnValue(0));
				allowing(keyValues).getValue(2);
				will(returnValue(0));
				allowing(keyValues).getValue(3);
				will(returnValue(0));
				//
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				allowing(keyValues).getKey(1);
				will(returnValue(1));
				allowing(keyValues).getKey(2);
				will(returnValue(2));
				allowing(keyValues).getKey(3);
				will(returnValue(3));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
		// Expect all to be 1.0 
		assertEquals(1.0, result.getValue(0));
		assertEquals(1.0, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
		assertEquals(1.0, result.getValue(3));
	}
	
	@Test
	public void getCumulativePercentagesForAllRowsAreZero(){
		mockingContext.checking(new Expectations() {
			{
				allowing(keyValues).getItemCount();
				will(returnValue(4));
				//
				allowing(keyValues).getValue(0);
				will(returnValue(0));
				allowing(keyValues).getValue(1);
				will(returnValue(0));
				allowing(keyValues).getValue(2);
				will(returnValue(0));
				allowing(keyValues).getValue(3);
				will(returnValue(0));
				//
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				allowing(keyValues).getKey(1);
				will(returnValue(1));
				allowing(keyValues).getKey(2);
				will(returnValue(2));
				allowing(keyValues).getKey(3);
				will(returnValue(3));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
		assertEquals(0.0 / 0.0, result.getValue(0));
		assertEquals(0.0 / 0.0, result.getValue(1));
		assertEquals(0.0 / 0.0, result.getValue(2));
		assertEquals(0.0 / 0.0, result.getValue(3));
	}
	
	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
}
