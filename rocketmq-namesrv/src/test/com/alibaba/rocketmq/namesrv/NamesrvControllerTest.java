package com.alibaba.rocketmq.namesrv;

import com.alibaba.rocketmq.common.namesrv.NamesrvConfig;
import com.alibaba.rocketmq.remoting.netty.NettyServerConfig;
import org.junit.Test;

/**
 * {@link NamesrvController}单元测试
 * 皮皮虾
 * Created by yunai on 2017/3/25.
 */
public class NamesrvControllerTest {

    /**
     * namesrv 启动
     */
    @Test
    public void testStart() throws Exception {
        final NamesrvConfig namesrvConfig = new NamesrvConfig();
        final NettyServerConfig nettyServerConfig = new NettyServerConfig();
        nettyServerConfig.setListenPort(9876);
        NamesrvController namesrvController = new NamesrvController(namesrvConfig, nettyServerConfig);
        namesrvController.initialize();
        namesrvController.start();
        Thread.sleep(Long.MAX_VALUE);
    }

}
