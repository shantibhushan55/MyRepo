package com.hp.es.service.util;

import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class TransactionIdGeneratorTest {

	@Test
	public void testGetId() {
/*Assert.assertNotNull(TransactionIdGenerator.getInstance().nextId());
		System.out.println("Id " +TransactionIdGenerator.getInstance().nextId());

		System.setProperty("weblogic.Name","es");
		Assert.assertNotNull(TransactionIdGenerator.getInstance().nextId());
		System.out.println("Id with weblogic name=es " +TransactionIdGenerator.getInstance().nextId());
		

		System.setProperty("weblogic.Name","es1");
		Assert.assertNotNull(TransactionIdGenerator.getInstance().nextId());
		System.out.println("Id " +TransactionIdGenerator.getInstance().nextId());
*/
		//System.setProperty("weblogic.Name","itg_es10");
		Assert.assertNotNull(TransactionIdGenerator.getInstance().nextId());
		System.out.println("Id " +TransactionIdGenerator.getInstance().nextId());

		
		
		HashSet<BigInteger> tUnique= new HashSet<BigInteger>();
		for(long i =0;i<=1000000; i++) {
			BigInteger tmp = new BigInteger(TransactionIdGenerator.getInstance().nextId());
			if(!tUnique.add(tmp)) {
				long stop= System.currentTimeMillis();
				fail("There is a bug AT ITERAtION "+i+", "+tmp+" already exists, stopped at"+ stop);
			}else {
				System.out.println(i+","+tmp);
			}
		}
		Assert.assertTrue(true);

	}

}
