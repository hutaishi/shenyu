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

package org.apache.shenyu.e2e.model.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.shenyu.e2e.common.IdManagers.Selectors;

import java.io.IOException;

/**
 * Resource data.
 */
public interface ResourceData {
    
    String getId();
    
    String getName();
    
    void setName(String name);

    class IntToStringSerializer extends JsonSerializer<String> {
        
        @Override
        public void serialize(String name, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String id = Selectors.INSTANCE.getIdByName(name);
            jsonGenerator.writeString(id);
        }
    }
}
