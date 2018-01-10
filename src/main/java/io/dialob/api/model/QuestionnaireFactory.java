package io.dialob.api.model;

public final class QuestionnaireFactory {

  private QuestionnaireFactory() {}

  public static Answer answer(String id, Object value) {
    return ImmutableAnswer.builder().id(id).value(value).build();
  }

  public static ContextValue contextValue(String id, Object value) {
    return ImmutableContextValue.builder().id(id).value(value).build();
  }

  public static VariableValue variableValue(String id, Object value) {
    return ImmutableVariableValue.builder().id(id).value(value).build();
  }

  public static Table table(String tableId, Iterable<String> rows) {
    return ImmutableTable.builder().tableId(tableId).rows(rows).build();
  }

  public static Questionnaire questionnaire(String id, String formId) {
    return ImmutableQuestionnaire.builder().id(id)
          .metadata(ImmutableMetadata.builder().formId(formId).build()).build();
  }

}
