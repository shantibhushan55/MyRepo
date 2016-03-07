package com.hp.es.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.exolab.castor.xml.Unmarshaller;

import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.util.CastorUtil;

public class CastorValidationWithColumn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "C:/getContractEntitlement_741.xml";
		
		InputStreamReader isr = null;
		BufferedReader fileReader = null;
		StringReader reader = null;
		EIAMessage request = null;
		
		String xml = "";
		try {
			File file = new File(path);
			StringBuilder sb = new StringBuilder();
			FileInputStream in = new FileInputStream(file);
			isr = new InputStreamReader(in, "UTF-8");
			fileReader = new BufferedReader(isr);

			String line = null;
			while ((line = fileReader.readLine()) != null) {
				sb.append(line);
			}			
			xml = sb.toString();
			reader = new StringReader(xml);
			Unmarshaller uma = CastorUtil
					.getUnmarshallerUsingEIAMessageMappingFile();
			request = (EIAMessage) uma.unmarshal(reader);

		} catch (Exception e) {
			String errorMessage = e.toString();
			System.out.println(errorMessage);
			
			int columnNumberStart = errorMessage.indexOf("column:");
			int columnNumberEnd = errorMessage.indexOf("}");
			if(columnNumberStart>0&&columnNumberEnd>0){
				String column = errorMessage.substring(columnNumberStart+8,columnNumberEnd);
				int column_ = Integer.parseInt(column);
				System.out.println("invalid character:" + xml.substring(column_-10, column_+10));	
			}
		} finally {
			try {
				isr.close();
				fileReader.close();
				reader.close();
			} catch (Exception e) {
			}
		}
	}

}
