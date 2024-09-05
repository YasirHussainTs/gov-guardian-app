//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/report_header_dto.dart';

class ReportHeaderResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const ReportHeaderResourceApi(this._dio, this._serializers);

  /// countReportHeaders
  /// 
  ///
  /// Parameters:
  /// * [idPeriodContains] 
  /// * [idPeriodDoesNotContain] 
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
  /// * [titlePeriodContains] 
  /// * [titlePeriodDoesNotContain] 
  /// * [titlePeriodEquals] 
  /// * [titlePeriodNotEquals] 
  /// * [titlePeriodSpecified] 
  /// * [titlePeriodIn] 
  /// * [titlePeriodNotIn] 
  /// * [timestampPeriodGreaterThan] 
  /// * [timestampPeriodLessThan] 
  /// * [timestampPeriodGreaterThanOrEqual] 
  /// * [timestampPeriodLessThanOrEqual] 
  /// * [timestampPeriodEquals] 
  /// * [timestampPeriodNotEquals] 
  /// * [timestampPeriodSpecified] 
  /// * [timestampPeriodIn] 
  /// * [timestampPeriodNotIn] 
  /// * [statusPeriodContains] 
  /// * [statusPeriodDoesNotContain] 
  /// * [statusPeriodEquals] 
  /// * [statusPeriodNotEquals] 
  /// * [statusPeriodSpecified] 
  /// * [statusPeriodIn] 
  /// * [statusPeriodNotIn] 
  /// * [appUserIdPeriodGreaterThan] 
  /// * [appUserIdPeriodLessThan] 
  /// * [appUserIdPeriodGreaterThanOrEqual] 
  /// * [appUserIdPeriodLessThanOrEqual] 
  /// * [appUserIdPeriodEquals] 
  /// * [appUserIdPeriodNotEquals] 
  /// * [appUserIdPeriodSpecified] 
  /// * [appUserIdPeriodIn] 
  /// * [appUserIdPeriodNotIn] 
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
  Future<Response<int>> countReportHeaders({ 
    String? idPeriodContains,
    String? idPeriodDoesNotContain,
    String? idPeriodEquals,
    String? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<String>? idPeriodIn,
    BuiltList<String>? idPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    String? titlePeriodContains,
    String? titlePeriodDoesNotContain,
    String? titlePeriodEquals,
    String? titlePeriodNotEquals,
    bool? titlePeriodSpecified,
    BuiltList<String>? titlePeriodIn,
    BuiltList<String>? titlePeriodNotIn,
    DateTime? timestampPeriodGreaterThan,
    DateTime? timestampPeriodLessThan,
    DateTime? timestampPeriodGreaterThanOrEqual,
    DateTime? timestampPeriodLessThanOrEqual,
    DateTime? timestampPeriodEquals,
    DateTime? timestampPeriodNotEquals,
    bool? timestampPeriodSpecified,
    BuiltList<DateTime>? timestampPeriodIn,
    BuiltList<DateTime>? timestampPeriodNotIn,
    String? statusPeriodContains,
    String? statusPeriodDoesNotContain,
    String? statusPeriodEquals,
    String? statusPeriodNotEquals,
    bool? statusPeriodSpecified,
    BuiltList<String>? statusPeriodIn,
    BuiltList<String>? statusPeriodNotIn,
    int? appUserIdPeriodGreaterThan,
    int? appUserIdPeriodLessThan,
    int? appUserIdPeriodGreaterThanOrEqual,
    int? appUserIdPeriodLessThanOrEqual,
    int? appUserIdPeriodEquals,
    int? appUserIdPeriodNotEquals,
    bool? appUserIdPeriodSpecified,
    BuiltList<int>? appUserIdPeriodIn,
    BuiltList<int>? appUserIdPeriodNotIn,
    bool? distinct,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers/count';
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
      if (idPeriodContains != null) r'id.contains': encodeQueryParameter(_serializers, idPeriodContains, const FullType(String)),
      if (idPeriodDoesNotContain != null) r'id.doesNotContain': encodeQueryParameter(_serializers, idPeriodDoesNotContain, const FullType(String)),
      if (idPeriodEquals != null) r'id.equals': encodeQueryParameter(_serializers, idPeriodEquals, const FullType(String)),
      if (idPeriodNotEquals != null) r'id.notEquals': encodeQueryParameter(_serializers, idPeriodNotEquals, const FullType(String)),
      if (idPeriodSpecified != null) r'id.specified': encodeQueryParameter(_serializers, idPeriodSpecified, const FullType(bool)),
      if (idPeriodIn != null) r'id.in': encodeCollectionQueryParameter<String>(_serializers, idPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (idPeriodNotIn != null) r'id.notIn': encodeCollectionQueryParameter<String>(_serializers, idPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (titlePeriodContains != null) r'title.contains': encodeQueryParameter(_serializers, titlePeriodContains, const FullType(String)),
      if (titlePeriodDoesNotContain != null) r'title.doesNotContain': encodeQueryParameter(_serializers, titlePeriodDoesNotContain, const FullType(String)),
      if (titlePeriodEquals != null) r'title.equals': encodeQueryParameter(_serializers, titlePeriodEquals, const FullType(String)),
      if (titlePeriodNotEquals != null) r'title.notEquals': encodeQueryParameter(_serializers, titlePeriodNotEquals, const FullType(String)),
      if (titlePeriodSpecified != null) r'title.specified': encodeQueryParameter(_serializers, titlePeriodSpecified, const FullType(bool)),
      if (titlePeriodIn != null) r'title.in': encodeCollectionQueryParameter<String>(_serializers, titlePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (titlePeriodNotIn != null) r'title.notIn': encodeCollectionQueryParameter<String>(_serializers, titlePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (timestampPeriodGreaterThan != null) r'timestamp.greaterThan': encodeQueryParameter(_serializers, timestampPeriodGreaterThan, const FullType(DateTime)),
      if (timestampPeriodLessThan != null) r'timestamp.lessThan': encodeQueryParameter(_serializers, timestampPeriodLessThan, const FullType(DateTime)),
      if (timestampPeriodGreaterThanOrEqual != null) r'timestamp.greaterThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodLessThanOrEqual != null) r'timestamp.lessThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodLessThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodEquals != null) r'timestamp.equals': encodeQueryParameter(_serializers, timestampPeriodEquals, const FullType(DateTime)),
      if (timestampPeriodNotEquals != null) r'timestamp.notEquals': encodeQueryParameter(_serializers, timestampPeriodNotEquals, const FullType(DateTime)),
      if (timestampPeriodSpecified != null) r'timestamp.specified': encodeQueryParameter(_serializers, timestampPeriodSpecified, const FullType(bool)),
      if (timestampPeriodIn != null) r'timestamp.in': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (timestampPeriodNotIn != null) r'timestamp.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (statusPeriodContains != null) r'status.contains': encodeQueryParameter(_serializers, statusPeriodContains, const FullType(String)),
      if (statusPeriodDoesNotContain != null) r'status.doesNotContain': encodeQueryParameter(_serializers, statusPeriodDoesNotContain, const FullType(String)),
      if (statusPeriodEquals != null) r'status.equals': encodeQueryParameter(_serializers, statusPeriodEquals, const FullType(String)),
      if (statusPeriodNotEquals != null) r'status.notEquals': encodeQueryParameter(_serializers, statusPeriodNotEquals, const FullType(String)),
      if (statusPeriodSpecified != null) r'status.specified': encodeQueryParameter(_serializers, statusPeriodSpecified, const FullType(bool)),
      if (statusPeriodIn != null) r'status.in': encodeCollectionQueryParameter<String>(_serializers, statusPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (statusPeriodNotIn != null) r'status.notIn': encodeCollectionQueryParameter<String>(_serializers, statusPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (appUserIdPeriodGreaterThan != null) r'appUserId.greaterThan': encodeQueryParameter(_serializers, appUserIdPeriodGreaterThan, const FullType(int)),
      if (appUserIdPeriodLessThan != null) r'appUserId.lessThan': encodeQueryParameter(_serializers, appUserIdPeriodLessThan, const FullType(int)),
      if (appUserIdPeriodGreaterThanOrEqual != null) r'appUserId.greaterThanOrEqual': encodeQueryParameter(_serializers, appUserIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (appUserIdPeriodLessThanOrEqual != null) r'appUserId.lessThanOrEqual': encodeQueryParameter(_serializers, appUserIdPeriodLessThanOrEqual, const FullType(int)),
      if (appUserIdPeriodEquals != null) r'appUserId.equals': encodeQueryParameter(_serializers, appUserIdPeriodEquals, const FullType(int)),
      if (appUserIdPeriodNotEquals != null) r'appUserId.notEquals': encodeQueryParameter(_serializers, appUserIdPeriodNotEquals, const FullType(int)),
      if (appUserIdPeriodSpecified != null) r'appUserId.specified': encodeQueryParameter(_serializers, appUserIdPeriodSpecified, const FullType(bool)),
      if (appUserIdPeriodIn != null) r'appUserId.in': encodeCollectionQueryParameter<int>(_serializers, appUserIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (appUserIdPeriodNotIn != null) r'appUserId.notIn': encodeCollectionQueryParameter<int>(_serializers, appUserIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
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

  /// createReportHeader
  /// 
  ///
  /// Parameters:
  /// * [reportHeaderDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportHeaderDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportHeaderDTO>> createReportHeader({ 
    required ReportHeaderDTO reportHeaderDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers';
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
      const _type = FullType(ReportHeaderDTO);
      _bodyData = _serializers.serialize(reportHeaderDTO, specifiedType: _type);

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

    ReportHeaderDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportHeaderDTO),
      ) as ReportHeaderDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportHeaderDTO>(
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

  /// deleteReportHeader
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
  Future<Response<void>> deleteReportHeader({ 
    required String id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(String)).toString());
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

  /// getAllReportHeaders
  /// 
  ///
  /// Parameters:
  /// * [idPeriodContains] 
  /// * [idPeriodDoesNotContain] 
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
  /// * [titlePeriodContains] 
  /// * [titlePeriodDoesNotContain] 
  /// * [titlePeriodEquals] 
  /// * [titlePeriodNotEquals] 
  /// * [titlePeriodSpecified] 
  /// * [titlePeriodIn] 
  /// * [titlePeriodNotIn] 
  /// * [timestampPeriodGreaterThan] 
  /// * [timestampPeriodLessThan] 
  /// * [timestampPeriodGreaterThanOrEqual] 
  /// * [timestampPeriodLessThanOrEqual] 
  /// * [timestampPeriodEquals] 
  /// * [timestampPeriodNotEquals] 
  /// * [timestampPeriodSpecified] 
  /// * [timestampPeriodIn] 
  /// * [timestampPeriodNotIn] 
  /// * [statusPeriodContains] 
  /// * [statusPeriodDoesNotContain] 
  /// * [statusPeriodEquals] 
  /// * [statusPeriodNotEquals] 
  /// * [statusPeriodSpecified] 
  /// * [statusPeriodIn] 
  /// * [statusPeriodNotIn] 
  /// * [appUserIdPeriodGreaterThan] 
  /// * [appUserIdPeriodLessThan] 
  /// * [appUserIdPeriodGreaterThanOrEqual] 
  /// * [appUserIdPeriodLessThanOrEqual] 
  /// * [appUserIdPeriodEquals] 
  /// * [appUserIdPeriodNotEquals] 
  /// * [appUserIdPeriodSpecified] 
  /// * [appUserIdPeriodIn] 
  /// * [appUserIdPeriodNotIn] 
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
  /// Returns a [Future] containing a [Response] with a [BuiltList<ReportHeaderDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<ReportHeaderDTO>>> getAllReportHeaders({ 
    String? idPeriodContains,
    String? idPeriodDoesNotContain,
    String? idPeriodEquals,
    String? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<String>? idPeriodIn,
    BuiltList<String>? idPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    String? titlePeriodContains,
    String? titlePeriodDoesNotContain,
    String? titlePeriodEquals,
    String? titlePeriodNotEquals,
    bool? titlePeriodSpecified,
    BuiltList<String>? titlePeriodIn,
    BuiltList<String>? titlePeriodNotIn,
    DateTime? timestampPeriodGreaterThan,
    DateTime? timestampPeriodLessThan,
    DateTime? timestampPeriodGreaterThanOrEqual,
    DateTime? timestampPeriodLessThanOrEqual,
    DateTime? timestampPeriodEquals,
    DateTime? timestampPeriodNotEquals,
    bool? timestampPeriodSpecified,
    BuiltList<DateTime>? timestampPeriodIn,
    BuiltList<DateTime>? timestampPeriodNotIn,
    String? statusPeriodContains,
    String? statusPeriodDoesNotContain,
    String? statusPeriodEquals,
    String? statusPeriodNotEquals,
    bool? statusPeriodSpecified,
    BuiltList<String>? statusPeriodIn,
    BuiltList<String>? statusPeriodNotIn,
    int? appUserIdPeriodGreaterThan,
    int? appUserIdPeriodLessThan,
    int? appUserIdPeriodGreaterThanOrEqual,
    int? appUserIdPeriodLessThanOrEqual,
    int? appUserIdPeriodEquals,
    int? appUserIdPeriodNotEquals,
    bool? appUserIdPeriodSpecified,
    BuiltList<int>? appUserIdPeriodIn,
    BuiltList<int>? appUserIdPeriodNotIn,
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
    final _path = r'/api/report-headers';
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
      if (idPeriodContains != null) r'id.contains': encodeQueryParameter(_serializers, idPeriodContains, const FullType(String)),
      if (idPeriodDoesNotContain != null) r'id.doesNotContain': encodeQueryParameter(_serializers, idPeriodDoesNotContain, const FullType(String)),
      if (idPeriodEquals != null) r'id.equals': encodeQueryParameter(_serializers, idPeriodEquals, const FullType(String)),
      if (idPeriodNotEquals != null) r'id.notEquals': encodeQueryParameter(_serializers, idPeriodNotEquals, const FullType(String)),
      if (idPeriodSpecified != null) r'id.specified': encodeQueryParameter(_serializers, idPeriodSpecified, const FullType(bool)),
      if (idPeriodIn != null) r'id.in': encodeCollectionQueryParameter<String>(_serializers, idPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (idPeriodNotIn != null) r'id.notIn': encodeCollectionQueryParameter<String>(_serializers, idPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (titlePeriodContains != null) r'title.contains': encodeQueryParameter(_serializers, titlePeriodContains, const FullType(String)),
      if (titlePeriodDoesNotContain != null) r'title.doesNotContain': encodeQueryParameter(_serializers, titlePeriodDoesNotContain, const FullType(String)),
      if (titlePeriodEquals != null) r'title.equals': encodeQueryParameter(_serializers, titlePeriodEquals, const FullType(String)),
      if (titlePeriodNotEquals != null) r'title.notEquals': encodeQueryParameter(_serializers, titlePeriodNotEquals, const FullType(String)),
      if (titlePeriodSpecified != null) r'title.specified': encodeQueryParameter(_serializers, titlePeriodSpecified, const FullType(bool)),
      if (titlePeriodIn != null) r'title.in': encodeCollectionQueryParameter<String>(_serializers, titlePeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (titlePeriodNotIn != null) r'title.notIn': encodeCollectionQueryParameter<String>(_serializers, titlePeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (timestampPeriodGreaterThan != null) r'timestamp.greaterThan': encodeQueryParameter(_serializers, timestampPeriodGreaterThan, const FullType(DateTime)),
      if (timestampPeriodLessThan != null) r'timestamp.lessThan': encodeQueryParameter(_serializers, timestampPeriodLessThan, const FullType(DateTime)),
      if (timestampPeriodGreaterThanOrEqual != null) r'timestamp.greaterThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodLessThanOrEqual != null) r'timestamp.lessThanOrEqual': encodeQueryParameter(_serializers, timestampPeriodLessThanOrEqual, const FullType(DateTime)),
      if (timestampPeriodEquals != null) r'timestamp.equals': encodeQueryParameter(_serializers, timestampPeriodEquals, const FullType(DateTime)),
      if (timestampPeriodNotEquals != null) r'timestamp.notEquals': encodeQueryParameter(_serializers, timestampPeriodNotEquals, const FullType(DateTime)),
      if (timestampPeriodSpecified != null) r'timestamp.specified': encodeQueryParameter(_serializers, timestampPeriodSpecified, const FullType(bool)),
      if (timestampPeriodIn != null) r'timestamp.in': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (timestampPeriodNotIn != null) r'timestamp.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, timestampPeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (statusPeriodContains != null) r'status.contains': encodeQueryParameter(_serializers, statusPeriodContains, const FullType(String)),
      if (statusPeriodDoesNotContain != null) r'status.doesNotContain': encodeQueryParameter(_serializers, statusPeriodDoesNotContain, const FullType(String)),
      if (statusPeriodEquals != null) r'status.equals': encodeQueryParameter(_serializers, statusPeriodEquals, const FullType(String)),
      if (statusPeriodNotEquals != null) r'status.notEquals': encodeQueryParameter(_serializers, statusPeriodNotEquals, const FullType(String)),
      if (statusPeriodSpecified != null) r'status.specified': encodeQueryParameter(_serializers, statusPeriodSpecified, const FullType(bool)),
      if (statusPeriodIn != null) r'status.in': encodeCollectionQueryParameter<String>(_serializers, statusPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (statusPeriodNotIn != null) r'status.notIn': encodeCollectionQueryParameter<String>(_serializers, statusPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (appUserIdPeriodGreaterThan != null) r'appUserId.greaterThan': encodeQueryParameter(_serializers, appUserIdPeriodGreaterThan, const FullType(int)),
      if (appUserIdPeriodLessThan != null) r'appUserId.lessThan': encodeQueryParameter(_serializers, appUserIdPeriodLessThan, const FullType(int)),
      if (appUserIdPeriodGreaterThanOrEqual != null) r'appUserId.greaterThanOrEqual': encodeQueryParameter(_serializers, appUserIdPeriodGreaterThanOrEqual, const FullType(int)),
      if (appUserIdPeriodLessThanOrEqual != null) r'appUserId.lessThanOrEqual': encodeQueryParameter(_serializers, appUserIdPeriodLessThanOrEqual, const FullType(int)),
      if (appUserIdPeriodEquals != null) r'appUserId.equals': encodeQueryParameter(_serializers, appUserIdPeriodEquals, const FullType(int)),
      if (appUserIdPeriodNotEquals != null) r'appUserId.notEquals': encodeQueryParameter(_serializers, appUserIdPeriodNotEquals, const FullType(int)),
      if (appUserIdPeriodSpecified != null) r'appUserId.specified': encodeQueryParameter(_serializers, appUserIdPeriodSpecified, const FullType(bool)),
      if (appUserIdPeriodIn != null) r'appUserId.in': encodeCollectionQueryParameter<int>(_serializers, appUserIdPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (appUserIdPeriodNotIn != null) r'appUserId.notIn': encodeCollectionQueryParameter<int>(_serializers, appUserIdPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
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

    BuiltList<ReportHeaderDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(ReportHeaderDTO)]),
      ) as BuiltList<ReportHeaderDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<ReportHeaderDTO>>(
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

  /// getReportHeader
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
  /// Returns a [Future] containing a [Response] with a [ReportHeaderDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportHeaderDTO>> getReportHeader({ 
    required String id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(String)).toString());
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

    ReportHeaderDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportHeaderDTO),
      ) as ReportHeaderDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportHeaderDTO>(
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

  /// partialUpdateReportHeader
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reportHeaderDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportHeaderDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportHeaderDTO>> partialUpdateReportHeader({ 
    required String id,
    required ReportHeaderDTO reportHeaderDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(String)).toString());
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
      const _type = FullType(ReportHeaderDTO);
      _bodyData = _serializers.serialize(reportHeaderDTO, specifiedType: _type);

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

    ReportHeaderDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportHeaderDTO),
      ) as ReportHeaderDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportHeaderDTO>(
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

  /// updateReportHeader
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reportHeaderDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportHeaderDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportHeaderDTO>> updateReportHeader({ 
    required String id,
    required ReportHeaderDTO reportHeaderDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-headers/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(String)).toString());
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
      const _type = FullType(ReportHeaderDTO);
      _bodyData = _serializers.serialize(reportHeaderDTO, specifiedType: _type);

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

    ReportHeaderDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportHeaderDTO),
      ) as ReportHeaderDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportHeaderDTO>(
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
