package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class validate the function `static double calculateRowTotal(Values2D data, int row)`
 * of the class `DataUtilities`.
 * It is expected that the function receives a 2D table and a row number and 
 * then it returns the total of the values in the passed row of the supplied data table.
 * 
 * We tested the function for different combination of positive and negative values, single element and 
 * empty arrays. Also, we covered the precision test. 
 * 
 * @author Group#4
 *
 */
public class DataUtilitiesCalculateRowTotalTest {
	
	Mockery mockingContext;
	Values2D values2D;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'CalculateRowTotal' of the class DataUtilities has been started.");
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();	
		values2D = mockingContext.mock(Values2D.class);
	}

	@Test
	public void calculateRowTotalForTwoPositiveValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.6));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(2.4));				
				//     0		1
				//------------------
				//0 |  7.6      2.4
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateRowTotalForTwoNegativeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(-7.6));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(-2.4));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, -10.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateRowTotalForTwoNegativePositiveValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(-7.5));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(2.5));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, -5.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateRowTotalForTwoPositiveNegativeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.5));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(-2.5));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 5.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateRowTotalForTwoOppositePolaritySameMagnitudeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.5));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(-7.5));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForTwoZeroValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(0.0));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(0.0));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForSingleValue() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(1));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(50.36598));			
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 50.36598, .000000000d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForNullValue() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(1));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(null));			
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 0.0d, .000000000d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForEmptyValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(0));
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForPrecision() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getColumnCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(5.6));
				one(values2D).getValue(0, 1); // int row, int column
				will(returnValue(5.8));				
			}
		});
		// exercise
		// Returns the total of the values in one row of the supplied data table.
		double result = DataUtilities.calculateRowTotal(values2D, 0); 
		// verify
		assertEquals(result, 11.399999999999999d, 0d);
		// tear-down: NONE in this test method
	}	
	
	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
}
