package es.uned.lsi.eped.pract2018_2019;
import es.uned.lsi.eped.DataStructures.Stack;
import es.uned.lsi.eped.DataStructures.BTreeIF;

public class StackMachine {
	
	private BTreeIF<Node> arbol;
	private Operand operando1;
	private Operand operando2;
	private Operator operador;
	private Stack<Node> pila;
	
	public StackMachine() {
		pila=new Stack<Node>();
	}
	
	public Operand execute(SynTree syn) {	
		arbol = syn.getSynTree();
		recorrerArbol(arbol, pila);
		return ((Operand) pila.getTop());		
		}
		
	public void recorrerArbol(BTreeIF<Node> arbol, Stack<Node> pila) {
		if(!arbol.isEmpty()) {
			
			if ( arbol.getLeftChild() != null ) { 
				recorrerArbol(arbol.getLeftChild(),pila); 
			}
			if ( arbol.getRightChild() != null ) { 
				recorrerArbol(arbol.getRightChild(),pila); 
			}
			
			if (arbol.getRoot().getNodeType() == Node.NodeType.OPERAND) {
				pila.push(arbol.getRoot());
			}else {
				operador = (Operator)arbol.getRoot();
				
				if(operador.getOperatorType() == Operator.OperatorType.ADD) {
					operando2 = (Operand) pila.getTop();
					pila.pop();
					operando1 = (Operand) pila.getTop();
					pila.pop();
					operando1.add(operando2);
					pila.push(operando1);
				}else if(operador.getOperatorType() == Operator.OperatorType.SUB) {
					operando2 = (Operand) pila.getTop();
					pila.pop();
					operando1 = (Operand) pila.getTop();
					pila.pop();
					operando1.sub(operando2);
					pila.push(operando1);
				}else if(operador.getOperatorType() == Operator.OperatorType.MULT) {
					operando2 = (Operand) pila.getTop();
					pila.pop();
					operando1 = (Operand) pila.getTop();
					pila.pop();
					operando1.mult(operando2);
					pila.push(operando1);
				}
			}
		}
	}
}
	