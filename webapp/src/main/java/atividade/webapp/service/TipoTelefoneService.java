package atividade.webapp.service;

import java.util.ArrayList;
import java.util.List;

import atividade.webapp.model.TipoTelefone;

public class TipoTelefoneService extends BaseService {
	
	private static TipoTelefoneService instance;
	
	public static TipoTelefoneService getInstance() {
		return instance == null ? instance = new TipoTelefoneService() : instance;
	}
	
	public List<TipoTelefone> findAll() {
		ArrayList<TipoTelefone> tipoTelefoneList = new ArrayList<TipoTelefone>();
		
		TipoTelefone tipoTelefone = new TipoTelefone();
		tipoTelefone.setCdTipoTelefone(1l);
		tipoTelefone.setDsTipoTelefone(TipoTelefone.TIPO_FIXO);
		
		tipoTelefoneList.add(tipoTelefone);
		
		tipoTelefone = new TipoTelefone();
		tipoTelefone.setCdTipoTelefone(2l);
		tipoTelefone.setDsTipoTelefone(TipoTelefone.TIPO_CELULAR);
		
		tipoTelefoneList.add(tipoTelefone);
		
		return tipoTelefoneList;
				
	}
	


}
