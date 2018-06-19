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

package io.bootique.kafka.client_0_8;


import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import io.bootique.kafka.client_0_8.consumer.ConsumerConfigFactory;
import io.bootique.kafka.client_0_8.consumer.DefaultConsumerFactory;

import java.util.HashMap;
import java.util.Map;

// separating factory methods for producer and consumer ... only one may be needed in reality
// TODO: implement producers
@BQConfig
public class KafkaClient_0_8_Factory {

    private Map<String, ConsumerConfigFactory> consumers;

    public DefaultConsumerFactory createConsumerFactory() {
        Map<String, Map<String, String>> configMap = new HashMap<>();

        if(consumers != null) {
            consumers.forEach((name, factory) -> configMap.put(name, factory.createConsumerConfig()));
        }

        return new DefaultConsumerFactory(configMap);
    }

    @BQConfigProperty
    public void setConsumers(Map<String, ConsumerConfigFactory> consumers) {
        this.consumers = consumers;
    }
}
