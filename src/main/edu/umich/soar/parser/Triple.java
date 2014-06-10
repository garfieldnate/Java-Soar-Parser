package edu.umich.soar.parser;

public class Triple {
	// DataMembers
	Pair d_variable;
	Pair d_attribute;
	Pair d_value;
	StateDeclaration stateDeclaration = StateDeclaration.NONE;
	int d_line;
  boolean d_condition = true;   // for keeping track of whether a condition or action
                              // default is condition

	// NOT IMPLEMENTED
	private Triple() {}
	
	// Constructors
	public Triple(Pair variable,Pair attribute,Pair value) {
		d_variable = variable;
		d_attribute = attribute;
		d_value = value;
	}

	public Triple(Pair variable,Pair attribute,Pair value, StateDeclaration stateDeclaration) {
		this(variable,attribute,value);
		this.stateDeclaration = stateDeclaration;
	}

  public Triple(Pair variable,Pair attribute,Pair value, StateDeclaration stateDeclaration, boolean in_condition) {
		this(variable,attribute,value, stateDeclaration);
		d_condition = in_condition;
	}

	// Accessors
	public StateDeclaration stateDeclaration() {
		return stateDeclaration;
	}
	
	public Pair getVariable() {
		return d_variable;
	}
	
	public Pair getAttribute() {
		return d_attribute;
	}
	
	public Pair getValue() {
		return d_value;
	}
	
	public int getLine() {
		if(d_value.getLine() != -1)
			return d_value.getLine();
		else if(d_attribute.getLine() != -1)
			return d_attribute.getLine();
		else
			return d_variable.getLine();
	}

  public boolean isCondition() {
    return d_condition;
  }

  public boolean isAction() {
    return !d_condition;
  }

  void setAsCondition() {
    d_condition = true;
  }

  void setAsAction() {
    d_condition = false;
  }
	
	public String toString() {
		return "(" + d_variable.getString() + "," + d_attribute.getString() + "," + d_value.getString() + ")";
	}
}
