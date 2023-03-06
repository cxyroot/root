package com.jingyougroup.first;

import java.net.SocketAddress;
import java.net.URI;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		System.out.println(msg.getClass());
		SocketAddress remoteAddress = ctx.channel().remoteAddress();
		
		Thread.sleep(8000);
		System.out.println(remoteAddress);
		if(msg instanceof HttpRequest) {
			HttpRequest httpRequest =(HttpRequest)msg;
			//String name = httpRequest.getMethod().name();
			//String uri = httpRequest.getUri();
			URI uri=new URI(httpRequest.getUri());
			if("/favicon.ico".equals(uri.getPath())) {
				System.out.println("请求favicon.ico");
				return ;
			}
			System.out.println("channelRead0");
			ByteBuf byteBuf=Unpooled.copiedBuffer("Hello World",CharsetUtil.UTF_8);
			FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
			ctx.writeAndFlush(response);
			
			//ctx.channel().close();
		}
	}
	//父类方法
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		super.handlerAdded(ctx);
	}
	
}
