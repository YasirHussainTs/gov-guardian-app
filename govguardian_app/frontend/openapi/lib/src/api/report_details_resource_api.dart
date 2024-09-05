//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/report_details_dto.dart';

class ReportDetailsResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const ReportDetailsResourceApi(this._dio, this._serializers);

  /// countReportDetails
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
  /// * [ownerPeriodContains] 
  /// * [ownerPeriodDoesNotContain] 
  /// * [ownerPeriodEquals] 
  /// * [ownerPeriodNotEquals] 
  /// * [ownerPeriodSpecified] 
  /// * [ownerPeriodIn] 
  /// * [ownerPeriodNotIn] 
  /// * [responderPeriodContains] 
  /// * [responderPeriodDoesNotContain] 
  /// * [responderPeriodEquals] 
  /// * [responderPeriodNotEquals] 
  /// * [responderPeriodSpecified] 
  /// * [responderPeriodIn] 
  /// * [responderPeriodNotIn] 
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
  Future<Response<int>> countReportDetails({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? ownerPeriodContains,
    String? ownerPeriodDoesNotContain,
    String? ownerPeriodEquals,
    String? ownerPeriodNotEquals,
    bool? ownerPeriodSpecified,
    BuiltList<String>? ownerPeriodIn,
    BuiltList<String>? ownerPeriodNotIn,
    String? responderPeriodContains,
    String? responderPeriodDoesNotContain,
    String? responderPeriodEquals,
    String? responderPeriodNotEquals,
    bool? responderPeriodSpecified,
    BuiltList<String>? responderPeriodIn,
    BuiltList<String>? responderPeriodNotIn,
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
    final _path = r'/api/report-details/count';
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
      if (ownerPeriodContains != null) r'owner.contains': encodeQueryParameter(_serializers, ownerPeriodContains, const FullType(String)),
      if (ownerPeriodDoesNotContain != null) r'owner.doesNotContain': encodeQueryParameter(_serializers, ownerPeriodDoesNotContain, const FullType(String)),
      if (ownerPeriodEquals != null) r'owner.equals': encodeQueryParameter(_serializers, ownerPeriodEquals, const FullType(String)),
      if (ownerPeriodNotEquals != null) r'owner.notEquals': encodeQueryParameter(_serializers, ownerPeriodNotEquals, const FullType(String)),
      if (ownerPeriodSpecified != null) r'owner.specified': encodeQueryParameter(_serializers, ownerPeriodSpecified, const FullType(bool)),
      if (ownerPeriodIn != null) r'owner.in': encodeCollectionQueryParameter<String>(_serializers, ownerPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (ownerPeriodNotIn != null) r'owner.notIn': encodeCollectionQueryParameter<String>(_serializers, ownerPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (responderPeriodContains != null) r'responder.contains': encodeQueryParameter(_serializers, responderPeriodContains, const FullType(String)),
      if (responderPeriodDoesNotContain != null) r'responder.doesNotContain': encodeQueryParameter(_serializers, responderPeriodDoesNotContain, const FullType(String)),
      if (responderPeriodEquals != null) r'responder.equals': encodeQueryParameter(_serializers, responderPeriodEquals, const FullType(String)),
      if (responderPeriodNotEquals != null) r'responder.notEquals': encodeQueryParameter(_serializers, responderPeriodNotEquals, const FullType(String)),
      if (responderPeriodSpecified != null) r'responder.specified': encodeQueryParameter(_serializers, responderPeriodSpecified, const FullType(bool)),
      if (responderPeriodIn != null) r'responder.in': encodeCollectionQueryParameter<String>(_serializers, responderPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (responderPeriodNotIn != null) r'responder.notIn': encodeCollectionQueryParameter<String>(_serializers, responderPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
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

  /// createReportDetails
  /// 
  ///
  /// Parameters:
  /// * [reportDetailsDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportDetailsDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportDetailsDTO>> createReportDetails({ 
    required ReportDetailsDTO reportDetailsDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-details';
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
      const _type = FullType(ReportDetailsDTO);
      _bodyData = _serializers.serialize(reportDetailsDTO, specifiedType: _type);

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

    ReportDetailsDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportDetailsDTO),
      ) as ReportDetailsDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportDetailsDTO>(
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

  /// deleteReportDetails
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
  Future<Response<void>> deleteReportDetails({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-details/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

  /// getAllReportDetails
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
  /// * [ownerPeriodContains] 
  /// * [ownerPeriodDoesNotContain] 
  /// * [ownerPeriodEquals] 
  /// * [ownerPeriodNotEquals] 
  /// * [ownerPeriodSpecified] 
  /// * [ownerPeriodIn] 
  /// * [ownerPeriodNotIn] 
  /// * [responderPeriodContains] 
  /// * [responderPeriodDoesNotContain] 
  /// * [responderPeriodEquals] 
  /// * [responderPeriodNotEquals] 
  /// * [responderPeriodSpecified] 
  /// * [responderPeriodIn] 
  /// * [responderPeriodNotIn] 
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
  /// Returns a [Future] containing a [Response] with a [BuiltList<ReportDetailsDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<ReportDetailsDTO>>> getAllReportDetails({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? ownerPeriodContains,
    String? ownerPeriodDoesNotContain,
    String? ownerPeriodEquals,
    String? ownerPeriodNotEquals,
    bool? ownerPeriodSpecified,
    BuiltList<String>? ownerPeriodIn,
    BuiltList<String>? ownerPeriodNotIn,
    String? responderPeriodContains,
    String? responderPeriodDoesNotContain,
    String? responderPeriodEquals,
    String? responderPeriodNotEquals,
    bool? responderPeriodSpecified,
    BuiltList<String>? responderPeriodIn,
    BuiltList<String>? responderPeriodNotIn,
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
    final _path = r'/api/report-details';
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
      if (ownerPeriodContains != null) r'owner.contains': encodeQueryParameter(_serializers, ownerPeriodContains, const FullType(String)),
      if (ownerPeriodDoesNotContain != null) r'owner.doesNotContain': encodeQueryParameter(_serializers, ownerPeriodDoesNotContain, const FullType(String)),
      if (ownerPeriodEquals != null) r'owner.equals': encodeQueryParameter(_serializers, ownerPeriodEquals, const FullType(String)),
      if (ownerPeriodNotEquals != null) r'owner.notEquals': encodeQueryParameter(_serializers, ownerPeriodNotEquals, const FullType(String)),
      if (ownerPeriodSpecified != null) r'owner.specified': encodeQueryParameter(_serializers, ownerPeriodSpecified, const FullType(bool)),
      if (ownerPeriodIn != null) r'owner.in': encodeCollectionQueryParameter<String>(_serializers, ownerPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (ownerPeriodNotIn != null) r'owner.notIn': encodeCollectionQueryParameter<String>(_serializers, ownerPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (responderPeriodContains != null) r'responder.contains': encodeQueryParameter(_serializers, responderPeriodContains, const FullType(String)),
      if (responderPeriodDoesNotContain != null) r'responder.doesNotContain': encodeQueryParameter(_serializers, responderPeriodDoesNotContain, const FullType(String)),
      if (responderPeriodEquals != null) r'responder.equals': encodeQueryParameter(_serializers, responderPeriodEquals, const FullType(String)),
      if (responderPeriodNotEquals != null) r'responder.notEquals': encodeQueryParameter(_serializers, responderPeriodNotEquals, const FullType(String)),
      if (responderPeriodSpecified != null) r'responder.specified': encodeQueryParameter(_serializers, responderPeriodSpecified, const FullType(bool)),
      if (responderPeriodIn != null) r'responder.in': encodeCollectionQueryParameter<String>(_serializers, responderPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (responderPeriodNotIn != null) r'responder.notIn': encodeCollectionQueryParameter<String>(_serializers, responderPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
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

    BuiltList<ReportDetailsDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(ReportDetailsDTO)]),
      ) as BuiltList<ReportDetailsDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<ReportDetailsDTO>>(
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

  /// getReportDetails
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
  /// Returns a [Future] containing a [Response] with a [ReportDetailsDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportDetailsDTO>> getReportDetails({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-details/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

    ReportDetailsDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportDetailsDTO),
      ) as ReportDetailsDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportDetailsDTO>(
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

  /// partialUpdateReportDetails
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reportDetailsDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportDetailsDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportDetailsDTO>> partialUpdateReportDetails({ 
    required int id,
    required ReportDetailsDTO reportDetailsDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-details/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(ReportDetailsDTO);
      _bodyData = _serializers.serialize(reportDetailsDTO, specifiedType: _type);

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

    ReportDetailsDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportDetailsDTO),
      ) as ReportDetailsDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportDetailsDTO>(
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

  /// updateReportDetails
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reportDetailsDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReportDetailsDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReportDetailsDTO>> updateReportDetails({ 
    required int id,
    required ReportDetailsDTO reportDetailsDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/report-details/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(ReportDetailsDTO);
      _bodyData = _serializers.serialize(reportDetailsDTO, specifiedType: _type);

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

    ReportDetailsDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReportDetailsDTO),
      ) as ReportDetailsDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReportDetailsDTO>(
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
