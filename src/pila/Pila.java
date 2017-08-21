package pila;

import excepcion.Desbordamiento;

public interface Pila {

	void apilar(Object x);
	void desapilar() throws Desbordamiento;
	Object cima();
	Object cimaYDesapilar() throws Desbordamiento;
	boolean esVacia();
	void vaciar();
}
