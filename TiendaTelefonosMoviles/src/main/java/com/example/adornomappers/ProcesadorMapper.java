package com.example.adornomappers;

import java.util.LinkedHashMap;

import com.example.adorno.DTO.ProcesadorDto;
import com.example.adorno.modelo.Procesador;

public class ProcesadorMapper implements BaseMapper<ProcesadorDto, LinkedHashMap> {

	@Override
	public ProcesadorDto map(LinkedHashMap v) {
		// TODO Auto-generated method stub
		return new ProcesadorDto(Long.valueOf(String.valueOf(v.get("numero_nucleos"))));
	}

}
