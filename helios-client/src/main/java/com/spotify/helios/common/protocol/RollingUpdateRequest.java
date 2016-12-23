/*-
 * -\-\-
 * Helios Client
 * --
 * Copyright (C) 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.helios.common.protocol;

import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.helios.common.Json;
import com.spotify.helios.common.descriptors.JobId;
import com.spotify.helios.common.descriptors.RolloutOptions;

public class RollingUpdateRequest {

  private final JobId job;
  private final RolloutOptions rolloutOptions;

  public RollingUpdateRequest(@JsonProperty("job") final JobId job,
                              @JsonProperty("rolloutOptions") final RolloutOptions rolloutOptions) {
    this.job = checkNotNull(job);
    this.rolloutOptions = rolloutOptions;
  }

  public JobId getJob() {
    return job;
  }

  public RolloutOptions getRolloutOptions() {
    return rolloutOptions;
  }

  @Override
  public String toString() {
    return "RollingUpdateRequest{"
           + "job=" + job
           + ", rolloutOptions=" + rolloutOptions
           + '}';
  }

  public String toJsonString() {
    return Json.asStringUnchecked(this);
  }
}
