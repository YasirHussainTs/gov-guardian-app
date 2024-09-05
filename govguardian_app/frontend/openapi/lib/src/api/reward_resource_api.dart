//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/reward_dto.dart';

class RewardResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const RewardResourceApi(this._dio, this._serializers);

  /// countRewards
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
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [pointsPeriodGreaterThan] 
  /// * [pointsPeriodLessThan] 
  /// * [pointsPeriodGreaterThanOrEqual] 
  /// * [pointsPeriodLessThanOrEqual] 
  /// * [pointsPeriodEquals] 
  /// * [pointsPeriodNotEquals] 
  /// * [pointsPeriodSpecified] 
  /// * [pointsPeriodIn] 
  /// * [pointsPeriodNotIn] 
  /// * [timestampPeriodGreaterThan] 
  /// * [timestampPeriodLessThan] 
  /// * [timestampPeriodGreaterThanOrEqual] 
  /// * [timestampPeriodLessThanOrEqual] 
  /// * [timestampPeriodEquals] 
  /// * [timestampPeriodNotEquals] 
  /// * [timestampPeriodSpecified] 
  /// * [timestampPeriodIn] 
  /// * [timestampPeriodNotIn] 
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
  Future<Response<int>> countRewards({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    int? pointsPeriodGreaterThan,
    int? pointsPeriodLessThan,
    int? pointsPeriodGreaterThanOrEqual,
    int? pointsPeriodLessThanOrEqual,
    int? pointsPeriodEquals,
    int? pointsPeriodNotEquals,
    bool? pointsPeriodSpecified,
    BuiltList<int>? pointsPeriodIn,
    BuiltList<int>? pointsPeriodNotIn,
    DateTime? timestampPeriodGreaterThan,
    DateTime? timestampPeriodLessThan,
    DateTime? timestampPeriodGreaterThanOrEqual,
    DateTime? timestampPeriodLessThanOrEqual,
    DateTime? timestampPeriodEquals,
    DateTime? timestampPeriodNotEquals,
    bool? timestampPeriodSpecified,
    BuiltList<DateTime>? timestampPeriodIn,
    BuiltList<DateTime>? timestampPeriodNotIn,
    bool? distinct,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards/count';
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
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (pointsPeriodGreaterThan != null) r'points.greaterThan': encodeQueryParameter(_serializers, pointsPeriodGreaterThan, const FullType(int)),
      if (pointsPeriodLessThan != null) r'points.lessThan': encodeQueryParameter(_serializers, pointsPeriodLessThan, const FullType(int)),
      if (pointsPeriodGreaterThanOrEqual != null) r'points.greaterThanOrEqual': encodeQueryParameter(_serializers, pointsPeriodGreaterThanOrEqual, const FullType(int)),
      if (pointsPeriodLessThanOrEqual != null) r'points.lessThanOrEqual': encodeQueryParameter(_serializers, pointsPeriodLessThanOrEqual, const FullType(int)),
      if (pointsPeriodEquals != null) r'points.equals': encodeQueryParameter(_serializers, pointsPeriodEquals, const FullType(int)),
      if (pointsPeriodNotEquals != null) r'points.notEquals': encodeQueryParameter(_serializers, pointsPeriodNotEquals, const FullType(int)),
      if (pointsPeriodSpecified != null) r'points.specified': encodeQueryParameter(_serializers, pointsPeriodSpecified, const FullType(bool)),
      if (pointsPeriodIn != null) r'points.in': encodeCollectionQueryParameter<int>(_serializers, pointsPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (pointsPeriodNotIn != null) r'points.notIn': encodeCollectionQueryParameter<int>(_serializers, pointsPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (timestampPeriodGreaterThan != null) r'timestamp.greaterThan': encodeQueryParameter(_serializers, timestampPeriodGreaterThan, const FullType(DateTime)),
      if (timestampPeriodLessThan != null) r'timestamp.lessThan': encodeQueryParameter(_serializers, timestampPeriodLessThan, const FullType(DateTime)),
      if (timestampPeriodGreaterThanOrEqual != null) r'timestamp.greaterThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodLessThanOrEqual != null) r'timestamp.lessThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodLessThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodEquals != null) r'timestamp.equals': encodeQueryParameter(_serializers, timestampPeriodEquals, const FullType(DateTime)),
      if (timestampPeriodNotEquals != null) r'timestamp.notEquals': encodeQueryParameter(_serializers, timestampPeriodNotEquals, const FullType(DateTime)),
      if (timestampPeriodSpecified != null) r'timestamp.specified': encodeQueryParameter(_serializers, timestampPeriodSpecified, const FullType(bool)),
      if (timestampPeriodIn != null) r'timestamp.in': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (timestampPeriodNotIn != null) r'timestamp.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
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

  /// createReward
  /// 
  ///
  /// Parameters:
  /// * [rewardDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [RewardDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<RewardDTO>> createReward({ 
    required RewardDTO rewardDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards';
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
      const _type = FullType(RewardDTO);
      _bodyData = _serializers.serialize(rewardDTO, specifiedType: _type);

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

    RewardDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(RewardDTO),
      ) as RewardDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<RewardDTO>(
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

  /// deleteReward
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
  Future<Response<void>> deleteReward({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

  /// getAllRewards
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
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [pointsPeriodGreaterThan] 
  /// * [pointsPeriodLessThan] 
  /// * [pointsPeriodGreaterThanOrEqual] 
  /// * [pointsPeriodLessThanOrEqual] 
  /// * [pointsPeriodEquals] 
  /// * [pointsPeriodNotEquals] 
  /// * [pointsPeriodSpecified] 
  /// * [pointsPeriodIn] 
  /// * [pointsPeriodNotIn] 
  /// * [timestampPeriodGreaterThan] 
  /// * [timestampPeriodLessThan] 
  /// * [timestampPeriodGreaterThanOrEqual] 
  /// * [timestampPeriodLessThanOrEqual] 
  /// * [timestampPeriodEquals] 
  /// * [timestampPeriodNotEquals] 
  /// * [timestampPeriodSpecified] 
  /// * [timestampPeriodIn] 
  /// * [timestampPeriodNotIn] 
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
  /// Returns a [Future] containing a [Response] with a [BuiltList<RewardDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<RewardDTO>>> getAllRewards({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    int? pointsPeriodGreaterThan,
    int? pointsPeriodLessThan,
    int? pointsPeriodGreaterThanOrEqual,
    int? pointsPeriodLessThanOrEqual,
    int? pointsPeriodEquals,
    int? pointsPeriodNotEquals,
    bool? pointsPeriodSpecified,
    BuiltList<int>? pointsPeriodIn,
    BuiltList<int>? pointsPeriodNotIn,
    DateTime? timestampPeriodGreaterThan,
    DateTime? timestampPeriodLessThan,
    DateTime? timestampPeriodGreaterThanOrEqual,
    DateTime? timestampPeriodLessThanOrEqual,
    DateTime? timestampPeriodEquals,
    DateTime? timestampPeriodNotEquals,
    bool? timestampPeriodSpecified,
    BuiltList<DateTime>? timestampPeriodIn,
    BuiltList<DateTime>? timestampPeriodNotIn,
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
    final _path = r'/api/rewards';
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
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (pointsPeriodGreaterThan != null) r'points.greaterThan': encodeQueryParameter(_serializers, pointsPeriodGreaterThan, const FullType(int)),
      if (pointsPeriodLessThan != null) r'points.lessThan': encodeQueryParameter(_serializers, pointsPeriodLessThan, const FullType(int)),
      if (pointsPeriodGreaterThanOrEqual != null) r'points.greaterThanOrEqual': encodeQueryParameter(_serializers, pointsPeriodGreaterThanOrEqual, const FullType(int)),
      if (pointsPeriodLessThanOrEqual != null) r'points.lessThanOrEqual': encodeQueryParameter(_serializers, pointsPeriodLessThanOrEqual, const FullType(int)),
      if (pointsPeriodEquals != null) r'points.equals': encodeQueryParameter(_serializers, pointsPeriodEquals, const FullType(int)),
      if (pointsPeriodNotEquals != null) r'points.notEquals': encodeQueryParameter(_serializers, pointsPeriodNotEquals, const FullType(int)),
      if (pointsPeriodSpecified != null) r'points.specified': encodeQueryParameter(_serializers, pointsPeriodSpecified, const FullType(bool)),
      if (pointsPeriodIn != null) r'points.in': encodeCollectionQueryParameter<int>(_serializers, pointsPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (pointsPeriodNotIn != null) r'points.notIn': encodeCollectionQueryParameter<int>(_serializers, pointsPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (timestampPeriodGreaterThan != null) r'timestamp.greaterThan': encodeQueryParameter(_serializers, timestampPeriodGreaterThan, const FullType(DateTime)),
      if (timestampPeriodLessThan != null) r'timestamp.lessThan': encodeQueryParameter(_serializers, timestampPeriodLessThan, const FullType(DateTime)),
      if (timestampPeriodGreaterThanOrEqual != null) r'timestamp.greaterThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodLessThanOrEqual != null) r'timestamp.lessThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodLessThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodEquals != null) r'timestamp.equals': encodeQueryParameter(_serializers, timestampPeriodEquals, const FullType(DateTime)),
      if (timestampPeriodNotEquals != null) r'timestamp.notEquals': encodeQueryParameter(_serializers, timestampPeriodNotEquals, const FullType(DateTime)),
      if (timestampPeriodSpecified != null) r'timestamp.specified': encodeQueryParameter(_serializers, timestampPeriodSpecified, const FullType(bool)),
      if (timestampPeriodIn != null) r'timestamp.in': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (timestampPeriodNotIn != null) r'timestamp.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
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

    BuiltList<RewardDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(RewardDTO)]),
      ) as BuiltList<RewardDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<RewardDTO>>(
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

  /// getReward
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
  /// Returns a [Future] containing a [Response] with a [RewardDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<RewardDTO>> getReward({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

    RewardDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(RewardDTO),
      ) as RewardDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<RewardDTO>(
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

  /// partialUpdateReward
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [rewardDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [RewardDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<RewardDTO>> partialUpdateReward({ 
    required int id,
    required RewardDTO rewardDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(RewardDTO);
      _bodyData = _serializers.serialize(rewardDTO, specifiedType: _type);

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

    RewardDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(RewardDTO),
      ) as RewardDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<RewardDTO>(
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

  /// updateReward
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [rewardDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [RewardDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<RewardDTO>> updateReward({ 
    required int id,
    required RewardDTO rewardDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/rewards/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(RewardDTO);
      _bodyData = _serializers.serialize(rewardDTO, specifiedType: _type);

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

    RewardDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(RewardDTO),
      ) as RewardDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<RewardDTO>(
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
