package com.genericdata;

import java.util.List;
import static java.util.stream.Collectors.toList;;
public abstract class AbstractConverter<E, R> {

	public List<E> toEntity(List<R> representations) {
		return representations.stream()
				.map(this::toEntity)
				.collect(toList());
	}
	
	public List<R> toRepresentation(List<E> entities) {
		return entities.stream()
				.map(this::toRepresentation)
				.collect(toList());
	}
	
	public abstract E toEntity(R representation);
	
	public abstract E toEntity(R representation, E entity);
	
	public abstract R toRepresentation(E entity);
	
}
