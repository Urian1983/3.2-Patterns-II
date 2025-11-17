package level1.model;

public class Base {
    private BaseType baseType;

    public Base(BaseType baseType) {
        this.baseType = baseType;
    }

    public BaseType getBaseType() {
        return baseType;
    }

    public enum BaseType{
        SMALL,
        STANDARD,
        BIG,
        XXL;
    }

}
