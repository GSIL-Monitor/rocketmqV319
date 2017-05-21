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

package com.alibaba.rocketmq.broker;

import com.alibaba.rocketmq.common.BrokerConfig;
import com.alibaba.rocketmq.common.MQVersion;
import com.alibaba.rocketmq.remoting.netty.NettyClientConfig;
import com.alibaba.rocketmq.remoting.netty.NettyServerConfig;
import com.alibaba.rocketmq.remoting.protocol.RemotingCommand;
import com.alibaba.rocketmq.store.config.FlushDiskType;
import com.alibaba.rocketmq.store.config.MessageStoreConfig;
import org.junit.Test;

import java.io.File;

/**
 * {@link BrokerController}单元测试
 * 小龙虾，起飞
 */
public class BrokerControllerTest {

    /**
     * broker 启动
     */
    @Test
    public void testBrokerRestart() throws Exception {
        System.setProperty("user.home", System.getProperty("user.home") + File.separator + "broker" + File.separator + "v3_1_4");

        // 设置版本号
        System.setProperty(RemotingCommand.RemotingVersionKey, Integer.toString(MQVersion.CurrentVersion));
        //
        final NettyServerConfig nettyServerConfig = new NettyServerConfig();
        nettyServerConfig.setListenPort(10911);
        //
        final BrokerConfig brokerConfig = new BrokerConfig();
        brokerConfig.setBrokerName("broker-a");
        brokerConfig.setNamesrvAddr("127.0.0.1:9876");
        //
        final MessageStoreConfig messageStoreConfig = new MessageStoreConfig();
        messageStoreConfig.setDeleteWhen("04");
        messageStoreConfig.setFileReservedTime(48);
        messageStoreConfig.setFlushDiskType(FlushDiskType.ASYNC_FLUSH);


//        BrokerPathConfigHelper.setBrokerConfigPath("/Users/yunai/百度云同步盘/开发/Javascript/Story/incubator-rocketmq/conf/broker.conf");
        // broker 启动
        BrokerController brokerController = new BrokerController(//
                brokerConfig, //
                nettyServerConfig, //
                new NettyClientConfig(), //
                messageStoreConfig);
        brokerController.initialize();
        brokerController.start();
//        brokerController.getTopicConfigManager().createTopicInSendMessageBackMethod()
        Thread.sleep(Long.MAX_VALUE);
    }

}
