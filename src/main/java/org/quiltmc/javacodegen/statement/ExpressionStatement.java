package org.quiltmc.javacodegen.statement;

import org.quiltmc.javacodegen.expression.Expression;
import org.quiltmc.javacodegen.vars.VarsEntry;

public class ExpressionStatement implements SimpleSingleCompletingStatement {

	private final VarsEntry vars;
	protected final Expression expression;

	public ExpressionStatement(VarsEntry vars, Expression expression) {
		this.vars = vars;
		this.expression = expression;
		assert expression != null;
	}

	@Override
	public VarsEntry varsFor() {
		return this.vars;
	}

	@Override
	public void javaLike(StringBuilder builder, String indentation) {
		builder.append(indentation);
		this.expression.javaLike(builder);
		builder.append(";\n");
	}

	@Override
	public String toString() {
		return "ExpressionStatement[]";
	}
}
