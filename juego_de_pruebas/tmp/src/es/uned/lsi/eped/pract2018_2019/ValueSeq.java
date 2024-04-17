package es.uned.lsi.eped.pract2018_2019;
import java.math.BigInteger;
import es.uned.lsi.eped.DataStructures.Stack;

public class ValueSeq extends Value {
	
	private int tama�o;
	private String cadena = "";
	private String cadenaAux = "";
	private Stack<Integer> numerosPila = new Stack<Integer>();
	private Stack<Integer> numerosPila2 = new Stack<Integer>();
	
	/* Constructor: recibe un String con el valor numérico */
	public ValueSeq(String s) {
		tama�o = s.length();
		numerosPila.clear();
		numerosPila2.clear();
		for (int i=0;i<tama�o;i++) {
			cadena = String.valueOf(s.charAt(i));
			numerosPila.push(Integer.parseInt(cadena));
			numerosPila2.push(Integer.parseInt(cadena));
		}
	}
	
	/* Método que transforma el valor numérico en un String */
	public String toString() {
		while(numerosPila.size() > 0) {
			cadenaAux += numerosPila.getTop();
			numerosPila.pop();
		}
		StringBuilder cadenaSB = new StringBuilder(cadenaAux);
		cadenaSB.reverse();
		return cadenaSB.toString();
	}

	/* Método que modifica el valor numérico llamante, sumándole el valor numérico parámetro */
	public void addValue(Value n) {
		Stack<Integer> llamante = new Stack<Integer>();
		Stack<Integer> parametro = new Stack<Integer>();
		llamante = this.numerosPila;
		parametro = ((ValueSeq) n).numerosPila;
		String llamanteAux = "";
		String parametroAux = "";
		BigInteger llam;
		BigInteger par;
		
		while(llamante.size() > 0) {
			llamanteAux += llamante.getTop();
			llamante.pop();
		}
		StringBuilder cadenaSBLlamante = new StringBuilder(llamanteAux);
		llam = new BigInteger(cadenaSBLlamante.reverse().toString());
		
		while(parametro.size() > 0) {
			parametroAux += parametro.getTop();
			parametro.pop();
		}
		StringBuilder cadenaSBParametro = new StringBuilder(parametroAux);
		par = new BigInteger(cadenaSBParametro.reverse().toString());
		
		llam = llam.add(par);
		
		String aux = llam.toString();
		
		numerosPila.clear();
		numerosPila2.clear();
		
		for (int i=0;i<aux.length();i++) {
			cadena = String.valueOf(aux.charAt(i));
			numerosPila.push(Integer.parseInt(cadena));
			numerosPila2.push(Integer.parseInt(cadena));
		}
	}

	/* Método que modifica el valor numérico llamante, restándole el valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico llamante */
	public void subValue(Value n) {
		Stack<Integer> llamante = new Stack<Integer>();
		Stack<Integer> parametro = new Stack<Integer>();
		llamante = this.numerosPila;
		parametro = ((ValueSeq) n).numerosPila;
		String llamanteAux = "";
		String parametroAux = "";
		BigInteger llam;
		BigInteger par;
		
		while(llamante.size() > 0) {
			llamanteAux += llamante.getTop();
			llamante.pop();
		}
		StringBuilder cadenaSBLlamante = new StringBuilder(llamanteAux);
		llam = new BigInteger(cadenaSBLlamante.reverse().toString());
		
		while(parametro.size() > 0) {
			parametroAux += parametro.getTop();
			parametro.pop();
		}
		StringBuilder cadenaSBParametro = new StringBuilder(parametroAux);
		par = new BigInteger(cadenaSBParametro.reverse().toString());
		
		llam = llam.subtract(par);
		
		String aux = llam.toString();
		
		for (int i=0;i<aux.length();i++) {
			cadena = String.valueOf(aux.charAt(i));
			numerosPila.push(Integer.parseInt(cadena));
			numerosPila2.push(Integer.parseInt(cadena));
		}
	}

