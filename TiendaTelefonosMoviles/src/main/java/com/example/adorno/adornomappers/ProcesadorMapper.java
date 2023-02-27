package com.example.adorno.adornomappers;

import java.util.LinkedHashMap;

import com.example.adorno.DTO.ProcesadorDto;

public class ProcesadorMapper implements BaseMapper<ProcesadorDto, LinkedHashMap> {

	@Override
	public ProcesadorDto map(LinkedHashMap v) {
		// TODO Auto-generated method stub
		return new ProcesadorDto(Long.valueOf(String.valueOf(v.get("id"))));
	}

}
