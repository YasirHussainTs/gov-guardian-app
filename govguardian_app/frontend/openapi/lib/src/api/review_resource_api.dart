//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:async';

import 'package:built_value/serializer.dart';
import 'package:dio/dio.dart';

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/api_util.dart';
import 'package:openapi/src/model/review_dto.dart';

class ReviewResourceApi {

  final Dio _dio;

  final Serializers _serializers;

  const ReviewResourceApi(this._dio, this._serializers);

  /// countReviews
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
  /// * [contentPeriodContains] 
  /// * [contentPeriodDoesNotContain] 
  /// * [contentPeriodEquals] 
  /// * [contentPeriodNotEquals] 
  /// * [contentPeriodSpecified] 
  /// * [contentPeriodIn] 
  /// * [contentPeriodNotIn] 
  /// * [ratingPeriodGreaterThan] 
  /// * [ratingPeriodLessThan] 
  /// * [ratingPeriodGreaterThanOrEqual] 
  /// * [ratingPeriodLessThanOrEqual] 
  /// * [ratingPeriodEquals] 
  /// * [ratingPeriodNotEquals] 
  /// * [ratingPeriodSpecified] 
  /// * [ratingPeriodIn] 
  /// * [ratingPeriodNotIn] 
  /// * [feedbackPeriodContains] 
  /// * [feedbackPeriodDoesNotContain] 
  /// * [feedbackPeriodEquals] 
  /// * [feedbackPeriodNotEquals] 
  /// * [feedbackPeriodSpecified] 
  /// * [feedbackPeriodIn] 
  /// * [feedbackPeriodNotIn] 
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
  Future<Response<int>> countReviews({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? contentPeriodContains,
    String? contentPeriodDoesNotContain,
    String? contentPeriodEquals,
    String? contentPeriodNotEquals,
    bool? contentPeriodSpecified,
    BuiltList<String>? contentPeriodIn,
    BuiltList<String>? contentPeriodNotIn,
    int? ratingPeriodGreaterThan,
    int? ratingPeriodLessThan,
    int? ratingPeriodGreaterThanOrEqual,
    int? ratingPeriodLessThanOrEqual,
    int? ratingPeriodEquals,
    int? ratingPeriodNotEquals,
    bool? ratingPeriodSpecified,
    BuiltList<int>? ratingPeriodIn,
    BuiltList<int>? ratingPeriodNotIn,
    String? feedbackPeriodContains,
    String? feedbackPeriodDoesNotContain,
    String? feedbackPeriodEquals,
    String? feedbackPeriodNotEquals,
    bool? feedbackPeriodSpecified,
    BuiltList<String>? feedbackPeriodIn,
    BuiltList<String>? feedbackPeriodNotIn,
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
    final _path = r'/api/reviews/count';
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
      if (contentPeriodContains != null) r'content.contains': encodeQueryParameter(_serializers, contentPeriodContains, const FullType(String)),
      if (contentPeriodDoesNotContain != null) r'content.doesNotContain': encodeQueryParameter(_serializers, contentPeriodDoesNotContain, const FullType(String)),
      if (contentPeriodEquals != null) r'content.equals': encodeQueryParameter(_serializers, contentPeriodEquals, const FullType(String)),
      if (contentPeriodNotEquals != null) r'content.notEquals': encodeQueryParameter(_serializers, contentPeriodNotEquals, const FullType(String)),
      if (contentPeriodSpecified != null) r'content.specified': encodeQueryParameter(_serializers, contentPeriodSpecified, const FullType(bool)),
      if (contentPeriodIn != null) r'content.in': encodeCollectionQueryParameter<String>(_serializers, contentPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (contentPeriodNotIn != null) r'content.notIn': encodeCollectionQueryParameter<String>(_serializers, contentPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (ratingPeriodGreaterThan != null) r'rating.greaterThan': encodeQueryParameter(_serializers, ratingPeriodGreaterThan, const FullType(int)),
      if (ratingPeriodLessThan != null) r'rating.lessThan': encodeQueryParameter(_serializers, ratingPeriodLessThan, const FullType(int)),
      if (ratingPeriodGreaterThanOrEqual != null) r'rating.greaterThanOrEqual': encodeQueryParameter(_serializers, ratingPeriodGreaterThanOrEqual, const FullType(int)),
      if (ratingPeriodLessThanOrEqual != null) r'rating.lessThanOrEqual': encodeQueryParameter(_serializers, ratingPeriodLessThanOrEqual, const FullType(int)),
      if (ratingPeriodEquals != null) r'rating.equals': encodeQueryParameter(_serializers, ratingPeriodEquals, const FullType(int)),
      if (ratingPeriodNotEquals != null) r'rating.notEquals': encodeQueryParameter(_serializers, ratingPeriodNotEquals, const FullType(int)),
      if (ratingPeriodSpecified != null) r'rating.specified': encodeQueryParameter(_serializers, ratingPeriodSpecified, const FullType(bool)),
      if (ratingPeriodIn != null) r'rating.in': encodeCollectionQueryParameter<int>(_serializers, ratingPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (ratingPeriodNotIn != null) r'rating.notIn': encodeCollectionQueryParameter<int>(_serializers, ratingPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (feedbackPeriodContains != null) r'feedback.contains': encodeQueryParameter(_serializers, feedbackPeriodContains, const FullType(String)),
      if (feedbackPeriodDoesNotContain != null) r'feedback.doesNotContain': encodeQueryParameter(_serializers, feedbackPeriodDoesNotContain, const FullType(String)),
      if (feedbackPeriodEquals != null) r'feedback.equals': encodeQueryParameter(_serializers, feedbackPeriodEquals, const FullType(String)),
      if (feedbackPeriodNotEquals != null) r'feedback.notEquals': encodeQueryParameter(_serializers, feedbackPeriodNotEquals, const FullType(String)),
      if (feedbackPeriodSpecified != null) r'feedback.specified': encodeQueryParameter(_serializers, feedbackPeriodSpecified, const FullType(bool)),
      if (feedbackPeriodIn != null) r'feedback.in': encodeCollectionQueryParameter<String>(_serializers, feedbackPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (feedbackPeriodNotIn != null) r'feedback.notIn': encodeCollectionQueryParameter<String>(_serializers, feedbackPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
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

  /// createReview
  /// 
  ///
  /// Parameters:
  /// * [reviewDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReviewDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReviewDTO>> createReview({ 
    required ReviewDTO reviewDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/reviews';
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
      const _type = FullType(ReviewDTO);
      _bodyData = _serializers.serialize(reviewDTO, specifiedType: _type);

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

    ReviewDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReviewDTO),
      ) as ReviewDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReviewDTO>(
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

  /// deleteReview
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
  Future<Response<void>> deleteReview({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/reviews/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

  /// getAllReviews
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
  /// * [contentPeriodContains] 
  /// * [contentPeriodDoesNotContain] 
  /// * [contentPeriodEquals] 
  /// * [contentPeriodNotEquals] 
  /// * [contentPeriodSpecified] 
  /// * [contentPeriodIn] 
  /// * [contentPeriodNotIn] 
  /// * [ratingPeriodGreaterThan] 
  /// * [ratingPeriodLessThan] 
  /// * [ratingPeriodGreaterThanOrEqual] 
  /// * [ratingPeriodLessThanOrEqual] 
  /// * [ratingPeriodEquals] 
  /// * [ratingPeriodNotEquals] 
  /// * [ratingPeriodSpecified] 
  /// * [ratingPeriodIn] 
  /// * [ratingPeriodNotIn] 
  /// * [feedbackPeriodContains] 
  /// * [feedbackPeriodDoesNotContain] 
  /// * [feedbackPeriodEquals] 
  /// * [feedbackPeriodNotEquals] 
  /// * [feedbackPeriodSpecified] 
  /// * [feedbackPeriodIn] 
  /// * [feedbackPeriodNotIn] 
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
  /// Returns a [Future] containing a [Response] with a [BuiltList<ReviewDTO>] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<BuiltList<ReviewDTO>>> getAllReviews({ 
    int? idPeriodGreaterThan,
    int? idPeriodLessThan,
    int? idPeriodGreaterThanOrEqual,
    int? idPeriodLessThanOrEqual,
    int? idPeriodEquals,
    int? idPeriodNotEquals,
    bool? idPeriodSpecified,
    BuiltList<int>? idPeriodIn,
    BuiltList<int>? idPeriodNotIn,
    String? contentPeriodContains,
    String? contentPeriodDoesNotContain,
    String? contentPeriodEquals,
    String? contentPeriodNotEquals,
    bool? contentPeriodSpecified,
    BuiltList<String>? contentPeriodIn,
    BuiltList<String>? contentPeriodNotIn,
    int? ratingPeriodGreaterThan,
    int? ratingPeriodLessThan,
    int? ratingPeriodGreaterThanOrEqual,
    int? ratingPeriodLessThanOrEqual,
    int? ratingPeriodEquals,
    int? ratingPeriodNotEquals,
    bool? ratingPeriodSpecified,
    BuiltList<int>? ratingPeriodIn,
    BuiltList<int>? ratingPeriodNotIn,
    String? feedbackPeriodContains,
    String? feedbackPeriodDoesNotContain,
    String? feedbackPeriodEquals,
    String? feedbackPeriodNotEquals,
    bool? feedbackPeriodSpecified,
    BuiltList<String>? feedbackPeriodIn,
    BuiltList<String>? feedbackPeriodNotIn,
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
    final _path = r'/api/reviews';
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
      if (contentPeriodContains != null) r'content.contains': encodeQueryParameter(_serializers, contentPeriodContains, const FullType(String)),
      if (contentPeriodDoesNotContain != null) r'content.doesNotContain': encodeQueryParameter(_serializers, contentPeriodDoesNotContain, const FullType(String)),
      if (contentPeriodEquals != null) r'content.equals': encodeQueryParameter(_serializers, contentPeriodEquals, const FullType(String)),
      if (contentPeriodNotEquals != null) r'content.notEquals': encodeQueryParameter(_serializers, contentPeriodNotEquals, const FullType(String)),
      if (contentPeriodSpecified != null) r'content.specified': encodeQueryParameter(_serializers, contentPeriodSpecified, const FullType(bool)),
      if (contentPeriodIn != null) r'content.in': encodeCollectionQueryParameter<String>(_serializers, contentPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (contentPeriodNotIn != null) r'content.notIn': encodeCollectionQueryParameter<String>(_serializers, contentPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (ratingPeriodGreaterThan != null) r'rating.greaterThan': encodeQueryParameter(_serializers, ratingPeriodGreaterThan, const FullType(int)),
      if (ratingPeriodLessThan != null) r'rating.lessThan': encodeQueryParameter(_serializers, ratingPeriodLessThan, const FullType(int)),
      if (ratingPeriodGreaterThanOrEqual != null) r'rating.greaterThanOrEqual': encodeQueryParameter(_serializers, ratingPeriodGreaterThanOrEqual, const FullType(int)),
      if (ratingPeriodLessThanOrEqual != null) r'rating.lessThanOrEqual': encodeQueryParameter(_serializers, ratingPeriodLessThanOrEqual, const FullType(int)),
      if (ratingPeriodEquals != null) r'rating.equals': encodeQueryParameter(_serializers, ratingPeriodEquals, const FullType(int)),
      if (ratingPeriodNotEquals != null) r'rating.notEquals': encodeQueryParameter(_serializers, ratingPeriodNotEquals, const FullType(int)),
      if (ratingPeriodSpecified != null) r'rating.specified': encodeQueryParameter(_serializers, ratingPeriodSpecified, const FullType(bool)),
      if (ratingPeriodIn != null) r'rating.in': encodeCollectionQueryParameter<int>(_serializers, ratingPeriodIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (ratingPeriodNotIn != null) r'rating.notIn': encodeCollectionQueryParameter<int>(_serializers, ratingPeriodNotIn, const FullType(BuiltList, [FullType(int)]), format: ListFormat.multi,),
      if (feedbackPeriodContains != null) r'feedback.contains': encodeQueryParameter(_serializers, feedbackPeriodContains, const FullType(String)),
      if (feedbackPeriodDoesNotContain != null) r'feedback.doesNotContain': encodeQueryParameter(_serializers, feedbackPeriodDoesNotContain, const FullType(String)),
      if (feedbackPeriodEquals != null) r'feedback.equals': encodeQueryParameter(_serializers, feedbackPeriodEquals, const FullType(String)),
      if (feedbackPeriodNotEquals != null) r'feedback.notEquals': encodeQueryParameter(_serializers, feedbackPeriodNotEquals, const FullType(String)),
      if (feedbackPeriodSpecified != null) r'feedback.specified': encodeQueryParameter(_serializers, feedbackPeriodSpecified, const FullType(bool)),
      if (feedbackPeriodIn != null) r'feedback.in': encodeCollectionQueryParameter<String>(_serializers, feedbackPeriodIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
      if (feedbackPeriodNotIn != null) r'feedback.notIn': encodeCollectionQueryParameter<String>(_serializers, feedbackPeriodNotIn, const FullType(BuiltList, [FullType(String)]), format: ListFormat.multi,),
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

    BuiltList<ReviewDTO>? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(BuiltList, [FullType(ReviewDTO)]),
      ) as BuiltList<ReviewDTO>;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<BuiltList<ReviewDTO>>(
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

  /// getReview
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
  /// Returns a [Future] containing a [Response] with a [ReviewDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReviewDTO>> getReview({ 
    required int id,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/reviews/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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

    ReviewDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReviewDTO),
      ) as ReviewDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReviewDTO>(
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

  /// partialUpdateReview
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reviewDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReviewDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReviewDTO>> partialUpdateReview({ 
    required int id,
    required ReviewDTO reviewDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/reviews/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(ReviewDTO);
      _bodyData = _serializers.serialize(reviewDTO, specifiedType: _type);

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

    ReviewDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReviewDTO),
      ) as ReviewDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReviewDTO>(
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

  /// updateReview
  /// 
  ///
  /// Parameters:
  /// * [id] 
  /// * [reviewDTO] 
  /// * [cancelToken] - A [CancelToken] that can be used to cancel the operation
  /// * [headers] - Can be used to add additional headers to the request
  /// * [extras] - Can be used to add flags to the request
  /// * [validateStatus] - A [ValidateStatus] callback that can be used to determine request success based on the HTTP status of the response
  /// * [onSendProgress] - A [ProgressCallback] that can be used to get the send progress
  /// * [onReceiveProgress] - A [ProgressCallback] that can be used to get the receive progress
  ///
  /// Returns a [Future] containing a [Response] with a [ReviewDTO] as data
  /// Throws [DioException] if API call or serialization fails
  Future<Response<ReviewDTO>> updateReview({ 
    required int id,
    required ReviewDTO reviewDTO,
    CancelToken? cancelToken,
    Map<String, dynamic>? headers,
    Map<String, dynamic>? extra,
    ValidateStatus? validateStatus,
    ProgressCallback? onSendProgress,
    ProgressCallback? onReceiveProgress,
  }) async {
    final _path = r'/api/reviews/{id}'.replaceAll('{' r'id' '}', encodeQueryParameter(_serializers, id, const FullType(int)).toString());
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
      const _type = FullType(ReviewDTO);
      _bodyData = _serializers.serialize(reviewDTO, specifiedType: _type);

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

    ReviewDTO? _responseData;

    try {
      final rawResponse = _response.data;
      _responseData = rawResponse == null ? null : _serializers.deserialize(
        rawResponse,
        specifiedType: const FullType(ReviewDTO),
      ) as ReviewDTO;

    } catch (error, stackTrace) {
      throw DioException(
        requestOptions: _response.requestOptions,
        response: _response,
        type: DioExceptionType.unknown,
        error: error,
        stackTrace: stackTrace,
      );
    }

    return Response<ReviewDTO>(
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
