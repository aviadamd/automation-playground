package base.utilities;

import base.baseUtilities.Base;

public class UiUtilities extends Base {

    public UiActions uiActions() { return new UiActions(); }
    public Verifications verifications() { return new Verifications(); }
    public JavaScriptUtil jsUtil() { return new JavaScriptUtil(); }
}
