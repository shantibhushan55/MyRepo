package com.hp.es.service.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testCleanStringForTmInsert() {
		
		

		Assert.assertEquals("should be -", "-", StringUtils.cleanStringForTmInsert(null, 10, true));

		Assert.assertEquals("should be null", null, StringUtils.cleanStringForTmInsert(null, 10, false));
		
		Assert.assertEquals("should be null", null, StringUtils.cleanStringForTmInsert("", 10, false));
		Assert.assertEquals("should be -", "-", StringUtils.cleanStringForTmInsert("", 10, true));
		Assert.assertEquals("should be null", null, StringUtils.cleanStringForTmInsert("  ", 10, false));
		Assert.assertEquals("should be -", "-", StringUtils.cleanStringForTmInsert("   ", 10, true));
		
		
		
		Assert.assertEquals("should be lala", "lala", StringUtils.cleanStringForTmInsert("lala", 10, false));
		Assert.assertEquals("should be lala", "lala", StringUtils.cleanStringForTmInsert("lala  ", 10, false));

		Assert.assertEquals("should be lala", "la�la", StringUtils.cleanStringForTmInsert("la\nla  ", 10, false));
		Assert.assertEquals("should be lala", "la�la", StringUtils.cleanStringForTmInsert("la\rla  ", 10, false));
		Assert.assertEquals("should be lala", "la��la", StringUtils.cleanStringForTmInsert("la\n\rla  ", 10, false));
		
		Assert.assertEquals("should be lala", "la��la  �a", StringUtils.cleanStringForTmInsert("la\n\rla  \na", 10, false));
		
		Assert.assertEquals("should be 12345", "12345", StringUtils.cleanStringForTmInsert("12345", 5, false));
		Assert.assertEquals("should be 12345", "12345", StringUtils.cleanStringForTmInsert("12345 ", 5, false));
		Assert.assertEquals("should be 12345", "123�4", StringUtils.cleanStringForTmInsert("123\n4", 5, false));
		
		Assert.assertEquals("should be 8A§            D8 0B","8A§            D8 0", StringUtils.cleanStringForTmInsert("8A�\n            D8 0B",20, true));
		
		
		
	}

}
