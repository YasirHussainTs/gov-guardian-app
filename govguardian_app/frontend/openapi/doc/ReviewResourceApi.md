# openapi.api.ReviewResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countReviews**](ReviewResourceApi.md#countreviews) | **GET** /api/reviews/count | 
[**createReview**](ReviewResourceApi.md#createreview) | **POST** /api/reviews | 
[**deleteReview**](ReviewResourceApi.md#deletereview) | **DELETE** /api/reviews/{id} | 
[**getAllReviews**](ReviewResourceApi.md#getallreviews) | **GET** /api/reviews | 
[**getReview**](ReviewResourceApi.md#getreview) | **GET** /api/reviews/{id} | 
[**partialUpdateReview**](ReviewResourceApi.md#partialupdatereview) | **PATCH** /api/reviews/{id} | 
[**updateReview**](ReviewResourceApi.md#updatereview) | **PUT** /api/reviews/{id} | 


# **countReviews**
> int countReviews(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, contentPeriodContains, contentPeriodDoesNotContain, contentPeriodEquals, contentPeriodNotEquals, contentPeriodSpecified, contentPeriodIn, contentPeriodNotIn, ratingPeriodGreaterThan, ratingPeriodLessThan, ratingPeriodGreaterThanOrEqual, ratingPeriodLessThanOrEqual, ratingPeriodEquals, ratingPeriodNotEquals, ratingPeriodSpecified, ratingPeriodIn, ratingPeriodNotIn, feedbackPeriodContains, feedbackPeriodDoesNotContain, feedbackPeriodEquals, feedbackPeriodNotEquals, feedbackPeriodSpecified, feedbackPeriodIn, feedbackPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String contentPeriodContains = contentPeriodContains_example; // String | 
final String contentPeriodDoesNotContain = contentPeriodDoesNotContain_example; // String | 
final String contentPeriodEquals = contentPeriodEquals_example; // String | 
final String contentPeriodNotEquals = contentPeriodNotEquals_example; // String | 
final bool contentPeriodSpecified = true; // bool | 
final BuiltList<String> contentPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> contentPeriodNotIn = ; // BuiltList<String> | 
final int ratingPeriodGreaterThan = 56; // int | 
final int ratingPeriodLessThan = 56; // int | 
final int ratingPeriodGreaterThanOrEqual = 56; // int | 
final int ratingPeriodLessThanOrEqual = 56; // int | 
final int ratingPeriodEquals = 56; // int | 
final int ratingPeriodNotEquals = 56; // int | 
final bool ratingPeriodSpecified = true; // bool | 
final BuiltList<int> ratingPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> ratingPeriodNotIn = ; // BuiltList<int> | 
final String feedbackPeriodContains = feedbackPeriodContains_example; // String | 
final String feedbackPeriodDoesNotContain = feedbackPeriodDoesNotContain_example; // String | 
final String feedbackPeriodEquals = feedbackPeriodEquals_example; // String | 
final String feedbackPeriodNotEquals = feedbackPeriodNotEquals_example; // String | 
final bool feedbackPeriodSpecified = true; // bool | 
final BuiltList<String> feedbackPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> feedbackPeriodNotIn = ; // BuiltList<String> | 
final DateTime timestampPeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool timestampPeriodSpecified = true; // bool | 
final BuiltList<DateTime> timestampPeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> timestampPeriodNotIn = ; // BuiltList<DateTime> | 
final bool distinct = true; // bool | 

try {
    final response = api.countReviews(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, contentPeriodContains, contentPeriodDoesNotContain, contentPeriodEquals, contentPeriodNotEquals, contentPeriodSpecified, contentPeriodIn, contentPeriodNotIn, ratingPeriodGreaterThan, ratingPeriodLessThan, ratingPeriodGreaterThanOrEqual, ratingPeriodLessThanOrEqual, ratingPeriodEquals, ratingPeriodNotEquals, ratingPeriodSpecified, ratingPeriodIn, ratingPeriodNotIn, feedbackPeriodContains, feedbackPeriodDoesNotContain, feedbackPeriodEquals, feedbackPeriodNotEquals, feedbackPeriodSpecified, feedbackPeriodIn, feedbackPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->countReviews: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idPeriodGreaterThan** | **int**|  | [optional] 
 **idPeriodLessThan** | **int**|  | [optional] 
 **idPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **idPeriodLessThanOrEqual** | **int**|  | [optional] 
 **idPeriodEquals** | **int**|  | [optional] 
 **idPeriodNotEquals** | **int**|  | [optional] 
 **idPeriodSpecified** | **bool**|  | [optional] 
 **idPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **idPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **contentPeriodContains** | **String**|  | [optional] 
 **contentPeriodDoesNotContain** | **String**|  | [optional] 
 **contentPeriodEquals** | **String**|  | [optional] 
 **contentPeriodNotEquals** | **String**|  | [optional] 
 **contentPeriodSpecified** | **bool**|  | [optional] 
 **contentPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **contentPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **ratingPeriodGreaterThan** | **int**|  | [optional] 
 **ratingPeriodLessThan** | **int**|  | [optional] 
 **ratingPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **ratingPeriodLessThanOrEqual** | **int**|  | [optional] 
 **ratingPeriodEquals** | **int**|  | [optional] 
 **ratingPeriodNotEquals** | **int**|  | [optional] 
 **ratingPeriodSpecified** | **bool**|  | [optional] 
 **ratingPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **ratingPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **feedbackPeriodContains** | **String**|  | [optional] 
 **feedbackPeriodDoesNotContain** | **String**|  | [optional] 
 **feedbackPeriodEquals** | **String**|  | [optional] 
 **feedbackPeriodNotEquals** | **String**|  | [optional] 
 **feedbackPeriodSpecified** | **bool**|  | [optional] 
 **feedbackPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **feedbackPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **timestampPeriodGreaterThan** | **DateTime**|  | [optional] 
 **timestampPeriodLessThan** | **DateTime**|  | [optional] 
 **timestampPeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodEquals** | **DateTime**|  | [optional] 
 **timestampPeriodNotEquals** | **DateTime**|  | [optional] 
 **timestampPeriodSpecified** | **bool**|  | [optional] 
 **timestampPeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **timestampPeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createReview**
> ReviewDTO createReview(reviewDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final ReviewDTO reviewDTO = ; // ReviewDTO | 

try {
    final response = api.createReview(reviewDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->createReview: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reviewDTO** | [**ReviewDTO**](ReviewDTO.md)|  | 

### Return type

[**ReviewDTO**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteReview**
> deleteReview(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int id = 789; // int | 

try {
    api.deleteReview(id);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->deleteReview: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllReviews**
> BuiltList<ReviewDTO> getAllReviews(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, contentPeriodContains, contentPeriodDoesNotContain, contentPeriodEquals, contentPeriodNotEquals, contentPeriodSpecified, contentPeriodIn, contentPeriodNotIn, ratingPeriodGreaterThan, ratingPeriodLessThan, ratingPeriodGreaterThanOrEqual, ratingPeriodLessThanOrEqual, ratingPeriodEquals, ratingPeriodNotEquals, ratingPeriodSpecified, ratingPeriodIn, ratingPeriodNotIn, feedbackPeriodContains, feedbackPeriodDoesNotContain, feedbackPeriodEquals, feedbackPeriodNotEquals, feedbackPeriodSpecified, feedbackPeriodIn, feedbackPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String contentPeriodContains = contentPeriodContains_example; // String | 
final String contentPeriodDoesNotContain = contentPeriodDoesNotContain_example; // String | 
final String contentPeriodEquals = contentPeriodEquals_example; // String | 
final String contentPeriodNotEquals = contentPeriodNotEquals_example; // String | 
final bool contentPeriodSpecified = true; // bool | 
final BuiltList<String> contentPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> contentPeriodNotIn = ; // BuiltList<String> | 
final int ratingPeriodGreaterThan = 56; // int | 
final int ratingPeriodLessThan = 56; // int | 
final int ratingPeriodGreaterThanOrEqual = 56; // int | 
final int ratingPeriodLessThanOrEqual = 56; // int | 
final int ratingPeriodEquals = 56; // int | 
final int ratingPeriodNotEquals = 56; // int | 
final bool ratingPeriodSpecified = true; // bool | 
final BuiltList<int> ratingPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> ratingPeriodNotIn = ; // BuiltList<int> | 
final String feedbackPeriodContains = feedbackPeriodContains_example; // String | 
final String feedbackPeriodDoesNotContain = feedbackPeriodDoesNotContain_example; // String | 
final String feedbackPeriodEquals = feedbackPeriodEquals_example; // String | 
final String feedbackPeriodNotEquals = feedbackPeriodNotEquals_example; // String | 
final bool feedbackPeriodSpecified = true; // bool | 
final BuiltList<String> feedbackPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> feedbackPeriodNotIn = ; // BuiltList<String> | 
final DateTime timestampPeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool timestampPeriodSpecified = true; // bool | 
final BuiltList<DateTime> timestampPeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> timestampPeriodNotIn = ; // BuiltList<DateTime> | 
final bool distinct = true; // bool | 
final int page = 56; // int | Zero-based page index (0..N)
final int size = 56; // int | The size of the page to be returned
final BuiltList<String> sort = ; // BuiltList<String> | Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.

try {
    final response = api.getAllReviews(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, contentPeriodContains, contentPeriodDoesNotContain, contentPeriodEquals, contentPeriodNotEquals, contentPeriodSpecified, contentPeriodIn, contentPeriodNotIn, ratingPeriodGreaterThan, ratingPeriodLessThan, ratingPeriodGreaterThanOrEqual, ratingPeriodLessThanOrEqual, ratingPeriodEquals, ratingPeriodNotEquals, ratingPeriodSpecified, ratingPeriodIn, ratingPeriodNotIn, feedbackPeriodContains, feedbackPeriodDoesNotContain, feedbackPeriodEquals, feedbackPeriodNotEquals, feedbackPeriodSpecified, feedbackPeriodIn, feedbackPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->getAllReviews: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idPeriodGreaterThan** | **int**|  | [optional] 
 **idPeriodLessThan** | **int**|  | [optional] 
 **idPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **idPeriodLessThanOrEqual** | **int**|  | [optional] 
 **idPeriodEquals** | **int**|  | [optional] 
 **idPeriodNotEquals** | **int**|  | [optional] 
 **idPeriodSpecified** | **bool**|  | [optional] 
 **idPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **idPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **contentPeriodContains** | **String**|  | [optional] 
 **contentPeriodDoesNotContain** | **String**|  | [optional] 
 **contentPeriodEquals** | **String**|  | [optional] 
 **contentPeriodNotEquals** | **String**|  | [optional] 
 **contentPeriodSpecified** | **bool**|  | [optional] 
 **contentPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **contentPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **ratingPeriodGreaterThan** | **int**|  | [optional] 
 **ratingPeriodLessThan** | **int**|  | [optional] 
 **ratingPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **ratingPeriodLessThanOrEqual** | **int**|  | [optional] 
 **ratingPeriodEquals** | **int**|  | [optional] 
 **ratingPeriodNotEquals** | **int**|  | [optional] 
 **ratingPeriodSpecified** | **bool**|  | [optional] 
 **ratingPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **ratingPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **feedbackPeriodContains** | **String**|  | [optional] 
 **feedbackPeriodDoesNotContain** | **String**|  | [optional] 
 **feedbackPeriodEquals** | **String**|  | [optional] 
 **feedbackPeriodNotEquals** | **String**|  | [optional] 
 **feedbackPeriodSpecified** | **bool**|  | [optional] 
 **feedbackPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **feedbackPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **timestampPeriodGreaterThan** | **DateTime**|  | [optional] 
 **timestampPeriodLessThan** | **DateTime**|  | [optional] 
 **timestampPeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodEquals** | **DateTime**|  | [optional] 
 **timestampPeriodNotEquals** | **DateTime**|  | [optional] 
 **timestampPeriodSpecified** | **bool**|  | [optional] 
 **timestampPeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **timestampPeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 
 **page** | **int**| Zero-based page index (0..N) | [optional] [default to 0]
 **size** | **int**| The size of the page to be returned | [optional] [default to 20]
 **sort** | [**BuiltList&lt;String&gt;**](String.md)| Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional] 

### Return type

[**BuiltList&lt;ReviewDTO&gt;**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getReview**
> ReviewDTO getReview(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int id = 789; // int | 

try {
    final response = api.getReview(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->getReview: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

[**ReviewDTO**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateReview**
> ReviewDTO partialUpdateReview(id, reviewDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int id = 789; // int | 
final ReviewDTO reviewDTO = ; // ReviewDTO | 

try {
    final response = api.partialUpdateReview(id, reviewDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->partialUpdateReview: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **reviewDTO** | [**ReviewDTO**](ReviewDTO.md)|  | 

### Return type

[**ReviewDTO**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateReview**
> ReviewDTO updateReview(id, reviewDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReviewResourceApi();
final int id = 789; // int | 
final ReviewDTO reviewDTO = ; // ReviewDTO | 

try {
    final response = api.updateReview(id, reviewDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReviewResourceApi->updateReview: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **reviewDTO** | [**ReviewDTO**](ReviewDTO.md)|  | 

### Return type

[**ReviewDTO**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

