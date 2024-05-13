package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder {
	
	private CustomStack<Integer> stack;
	
	public NumberAscOrder(CustomStack<Integer> stack) {
		this.stack = stack;
	}
	
	public List<Integer> sort() throws StackEmptyException{
		List<Integer> listaordenada = new ArrayList<>();
		
		while (!stack.isEmpty()) {
			listaordenada.add(stack.pop());
		}
		
		Collections.sort(listaordenada);
		return listaordenada;
	}
	

}