	/* Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico parámetro */
	public void subFromValue(Value n) {
		Stack<Integer> llamante = new Stack<Integer>();
		Stack<Integer> parametro = new Stack<Integer>();
		llamante = this.numerosPila;
		parametro = ((ValueSeq) n).numerosPila;
		String llamanteAux = "";
		String parametroAux = "";
		BigInteger llam;
		BigInteger par;
		
		while(llamante.size() > 0) {
			llamanteAux += llamante.getTop();
			llamante.pop();
		}
		StringBuilder cadenaSBLlamante = new StringBuilder(llamanteAux);
		llam = new BigInteger(cadenaSBLlamante.reverse().toString());
		
		while(parametro.size() > 0) {
			parametroAux += parametro.getTop();
			parametro.pop();
		}
		StringBuilder cadenaSBParametro = new StringBuilder(parametroAux);
		par = new BigInteger(cadenaSBParametro.reverse().toString());
		
		llam = par.subtract(llam);
		
		String aux = llam.toString();
		
		for (int i=0;i<aux.length();i++) {
			cadena = String.valueOf(aux.charAt(i));
			numerosPila.push(Integer.parseInt(cadena));
			numerosPila2.push(Integer.parseInt(cadena));
		}
	}

	/* Método que modifica el valor numérico llamante, multiplicándolo por el valor numérico parámetro */
	public void multValue(Value n) {
		if(this.isZero() || ((ValueSeq)n).isZero()) {
			Integer resultado = 0;
			String aux = resultado.toString();
			
			for (int i=0;i<numerosPila.size();i++) {
				numerosPila.pop();
			}
			
			numerosPila.push(Integer.parseInt(aux));
			numerosPila2.push(Integer.parseInt(aux));
			
		}else {
			Stack<Integer> llamante = new Stack<Integer>();
			Stack<Integer> parametro = new Stack<Integer>();
			llamante = this.numerosPila;
			parametro = ((ValueSeq) n).numerosPila;
			String llamanteAux = "";
			String parametroAux = "";
			BigInteger llam;
			BigInteger par;
			
			while(llamante.size() > 0) {
				llamanteAux += llamante.getTop();
				llamante.pop();
			}
			StringBuilder cadenaSBLlamante = new StringBuilder(llamanteAux);
			llam = new BigInteger(cadenaSBLlamante.reverse().toString());
			
			while(parametro.size() > 0) {
				parametroAux += parametro.getTop();
				parametro.pop();
			}
			StringBuilder cadenaSBParametro = new StringBuilder(parametroAux);
			par = new BigInteger(cadenaSBParametro.reverse().toString());
			
			llam = llam.multiply(par);
			
			String aux = llam.toString();
			
			
			
			numerosPila.clear();
			numerosPila2.clear();
			
			for (int i=0;i<aux.length();i++) {
				cadena = String.valueOf(aux.charAt(i));
				numerosPila.push(Integer.parseInt(cadena));
				numerosPila2.push(Integer.parseInt(cadena));
			}
		}
	}

	/* Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro */
	public boolean greater(Value n) {
		Stack<Integer> llamante = new Stack<Integer>();
		Stack<Integer> parametro = new Stack<Integer>();
		llamante = this.numerosPila2;
		parametro = ((ValueSeq) n).numerosPila2;
		String llamanteAux = "";
		String parametroAux = "";
		BigInteger llam;
		BigInteger par;
		
		while(llamante.size() > 0) {
			llamanteAux += llamante.getTop();
			llamante.pop();
		}
		StringBuilder cadenaSBLlamante = new StringBuilder(llamanteAux);
		llam = new BigInteger(cadenaSBLlamante.reverse().toString());
		
		while(parametro.size() > 0) {
			parametroAux += parametro.getTop();
			parametro.pop();
		}
		StringBuilder cadenaSBParametro = new StringBuilder(parametroAux);
		par = new BigInteger(cadenaSBParametro.reverse().toString());
		
		if (llam.compareTo(par)==1) {
			return true;
		}else if(llam.compareTo(par) == 0 || llam.compareTo(par)==-1){ 
			return false;
			}
		return false;
	}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {
		Stack<Integer> aux =new Stack<Integer>(numerosPila);
		int contador = 0;
		
		while(!aux.isEmpty() && contador == 0) {
			contador += aux.getTop();
			aux.pop();
		}
		return contador == 0?true:false;
	}

}
