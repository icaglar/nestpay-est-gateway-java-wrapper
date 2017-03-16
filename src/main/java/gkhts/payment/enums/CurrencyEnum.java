package gkhts.payment.enums;


public enum CurrencyEnum{
	TL("949"),
	USD("840");
	
	public String name;

	CurrencyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public static CurrencyEnum fromString(String name) {
        if (name != null) {
            for (CurrencyEnum objType : CurrencyEnum.values()) {
                if (name.equalsIgnoreCase(objType.name)) {
                    return objType;
                }
            }
        }
        return null;
    }
	
}