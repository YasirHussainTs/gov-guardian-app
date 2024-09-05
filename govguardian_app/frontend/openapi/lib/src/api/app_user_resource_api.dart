//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/app_user_dto.dart';

class AppUserResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const AppUserResourceApi(this._dio, this._serializers);

  /// countAppUsers
  /// 
  ///
  /// Parameters:
  /// * [idPeriodGreaterThan] 
  /// * [idPeriodLessThan] 
  /// * [idPeriodGreaterThanOrEqual] 
  /// * [idPeriodLessThanOrEqual] 
  /// * [idPeriodEquals] 
  /// * [idPeriodNotEquals] 
  /// * [idPeriodSpecified] 
  /// * [idPeriodIn] 
  /// * [idPeriodNotIn] 
  /// * [emailPeriodContains] 
  /// * [emailPeriodDoesNotContain] 
  /// * [emailPeriodEquals] 
  /// * [emailPeriodNotEquals] 
  /// * [emailPeriodSpecified] 
  /// * [emailPeriodIn] 
  /// * [emailPeriodNotIn] 
  /// * [addressPeriodContains] 
  /// * [addressPeriodDoesNotContain] 
  /// * [addressPeriodEquals] 
  /// * [addressPeriodNotEquals] 
  /// * [addressPeriodSpecified] 
  /// * [addressPeriodIn] 
  /// * [addressPeriodNotIn] 
  /// * [phonePeriodContains] 
  /// * [phonePeriodDoesNotContain] 
  /// * [phonePeriodEquals] 
  /// * [phonePeriodNotEquals] 
  /// * [phonePeriodSpecified] 
  /// * [phonePeriodIn] 
  /// * [phonePeriodNotIn] 
  /// * [genderPeriodContains] 
  /// * [genderPeriodDoesNotContain] 
  /// * [genderPeriodEquals] 
  /// * [genderPeriodNotEquals] 
  /// * [genderPeriodSpecified] 
  /// * [genderPeriodIn] 
  /// * [genderPeriodNotIn] 
  /// * [departmentPeriodContains] 
  /// * [departmentPeriodDoesNotContain] 
  /// * [departmentPeriodEquals] 
  /// * [departmentPeriodNotEquals] 
  /// * [departmentPeriodSpecified] 
  /// * [departmentPeriodIn] 
  /// * [departmentPeriodNotIn] 
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [latitudePeriodGreaterThan] 
  /// * [latitudePeriodLessThan] 
  /// * [latitudePeriodGreaterThanOrEqual] 
  /// * [latitudePeriodLessThanOrEqual] 
  /// * [latitudePeriodEquals] 
  /// * [latitudePeriodNotEquals] 
  /// * [latitudePeriodSpecified] 
  /// * [latitudePeriodIn] 
  /// * [latitudePeriodNotIn] 
  /// * [longitudePeriodGreaterThan] 
  /// * [longitudePeriodLessThan] 
  /// * [longitudePeriodGreaterThanOrEqual] 
  /// * [longitudePeriodLessThanOrEqual] 
  /// * [longitudePeriodEquals] 
  /// * [longitudePeriodNotEquals] 
  /// * [longitudePeriodSpecified] 
  /// * [longitudePeriodIn] 
  /// * [longitudePeriodNotIn] 
  /// * [userTypePeriodEquals] 
  /// * [userTypePeriodNotEquals] 
  /// * [userTypePeriodSpecified] 
  /// * [userTypePeriodIn] 
  /// * [userTypePeriodNotIn] 
  /// * [userIdPeriodGreaterThan] 
  /// * [userIdPeriodLessThan] 
  /// * [userIdPeriodGreaterThanOrEqual] 
  /// * [userIdPeriodLessThanOrEqual] 
  /// * [userIdPeriodEquals] 
  /// * [userIdPeriodNotEquals] 
  /// * [userIdPeriodSpecified] 
  /// * [userIdPeriodIn] 
  /// * [userIdPeriodNotIn] 
  /// * [reviewsIdPeriodGreaterThan] 
  /// * [reviewsIdPeriodLessThan] 
  /// * [reviewsIdPeriodGreaterThanOrEqual] 
  /// * [reviewsIdPeriodLessThanOrEqual] 
  /// * [reviewsIdPeriodEquals] 
  /// * [reviewsIdPeriodNotEquals] 
  /// * [reviewsIdPeriodSpecified] 
  /// * [reviewsIdPeriodIn] 
  /// * [reviewsIdPeriodNotIn] 
  /// * [rewardsIdPeriodGreaterThan] 
  /// * [rewardsIdPeriodLessThan] 
  /// * [rewardsIdPeriodGreaterThanOrEqual] 
  /// * [rewardsIdPeriodLessThanOrEqual] 
  /// * [rewardsIdPeriodEquals] 
  /// * [rewardsIdPeriodNotEquals] 
  /// * [rewardsIdPeriodSpecified] 
  /// * [rewardsIdPeriodIn] 
  /// * [rewardsIdPeriodNotIn] 
  /// * [govOfficialContentIdPeriodGreaterThan] 
  /// * [govOfficialContentIdPeriodLessThan] 
  /// * [govOfficialContentIdPeriodGreaterThanOrEqual] 
  /// * [govOfficialContentIdPeriodLessThanOrEqual] 
  /// * [govOfficialContentIdPeriodEquals] 
  /// * [govOfficialContentIdPeriodNotEquals] 
  /// * [govOfficialContentIdPeriodSpecified] 
  /// * [govOfficialContentIdPeriodIn] 
  /// * [govOfficialContentIdPeriodNotIn] 
  /// * [distinct] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [int] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<int>> countAppUsers({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? emailPeriodContains,
    String? emailPeriodDoesNotContain,
    String? emailPeriodEquals,
    String? emailPeriodNotEquals,
    bool? emailPeriodSpecified,
    BuiltList<String>? emailPeriodIn,
    BuiltList<String>? emailPeriodNotIn,
    String? addressPeriodContains,
    String? addressPeriodDoesNotContain,
    String? addressPeriodEquals,
    String? addressPeriodNotEquals,
    bool? addressPeriodSpecified,
    BuiltList<String>? addressPeriodIn,
    BuiltList<String>? addressPeriodNotIn,
    String? phonePeriodContains,
    String? phonePeriodDoesNotContain,
    String? phonePeriodEquals,
    String? phonePeriodNotEquals,
    bool? phonePeriodSpecified,
    BuiltList<String>? phonePeriodIn,
    BuiltList<String>? phonePeriodNotIn,
    String? genderPeriodContains,
    String? genderPeriodDoesNotContain,
    String? genderPeriodEquals,
    String? genderPeriodNotEquals,
    bool? genderPeriodSpecified,
    BuiltList<String>? genderPeriodIn,
    BuiltList<String>? genderPeriodNotIn,
    String? departmentPeriodContains,
    String? departmentPeriodDoesNotContain,
    String? departmentPeriodEquals,
    String? departmentPeriodNotEquals,
    bool? departmentPeriodSpecified,
    BuiltList<String>? departmentPeriodIn,
    BuiltList<String>? departmentPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    double? latitudePeriodGreaterThan,
    double? latitudePeriodLessThan,
    double? latitudePeriodGreaterThanOrEqual,
    double? latitudePeriodLessThanOrEqual,
    double? latitudePeriodEquals,
    double? latitudePeriodNotEquals,
    bool? latitudePeriodSpecified,
    BuiltList<double>? latitudePeriodIn,
    BuiltList<double>? latitudePeriodNotIn,
    double? longitudePeriodGreaterThan,
    double? longitudePeriodLessThan,
    double? longitudePeriodGreaterThanOrEqual,
    double? longitudePeriodLessThanOrEqual,
    double? longitudePeriodEquals,
    double? longitudePeriodNotEquals,
    bool? longitudePeriodSpecified,
    BuiltList<double>? longitudePeriodIn,
    BuiltList<double>? longitudePeriodNotIn,
    String? userTypePeriodEquals,
    String? userTypePeriodNotEquals,
    bool? userTypePeriodSpecified,
    BuiltList<String>? userTypePeriodIn,
    BuiltList<String>? userTypePeriodNotIn,
    int? userIdPeriodGreaterThan,
    int? userIdPeriodLessThan,
    int? userIdPeriodGreaterThanOrEqual,
    int? userIdPeriodLessThanOrEqual,
    int? userIdPeriodEquals,
    int? userIdPeriodNotEquals,
    bool? userIdPeriodSpecified,
    BuiltList<int>? userIdPeriodIn,
    BuiltList<int>? userIdPeriodNotIn,
    int? reviewsIdPeriodGreaterThan,
    int? reviewsIdPeriodLessThan,
    int? reviewsIdPeriodGreaterThanOrEqual,
    int? reviewsIdPeriodLessThanOrEqual,
    int? reviewsIdPeriodEquals,
    int? reviewsIdPeriodNotEquals,
    bool? reviewsIdPeriodSpecified,
    BuiltList<int>? reviewsIdPeriodIn,
    BuiltList<int>? reviewsIdPeriodNotIn,
    int? rewardsIdPeriodGreaterThan,
    int? rewardsIdPeriodLessThan,
    int? rewardsIdPeriodGreaterThanOrEqual,
    int? rewardsIdPeriodLessThanOrEqual,
    int? rewardsIdPeriodEquals,
    int? rewardsIdPeriodNotEquals,
    bool? rewardsIdPeriodSpecified,
    BuiltList<int>? rewardsIdPeriodIn,
    BuiltList<int>? rewardsIdPeriodNotIn,
    int? govOfficialContentIdPeriodGreaterThan,
    int? govOfficialContentIdPeriodLessThan,
    int? govOfficialContentIdPeriodGreaterThanOrEqual,
    int? govOfficialContentIdPeriodLessThanOrEqual,
    int? govOfficialContentIdPeriodEquals,
    int? govOfficialContentIdPeriodNotEquals,
    bool? govOfficialContentIdPeriodSpecified,
    BuiltList<int>? govOfficialContentIdPeriodIn,
    BuiltList<int>? govOfficialContentIdPeriodNotIn,
    bool? distinct,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users/count';
    final _options = Options(
      method: r'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _queryParameters = <String, dynamic>{
      if (idPeriodGreaterThan != null) r'id.greaterThan': encodeQueryParameter(_serializers, idPeriodGreaterThan, const FullType(int)),
      if (idPeriodLessThan != null) r'id.lessThan': encodeQueryParameter(_serializers, idPeriodLessThan, const FullType(int)),
      if (idPeriodGreaterThanOrEqual != null) r'id.greaterThanOrEqual': encodeQueryParameter(_serializers, idPeriodGreaterThanOrEqual, const FullType(int)),
      if (idPeriodLessThanOrEqual != null) r'id.lessThanOrEqual': encodeQueryParameter(_serializers, idPeriodLessThanOrEqual, const FullType(int)),
      if (idPeriodEquals != null) r'id.equals': encodeQueryParameter(_serializers, idPeriodEquals, const FullType(int)),
      if (idPeriodNotEquals != null) r'id.notEquals': encodeQueryParameter(_serializers, idPeriodNotEquals, const FullType(int)),
      if (idPeriodSpecified != null) r'id.specified': encodeQueryParameter(_serializers, idPeriodSpecified, const FullType(bool)),
      if (idPeriodIn != null) r'id.in': encodeCollectionQueryParameter<int>(_serializers, idPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (idPeriodNotIn != null) r'id.notIn': encodeCollectionQueryParameter<int>(_serializers, idPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (emailPeriodContains != null) r'email.contains': encodeQueryParameter(_serializers, emailPeriodContains, const FullType(String)),
      if (emailPeriodDoesNotContain != null) r'email.doesNotContain': encodeQueryParameter(_serializers, emailPeriodDoesNotContain, const FullType(String)),
      if (emailPeriodEquals != null) r'email.equals': encodeQueryParameter(_serializers, emailPeriodEquals, const FullType(String)),
      if (emailPeriodNotEquals != null) r'email.notEquals': encodeQueryParameter(_serializers, emailPeriodNotEquals, const FullType(String)),
      if (emailPeriodSpecified != null) r'email.specified': encodeQueryParameter(_serializers, emailPeriodSpecified, const FullType(bool)),
      if (emailPeriodIn != null) r'email.in': encodeCollectionQueryParameter<String>(_serializers, emailPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (emailPeriodNotIn != null) r'email.notIn': encodeCollectionQueryParameter<String>(_serializers, emailPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (addressPeriodContains != null) r'address.contains': encodeQueryParameter(_serializers, addressPeriodContains, const FullType(String)),
      if (addressPeriodDoesNotContain != null) r'address.doesNotContain': encodeQueryParameter(_serializers, addressPeriodDoesNotContain, const FullType(String)),
      if (addressPeriodEquals != null) r'address.equals': encodeQueryParameter(_serializers, addressPeriodEquals, const FullType(String)),
      if (addressPeriodNotEquals != null) r'address.notEquals': encodeQueryParameter(_serializers, addressPeriodNotEquals, const FullType(String)),
      if (addressPeriodSpecified != null) r'address.specified': encodeQueryParameter(_serializers, addressPeriodSpecified, const FullType(bool)),
      if (addressPeriodIn != null) r'address.in': encodeCollectionQueryParameter<String>(_serializers, addressPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (addressPeriodNotIn != null) r'address.notIn': encodeCollectionQueryParameter<String>(_serializers, addressPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (phonePeriodContains != null) r'phone.contains': encodeQueryParameter(_serializers, phonePeriodContains, const FullType(String)),
      if (phonePeriodDoesNotContain != null) r'phone.doesNotContain': encodeQueryParameter(_serializers, phonePeriodDoesNotContain, const FullType(String)),
      if (phonePeriodEquals != null) r'phone.equals': encodeQueryParameter(_serializers, phonePeriodEquals, const FullType(String)),
      if (phonePeriodNotEquals != null) r'phone.notEquals': encodeQueryParameter(_serializers, phonePeriodNotEquals, const FullType(String)),
      if (phonePeriodSpecified != null) r'phone.specified': encodeQueryParameter(_serializers, phonePeriodSpecified, const FullType(bool)),
      if (phonePeriodIn != null) r'phone.in': encodeCollectionQueryParameter<String>(_serializers, phonePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (phonePeriodNotIn != null) r'phone.notIn': encodeCollectionQueryParameter<String>(_serializers, phonePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (genderPeriodContains != null) r'gender.contains': encodeQueryParameter(_serializers, genderPeriodContains, const FullType(String)),
      if (genderPeriodDoesNotContain != null) r'gender.doesNotContain': encodeQueryParameter(_serializers, genderPeriodDoesNotContain, const FullType(String)),
      if (genderPeriodEquals != null) r'gender.equals': encodeQueryParameter(_serializers, genderPeriodEquals, const FullType(String)),
      if (genderPeriodNotEquals != null) r'gender.notEquals': encodeQueryParameter(_serializers, genderPeriodNotEquals, const FullType(String)),
      if (genderPeriodSpecified != null) r'gender.specified': encodeQueryParameter(_serializers, genderPeriodSpecified, const FullType(bool)),
      if (genderPeriodIn != null) r'gender.in': encodeCollectionQueryParameter<String>(_serializers, genderPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (genderPeriodNotIn != null) r'gender.notIn': encodeCollectionQueryParameter<String>(_serializers, genderPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (departmentPeriodContains != null) r'department.contains': encodeQueryParameter(_serializers, departmentPeriodContains, const FullType(String)),
      if (departmentPeriodDoesNotContain != null) r'department.doesNotContain': encodeQueryParameter(_serializers, departmentPeriodDoesNotContain, const FullType(String)),
      if (departmentPeriodEquals != null) r'department.equals': encodeQueryParameter(_serializers, departmentPeriodEquals, const FullType(String)),
      if (departmentPeriodNotEquals != null) r'department.notEquals': encodeQueryParameter(_serializers, departmentPeriodNotEquals, const FullType(String)),
      if (departmentPeriodSpecified != null) r'department.specified': encodeQueryParameter(_serializers, departmentPeriodSpecified, const FullType(bool)),
      if (departmentPeriodIn != null) r'department.in': encodeCollectionQueryParameter<String>(_serializers, departmentPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (departmentPeriodNotIn != null) r'department.notIn': encodeCollectionQueryParameter<String>(_serializers, departmentPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (latitudePeriodGreaterThan != null) r'latitude.greaterThan': encodeQueryParameter(_serializers, latitudePeriodGreaterThan, const FullType(double)),
      if (latitudePeriodLessThan != null) r'latitude.lessThan': encodeQueryParameter(_serializers, latitudePeriodLessThan, const FullType(double)),
      if (latitudePeriodGreaterThanOrEqual != null) r'latitude.greaterThanOrEqual': encodeQueryParameter(_serializers, latitudePeriodGreaterThanOrEqual, const FullType(double)),
      if (latitudePeriodLessThanOrEqual != null) r'latitude.lessThanOrEqual': encodeQueryParameter(_serializers, latitudePeriodLessThanOrEqual, const FullType(double)),
      if (latitudePeriodEquals != null) r'latitude.equals': encodeQueryParameter(_serializers, latitudePeriodEquals, const FullType(double)),
      if (latitudePeriodNotEquals != null) r'latitude.notEquals': encodeQueryParameter(_serializers, latitudePeriodNotEquals, const FullType(double)),
      if (latitudePeriodSpecified != null) r'latitude.specified': encodeQueryParameter(_serializers, latitudePeriodSpecified, const FullType(bool)),
      if (latitudePeriodIn != null) r'latitude.in': encodeCollectionQueryParameter<double>(_serializers, latitudePeriodIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (latitudePeriodNotIn != null) r'latitude.notIn': encodeCollectionQueryParameter<double>(_serializers, latitudePeriodNotIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (longitudePeriodGreaterThan != null) r'longitude.greaterThan': encodeQueryParameter(_serializers, longitudePeriodGreaterThan, const FullType(double)),
      if (longitudePeriodLessThan != null) r'longitude.lessThan': encodeQueryParameter(_serializers, longitudePeriodLessThan, const FullType(double)),
      if (longitudePeriodGreaterThanOrEqual != null) r'longitude.greaterThanOrEqual': encodeQueryParameter(_serializers, longitudePeriodGreaterThanOrEqual, const FullType(double)),
      if (longitudePeriodLessThanOrEqual != null) r'longitude.lessThanOrEqual': encodeQueryParameter(_serializers, longitudePeriodLessThanOrEqual, const FullType(double)),
      if (longitudePeriodEquals != null) r'longitude.equals': encodeQueryParameter(_serializers, longitudePeriodEquals, const FullType(double)),
      if (longitudePeriodNotEquals != null) r'longitude.notEquals': encodeQueryParameter(_serializers, longitudePeriodNotEquals, const FullType(double)),
      if (longitudePeriodSpecified != null) r'longitude.specified': encodeQueryParameter(_serializers, longitudePeriodSpecified, const FullType(bool)),
      if (longitudePeriodIn != null) r'longitude.in': encodeCollectionQueryParameter<double>(_serializers, longitudePeriodIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (longitudePeriodNotIn != null) r'longitude.notIn': encodeCollectionQueryParameter<double>(_serializers, longitudePeriodNotIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (userTypePeriodEquals != null) r'userType.equals': encodeQueryParameter(_serializers, userTypePeriodEquals, const FullType(String)),
      if (userTypePeriodNotEquals != null) r'userType.notEquals': encodeQueryParameter(_serializers, userTypePeriodNotEquals, const FullType(String)),
      if (userTypePeriodSpecified != null) r'userType.specified': encodeQueryParameter(_serializers, userTypePeriodSpecified, const FullType(bool)),
      if (userTypePeriodIn != null) r'userType.in': encodeCollectionQueryParameter<String>(_serializers, userTypePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (userTypePeriodNotIn != null) r'userType.notIn': encodeCollectionQueryParameter<String>(_serializers, userTypePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (userIdPeriodGreaterThan != null) r'userId.greaterThan': encodeQueryParameter(_serializers, userIdPeriodGreaterThan, const FullType(int)),
      if (userIdPeriodLessThan != null) r'userId.lessThan': encodeQueryParameter(_serializers, userIdPeriodLessThan, const FullType(int)),
      if (userIdPeriodGreaterThanOrEqual != null) r'userId.greaterThanOrEqual': encodeQueryParameter(_serializers, userIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (userIdPeriodLessThanOrEqual != null) r'userId.lessThanOrEqual': encodeQueryParameter(_serializers, userIdPeriodLessThanOrEqual, const FullType(int)),
      if (userIdPeriodEquals != null) r'userId.equals': encodeQueryParameter(_serializers, userIdPeriodEquals, const FullType(int)),
      if (userIdPeriodNotEquals != null) r'userId.notEquals': encodeQueryParameter(_serializers, userIdPeriodNotEquals, const FullType(int)),
      if (userIdPeriodSpecified != null) r'userId.specified': encodeQueryParameter(_serializers, userIdPeriodSpecified, const FullType(bool)),
      if (userIdPeriodIn != null) r'userId.in': encodeCollectionQueryParameter<int>(_serializers, userIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (userIdPeriodNotIn != null) r'userId.notIn': encodeCollectionQueryParameter<int>(_serializers, userIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (reviewsIdPeriodGreaterThan != null) r'reviewsId.greaterThan': encodeQueryParameter(_serializers, reviewsIdPeriodGreaterThan, const FullType(int)),
      if (reviewsIdPeriodLessThan != null) r'reviewsId.lessThan': encodeQueryParameter(_serializers, reviewsIdPeriodLessThan, const FullType(int)),
      if (reviewsIdPeriodGreaterThanOrEqual != null) r'reviewsId.greaterThanOrEqual': encodeQueryParameter(_serializers, reviewsIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (reviewsIdPeriodLessThanOrEqual != null) r'reviewsId.lessThanOrEqual': encodeQueryParameter(_serializers, reviewsIdPeriodLessThanOrEqual, const FullType(int)),
      if (reviewsIdPeriodEquals != null) r'reviewsId.equals': encodeQueryParameter(_serializers, reviewsIdPeriodEquals, const FullType(int)),
      if (reviewsIdPeriodNotEquals != null) r'reviewsId.notEquals': encodeQueryParameter(_serializers, reviewsIdPeriodNotEquals, const FullType(int)),
      if (reviewsIdPeriodSpecified != null) r'reviewsId.specified': encodeQueryParameter(_serializers, reviewsIdPeriodSpecified, const FullType(bool)),
      if (reviewsIdPeriodIn != null) r'reviewsId.in': encodeCollectionQueryParameter<int>(_serializers, reviewsIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (reviewsIdPeriodNotIn != null) r'reviewsId.notIn': encodeCollectionQueryParameter<int>(_serializers, reviewsIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (rewardsIdPeriodGreaterThan != null) r'rewardsId.greaterThan': encodeQueryParameter(_serializers, rewardsIdPeriodGreaterThan, const FullType(int)),
      if (rewardsIdPeriodLessThan != null) r'rewardsId.lessThan': encodeQueryParameter(_serializers, rewardsIdPeriodLessThan, const FullType(int)),
      if (rewardsIdPeriodGreaterThanOrEqual != null) r'rewardsId.greaterThanOrEqual': encodeQueryParameter(_serializers, rewardsIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (rewardsIdPeriodLessThanOrEqual != null) r'rewardsId.lessThanOrEqual': encodeQueryParameter(_serializers, rewardsIdPeriodLessThanOrEqual, const FullType(int)),
      if (rewardsIdPeriodEquals != null) r'rewardsId.equals': encodeQueryParameter(_serializers, rewardsIdPeriodEquals, const FullType(int)),
      if (rewardsIdPeriodNotEquals != null) r'rewardsId.notEquals': encodeQueryParameter(_serializers, rewardsIdPeriodNotEquals, const FullType(int)),
      if (rewardsIdPeriodSpecified != null) r'rewardsId.specified': encodeQueryParameter(_serializers, rewardsIdPeriodSpecified, const FullType(bool)),
      if (rewardsIdPeriodIn != null) r'rewardsId.in': encodeCollectionQueryParameter<int>(_serializers, rewardsIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (rewardsIdPeriodNotIn != null) r'rewardsId.notIn': encodeCollectionQueryParameter<int>(_serializers, rewardsIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (govOfficialContentIdPeriodGreaterThan != null) r'govOfficialContentId.greaterThan': encodeQueryParameter(_serializers, govOfficialContentIdPeriodGreaterThan, const FullType(int)),
      if (govOfficialContentIdPeriodLessThan != null) r'govOfficialContentId.lessThan': encodeQueryParameter(_serializers, govOfficialContentIdPeriodLessThan, const FullType(int)),
      if (govOfficialContentIdPeriodGreaterThanOrEqual != null) r'govOfficialContentId.greaterThanOrEqual': encodeQueryParameter(_serializers, govOfficialContentIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (govOfficialContentIdPeriodLessThanOrEqual != null) r'govOfficialContentId.lessThanOrEqual': encodeQueryParameter(_serializers, govOfficialContentIdPeriodLessThanOrEqual, const FullType(int)),
      if (govOfficialContentIdPeriodEquals != null) r'govOfficialContentId.equals': encodeQueryParameter(_serializers, govOfficialContentIdPeriodEquals, const FullType(int)),
      if (govOfficialContentIdPeriodNotEquals != null) r'govOfficialContentId.notEquals': encodeQueryParameter(_serializers, govOfficialContentIdPeriodNotEquals, const FullType(int)),
      if (govOfficialContentIdPeriodSpecified != null) r'govOfficialContentId.specified': encodeQueryParameter(_serializers, govOfficialContentIdPeriodSpecified, const FullType(bool)),
      if (govOfficialContentIdPeriodIn != null) r'govOfficialContentId.in': encodeCollectionQueryParameter<int>(_serializers, govOfficialContentIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (govOfficialContentIdPeriodNotIn != null) r'govOfficialContentId.notIn': encodeCollectionQueryParameter<int>(_serializers, govOfficialContentIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (distinct != null) r'distinct': encodeQueryParameter(_serializers, distinct, const FullType(bool)),
    };

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      queryParameters: _queryParameters,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    int? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : rawResponse as int;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<int>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// createAppUser
  /// 
  ///
  /// Parameters:
  /// * [appUserDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [AppUserDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<AppUserDTO>> createAppUser({ 
    required AppUserDTO appUserDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users';
    final _options = Options(
      method: r'POST',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      contentType: 'application/json',
      validateStatus: validateStatus,
    );

    dynamic _bodyData;

    try {
      const _type = FullType(AppUserDTO);
      _bodyData = _serializers.serialize(appUserDTO, specifiedType: _type);

    } catch(error, stackTrace) {
      throw DioException(
         requestOptions: _options.compose(
          _dio.options,
          _path,
        ),
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    final _response = await _dio.request<Object>(
      _path,
      data: _bodyData,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    AppUserDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(AppUserDTO),
      ) as AppUserDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<AppUserDTO>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// deleteAppUser
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future]
  /// Throws [DioException] if API call or serialization fails
  Future<Response<void>> deleteAppUser({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
    final _options = Options(
      method: r'DELETE',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    return _response;
  }

  /// getAllAppUsers
  /// 
  ///
  /// Parameters:
  /// * [idPeriodGreaterThan] 
  /// * [idPeriodLessThan] 
  /// * [idPeriodGreaterThanOrEqual] 
  /// * [idPeriodLessThanOrEqual] 
  /// * [idPeriodEquals] 
  /// * [idPeriodNotEquals] 
  /// * [idPeriodSpecified] 
  /// * [idPeriodIn] 
  /// * [idPeriodNotIn] 
  /// * [emailPeriodContains] 
  /// * [emailPeriodDoesNotContain] 
  /// * [emailPeriodEquals] 
  /// * [emailPeriodNotEquals] 
  /// * [emailPeriodSpecified] 
  /// * [emailPeriodIn] 
  /// * [emailPeriodNotIn] 
  /// * [addressPeriodContains] 
  /// * [addressPeriodDoesNotContain] 
  /// * [addressPeriodEquals] 
  /// * [addressPeriodNotEquals] 
  /// * [addressPeriodSpecified] 
  /// * [addressPeriodIn] 
  /// * [addressPeriodNotIn] 
  /// * [phonePeriodContains] 
  /// * [phonePeriodDoesNotContain] 
  /// * [phonePeriodEquals] 
  /// * [phonePeriodNotEquals] 
  /// * [phonePeriodSpecified] 
  /// * [phonePeriodIn] 
  /// * [phonePeriodNotIn] 
  /// * [genderPeriodContains] 
  /// * [genderPeriodDoesNotContain] 
  /// * [genderPeriodEquals] 
  /// * [genderPeriodNotEquals] 
  /// * [genderPeriodSpecified] 
  /// * [genderPeriodIn] 
  /// * [genderPeriodNotIn] 
  /// * [departmentPeriodContains] 
  /// * [departmentPeriodDoesNotContain] 
  /// * [departmentPeriodEquals] 
  /// * [departmentPeriodNotEquals] 
  /// * [departmentPeriodSpecified] 
  /// * [departmentPeriodIn] 
  /// * [departmentPeriodNotIn] 
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [latitudePeriodGreaterThan] 
  /// * [latitudePeriodLessThan] 
  /// * [latitudePeriodGreaterThanOrEqual] 
  /// * [latitudePeriodLessThanOrEqual] 
  /// * [latitudePeriodEquals] 
  /// * [latitudePeriodNotEquals] 
  /// * [latitudePeriodSpecified] 
  /// * [latitudePeriodIn] 
  /// * [latitudePeriodNotIn] 
  /// * [longitudePeriodGreaterThan] 
  /// * [longitudePeriodLessThan] 
  /// * [longitudePeriodGreaterThanOrEqual] 
  /// * [longitudePeriodLessThanOrEqual] 
  /// * [longitudePeriodEquals] 
  /// * [longitudePeriodNotEquals] 
  /// * [longitudePeriodSpecified] 
  /// * [longitudePeriodIn] 
  /// * [longitudePeriodNotIn] 
  /// * [userTypePeriodEquals] 
  /// * [userTypePeriodNotEquals] 
  /// * [userTypePeriodSpecified] 
  /// * [userTypePeriodIn] 
  /// * [userTypePeriodNotIn] 
  /// * [userIdPeriodGreaterThan] 
  /// * [userIdPeriodLessThan] 
  /// * [userIdPeriodGreaterThanOrEqual] 
  /// * [userIdPeriodLessThanOrEqual] 
  /// * [userIdPeriodEquals] 
  /// * [userIdPeriodNotEquals] 
  /// * [userIdPeriodSpecified] 
  /// * [userIdPeriodIn] 
  /// * [userIdPeriodNotIn] 
  /// * [reviewsIdPeriodGreaterThan] 
  /// * [reviewsIdPeriodLessThan] 
  /// * [reviewsIdPeriodGreaterThanOrEqual] 
  /// * [reviewsIdPeriodLessThanOrEqual] 
  /// * [reviewsIdPeriodEquals] 
  /// * [reviewsIdPeriodNotEquals] 
  /// * [reviewsIdPeriodSpecified] 
  /// * [reviewsIdPeriodIn] 
  /// * [reviewsIdPeriodNotIn] 
  /// * [rewardsIdPeriodGreaterThan] 
  /// * [rewardsIdPeriodLessThan] 
  /// * [rewardsIdPeriodGreaterThanOrEqual] 
  /// * [rewardsIdPeriodLessThanOrEqual] 
  /// * [rewardsIdPeriodEquals] 
  /// * [rewardsIdPeriodNotEquals] 
  /// * [rewardsIdPeriodSpecified] 
  /// * [rewardsIdPeriodIn] 
  /// * [rewardsIdPeriodNotIn] 
  /// * [govOfficialContentIdPeriodGreaterThan] 
  /// * [govOfficialContentIdPeriodLessThan] 
  /// * [govOfficialContentIdPeriodGreaterThanOrEqual] 
  /// * [govOfficialContentIdPeriodLessThanOrEqual] 
  /// * [govOfficialContentIdPeriodEquals] 
  /// * [govOfficialContentIdPeriodNotEquals] 
  /// * [govOfficialContentIdPeriodSpecified] 
  /// * [govOfficialContentIdPeriodIn] 
  /// * [govOfficialContentIdPeriodNotIn] 
  /// * [distinct] 
  /// * [page] - Zero-based page index (0..N)
  /// * [size] - The size of the page to be returned
  /// * [sort] - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [BuiltList<AppUserDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<AppUserDTO>>> getAllAppUsers({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? emailPeriodContains,
    String? emailPeriodDoesNotContain,
    String? emailPeriodEquals,
    String? emailPeriodNotEquals,
    bool? emailPeriodSpecified,
    BuiltList<String>? emailPeriodIn,
    BuiltList<String>? emailPeriodNotIn,
    String? addressPeriodContains,
    String? addressPeriodDoesNotContain,
    String? addressPeriodEquals,
    String? addressPeriodNotEquals,
    bool? addressPeriodSpecified,
    BuiltList<String>? addressPeriodIn,
    BuiltList<String>? addressPeriodNotIn,
    String? phonePeriodContains,
    String? phonePeriodDoesNotContain,
    String? phonePeriodEquals,
    String? phonePeriodNotEquals,
    bool? phonePeriodSpecified,
    BuiltList<String>? phonePeriodIn,
    BuiltList<String>? phonePeriodNotIn,
    String? genderPeriodContains,
    String? genderPeriodDoesNotContain,
    String? genderPeriodEquals,
    String? genderPeriodNotEquals,
    bool? genderPeriodSpecified,
    BuiltList<String>? genderPeriodIn,
    BuiltList<String>? genderPeriodNotIn,
    String? departmentPeriodContains,
    String? departmentPeriodDoesNotContain,
    String? departmentPeriodEquals,
    String? departmentPeriodNotEquals,
    bool? departmentPeriodSpecified,
    BuiltList<String>? departmentPeriodIn,
    BuiltList<String>? departmentPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    double? latitudePeriodGreaterThan,
    double? latitudePeriodLessThan,
    double? latitudePeriodGreaterThanOrEqual,
    double? latitudePeriodLessThanOrEqual,
    double? latitudePeriodEquals,
    double? latitudePeriodNotEquals,
    bool? latitudePeriodSpecified,
    BuiltList<double>? latitudePeriodIn,
    BuiltList<double>? latitudePeriodNotIn,
    double? longitudePeriodGreaterThan,
    double? longitudePeriodLessThan,
    double? longitudePeriodGreaterThanOrEqual,
    double? longitudePeriodLessThanOrEqual,
    double? longitudePeriodEquals,
    double? longitudePeriodNotEquals,
    bool? longitudePeriodSpecified,
    BuiltList<double>? longitudePeriodIn,
    BuiltList<double>? longitudePeriodNotIn,
    String? userTypePeriodEquals,
    String? userTypePeriodNotEquals,
    bool? userTypePeriodSpecified,
    BuiltList<String>? userTypePeriodIn,
    BuiltList<String>? userTypePeriodNotIn,
    int? userIdPeriodGreaterThan,
    int? userIdPeriodLessThan,
    int? userIdPeriodGreaterThanOrEqual,
    int? userIdPeriodLessThanOrEqual,
    int? userIdPeriodEquals,
    int? userIdPeriodNotEquals,
    bool? userIdPeriodSpecified,
    BuiltList<int>? userIdPeriodIn,
    BuiltList<int>? userIdPeriodNotIn,
    int? reviewsIdPeriodGreaterThan,
    int? reviewsIdPeriodLessThan,
    int? reviewsIdPeriodGreaterThanOrEqual,
    int? reviewsIdPeriodLessThanOrEqual,
    int? reviewsIdPeriodEquals,
    int? reviewsIdPeriodNotEquals,
    bool? reviewsIdPeriodSpecified,
    BuiltList<int>? reviewsIdPeriodIn,
    BuiltList<int>? reviewsIdPeriodNotIn,
    int? rewardsIdPeriodGreaterThan,
    int? rewardsIdPeriodLessThan,
    int? rewardsIdPeriodGreaterThanOrEqual,
    int? rewardsIdPeriodLessThanOrEqual,
    int? rewardsIdPeriodEquals,
    int? rewardsIdPeriodNotEquals,
    bool? rewardsIdPeriodSpecified,
    BuiltList<int>? rewardsIdPeriodIn,
    BuiltList<int>? rewardsIdPeriodNotIn,
    int? govOfficialContentIdPeriodGreaterThan,
    int? govOfficialContentIdPeriodLessThan,
    int? govOfficialContentIdPeriodGreaterThanOrEqual,
    int? govOfficialContentIdPeriodLessThanOrEqual,
    int? govOfficialContentIdPeriodEquals,
    int? govOfficialContentIdPeriodNotEquals,
    bool? govOfficialContentIdPeriodSpecified,
    BuiltList<int>? govOfficialContentIdPeriodIn,
    BuiltList<int>? govOfficialContentIdPeriodNotIn,
    bool? distinct,
    int? page = 0,
    int? size = 20,
    BuiltList<String>? sort,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users';
    final _options = Options(
      method: r'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _queryParameters = <String, dynamic>{
      if (idPeriodGreaterThan != null) r'id.greaterThan': encodeQueryParameter(_serializers, idPeriodGreaterThan, const FullType(int)),
      if (idPeriodLessThan != null) r'id.lessThan': encodeQueryParameter(_serializers, idPeriodLessThan, const FullType(int)),
      if (idPeriodGreaterThanOrEqual != null) r'id.greaterThanOrEqual': encodeQueryParameter(_serializers, idPeriodGreaterThanOrEqual, const FullType(int)),
      if (idPeriodLessThanOrEqual != null) r'id.lessThanOrEqual': encodeQueryParameter(_serializers, idPeriodLessThanOrEqual, const FullType(int)),
      if (idPeriodEquals != null) r'id.equals': encodeQueryParameter(_serializers, idPeriodEquals, const FullType(int)),
      if (idPeriodNotEquals != null) r'id.notEquals': encodeQueryParameter(_serializers, idPeriodNotEquals, const FullType(int)),
      if (idPeriodSpecified != null) r'id.specified': encodeQueryParameter(_serializers, idPeriodSpecified, const FullType(bool)),
      if (idPeriodIn != null) r'id.in': encodeCollectionQueryParameter<int>(_serializers, idPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (idPeriodNotIn != null) r'id.notIn': encodeCollectionQueryParameter<int>(_serializers, idPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (emailPeriodContains != null) r'email.contains': encodeQueryParameter(_serializers, emailPeriodContains, const FullType(String)),
      if (emailPeriodDoesNotContain != null) r'email.doesNotContain': encodeQueryParameter(_serializers, emailPeriodDoesNotContain, const FullType(String)),
      if (emailPeriodEquals != null) r'email.equals': encodeQueryParameter(_serializers, emailPeriodEquals, const FullType(String)),
      if (emailPeriodNotEquals != null) r'email.notEquals': encodeQueryParameter(_serializers, emailPeriodNotEquals, const FullType(String)),
      if (emailPeriodSpecified != null) r'email.specified': encodeQueryParameter(_serializers, emailPeriodSpecified, const FullType(bool)),
      if (emailPeriodIn != null) r'email.in': encodeCollectionQueryParameter<String>(_serializers, emailPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (emailPeriodNotIn != null) r'email.notIn': encodeCollectionQueryParameter<String>(_serializers, emailPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (addressPeriodContains != null) r'address.contains': encodeQueryParameter(_serializers, addressPeriodContains, const FullType(String)),
      if (addressPeriodDoesNotContain != null) r'address.doesNotContain': encodeQueryParameter(_serializers, addressPeriodDoesNotContain, const FullType(String)),
      if (addressPeriodEquals != null) r'address.equals': encodeQueryParameter(_serializers, addressPeriodEquals, const FullType(String)),
      if (addressPeriodNotEquals != null) r'address.notEquals': encodeQueryParameter(_serializers, addressPeriodNotEquals, const FullType(String)),
      if (addressPeriodSpecified != null) r'address.specified': encodeQueryParameter(_serializers, addressPeriodSpecified, const FullType(bool)),
      if (addressPeriodIn != null) r'address.in': encodeCollectionQueryParameter<String>(_serializers, addressPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (addressPeriodNotIn != null) r'address.notIn': encodeCollectionQueryParameter<String>(_serializers, addressPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (phonePeriodContains != null) r'phone.contains': encodeQueryParameter(_serializers, phonePeriodContains, const FullType(String)),
      if (phonePeriodDoesNotContain != null) r'phone.doesNotContain': encodeQueryParameter(_serializers, phonePeriodDoesNotContain, const FullType(String)),
      if (phonePeriodEquals != null) r'phone.equals': encodeQueryParameter(_serializers, phonePeriodEquals, const FullType(String)),
      if (phonePeriodNotEquals != null) r'phone.notEquals': encodeQueryParameter(_serializers, phonePeriodNotEquals, const FullType(String)),
      if (phonePeriodSpecified != null) r'phone.specified': encodeQueryParameter(_serializers, phonePeriodSpecified, const FullType(bool)),
      if (phonePeriodIn != null) r'phone.in': encodeCollectionQueryParameter<String>(_serializers, phonePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (phonePeriodNotIn != null) r'phone.notIn': encodeCollectionQueryParameter<String>(_serializers, phonePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (genderPeriodContains != null) r'gender.contains': encodeQueryParameter(_serializers, genderPeriodContains, const FullType(String)),
      if (genderPeriodDoesNotContain != null) r'gender.doesNotContain': encodeQueryParameter(_serializers, genderPeriodDoesNotContain, const FullType(String)),
      if (genderPeriodEquals != null) r'gender.equals': encodeQueryParameter(_serializers, genderPeriodEquals, const FullType(String)),
      if (genderPeriodNotEquals != null) r'gender.notEquals': encodeQueryParameter(_serializers, genderPeriodNotEquals, const FullType(String)),
      if (genderPeriodSpecified != null) r'gender.specified': encodeQueryParameter(_serializers, genderPeriodSpecified, const FullType(bool)),
      if (genderPeriodIn != null) r'gender.in': encodeCollectionQueryParameter<String>(_serializers, genderPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (genderPeriodNotIn != null) r'gender.notIn': encodeCollectionQueryParameter<String>(_serializers, genderPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (departmentPeriodContains != null) r'department.contains': encodeQueryParameter(_serializers, departmentPeriodContains, const FullType(String)),
      if (departmentPeriodDoesNotContain != null) r'department.doesNotContain': encodeQueryParameter(_serializers, departmentPeriodDoesNotContain, const FullType(String)),
      if (departmentPeriodEquals != null) r'department.equals': encodeQueryParameter(_serializers, departmentPeriodEquals, const FullType(String)),
      if (departmentPeriodNotEquals != null) r'department.notEquals': encodeQueryParameter(_serializers, departmentPeriodNotEquals, const FullType(String)),
      if (departmentPeriodSpecified != null) r'department.specified': encodeQueryParameter(_serializers, departmentPeriodSpecified, const FullType(bool)),
      if (departmentPeriodIn != null) r'department.in': encodeCollectionQueryParameter<String>(_serializers, departmentPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (departmentPeriodNotIn != null) r'department.notIn': encodeCollectionQueryParameter<String>(_serializers, departmentPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (latitudePeriodGreaterThan != null) r'latitude.greaterThan': encodeQueryParameter(_serializers, latitudePeriodGreaterThan, const FullType(double)),
      if (latitudePeriodLessThan != null) r'latitude.lessThan': encodeQueryParameter(_serializers, latitudePeriodLessThan, const FullType(double)),
      if (latitudePeriodGreaterThanOrEqual != null) r'latitude.greaterThanOrEqual': encodeQueryParameter(_serializers, latitudePeriodGreaterThanOrEqual, const FullType(double)),
      if (latitudePeriodLessThanOrEqual != null) r'latitude.lessThanOrEqual': encodeQueryParameter(_serializers, latitudePeriodLessThanOrEqual, const FullType(double)),
      if (latitudePeriodEquals != null) r'latitude.equals': encodeQueryParameter(_serializers, latitudePeriodEquals, const FullType(double)),
      if (latitudePeriodNotEquals != null) r'latitude.notEquals': encodeQueryParameter(_serializers, latitudePeriodNotEquals, const FullType(double)),
      if (latitudePeriodSpecified != null) r'latitude.specified': encodeQueryParameter(_serializers, latitudePeriodSpecified, const FullType(bool)),
      if (latitudePeriodIn != null) r'latitude.in': encodeCollectionQueryParameter<double>(_serializers, latitudePeriodIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (latitudePeriodNotIn != null) r'latitude.notIn': encodeCollectionQueryParameter<double>(_serializers, latitudePeriodNotIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (longitudePeriodGreaterThan != null) r'longitude.greaterThan': encodeQueryParameter(_serializers, longitudePeriodGreaterThan, const FullType(double)),
      if (longitudePeriodLessThan != null) r'longitude.lessThan': encodeQueryParameter(_serializers, longitudePeriodLessThan, const FullType(double)),
      if (longitudePeriodGreaterThanOrEqual != null) r'longitude.greaterThanOrEqual': encodeQueryParameter(_serializers, longitudePeriodGreaterThanOrEqual, const FullType(double)),
      if (longitudePeriodLessThanOrEqual != null) r'longitude.lessThanOrEqual': encodeQueryParameter(_serializers, longitudePeriodLessThanOrEqual, const FullType(double)),
      if (longitudePeriodEquals != null) r'longitude.equals': encodeQueryParameter(_serializers, longitudePeriodEquals, const FullType(double)),
      if (longitudePeriodNotEquals != null) r'longitude.notEquals': encodeQueryParameter(_serializers, longitudePeriodNotEquals, const FullType(double)),
      if (longitudePeriodSpecified != null) r'longitude.specified': encodeQueryParameter(_serializers, longitudePeriodSpecified, const FullType(bool)),
      if (longitudePeriodIn != null) r'longitude.in': encodeCollectionQueryParameter<double>(_serializers, longitudePeriodIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (longitudePeriodNotIn != null) r'longitude.notIn': encodeCollectionQueryParameter<double>(_serializers, longitudePeriodNotIn, const FullType(BuiltList, [FullType(double)]), format: ListFormat.multi,),
      if (userTypePeriodEquals != null) r'userType.equals': encodeQueryParameter(_serializers, userTypePeriodEquals, const FullType(String)),
      if (userTypePeriodNotEquals != null) r'userType.notEquals': encodeQueryParameter(_serializers, userTypePeriodNotEquals, const FullType(String)),
      if (userTypePeriodSpecified != null) r'userType.specified': encodeQueryParameter(_serializers, userTypePeriodSpecified, const FullType(bool)),
      if (userTypePeriodIn != null) r'userType.in': encodeCollectionQueryParameter<String>(_serializers, userTypePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (userTypePeriodNotIn != null) r'userType.notIn': encodeCollectionQueryParameter<String>(_serializers, userTypePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (userIdPeriodGreaterThan != null) r'userId.greaterThan': encodeQueryParameter(_serializers, userIdPeriodGreaterThan, const FullType(int)),
      if (userIdPeriodLessThan != null) r'userId.lessThan': encodeQueryParameter(_serializers, userIdPeriodLessThan, const FullType(int)),
      if (userIdPeriodGreaterThanOrEqual != null) r'userId.greaterThanOrEqual': encodeQueryParameter(_serializers, userIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (userIdPeriodLessThanOrEqual != null) r'userId.lessThanOrEqual': encodeQueryParameter(_serializers, userIdPeriodLessThanOrEqual, const FullType(int)),
      if (userIdPeriodEquals != null) r'userId.equals': encodeQueryParameter(_serializers, userIdPeriodEquals, const FullType(int)),
      if (userIdPeriodNotEquals != null) r'userId.notEquals': encodeQueryParameter(_serializers, userIdPeriodNotEquals, const FullType(int)),
      if (userIdPeriodSpecified != null) r'userId.specified': encodeQueryParameter(_serializers, userIdPeriodSpecified, const FullType(bool)),
      if (userIdPeriodIn != null) r'userId.in': encodeCollectionQueryParameter<int>(_serializers, userIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (userIdPeriodNotIn != null) r'userId.notIn': encodeCollectionQueryParameter<int>(_serializers, userIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (reviewsIdPeriodGreaterThan != null) r'reviewsId.greaterThan': encodeQueryParameter(_serializers, reviewsIdPeriodGreaterThan, const FullType(int)),
      if (reviewsIdPeriodLessThan != null) r'reviewsId.lessThan': encodeQueryParameter(_serializers, reviewsIdPeriodLessThan, const FullType(int)),
      if (reviewsIdPeriodGreaterThanOrEqual != null) r'reviewsId.greaterThanOrEqual': encodeQueryParameter(_serializers, reviewsIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (reviewsIdPeriodLessThanOrEqual != null) r'reviewsId.lessThanOrEqual': encodeQueryParameter(_serializers, reviewsIdPeriodLessThanOrEqual, const FullType(int)),
      if (reviewsIdPeriodEquals != null) r'reviewsId.equals': encodeQueryParameter(_serializers, reviewsIdPeriodEquals, const FullType(int)),
      if (reviewsIdPeriodNotEquals != null) r'reviewsId.notEquals': encodeQueryParameter(_serializers, reviewsIdPeriodNotEquals, const FullType(int)),
      if (reviewsIdPeriodSpecified != null) r'reviewsId.specified': encodeQueryParameter(_serializers, reviewsIdPeriodSpecified, const FullType(bool)),
      if (reviewsIdPeriodIn != null) r'reviewsId.in': encodeCollectionQueryParameter<int>(_serializers, reviewsIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (reviewsIdPeriodNotIn != null) r'reviewsId.notIn': encodeCollectionQueryParameter<int>(_serializers, reviewsIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (rewardsIdPeriodGreaterThan != null) r'rewardsId.greaterThan': encodeQueryParameter(_serializers, rewardsIdPeriodGreaterThan, const FullType(int)),
      if (rewardsIdPeriodLessThan != null) r'rewardsId.lessThan': encodeQueryParameter(_serializers, rewardsIdPeriodLessThan, const FullType(int)),
      if (rewardsIdPeriodGreaterThanOrEqual != null) r'rewardsId.greaterThanOrEqual': encodeQueryParameter(_serializers, rewardsIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (rewardsIdPeriodLessThanOrEqual != null) r'rewardsId.lessThanOrEqual': encodeQueryParameter(_serializers, rewardsIdPeriodLessThanOrEqual, const FullType(int)),
      if (rewardsIdPeriodEquals != null) r'rewardsId.equals': encodeQueryParameter(_serializers, rewardsIdPeriodEquals, const FullType(int)),
      if (rewardsIdPeriodNotEquals != null) r'rewardsId.notEquals': encodeQueryParameter(_serializers, rewardsIdPeriodNotEquals, const FullType(int)),
      if (rewardsIdPeriodSpecified != null) r'rewardsId.specified': encodeQueryParameter(_serializers, rewardsIdPeriodSpecified, const FullType(bool)),
      if (rewardsIdPeriodIn != null) r'rewardsId.in': encodeCollectionQueryParameter<int>(_serializers, rewardsIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (rewardsIdPeriodNotIn != null) r'rewardsId.notIn': encodeCollectionQueryParameter<int>(_serializers, rewardsIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (govOfficialContentIdPeriodGreaterThan != null) r'govOfficialContentId.greaterThan': encodeQueryParameter(_serializers, govOfficialContentIdPeriodGreaterThan, const FullType(int)),
      if (govOfficialContentIdPeriodLessThan != null) r'govOfficialContentId.lessThan': encodeQueryParameter(_serializers, govOfficialContentIdPeriodLessThan, const FullType(int)),
      if (govOfficialContentIdPeriodGreaterThanOrEqual != null) r'govOfficialContentId.greaterThanOrEqual': encodeQueryParameter(_serializers, govOfficialContentIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (govOfficialContentIdPeriodLessThanOrEqual != null) r'govOfficialContentId.lessThanOrEqual': encodeQueryParameter(_serializers, govOfficialContentIdPeriodLessThanOrEqual, const FullType(int)),
      if (govOfficialContentIdPeriodEquals != null) r'govOfficialContentId.equals': encodeQueryParameter(_serializers, govOfficialContentIdPeriodEquals, const FullType(int)),
      if (govOfficialContentIdPeriodNotEquals != null) r'govOfficialContentId.notEquals': encodeQueryParameter(_serializers, govOfficialContentIdPeriodNotEquals, const FullType(int)),
      if (govOfficialContentIdPeriodSpecified != null) r'govOfficialContentId.specified': encodeQueryParameter(_serializers, govOfficialContentIdPeriodSpecified, const FullType(bool)),
      if (govOfficialContentIdPeriodIn != null) r'govOfficialContentId.in': encodeCollectionQueryParameter<int>(_serializers, govOfficialContentIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (govOfficialContentIdPeriodNotIn != null) r'govOfficialContentId.notIn': encodeCollectionQueryParameter<int>(_serializers, govOfficialContentIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (distinct != null) r'distinct': encodeQueryParameter(_serializers, distinct, const FullType(bool)),
      if (page != null) r'page': encodeQueryParameter(_serializers, page, const FullType(int)),
      if (size != null) r'size': encodeQueryParameter(_serializers, size, const FullType(int)),
      if (sort != null) r'sort': encodeCollectionQueryParameter<String>(_serializers, sort, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
    };

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      queryParameters: _queryParameters,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    BuiltList<AppUserDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(AppUserDTO)]),
      ) as BuiltList<AppUserDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<AppUserDTO>>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// getAppUser
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [AppUserDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<AppUserDTO>> getAppUser({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
    final _options = Options(
      method: r'GET',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      validateStatus: validateStatus,
    );

    final _response = await _dio.request<Object>(
      _path,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    AppUserDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(AppUserDTO),
      ) as AppUserDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<AppUserDTO>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// partialUpdateAppUser
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [appUserDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [AppUserDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<AppUserDTO>> partialUpdateAppUser({ 
    required int id,
    required AppUserDTO appUserDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
    final _options = Options(
      method: r'PATCH',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      contentType: 'application/json',
      validateStatus: validateStatus,
    );

    dynamic _bodyData;

    try {
      const _type = FullType(AppUserDTO);
      _bodyData = _serializers.serialize(appUserDTO, specifiedType: _type);

    } catch(error, stackTrace) {
      throw DioException(
         requestOptions: _options.compose(
          _dio.options,
          _path,
        ),
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    final _response = await _dio.request<Object>(
      _path,
      data: _bodyData,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    AppUserDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(AppUserDTO),
      ) as AppUserDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<AppUserDTO>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

  /// updateAppUser
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [appUserDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [AppUserDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<AppUserDTO>> updateAppUser({ 
    required int id,
    required AppUserDTO appUserDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/app-users/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
    final _options = Options(
      method: r'PUT',
      headers: <String, dynamic>{
        ...?headers,
      },
      extra: <String, dynamic>{
        'secure': <Map<String, String>>[],
        ...?extra,
      },
      contentType: 'application/json',
      validateStatus: validateStatus,
    );

    dynamic _bodyData;

    try {
      const _type = FullType(AppUserDTO);
      _bodyData = _serializers.serialize(appUserDTO, specifiedType: _type);

    } catch(error, stackTrace) {
      throw DioException(
         requestOptions: _options.compose(
          _dio.options,
          _path,
        ),
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    final _response = await _dio.request<Object>(
      _path,
      data: _bodyData,
      options: _options,
      cancelToken: cancelToken,
      onSendProgress: onSendProgress,
      onReceiveProgress: onReceiveProgress,
    );

    AppUserDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(AppUserDTO),
      ) as AppUserDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<AppUserDTO>(
      data: _responseData,
      headers: _response.headers,
      isRedirect: _response.isRedirect,
      requestOptions: _response.requestOptions,
      redirects: _response.redirects,
      statusCode: _response.statusCode,
      statusMessage: _response.statusMessage,
      extra: _response.extra,
    );
  }

}
