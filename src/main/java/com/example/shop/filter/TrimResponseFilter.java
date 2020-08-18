package com.example.shop.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebFilter(filterName="TrimResponseFilter")
public class TrimResponseFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		TrimResponse response = new TrimResponse(resp);
		chain.doFilter(req, response);
		response.complete();
	}

	private static class TrimResponse extends HttpServletResponseWrapper {
		private TrimProxyWriter trimProxyWriter;
		private TrimResponse(HttpServletResponse response) throws IOException {
			super(response);
			trimProxyWriter = new TrimProxyWriter(response.getWriter());
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(trimProxyWriter);
		}
		
		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return new ServletOutputStream(){
				@Override
				public boolean isReady() {
					return false;
				}
				@Override
				public void setWriteListener(WriteListener writeListener) {
				}
				@Override
				public void write(int b) throws IOException {
					trimProxyWriter.write(b);
				}
			};
		}
		
		private void complete() throws IOException {
			setContentLength(trimProxyWriter.getLength());
			trimProxyWriter.complete();
		}
	}
	

	private static class TrimProxyWriter extends Writer {
		private final Writer wr;
		private int length;
		private TrimProxyWriter(Writer wr) {
			super();
			this.wr = wr;
			this.length = 0;
		}
		@Override
		public void write(int c) throws IOException {
			processChar((char)c);
		}
		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			for (int i = off; i < len; i++) {
				processChar(cbuf[i]);
			}
		}
		@Override
		public void write(String str, int off, int len) throws IOException {
			for (int i = off; i < len; i++) {
				processChar(str.charAt(i));
			}
		}
		private void processChar(char ch) throws IOException {
			if (ch != '\t' && ch != '\r' && ch != '\n') {
				wr.write(ch);
				length++;
			}
		}
		@Override
		public void flush() throws IOException {
		}
		@Override
		public void close() throws IOException {
		}
		private int getLength() {
			return length;
		}
		private void complete() throws IOException {
			wr.flush();
			wr.close();
		}
	}
}
