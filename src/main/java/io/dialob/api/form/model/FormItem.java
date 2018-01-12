package io.dialob.api.form.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Value.Immutable
@JsonSerialize(as = ImmutableFormItem.class)
@JsonDeserialize(as = ImmutableFormItem.class)
@Gson.TypeAdapters
public interface FormItem extends Serializable {

  @NotNull
  String getId();

//  "text",
//   "boolean",
//   "list",
//   "date",
//   "time",
//   "number",
//   "decimal",
//   "multichoice"

  @NotNull
  String getType();

  @Nullable
  Map<String, String> getLabel();

  @Nullable
  Map<String, String> getDescription();

  @Nullable
  String getRequired();

  @Nullable
  Boolean getReadOnly();

  @Nullable
  List<String> getItems();

  @Nullable
  List<String> getClassName();

  @Nullable
  String getActiveWhen();

  @Nullable
  List<Validation> getValidations();

  @Nullable
  String getValueSetId();

  @Nullable
  Object getDefaultValue();
}
