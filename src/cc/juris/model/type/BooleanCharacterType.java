package cc.juris.model.type;

import org.hibernate.type.CharBooleanType;

@SuppressWarnings("deprecation")
public class BooleanCharacterType extends CharBooleanType {

	private static final long serialVersionUID = 1L;

	protected BooleanCharacterType(char characterValueTrue, char characterValueFalse) {
		super(characterValueTrue, characterValueFalse);
	}
	
	public BooleanCharacterType() {
		super('1', '0');
	}

}
