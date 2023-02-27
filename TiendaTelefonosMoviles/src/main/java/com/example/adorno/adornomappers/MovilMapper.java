package com.example.adorno.adornomappers;

import java.util.LinkedHashMap;

import com.example.adorno.DTO.MovilDto;
import com.example.adorno.modelo.Marca;

public class MovilMapper implements BaseMapper<MovilDto, LinkedHashMap>{

	@Override
	public MovilDto map(LinkedHashMap v) {
		// TODO Auto-generated method stub
		return new MovilDto((Marca) v.get("marca"), (String) v.get("modelo"),
				new ProcesadorMapper().map((LinkedHashMap) v.get("procesador_nucleos")),
                Integer.parseInt(String.valueOf(v.get("almacenamiento"))),
				Long.parseLong(String.valueOf(v.get("ram"))),
                Float.parseFloat(String.valueOf(v.get("precio")))
		);
	}

}
