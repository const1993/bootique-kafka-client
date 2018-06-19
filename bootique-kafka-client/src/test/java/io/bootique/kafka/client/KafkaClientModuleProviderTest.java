/*
 * Licensed to ObjectStyle LLC under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ObjectStyle LLC licenses
 * this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.bootique.kafka.client;

import io.bootique.test.junit.BQModuleProviderChecker;
import org.junit.Test;

public class KafkaClientModuleProviderTest {

    @Test
    public void testAutoLoadable() {
        BQModuleProviderChecker.testAutoLoadable(KafkaClientModuleProvider.class);
    }

    @Test
    public void testMetadata() {
        BQModuleProviderChecker.testMetadata(KafkaClientModuleProvider.class);
    }
}
