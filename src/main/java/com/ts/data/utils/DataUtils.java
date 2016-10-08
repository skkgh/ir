package com.ts.data.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ts.data.source.DataSource;
import com.ts.model.Document;

public class DataUtils {

	public static void loadData(InputStream is){
		
		List<Document> docs = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
			String line=null;Document doc=null;int attrNo=1;
			while((line=br.readLine())!=null){
				switch(attrNo){
					case 1:doc=new Document();
						doc.setProductId(getValue(line));
						attrNo++;break;
					case 2:attrNo++;break;
					case 3:doc.setProfileName(getValue(line));
						attrNo++;break;
					case 4:attrNo++;break;
					case 5:doc.setScore(Float.parseFloat(getValue(line)));
						attrNo++;break;
					case 6:attrNo++;break;
					case 7:doc.setSummary(getValue(line));
						attrNo++;break;
					case 8:doc.setText(getValue(line));
						attrNo++;break;
					case 9:
						docs.add(doc);
						attrNo=1;break;
				}
			}
			DataSource.getInstance().loadData(docs);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		
	}
	
	public static String getValue(String line){
		if(line==null || line.isEmpty())	return null;
		int index=line.indexOf(':');
		String value = line.substring(index+1);
		value.trim();
		return value;
	}
}
