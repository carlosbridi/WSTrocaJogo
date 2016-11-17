package com.trocajogo.model;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

@Converter(autoApply = true)
public class StatusTrocaConverter implements AttributeConverter<StatusTroca, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusTroca status) {
		return status.getStatusTroca();
	}

	@Override
	public StatusTroca convertToEntityAttribute(Integer status) {
		return StatusTroca.from(status);
	}

}
