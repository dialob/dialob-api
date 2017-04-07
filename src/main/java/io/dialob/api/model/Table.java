/*
 * Copyright 2017 ReSys OÜ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dialob.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.join;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table implements Serializable {

  private String tableId;

  private List<String> rows;

  public Table withTableId(String tableId) {
    this.tableId = tableId;
    return this;
  }

  public Table withRows(List<String> rows) {
    this.rows = rows;
    return this;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public String getTableId() {
    return tableId;
  }

  public void setRows(List<String> rows) {
    this.rows = rows;
  }

  public List<String> getRows() {
    return rows;
  }

  @Override
  public String toString() {
    return "{\"tableId\":\"" + tableId + "\"" +
      (rows != null && !rows.isEmpty() ? ",\"rows\":[\"" + join(rows, "\",\"") + "\"]" : "") +
      "}";
  }
}
