package com.optimum.recommendation.interceptor;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HttpHeaderInterceptor implements ClientHttpRequestInterceptor {

	@Value("${napster.api.key}")
	String apiKey;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		URI uri = UriComponentsBuilder.fromHttpRequest(request).queryParam("apikey", apiKey).build().toUri();

		HttpRequest modifiedRequest = new HttpRequestWrapper(request) {

			@Override
			public URI getURI() {
				return uri;
			}
		};
		return execution.execute(modifiedRequest, body);
	}

}
