/**
 *  Licensed to ObjectStyle LLC under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ObjectStyle LLC licenses
 *  this file to you under the Apache License, Version 2.0 (the
 *  “License”); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package io.bootique.kafka.client;

import io.bootique.kafka.client.consumer.ConsumerConfig;
import io.bootique.kafka.client.producer.ProducerConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;

/**
 * An injectable service that helps to create Kafka producers and consumers based on Bootique configuration and
 * user-provided settings.
 *
 * @since 0.2
 */
public interface KafkaClientFactory {

    /**
     * Creates and returns a {@link Consumer} by merging default Bootique configuration with settings provided in a
     * {@link ConsumerConfig} argument. Uses default Kafka cluster connection information (default == single configuration
     * found in Bootique; if none or more than one exists, an exception is thrown). Returned Consumer needs to be
     * closed by the calling code when it is no longer in use.
     *
     * @param config Configuration of consumer specific to the given method call.
     * @param <K>    Consumed message key type.
     * @param <V>    Consumed message value type.
     * @return a new instance of Consumer.
     */
    <K, V> Consumer<K, V> createConsumer(ConsumerConfig<K, V> config);

    /**
     * Creates and returns a {@link Consumer} by merging default Bootique configuration with settings provided in a
     * {@link ConsumerConfig} argument. Returned Consumer needs to be closed by the calling code when it is no longer
     * in use.
     *
     * @param clusterName symbolic configuration name for the Kafka cluser coming from configuration.
     * @param config      Configuration of consumer specific to the given method call.
     * @param <K>         Consumed message key type.
     * @param <V>         Consumed message value type.
     * @return a new instance of Consumer.
     */
    <K, V> Consumer<K, V> createConsumer(String clusterName, ConsumerConfig<K, V> config);

    <K, V> Producer<K, V> createProducer(ProducerConfig<K, V>config);

    <K, V> Producer<K, V> createProducer(String clusterName, ProducerConfig<K, V>config);
}
