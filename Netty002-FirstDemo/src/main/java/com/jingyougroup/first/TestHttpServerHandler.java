package com.jingyougroup.first;

import java.net.URI;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		if(msg instanceof HttpRequest) {
			HttpRequest httpRequest =(HttpRequest)msg;
			//String name = httpRequest.getMethod().name();
			//String uri = httpRequest.getUri();
			URI uri=new URI(httpRequest.getUri());
			if("/favicon.ico".equals(uri.getPath())) {
				System.out.println("«Î«Ûfavicon.ico");
				return ;
			}
			System.out.println("channelRead0");
			ByteBuf byteBuf=Unpooled.copiedBuffer("Hello World",CharsetUtil.UTF_8);
			FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
			ctx.writeAndFlush(response);
		}
	}

}
