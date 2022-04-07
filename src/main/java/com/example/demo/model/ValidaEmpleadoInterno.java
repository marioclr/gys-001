package com.example.demo.model;

public class ValidaEmpleadoInterno {
	private IEmpleadoInterno empleado;
	private boolean esValido;

	public IEmpleadoInterno getEmpleado() {
		return empleado;
	}

	public void setEmpleado(IEmpleadoInterno empleado) {
		this.empleado = empleado;
	}

	public boolean getEsValido() {
		return esValido;
	}

	public void setEsValido(boolean esValido) {
		this.esValido = esValido;
	}
	
}
