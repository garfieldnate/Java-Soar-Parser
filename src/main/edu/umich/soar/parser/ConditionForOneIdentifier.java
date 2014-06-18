package edu.umich.soar.parser;

import java.util.*;

public final class ConditionForOneIdentifier {
	// Data Members
	private StateDeclaration state;
	private Test d_test;
	private List d_attributeValueTests = new LinkedList();
	
	// Constructor
	public ConditionForOneIdentifier(StateDeclaration state, Test test) {
		d_test = test;
		this.state = state;
	}
		
	// Accessor
	public final StateDeclaration stateDeclaration() {
		return state;
	}
	
	public final Test getTest() {
		return d_test;
	}
	
	public final void add(AttributeValueTest avt) {
		d_attributeValueTests.add(avt);
	}
	
	public final Iterator getAttributeValueTests() {
		return d_attributeValueTests.iterator();
	}

	public Pair getVariable() {
		throw new UnsupportedOperationException("TODO: needs to extract the bound variable from the starting test");
	}
}
