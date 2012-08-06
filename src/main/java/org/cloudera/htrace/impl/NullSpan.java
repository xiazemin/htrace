/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cloudera.htrace.impl;

import java.util.Collections;
import java.util.Map;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.cloudera.htrace.Span;

/**
 * A Span that does nothing. Used to avoid returning and checking for nulls when
 * we are not tracing.
 * 
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public class NullSpan implements Span {

  private static NullSpan instance = new NullSpan();

  // No need to ever have more than one NullSpan.
  public static NullSpan getInstance() {
    return instance;
  }

  private NullSpan() {
  }

  @Override
  public long getAccumulatedMillis() {
    return 0;
  }

  @Override
  public String getDescription() {
    return "NullSpan";
  }

  @Override
  public long getStartTimeMillis() {
    return 0;
  }

  @Override
  public long getStopTimeMillis() {
    return 0;
  }

  @Override
  public Span getParent() {
    return null;
  }

  @Override
  public long getParentId() {
    return -1;
  }

  @Override
  public boolean isRunning() {
    return false;
  }

  @Override
  public long getSpanId() {
    return -1;
  }

  @Override
  public void stop() {
  }

  @Override
  public long getTraceId() {
    return -1;
  }

  @Override
  public Span child(String description) {
    return this;
  }

  @Override
  public void addAnnotation(byte[] key, byte[] value) {
  }

  @Override
  public String toString() {
    return "Not Tracing";
  }

  @Override
  public Map<byte[], byte[]> getAnnotations() {
    return Collections.emptyMap();
  }

  @Override
  public String getProcessId() {
    return "";
  }

}
