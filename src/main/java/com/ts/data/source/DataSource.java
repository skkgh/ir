package com.ts.data.source;

import java.util.ArrayList;
import java.util.List;

import com.ts.model.Document;

public class DataSource {
	
	private static volatile DataSource ds;
	
	private List<Document> docs=new ArrayList<>();
	private boolean loaded=false;
	
	private DataSource(){
		
	}
	
	public static DataSource getInstance(){
		if(ds==null){
			synchronized(DataSource.class){
				if(ds==null){
					ds=new DataSource();
				}
			}
		}
		return ds;
	}
	public void loadData(List<Document> docs){
		this.docs = docs;
		this.loaded=true;
	}
	
	public List<Document> getDocs(){
		return docs;
	}
	
	public boolean isLoaded(){
		return loaded;
	}
}
