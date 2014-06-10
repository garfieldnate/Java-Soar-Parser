package edu.umich.soar.parser;

public interface TripleFactory {
	Triple createTriple(Pair variable,Pair attribute,Pair value,StateDeclaration stateDeclaration,boolean isChecking);
  Triple createTriple(Pair variable,Pair attribute,Pair value,StateDeclaration stateDeclaration,boolean isChecking,boolean isCondition);
}
