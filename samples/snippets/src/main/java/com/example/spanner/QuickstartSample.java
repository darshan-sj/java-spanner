/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_quickstart]
// Imports the Google Cloud client library
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.api.gax.rpc.StatusCode.Code;
import java.util.HashSet;
import java.util.Set;


/**
 * A quick start code for Cloud Spanner. It demonstrates how to setup the Cloud Spanner client and
 * execute a simple query using it against an existing database.
 */
public class QuickstartSample {
  public static void main(String... args) throws Exception {

    if (args.length != 2) {
      System.err.println("Usage: QuickStartSample <instance_id> <database_id>");
      return;
    }
    // Instantiates a client
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();

    Set<Code> retryableCodes = new HashSet<>();
    retryableCodes.add(Code.RESOURCE_EXHAUSTED);
    // Set retryable codes for all API methods
    builder
        .getSpannerStubSettingsBuilder()
        .applyToAllUnaryMethods(
            input -> {
              input.setRetryableCodes(retryableCodes);
              return null;
            });
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetryableCodes(retryableCodes);
    builder.setHost("https://staging-wrenchworks.sandbox.googleapis.com");
    builder.setProjectId("span-cloud-testing");
    SpannerOptions options = builder.build();
    Spanner spanner = options.getService();

    // Name of your instance & database.
    String instanceId = args[0];
    String databaseId = args[1];
    try {
      // Creates a database client
      DatabaseClient dbClient =
          spanner.getDatabaseClient(DatabaseId.of("span-cloud-testing", instanceId, databaseId));

      BatchClient batchClient = spanner.getBatchClient(DatabaseId.of("span-cloud-testing", instanceId, databaseId));

      System.out.println("\n\n spanner dialect " + dbClient.getDialect() + "\n\n");
      // Queries the database
      ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of("SELECT 1"));

      System.out.println("\n\nResults:");
      // Prints the results
      while (resultSet.next()) {
        System.out.printf("%d\n\n", resultSet.getLong(0));
      }

      ResultSet res = dbClient.singleUse().executeQuery(Statement.of("SELECT SingerId from Singers"));

      System.out.println("\n\nSingers Results:\n\n");
      // Prints the results
      while (res.next()) {
        System.out.printf("%d\n\n", res.getLong(0));
      }
    } finally {
      // Closes the client which will free up the resources used
      spanner.close();
    }
  }
}
// [END spanner_quickstart]
