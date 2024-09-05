# openapi.api.ReportHeaderResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countReportHeaders**](ReportHeaderResourceApi.md#countreportheaders) | **GET** /api/report-headers/count | 
[**createReportHeader**](ReportHeaderResourceApi.md#createreportheader) | **POST** /api/report-headers | 
[**deleteReportHeader**](ReportHeaderResourceApi.md#deletereportheader) | **DELETE** /api/report-headers/{id} | 
[**getAllReportHeaders**](ReportHeaderResourceApi.md#getallreportheaders) | **GET** /api/report-headers | 
[**getReportHeader**](ReportHeaderResourceApi.md#getreportheader) | **GET** /api/report-headers/{id} | 
[**partialUpdateReportHeader**](ReportHeaderResourceApi.md#partialupdatereportheader) | **PATCH** /api/report-headers/{id} | 
[**updateReportHeader**](ReportHeaderResourceApi.md#updatereportheader) | **PUT** /api/report-headers/{id} | 


# **countReportHeaders**
> int countReportHeaders(idPeriodContains, idPeriodDoesNotContain, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String idPeriodContains = idPeriodContains_example; // String | 
final String idPeriodDoesNotContain = idPeriodDoesNotContain_example; // String | 
final String idPeriodEquals = idPeriodEquals_example; // String | 
final String idPeriodNotEquals = idPeriodNotEquals_example; // String | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<String> idPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> idPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final String titlePeriodContains = titlePeriodContains_example; // String | 
final String titlePeriodDoesNotContain = titlePeriodDoesNotContain_example; // String | 
final String titlePeriodEquals = titlePeriodEquals_example; // String | 
final String titlePeriodNotEquals = titlePeriodNotEquals_example; // String | 
final bool titlePeriodSpecified = true; // bool | 
final BuiltList<String> titlePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> titlePeriodNotIn = ; // BuiltList<String> | 
final DateTime timestampPeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool timestampPeriodSpecified = true; // bool | 
final BuiltList<DateTime> timestampPeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> timestampPeriodNotIn = ; // BuiltList<DateTime> | 
final String statusPeriodContains = statusPeriodContains_example; // String | 
final String statusPeriodDoesNotContain = statusPeriodDoesNotContain_example; // String | 
final String statusPeriodEquals = statusPeriodEquals_example; // String | 
final String statusPeriodNotEquals = statusPeriodNotEquals_example; // String | 
final bool statusPeriodSpecified = true; // bool | 
final BuiltList<String> statusPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> statusPeriodNotIn = ; // BuiltList<String> | 
final int appUserIdPeriodGreaterThan = 789; // int | 
final int appUserIdPeriodLessThan = 789; // int | 
final int appUserIdPeriodGreaterThanOrEqual = 789; // int | 
final int appUserIdPeriodLessThanOrEqual = 789; // int | 
final int appUserIdPeriodEquals = 789; // int | 
final int appUserIdPeriodNotEquals = 789; // int | 
final bool appUserIdPeriodSpecified = true; // bool | 
final BuiltList<int> appUserIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> appUserIdPeriodNotIn = ; // BuiltList<int> | 
final bool distinct = true; // bool | 

try {
    final response = api.countReportHeaders(idPeriodContains, idPeriodDoesNotContain, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->countReportHeaders: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idPeriodContains** | **String**|  | [optional] 
 **idPeriodDoesNotContain** | **String**|  | [optional] 
 **idPeriodEquals** | **String**|  | [optional] 
 **idPeriodNotEquals** | **String**|  | [optional] 
 **idPeriodSpecified** | **bool**|  | [optional] 
 **idPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **idPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **titlePeriodContains** | **String**|  | [optional] 
 **titlePeriodDoesNotContain** | **String**|  | [optional] 
 **titlePeriodEquals** | **String**|  | [optional] 
 **titlePeriodNotEquals** | **String**|  | [optional] 
 **titlePeriodSpecified** | **bool**|  | [optional] 
 **titlePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **titlePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **timestampPeriodGreaterThan** | **DateTime**|  | [optional] 
 **timestampPeriodLessThan** | **DateTime**|  | [optional] 
 **timestampPeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodEquals** | **DateTime**|  | [optional] 
 **timestampPeriodNotEquals** | **DateTime**|  | [optional] 
 **timestampPeriodSpecified** | **bool**|  | [optional] 
 **timestampPeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **timestampPeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **statusPeriodContains** | **String**|  | [optional] 
 **statusPeriodDoesNotContain** | **String**|  | [optional] 
 **statusPeriodEquals** | **String**|  | [optional] 
 **statusPeriodNotEquals** | **String**|  | [optional] 
 **statusPeriodSpecified** | **bool**|  | [optional] 
 **statusPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **statusPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **appUserIdPeriodGreaterThan** | **int**|  | [optional] 
 **appUserIdPeriodLessThan** | **int**|  | [optional] 
 **appUserIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **appUserIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **appUserIdPeriodEquals** | **int**|  | [optional] 
 **appUserIdPeriodNotEquals** | **int**|  | [optional] 
 **appUserIdPeriodSpecified** | **bool**|  | [optional] 
 **appUserIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **appUserIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createReportHeader**
> ReportHeaderDTO createReportHeader(reportHeaderDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final ReportHeaderDTO reportHeaderDTO = ; // ReportHeaderDTO | 

try {
    final response = api.createReportHeader(reportHeaderDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->createReportHeader: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reportHeaderDTO** | [**ReportHeaderDTO**](ReportHeaderDTO.md)|  | 

### Return type

[**ReportHeaderDTO**](ReportHeaderDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteReportHeader**
> deleteReportHeader(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String id = id_example; // String | 

try {
    api.deleteReportHeader(id);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->deleteReportHeader: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllReportHeaders**
> BuiltList<ReportHeaderDTO> getAllReportHeaders(idPeriodContains, idPeriodDoesNotContain, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String idPeriodContains = idPeriodContains_example; // String | 
final String idPeriodDoesNotContain = idPeriodDoesNotContain_example; // String | 
final String idPeriodEquals = idPeriodEquals_example; // String | 
final String idPeriodNotEquals = idPeriodNotEquals_example; // String | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<String> idPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> idPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final String titlePeriodContains = titlePeriodContains_example; // String | 
final String titlePeriodDoesNotContain = titlePeriodDoesNotContain_example; // String | 
final String titlePeriodEquals = titlePeriodEquals_example; // String | 
final String titlePeriodNotEquals = titlePeriodNotEquals_example; // String | 
final bool titlePeriodSpecified = true; // bool | 
final BuiltList<String> titlePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> titlePeriodNotIn = ; // BuiltList<String> | 
final DateTime timestampPeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime timestampPeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool timestampPeriodSpecified = true; // bool | 
final BuiltList<DateTime> timestampPeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> timestampPeriodNotIn = ; // BuiltList<DateTime> | 
final String statusPeriodContains = statusPeriodContains_example; // String | 
final String statusPeriodDoesNotContain = statusPeriodDoesNotContain_example; // String | 
final String statusPeriodEquals = statusPeriodEquals_example; // String | 
final String statusPeriodNotEquals = statusPeriodNotEquals_example; // String | 
final bool statusPeriodSpecified = true; // bool | 
final BuiltList<String> statusPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> statusPeriodNotIn = ; // BuiltList<String> | 
final int appUserIdPeriodGreaterThan = 789; // int | 
final int appUserIdPeriodLessThan = 789; // int | 
final int appUserIdPeriodGreaterThanOrEqual = 789; // int | 
final int appUserIdPeriodLessThanOrEqual = 789; // int | 
final int appUserIdPeriodEquals = 789; // int | 
final int appUserIdPeriodNotEquals = 789; // int | 
final bool appUserIdPeriodSpecified = true; // bool | 
final BuiltList<int> appUserIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> appUserIdPeriodNotIn = ; // BuiltList<int> | 
final bool distinct = true; // bool | 
final int page = 56; // int | Zero-based page index (0..N)
final int size = 56; // int | The size of the page to be returned
final BuiltList<String> sort = ; // BuiltList<String> | Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.

try {
    final response = api.getAllReportHeaders(idPeriodContains, idPeriodDoesNotContain, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->getAllReportHeaders: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idPeriodContains** | **String**|  | [optional] 
 **idPeriodDoesNotContain** | **String**|  | [optional] 
 **idPeriodEquals** | **String**|  | [optional] 
 **idPeriodNotEquals** | **String**|  | [optional] 
 **idPeriodSpecified** | **bool**|  | [optional] 
 **idPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **idPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **titlePeriodContains** | **String**|  | [optional] 
 **titlePeriodDoesNotContain** | **String**|  | [optional] 
 **titlePeriodEquals** | **String**|  | [optional] 
 **titlePeriodNotEquals** | **String**|  | [optional] 
 **titlePeriodSpecified** | **bool**|  | [optional] 
 **titlePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **titlePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **timestampPeriodGreaterThan** | **DateTime**|  | [optional] 
 **timestampPeriodLessThan** | **DateTime**|  | [optional] 
 **timestampPeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **timestampPeriodEquals** | **DateTime**|  | [optional] 
 **timestampPeriodNotEquals** | **DateTime**|  | [optional] 
 **timestampPeriodSpecified** | **bool**|  | [optional] 
 **timestampPeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **timestampPeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **statusPeriodContains** | **String**|  | [optional] 
 **statusPeriodDoesNotContain** | **String**|  | [optional] 
 **statusPeriodEquals** | **String**|  | [optional] 
 **statusPeriodNotEquals** | **String**|  | [optional] 
 **statusPeriodSpecified** | **bool**|  | [optional] 
 **statusPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **statusPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **appUserIdPeriodGreaterThan** | **int**|  | [optional] 
 **appUserIdPeriodLessThan** | **int**|  | [optional] 
 **appUserIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **appUserIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **appUserIdPeriodEquals** | **int**|  | [optional] 
 **appUserIdPeriodNotEquals** | **int**|  | [optional] 
 **appUserIdPeriodSpecified** | **bool**|  | [optional] 
 **appUserIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **appUserIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 
 **page** | **int**| Zero-based page index (0..N) | [optional] [default to 0]
 **size** | **int**| The size of the page to be returned | [optional] [default to 20]
 **sort** | [**BuiltList&lt;String&gt;**](String.md)| Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional] 

### Return type

[**BuiltList&lt;ReportHeaderDTO&gt;**](ReportHeaderDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getReportHeader**
> ReportHeaderDTO getReportHeader(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String id = id_example; // String | 

try {
    final response = api.getReportHeader(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->getReportHeader: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 

### Return type

[**ReportHeaderDTO**](ReportHeaderDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateReportHeader**
> ReportHeaderDTO partialUpdateReportHeader(id, reportHeaderDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String id = id_example; // String | 
final ReportHeaderDTO reportHeaderDTO = ; // ReportHeaderDTO | 

try {
    final response = api.partialUpdateReportHeader(id, reportHeaderDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->partialUpdateReportHeader: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **reportHeaderDTO** | [**ReportHeaderDTO**](ReportHeaderDTO.md)|  | 

### Return type

[**ReportHeaderDTO**](ReportHeaderDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateReportHeader**
> ReportHeaderDTO updateReportHeader(id, reportHeaderDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportHeaderResourceApi();
final String id = id_example; // String | 
final ReportHeaderDTO reportHeaderDTO = ; // ReportHeaderDTO | 

try {
    final response = api.updateReportHeader(id, reportHeaderDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportHeaderResourceApi->updateReportHeader: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | 
 **reportHeaderDTO** | [**ReportHeaderDTO**](ReportHeaderDTO.md)|  | 

### Return type

[**ReportHeaderDTO**](ReportHeaderDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

