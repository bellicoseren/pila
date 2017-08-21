package pila;

import excepcion.Desbordamiento;
import pila.PilaImp;

public class PilaImp implements Pila{
	
	private static final int MEDIDA_POR_DEFECTO = 3;
	private int cima;
	private Object[] pila;
	
	public PilaImp() {
		pila = new Object[MEDIDA_POR_DEFECTO];
		cima = -1;
	}

	@Override
	public void apilar(Object x) {
		if(cima + 1 == pila.length){
			duplicar();
		}
		pila[++cima] = x;
		System.out.println("Se agregó elemento: " + x + " a la pila");
		pila();
	}

	private void duplicar() {
		Object[] nuevaPila = new Object[pila.length * 2];
		System.out.println("Tamaño del vector: " + pila.length);
		for(int i=0; i<pila.length; i++){
			nuevaPila[i] = pila[i];
		}
		pila = nuevaPila;
		System.out.println("Tamaño de la pila duplicado");
		System.out.println("Tamaño del vector: " + pila.length);
	}

	@Override
	public void desapilar() throws Desbordamiento {
		if(esVacia()){
			throw new Desbordamiento("Desapilar");
		}
		cima--;
		System.out.println("Se desapiló un elemento");
		pila();
	}

	@Override
	public Object cima() {
		pila();
		return pila[cima];
	}

	@Override
	public Object cimaYDesapilar() throws Desbordamiento {
		if(esVacia())
			throw new Desbordamiento("Cima y Desapilar");
		pila();
		return pila[--cima];
	}

	@Override
	public boolean esVacia() {
		
		return cima == -1;
	}

	@Override
	public void vaciar() {
		cima = -1;
		System.out.println("Se vació la pila");
		pila();
	}

	public void pila(){
		for(int i=0; i<pila.length; i++)
			System.out.println(pila[i]);
	}
	public static void main(String arg[]) throws Desbordamiento{
		PilaImp pila = new PilaImp();
		
		pila.apilar(new Integer(1));
		pila.apilar(new Integer(2));
		pila.apilar(new Integer(3));
		pila.apilar(new Integer(6));
		pila.apilar(new Integer(38));
		pila.apilar(new Integer(3));
		pila.apilar(new Integer(5));
		pila.apilar(new Integer(2));
		pila.apilar(new Integer(75));
		pila.apilar(new Integer(37));
		pila.apilar(new Integer(54));
		pila.apilar(new Integer(82));
		
		pila.desapilar();
		
		System.out.println("Cima: " + pila.cima());
		pila.desapilar();
		System.out.println("Cima y desapilar: " + pila.cimaYDesapilar());
		System.out.println("Cima: " + pila.cima());
		pila.desapilar();
		System.out.println("Cima: " + pila.cima());
		System.out.println("La pila está vacía? " + pila.esVacia());

		pila.vaciar();

		System.out.println("La pila está vacía? " + pila.esVacia());
		
		
		pila.apilar(new Integer(100));
		pila.apilar(new Integer(200));
		pila.apilar(new Integer(300));
		pila.apilar(new Integer(600));
		pila.apilar(new Integer(380));
		pila.apilar(new Integer(300));
		pila.apilar(new Integer(500));
	}
}
