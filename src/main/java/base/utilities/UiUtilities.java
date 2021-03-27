package base.utilities;

import base.baseUtilities.BaseOperations;

public class UiUtilities extends BaseOperations {

    public UiActions uiActions() { return new UiActions(); }
    public Verfications verfications() { return new Verfications(); }
    public JavaScriptUtil jsUtil() { return new JavaScriptUtil(); }
}
