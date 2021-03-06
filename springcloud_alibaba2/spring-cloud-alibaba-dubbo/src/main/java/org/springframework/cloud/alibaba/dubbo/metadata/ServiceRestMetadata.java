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
package org.springframework.cloud.alibaba.dubbo.metadata;

import java.util.Set;

/**
 * Service Rest Metadata
 *
 * @author Wujun
 * @see RestMethodMetadata
 */
public class ServiceRestMetadata {

    /**
     * 服务名
     */
    private String name;
    /**
     * Rest 方法元数据
     */
    private Set<RestMethodMetadata> meta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RestMethodMetadata> getMeta() {
        return meta;
    }

    public void setMeta(Set<RestMethodMetadata> meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceRestMetadata that = (ServiceRestMetadata) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return meta != null ? meta.equals(that.meta) : that.meta == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (meta != null ? meta.hashCode() : 0);
        return result;
    }
}
