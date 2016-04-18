package core.conditions;

import core.conditions.element.*;

public class ElementConditions {

    public static ElementCondition visible() {
        return new Visible();
    }

    public static ElementCondition present(){return new Present();}
}
