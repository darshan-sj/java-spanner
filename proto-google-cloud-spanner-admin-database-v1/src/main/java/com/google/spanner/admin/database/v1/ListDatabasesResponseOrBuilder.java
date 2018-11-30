// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/spanner/admin/database/v1/spanner_database_admin.proto

package com.google.spanner.admin.database.v1;

public interface ListDatabasesResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.database.v1.ListDatabasesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Databases that matched the request.
   * </pre>
   *
   * <code>repeated .google.spanner.admin.database.v1.Database databases = 1;</code>
   */
  java.util.List<com.google.spanner.admin.database.v1.Database> getDatabasesList();
  /**
   *
   *
   * <pre>
   * Databases that matched the request.
   * </pre>
   *
   * <code>repeated .google.spanner.admin.database.v1.Database databases = 1;</code>
   */
  com.google.spanner.admin.database.v1.Database getDatabases(int index);
  /**
   *
   *
   * <pre>
   * Databases that matched the request.
   * </pre>
   *
   * <code>repeated .google.spanner.admin.database.v1.Database databases = 1;</code>
   */
  int getDatabasesCount();
  /**
   *
   *
   * <pre>
   * Databases that matched the request.
   * </pre>
   *
   * <code>repeated .google.spanner.admin.database.v1.Database databases = 1;</code>
   */
  java.util.List<? extends com.google.spanner.admin.database.v1.DatabaseOrBuilder>
      getDatabasesOrBuilderList();
  /**
   *
   *
   * <pre>
   * Databases that matched the request.
   * </pre>
   *
   * <code>repeated .google.spanner.admin.database.v1.Database databases = 1;</code>
   */
  com.google.spanner.admin.database.v1.DatabaseOrBuilder getDatabasesOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * `next_page_token` can be sent in a subsequent
   * [ListDatabases][google.spanner.admin.database.v1.DatabaseAdmin.ListDatabases] call to fetch more
   * of the matching databases.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   */
  java.lang.String getNextPageToken();
  /**
   *
   *
   * <pre>
   * `next_page_token` can be sent in a subsequent
   * [ListDatabases][google.spanner.admin.database.v1.DatabaseAdmin.ListDatabases] call to fetch more
   * of the matching databases.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   */
  com.google.protobuf.ByteString getNextPageTokenBytes();
}
