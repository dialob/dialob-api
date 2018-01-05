package io.dialob.api.proto;

public final class ActionsFactory {

  public static final ImmutableAction PREVIOUS_ACTION = ImmutableAction.builder().type(Action.Type.PREVIOUS).build();
  public static final ImmutableAction NEXT_ACTION = ImmutableAction.builder().type(Action.Type.NEXT).build();

  private ActionsFactory() {}

  public static Action answer(String questionId, Object answer) {
    return ImmutableAction.builder().id(questionId).answer(answer).type(Action.Type.ANSWER).build();
  }

  public static Action next() {
    return NEXT_ACTION;
  }

  public static Action previous() {
    return PREVIOUS_ACTION;
  }

  public static Action complete(String questionnaireId) {
    return ImmutableAction.builder().type(Action.Type.COMPLETE).id(questionnaireId).build();
  }

  public static Action gotoPage(String pageId) {
    return ImmutableAction.builder().type(Action.Type.COMPLETE).id(pageId).build();
  }

  public static Action addRow(String groupId) {
    return ImmutableAction.builder().type(Action.Type.ADD_ROW).id(groupId).build();
  }

  public static Action deleteRow(String rowId) {
    return ImmutableAction.builder().type(Action.Type.DELETE_ROW).id(rowId).build();
  }

  public static Action rows(String ...ids) {
    return ImmutableAction.builder().type(Action.Type.ROWS).addIds(ids).build();
  }

  public static Actions actions(String rev, Action ...actions) {
    return ImmutableActions.builder().rev(rev).addActions(actions).build();
  }

  public static Actions actions(Action ...actions) {
    return actions(null, actions);
  }

}
