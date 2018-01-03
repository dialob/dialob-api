package io.dialob.api.proto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dialob.api.model.Action;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableActions.class)
@JsonDeserialize(as = ImmutableActions.class)
@Gson.TypeAdapters
public interface Actions extends Serializable {

  @Nullable String getPrevRev();

  @Nullable String getNextRev();

  @Nullable List<Action> actions();

}
