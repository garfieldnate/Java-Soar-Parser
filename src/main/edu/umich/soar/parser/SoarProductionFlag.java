package edu.umich.soar.parser;

/**
 * Represents all possible types of Soar production flags.
 * @author Nate Glenn
 *
 */
public enum SoarProductionFlag {
	isupport("i-support"),
	osupport("o-support"),
	chunk("chunk"),
	def("default"),
	interrupt("interrupt"),
	template("template"),
	monitor("monitor");
	
	String name;
	private SoarProductionFlag(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public static SoarProductionFlag getFlagByName(String name){
		for (SoarProductionFlag f : SoarProductionFlag.values()) {
			if (f.getName().equals(name)) {
				return f;
			}
		}
		throw new IllegalArgumentException("\"" + name
				+ "\" isn't a known production flag name");
	}
}