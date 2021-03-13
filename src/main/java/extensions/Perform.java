package extensions;

import utilities.Base;

import java.util.function.BiConsumer;

public class Perform extends Base {

    public static void perform(String text, BiConsumer<UiActions,Verfications> actionsConsumer) {
        UiActions uiActions = new UiActions();
        Verfications verfications = new Verfications();
        System.out.println(text);
        actionsConsumer.accept(uiActions, verfications);
    }

}
