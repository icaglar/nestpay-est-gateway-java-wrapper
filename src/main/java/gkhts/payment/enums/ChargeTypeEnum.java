package gkhts.payment.enums;


public enum ChargeTypeEnum{
	AUTH("Auth"),
	PREAUTH("PreAuth"),
	POSTAUTH("PostAuth"),
	CREDIT("Credit");
	
	public String name;

	ChargeTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public static ChargeTypeEnum fromString(String name) {
        if (name != null) {
            for (ChargeTypeEnum objType : ChargeTypeEnum.values()) {
                if (name.equalsIgnoreCase(objType.name)) {
                    return objType;
                }
            }
        }
        return null;
    }
	
}