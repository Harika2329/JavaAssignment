package com.example.pointcalculater;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.pointcalculater.model.Points;
import com.example.pointcalculater.model.Transaction;
import com.example.pointcalculater.service.PointServiceImpl;
import com.example.pointcalculater.util.Data;  

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointServiceImplTest {
	@Mock
	private Data data;
	@Mock
	private PointServiceImpl pointServiceImpl;


	
	@Test
	public void test_getPointsByCustomerId()
	{
		Points	points=new Points (); 
		points.setCustomerId(1l);
		points.setLastMonthPoints(123); 
		points.setLastSecondMonthPoints(0);
		points.setLastThirdMonthPoints(0); 
		points.setTotalPoints(0);
		Mockito.when(pointServiceImpl.getPointsByCustomerId(1l)).thenReturn(points);
		Points points1=pointServiceImpl.getPointsByCustomerId(1l);
		assertEquals(1l, points1.getCustomerId()); 		
		assertEquals(123, points1.getLastMonthPoints()); 		

	}
	
	@Test
	public void test_calculatePoints()
	{
		Transaction	transaction=new Transaction (); 
		transaction.setCustomerId(1l);
		transaction.setTransactionAmount(120);
		transaction.setTransactionId(1l);
		transaction.setTransactionDate(Timestamp.valueOf("2022-08-09 00:00:00")); 
		
		Mockito.when(pointServiceImpl.calculatePoints(transaction)).thenReturn(1l);
		long points1=pointServiceImpl.calculatePoints(transaction);
		assertEquals(1l, points1); 		


	}

}
