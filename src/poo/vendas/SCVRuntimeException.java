package poo.vendas;

import poo.vendas.io.SCVPersistenciaException;

@SuppressWarnings("serial")
public class SCVRuntimeException extends Exception {
	public SCVRuntimeException(SCVPersistenciaException e) {
		super(e);
	}
	
	public SCVRuntimeException(String msg){
		super(msg);
	}
}
