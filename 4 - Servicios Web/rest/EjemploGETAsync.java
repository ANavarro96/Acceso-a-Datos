package rest;
/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
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
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;


public class EjemploGETAsync {




	    public static void main(final String[] args) throws Exception {
	        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
	        try {
	            httpclient.start();
	            HttpGet request = new HttpGet("http://httpbin.org/get");
	            
	            Future<HttpResponse> future = httpclient.execute(request, null);
	            HttpResponse response = future.get();
	            System.out.println("Response: " + response.getStatusLine());
	        } finally {
	            httpclient.close();
	        }
	        System.out.println("Done");
	    
	}

}
