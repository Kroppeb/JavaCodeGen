package org.quiltmc.javacodegen.types;

public enum PrimitiveTypes implements Type {
	BOOLEAN("boolean", "Boolean"),
	BYTE("byte", "Byte"),
	CHAR("char", "Character"),
	SHORT("short", "Short"),
	INT("int", "Integer"),
	LONG("long", "Long"),
	FLOAT("float", "Float"),
	DOUBLE("double", "Double"),
	;

	public String getPrimitiveName() {
		return this.primitiveName;
	}

	private final String primitiveName;
	private final Boxed boxed;

	PrimitiveTypes(String primitive, String boxed) {
		this.primitiveName = primitive;
		this.boxed = new Boxed(boxed, this);
	}

	public Boxed Box() {
		return this.boxed;
	}


	@Override
	public void javaLike(StringBuilder builder) {
		builder.append(this.primitiveName);
	}

	public record Boxed(String name, PrimitiveTypes type) implements Type {

		@Override
		public void javaLike(StringBuilder builder) {
			builder.append(this.name);
		}
	}
}
