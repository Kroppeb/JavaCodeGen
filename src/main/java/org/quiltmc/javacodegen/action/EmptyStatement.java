package org.quiltmc.javacodegen.action;

public class EmptyStatement implements SimpleSingleCompletingStatement {
	// could be a singleton I think

	@Override
	public boolean completesNormally() {
		return true;
	}

	@Override
	public String toString() {
		return "EmptyStatement[]";
	}
}
