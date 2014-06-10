package edu.umich.soar.parser;

/**
 * The state declaration in a condition; 
 * state represents <code>(state ...)</code>, 
 * impasse represents <code>(impasse ...)</code>,
 * and represents the absence of either in the condition. 
 * 
 * @author Nate Glenn
 *
 */
public enum StateDeclaration {
	STATE, IMPASSE, NONE;
}