package com.hp.es.service.orchestration.sap;

import java.util.concurrent.ConcurrentLinkedQueue;

class CachedPortPool<T> {
	protected ConcurrentLinkedQueue < T > objects; 
	protected CachedPortPool( ) {
		objects = new ConcurrentLinkedQueue<T>();	
	}
		
	protected T borrowObject() {
		return objects.poll();
		  
	}
	protected void returnObject(T borrowed) {
		objects.add(borrowed);
		  
	}

	
	
	
}