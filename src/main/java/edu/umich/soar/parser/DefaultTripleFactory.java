package edu.umich.soar.parser;

public class DefaultTripleFactory implements TripleFactory {
	public Triple createTriple(Pair variable,Pair attribute,Pair value,StateDeclaration stateDeclaration,boolean isChecking) {
		return new Triple(variable,attribute,value,stateDeclaration);
	}
	public Triple createTriple(Pair variable,Pair attribute,Pair value,StateDeclaration stateDeclaration,boolean isChecking,boolean isCondition) {
		return new Triple(variable,attribute,value,stateDeclaration, isCondition);
	}
}
