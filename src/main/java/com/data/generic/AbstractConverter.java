package com.data.generic;

import java.util.List;
public abstract class AbstractConverter<E, R> {

	public List<E> toEntity(List<R> representations) {
		return null;
	}
	
	public List<R> toRepresentation(List<E> entities) {
		return null;
	}
	
	public abstract E toEntity(R representation);
	
	public abstract E toEntity(R representation, E entity);
	
	public abstract R toRepresentation(E entity);
	
}
