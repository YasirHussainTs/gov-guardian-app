# openapi.api.ReportDetailsResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countReportDetails**](ReportDetailsResourceApi.md#countreportdetails) | **GET** /api/report-details/count | 
[**createReportDetails**](ReportDetailsResourceApi.md#createreportdetails) | **POST** /api/report-details | 
[**deleteReportDetails**](ReportDetailsResourceApi.md#deletereportdetails) | **DELETE** /api/report-details/{id} | 
[**getAllReportDetails**](ReportDetailsResourceApi.md#getallreportdetails) | **GET** /api/report-details | 
[**getReportDetails**](ReportDetailsResourceApi.md#getreportdetails) | **GET** /api/report-details/{id} | 
[**partialUpdateReportDetails**](ReportDetailsResourceApi.md#partialupdatereportdetails) | **PATCH** /api/report-details/{id} | 
[**updateReportDetails**](ReportDetailsResourceApi.md#updatereportdetails) | **PUT** /api/report-details/{id} | 


# **countReportDetails**
> int countReportDetails(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, ownerPeriodContains, ownerPeriodDoesNotContain, ownerPeriodEquals, ownerPeriodNotEquals, ownerPeriodSpecified, ownerPeriodIn, ownerPeriodNotIn, responderPeriodContains, responderPeriodDoesNotContain, responderPeriodEquals, responderPeriodNotEquals, responderPeriodSpecified, responderPeriodIn, responderPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String ownerPeriodContains = ownerPeriodContains_example; // String | 
final String ownerPeriodDoesNotContain = ownerPeriodDoesNotContain_example; // String | 
final String ownerPeriodEquals = ownerPeriodEquals_example; // String | 
final String ownerPeriodNotEquals = ownerPeriodNotEquals_example; // String | 
final bool ownerPeriodSpecified = true; // bool | 
final BuiltList<String> ownerPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> ownerPeriodNotIn = ; // BuiltList<String> | 
final String responderPeriodContains = responderPeriodContains_example; // String | 
final String responderPeriodDoesNotContain = responderPeriodDoesNotContain_example; // String | 
final String responderPeriodEquals = responderPeriodEquals_example; // String | 
final String responderPeriodNotEquals = responderPeriodNotEquals_example; // String | 
final bool responderPeriodSpecified = true; // bool | 
final BuiltList<String> responderPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> responderPeriodNotIn = ; // BuiltList<String> | 
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
    final response = api.countReportDetails(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, ownerPeriodContains, ownerPeriodDoesNotContain, ownerPeriodEquals, ownerPeriodNotEquals, ownerPeriodSpecified, ownerPeriodIn, ownerPeriodNotIn, responderPeriodContains, responderPeriodDoesNotContain, responderPeriodEquals, responderPeriodNotEquals, responderPeriodSpecified, responderPeriodIn, responderPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->countReportDetails: $e\n');
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
 **ownerPeriodContains** | **String**|  | [optional] 
 **ownerPeriodDoesNotContain** | **String**|  | [optional] 
 **ownerPeriodEquals** | **String**|  | [optional] 
 **ownerPeriodNotEquals** | **String**|  | [optional] 
 **ownerPeriodSpecified** | **bool**|  | [optional] 
 **ownerPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **ownerPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **responderPeriodContains** | **String**|  | [optional] 
 **responderPeriodDoesNotContain** | **String**|  | [optional] 
 **responderPeriodEquals** | **String**|  | [optional] 
 **responderPeriodNotEquals** | **String**|  | [optional] 
 **responderPeriodSpecified** | **bool**|  | [optional] 
 **responderPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **responderPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
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

# **createReportDetails**
> ReportDetailsDTO createReportDetails(reportDetailsDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final ReportDetailsDTO reportDetailsDTO = ; // ReportDetailsDTO | 

try {
    final response = api.createReportDetails(reportDetailsDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->createReportDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reportDetailsDTO** | [**ReportDetailsDTO**](ReportDetailsDTO.md)|  | 

### Return type

[**ReportDetailsDTO**](ReportDetailsDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteReportDetails**
> deleteReportDetails(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int id = 789; // int | 

try {
    api.deleteReportDetails(id);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->deleteReportDetails: $e\n');
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

# **getAllReportDetails**
> BuiltList<ReportDetailsDTO> getAllReportDetails(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, ownerPeriodContains, ownerPeriodDoesNotContain, ownerPeriodEquals, ownerPeriodNotEquals, ownerPeriodSpecified, ownerPeriodIn, ownerPeriodNotIn, responderPeriodContains, responderPeriodDoesNotContain, responderPeriodEquals, responderPeriodNotEquals, responderPeriodSpecified, responderPeriodIn, responderPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String ownerPeriodContains = ownerPeriodContains_example; // String | 
final String ownerPeriodDoesNotContain = ownerPeriodDoesNotContain_example; // String | 
final String ownerPeriodEquals = ownerPeriodEquals_example; // String | 
final String ownerPeriodNotEquals = ownerPeriodNotEquals_example; // String | 
final bool ownerPeriodSpecified = true; // bool | 
final BuiltList<String> ownerPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> ownerPeriodNotIn = ; // BuiltList<String> | 
final String responderPeriodContains = responderPeriodContains_example; // String | 
final String responderPeriodDoesNotContain = responderPeriodDoesNotContain_example; // String | 
final String responderPeriodEquals = responderPeriodEquals_example; // String | 
final String responderPeriodNotEquals = responderPeriodNotEquals_example; // String | 
final bool responderPeriodSpecified = true; // bool | 
final BuiltList<String> responderPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> responderPeriodNotIn = ; // BuiltList<String> | 
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
    final response = api.getAllReportDetails(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, ownerPeriodContains, ownerPeriodDoesNotContain, ownerPeriodEquals, ownerPeriodNotEquals, ownerPeriodSpecified, ownerPeriodIn, ownerPeriodNotIn, responderPeriodContains, responderPeriodDoesNotContain, responderPeriodEquals, responderPeriodNotEquals, responderPeriodSpecified, responderPeriodIn, responderPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, titlePeriodContains, titlePeriodDoesNotContain, titlePeriodEquals, titlePeriodNotEquals, titlePeriodSpecified, titlePeriodIn, titlePeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, statusPeriodContains, statusPeriodDoesNotContain, statusPeriodEquals, statusPeriodNotEquals, statusPeriodSpecified, statusPeriodIn, statusPeriodNotIn, appUserIdPeriodGreaterThan, appUserIdPeriodLessThan, appUserIdPeriodGreaterThanOrEqual, appUserIdPeriodLessThanOrEqual, appUserIdPeriodEquals, appUserIdPeriodNotEquals, appUserIdPeriodSpecified, appUserIdPeriodIn, appUserIdPeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->getAllReportDetails: $e\n');
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
 **ownerPeriodContains** | **String**|  | [optional] 
 **ownerPeriodDoesNotContain** | **String**|  | [optional] 
 **ownerPeriodEquals** | **String**|  | [optional] 
 **ownerPeriodNotEquals** | **String**|  | [optional] 
 **ownerPeriodSpecified** | **bool**|  | [optional] 
 **ownerPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **ownerPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **responderPeriodContains** | **String**|  | [optional] 
 **responderPeriodDoesNotContain** | **String**|  | [optional] 
 **responderPeriodEquals** | **String**|  | [optional] 
 **responderPeriodNotEquals** | **String**|  | [optional] 
 **responderPeriodSpecified** | **bool**|  | [optional] 
 **responderPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **responderPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
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

[**BuiltList&lt;ReportDetailsDTO&gt;**](ReportDetailsDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getReportDetails**
> ReportDetailsDTO getReportDetails(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int id = 789; // int | 

try {
    final response = api.getReportDetails(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->getReportDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

[**ReportDetailsDTO**](ReportDetailsDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateReportDetails**
> ReportDetailsDTO partialUpdateReportDetails(id, reportDetailsDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int id = 789; // int | 
final ReportDetailsDTO reportDetailsDTO = ; // ReportDetailsDTO | 

try {
    final response = api.partialUpdateReportDetails(id, reportDetailsDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->partialUpdateReportDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **reportDetailsDTO** | [**ReportDetailsDTO**](ReportDetailsDTO.md)|  | 

### Return type

[**ReportDetailsDTO**](ReportDetailsDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateReportDetails**
> ReportDetailsDTO updateReportDetails(id, reportDetailsDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getReportDetailsResourceApi();
final int id = 789; // int | 
final ReportDetailsDTO reportDetailsDTO = ; // ReportDetailsDTO | 

try {
    final response = api.updateReportDetails(id, reportDetailsDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling ReportDetailsResourceApi->updateReportDetails: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **reportDetailsDTO** | [**ReportDetailsDTO**](ReportDetailsDTO.md)|  | 

### Return type

[**ReportDetailsDTO**](ReportDetailsDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

