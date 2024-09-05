//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_import

import 'package:one_of_serializer/any_of_serializer.dart';
import 'package:one_of_serializer/one_of_serializer.dart';
import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:built_value/standard_json_plugin.dart';
import 'package:built_value/iso_8601_date_time_serializer.dart';
import 'package:openapi/src/date_serializer.dart';
import 'package:openapi/src/model/date.dart';

import 'package:openapi/src/model/admin_user_dto.dart';
import 'package:openapi/src/model/app_user_dto.dart';
import 'package:openapi/src/model/gov_official_content_dto.dart';
import 'package:openapi/src/model/jwt_token.dart';
import 'package:openapi/src/model/key_and_password_vm.dart';
import 'package:openapi/src/model/login_vm.dart';
import 'package:openapi/src/model/managed_user_vm.dart';
import 'package:openapi/src/model/password_change_dto.dart';
import 'package:openapi/src/model/report_details_dto.dart';
import 'package:openapi/src/model/report_header_dto.dart';
import 'package:openapi/src/model/review_dto.dart';
import 'package:openapi/src/model/reward_dto.dart';
import 'package:openapi/src/model/user.dart';
import 'package:openapi/src/model/user_dto.dart';

part 'serializers.g.dart';

@SerializersFor([
  AdminUserDTO,
  AppUserDTO,
  GovOfficialContentDTO,
  JWTToken,
  KeyAndPasswordVM,
  LoginVM,
  ManagedUserVM,
  PasswordChangeDTO,
  ReportDetailsDTO,
  ReportHeaderDTO,
  ReviewDTO,
  RewardDTO,
  User,
  UserDTO,
])
Serializers serializers = (_$serializers.toBuilder()
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(ReviewDTO)]),
        () => ListBuilder<ReviewDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(AppUserDTO)]),
        () => ListBuilder<AppUserDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(int)]),
        () => ListBuilder<int>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(DateTime)]),
        () => ListBuilder<DateTime>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(RewardDTO)]),
        () => ListBuilder<RewardDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(AdminUserDTO)]),
        () => ListBuilder<AdminUserDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(GovOfficialContentDTO)]),
        () => ListBuilder<GovOfficialContentDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(ReportDetailsDTO)]),
        () => ListBuilder<ReportDetailsDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(String)]),
        () => ListBuilder<String>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(UserDTO)]),
        () => ListBuilder<UserDTO>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(double)]),
        () => ListBuilder<double>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(ReportHeaderDTO)]),
        () => ListBuilder<ReportHeaderDTO>(),
      )
      ..add(const OneOfSerializer())
      ..add(const AnyOfSerializer())
      ..add(const DateSerializer())
      ..add(Iso8601DateTimeSerializer()))
    .build();

Serializers standardSerializers =
    (serializers.toBuilder()..addPlugin(StandardJsonPlugin())).build();
