//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/gov_official_content_dto.dart';

class GovOfficialContentResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const GovOfficialContentResourceApi(this._dio, this._serializers);

  /// countGovOfficialContents
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
  /// * [lawPeriodContains] 
  /// * [lawPeriodDoesNotContain] 
  /// * [lawPeriodEquals] 
  /// * [lawPeriodNotEquals] 
  /// * [lawPeriodSpecified] 
  /// * [lawPeriodIn] 
  /// * [lawPeriodNotIn] 
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [actionPeriodContains] 
  /// * [actionPeriodDoesNotContain] 
  /// * [actionPeriodEquals] 
  /// * [actionPeriodNotEquals] 
  /// * [actionPeriodSpecified] 
  /// * [actionPeriodIn] 
  /// * [actionPeriodNotIn] 
  /// * [datePeriodGreaterThan] 
  /// * [datePeriodLessThan] 
  /// * [datePeriodGreaterThanOrEqual] 
  /// * [datePeriodLessThanOrEqual] 
  /// * [datePeriodEquals] 
  /// * [datePeriodNotEquals] 
  /// * [datePeriodSpecified] 
  /// * [datePeriodIn] 
  /// * [datePeriodNotIn] 
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
  Future<Response<int>> countGovOfficialContents({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? lawPeriodContains,
    String? lawPeriodDoesNotContain,
    String? lawPeriodEquals,
    String? lawPeriodNotEquals,
    bool? lawPeriodSpecified,
    BuiltList<String>? lawPeriodIn,
    BuiltList<String>? lawPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    String? actionPeriodContains,
    String? actionPeriodDoesNotContain,
    String? actionPeriodEquals,
    String? actionPeriodNotEquals,
    bool? actionPeriodSpecified,
    BuiltList<String>? actionPeriodIn,
    BuiltList<String>? actionPeriodNotIn,
    DateTime? datePeriodGreaterThan,
    DateTime? datePeriodLessThan,
    DateTime? datePeriodGreaterThanOrEqual,
    DateTime? datePeriodLessThanOrEqual,
    DateTime? datePeriodEquals,
    DateTime? datePeriodNotEquals,
    bool? datePeriodSpecified,
    BuiltList<DateTime>? datePeriodIn,
    BuiltList<DateTime>? datePeriodNotIn,
    bool? distinct,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents/count';
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
      if (lawPeriodContains != null) r'law.contains': encodeQueryParameter(_serializers, lawPeriodContains, const FullType(String)),
      if (lawPeriodDoesNotContain != null) r'law.doesNotContain': encodeQueryParameter(_serializers, lawPeriodDoesNotContain, const FullType(String)),
      if (lawPeriodEquals != null) r'law.equals': encodeQueryParameter(_serializers, lawPeriodEquals, const FullType(String)),
      if (lawPeriodNotEquals != null) r'law.notEquals': encodeQueryParameter(_serializers, lawPeriodNotEquals, const FullType(String)),
      if (lawPeriodSpecified != null) r'law.specified': encodeQueryParameter(_serializers, lawPeriodSpecified, const FullType(bool)),
      if (lawPeriodIn != null) r'law.in': encodeCollectionQueryParameter<String>(_serializers, lawPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (lawPeriodNotIn != null) r'law.notIn': encodeCollectionQueryParameter<String>(_serializers, lawPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (actionPeriodContains != null) r'action.contains': encodeQueryParameter(_serializers, actionPeriodContains, const FullType(String)),
      if (actionPeriodDoesNotContain != null) r'action.doesNotContain': encodeQueryParameter(_serializers, actionPeriodDoesNotContain, const FullType(String)),
      if (actionPeriodEquals != null) r'action.equals': encodeQueryParameter(_serializers, actionPeriodEquals, const FullType(String)),
      if (actionPeriodNotEquals != null) r'action.notEquals': encodeQueryParameter(_serializers, actionPeriodNotEquals, const FullType(String)),
      if (actionPeriodSpecified != null) r'action.specified': encodeQueryParameter(_serializers, actionPeriodSpecified, const FullType(bool)),
      if (actionPeriodIn != null) r'action.in': encodeCollectionQueryParameter<String>(_serializers, actionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (actionPeriodNotIn != null) r'action.notIn': encodeCollectionQueryParameter<String>(_serializers, actionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (datePeriodGreaterThan != null) r'date.greaterThan': encodeQueryParameter(_serializers, datePeriodGreaterThan, const FullType(DateTime)),
      if (datePeriodLessThan != null) r'date.lessThan': encodeQueryParameter(_serializers, datePeriodLessThan, const FullType(DateTime)),
      if (datePeriodGreaterThanOrEqual != null) r'date.greaterThanOrEqual': encodeQueryParameter(_serializers, datePeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (datePeriodLessThanOrEqual != null) r'date.lessThanOrEqual': encodeQueryParameter(_serializers, datePeriodLessThanOrEqual, const FullType(DateTime)),
      if (datePeriodEquals != null) r'date.equals': encodeQueryParameter(_serializers, datePeriodEquals, const FullType(DateTime)),
      if (datePeriodNotEquals != null) r'date.notEquals': encodeQueryParameter(_serializers, datePeriodNotEquals, const FullType(DateTime)),
      if (datePeriodSpecified != null) r'date.specified': encodeQueryParameter(_serializers, datePeriodSpecified, const FullType(bool)),
      if (datePeriodIn != null) r'date.in': encodeCollectionQueryParameter<DateTime>(_serializers, datePeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (datePeriodNotIn != null) r'date.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, datePeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
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

  /// createGovOfficialContent
  /// 
  ///
  /// Parameters:
  /// * [govOfficialContentDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GovOfficialContentDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GovOfficialContentDTO>> createGovOfficialContent({ 
    required GovOfficialContentDTO govOfficialContentDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents';
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
      const _type = FullType(GovOfficialContentDTO);
      _bodyData = _serializers.serialize(govOfficialContentDTO, specifiedType: _type);

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

    GovOfficialContentDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GovOfficialContentDTO),
      ) as GovOfficialContentDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GovOfficialContentDTO>(
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

  /// deleteGovOfficialContent
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
  Future<Response<void>> deleteGovOfficialContent({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

  /// getAllGovOfficialContents
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
  /// * [lawPeriodContains] 
  /// * [lawPeriodDoesNotContain] 
  /// * [lawPeriodEquals] 
  /// * [lawPeriodNotEquals] 
  /// * [lawPeriodSpecified] 
  /// * [lawPeriodIn] 
  /// * [lawPeriodNotIn] 
  /// * [descriptionPeriodContains] 
  /// * [descriptionPeriodDoesNotContain] 
  /// * [descriptionPeriodEquals] 
  /// * [descriptionPeriodNotEquals] 
  /// * [descriptionPeriodSpecified] 
  /// * [descriptionPeriodIn] 
  /// * [descriptionPeriodNotIn] 
  /// * [actionPeriodContains] 
  /// * [actionPeriodDoesNotContain] 
  /// * [actionPeriodEquals] 
  /// * [actionPeriodNotEquals] 
  /// * [actionPeriodSpecified] 
  /// * [actionPeriodIn] 
  /// * [actionPeriodNotIn] 
  /// * [datePeriodGreaterThan] 
  /// * [datePeriodLessThan] 
  /// * [datePeriodGreaterThanOrEqual] 
  /// * [datePeriodLessThanOrEqual] 
  /// * [datePeriodEquals] 
  /// * [datePeriodNotEquals] 
  /// * [datePeriodSpecified] 
  /// * [datePeriodIn] 
  /// * [datePeriodNotIn] 
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
  /// Returns a [Future] containing a [Response] with a [BuiltList<GovOfficialContentDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<GovOfficialContentDTO>>> getAllGovOfficialContents({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? lawPeriodContains,
    String? lawPeriodDoesNotContain,
    String? lawPeriodEquals,
    String? lawPeriodNotEquals,
    bool? lawPeriodSpecified,
    BuiltList<String>? lawPeriodIn,
    BuiltList<String>? lawPeriodNotIn,
    String? descriptionPeriodContains,
    String? descriptionPeriodDoesNotContain,
    String? descriptionPeriodEquals,
    String? descriptionPeriodNotEquals,
    bool? descriptionPeriodSpecified,
    BuiltList<String>? descriptionPeriodIn,
    BuiltList<String>? descriptionPeriodNotIn,
    String? actionPeriodContains,
    String? actionPeriodDoesNotContain,
    String? actionPeriodEquals,
    String? actionPeriodNotEquals,
    bool? actionPeriodSpecified,
    BuiltList<String>? actionPeriodIn,
    BuiltList<String>? actionPeriodNotIn,
    DateTime? datePeriodGreaterThan,
    DateTime? datePeriodLessThan,
    DateTime? datePeriodGreaterThanOrEqual,
    DateTime? datePeriodLessThanOrEqual,
    DateTime? datePeriodEquals,
    DateTime? datePeriodNotEquals,
    bool? datePeriodSpecified,
    BuiltList<DateTime>? datePeriodIn,
    BuiltList<DateTime>? datePeriodNotIn,
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
    final _path = r'/api/gov-official-contents';
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
      if (lawPeriodContains != null) r'law.contains': encodeQueryParameter(_serializers, lawPeriodContains, const FullType(String)),
      if (lawPeriodDoesNotContain != null) r'law.doesNotContain': encodeQueryParameter(_serializers, lawPeriodDoesNotContain, const FullType(String)),
      if (lawPeriodEquals != null) r'law.equals': encodeQueryParameter(_serializers, lawPeriodEquals, const FullType(String)),
      if (lawPeriodNotEquals != null) r'law.notEquals': encodeQueryParameter(_serializers, lawPeriodNotEquals, const FullType(String)),
      if (lawPeriodSpecified != null) r'law.specified': encodeQueryParameter(_serializers, lawPeriodSpecified, const FullType(bool)),
      if (lawPeriodIn != null) r'law.in': encodeCollectionQueryParameter<String>(_serializers, lawPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (lawPeriodNotIn != null) r'law.notIn': encodeCollectionQueryParameter<String>(_serializers, lawPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodContains != null) r'description.contains': encodeQueryParameter(_serializers, descriptionPeriodContains, const FullType(String)),
      if (descriptionPeriodDoesNotContain != null) r'description.doesNotContain': encodeQueryParameter(_serializers, descriptionPeriodDoesNotContain, const FullType(String)),
      if (descriptionPeriodEquals != null) r'description.equals': encodeQueryParameter(_serializers, descriptionPeriodEquals, const FullType(String)),
      if (descriptionPeriodNotEquals != null) r'description.notEquals': encodeQueryParameter(_serializers, descriptionPeriodNotEquals, const FullType(String)),
      if (descriptionPeriodSpecified != null) r'description.specified': encodeQueryParameter(_serializers, descriptionPeriodSpecified, const FullType(bool)),
      if (descriptionPeriodIn != null) r'description.in': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (descriptionPeriodNotIn != null) r'description.notIn': encodeCollectionQueryParameter<String>(_serializers, descriptionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (actionPeriodContains != null) r'action.contains': encodeQueryParameter(_serializers, actionPeriodContains, const FullType(String)),
      if (actionPeriodDoesNotContain != null) r'action.doesNotContain': encodeQueryParameter(_serializers, actionPeriodDoesNotContain, const FullType(String)),
      if (actionPeriodEquals != null) r'action.equals': encodeQueryParameter(_serializers, actionPeriodEquals, const FullType(String)),
      if (actionPeriodNotEquals != null) r'action.notEquals': encodeQueryParameter(_serializers, actionPeriodNotEquals, const FullType(String)),
      if (actionPeriodSpecified != null) r'action.specified': encodeQueryParameter(_serializers, actionPeriodSpecified, const FullType(bool)),
      if (actionPeriodIn != null) r'action.in': encodeCollectionQueryParameter<String>(_serializers, actionPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (actionPeriodNotIn != null) r'action.notIn': encodeCollectionQueryParameter<String>(_serializers, actionPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (datePeriodGreaterThan != null) r'date.greaterThan': encodeQueryParameter(_serializers, datePeriodGreaterThan, const FullType(DateTime)),
      if (datePeriodLessThan != null) r'date.lessThan': encodeQueryParameter(_serializers, datePeriodLessThan, const FullType(DateTime)),
      if (datePeriodGreaterThanOrEqual != null) r'date.greaterThanOrEqual': encodeQueryParameter(_serializers, datePeriodGreaterThanOrEqual, const FullType(DateTime)),
      if (datePeriodLessThanOrEqual != null) r'date.lessThanOrEqual': encodeQueryParameter(_serializers, datePeriodLessThanOrEqual, const FullType(DateTime)),
      if (datePeriodEquals != null) r'date.equals': encodeQueryParameter(_serializers, datePeriodEquals, const FullType(DateTime)),
      if (datePeriodNotEquals != null) r'date.notEquals': encodeQueryParameter(_serializers, datePeriodNotEquals, const FullType(DateTime)),
      if (datePeriodSpecified != null) r'date.specified': encodeQueryParameter(_serializers, datePeriodSpecified, const FullType(bool)),
      if (datePeriodIn != null) r'date.in': encodeCollectionQueryParameter<DateTime>(_serializers, datePeriodIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
      if (datePeriodNotIn != null) r'date.notIn': encodeCollectionQueryParameter<DateTime>(_serializers, datePeriodNotIn, const FullType(BuiltList, [FullType(DateTime)]), format: ListFormat.multi,),
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

    BuiltList<GovOfficialContentDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(GovOfficialContentDTO)]),
      ) as BuiltList<GovOfficialContentDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<GovOfficialContentDTO>>(
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

  /// getGovOfficialContent
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
  /// Returns a [Future] containing a [Response] with a [GovOfficialContentDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GovOfficialContentDTO>> getGovOfficialContent({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

    GovOfficialContentDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GovOfficialContentDTO),
      ) as GovOfficialContentDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GovOfficialContentDTO>(
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

  /// partialUpdateGovOfficialContent
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [govOfficialContentDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GovOfficialContentDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GovOfficialContentDTO>> partialUpdateGovOfficialContent({ 
    required int id,
    required GovOfficialContentDTO govOfficialContentDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(GovOfficialContentDTO);
      _bodyData = _serializers.serialize(govOfficialContentDTO, specifiedType: _type);

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

    GovOfficialContentDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GovOfficialContentDTO),
      ) as GovOfficialContentDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GovOfficialContentDTO>(
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

  /// updateGovOfficialContent
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [govOfficialContentDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [GovOfficialContentDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<GovOfficialContentDTO>> updateGovOfficialContent({ 
    required int id,
    required GovOfficialContentDTO govOfficialContentDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/gov-official-contents/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(GovOfficialContentDTO);
      _bodyData = _serializers.serialize(govOfficialContentDTO, specifiedType: _type);

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

    GovOfficialContentDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(GovOfficialContentDTO),
      ) as GovOfficialContentDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<GovOfficialContentDTO>(
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
