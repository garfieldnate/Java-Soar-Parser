package edu.umich.soar.parser;

import java.util.*;

public final class ConditionForOneIdentifier {
	// Data Members
	private StateDeclaration state;
	private Pair d_variable;
	private List d_attributeValueTests = new LinkedList();
	
	// Constructor
	public ConditionForOneIdentifier(StateDeclaration state, Pair variable) {
		d_variable = variable;
		this.state = state;
	}
		
	// Accessor
	public final StateDeclaration stateDeclaration() {
		return state;
	}
	
	public final Pair getVariable() {
		return d_variable;
	}
	
	public final void add(AttributeValueTest avt) {
		d_attributeValueTests.add(avt);
	}
	
	public final Iterator getAttributeValueTests() {
		return d_attributeValueTests.iterator();
	}
}
