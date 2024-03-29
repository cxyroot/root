package com.jingyougroup.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
	public static void main(String[] args) {
		EventLoopGroup eventLoopGroup =new NioEventLoopGroup();
		try {
			//在服务器端的handler()方法表示对bossGroup起作用，而childHandler表示对wokerGroup起作用
			Bootstrap bootstrap=new Bootstrap();
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer());
			ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",8899).sync();
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
