package org.quiltmc.javacodegen.action;

import java.util.ArrayList;
import java.util.List;

public class Scope implements Statement {
	List<Statement> statements = new ArrayList<>();

	public void AddStatement(Statement statement) {
		this.statements.add(statement);
	}

	@Override
	public boolean completesNormally() {
		if (this.statements.isEmpty()) {
			return true;
		}

		return this.statements.get(this.statements.size() - 1).completesNormally();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder().append("Scope[").append("statements={");
		for (Statement statement : this.statements) {
			builder.append("\n").append(statement);
		}
		if(!this.statements.isEmpty()){
			builder.append("\n");
		}
		builder.append("}]");
		return builder.toString();
	}
}
