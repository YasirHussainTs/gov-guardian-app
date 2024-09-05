# openapi.api.GovOfficialContentResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countGovOfficialContents**](GovOfficialContentResourceApi.md#countgovofficialcontents) | **GET** /api/gov-official-contents/count | 
[**createGovOfficialContent**](GovOfficialContentResourceApi.md#creategovofficialcontent) | **POST** /api/gov-official-contents | 
[**deleteGovOfficialContent**](GovOfficialContentResourceApi.md#deletegovofficialcontent) | **DELETE** /api/gov-official-contents/{id} | 
[**getAllGovOfficialContents**](GovOfficialContentResourceApi.md#getallgovofficialcontents) | **GET** /api/gov-official-contents | 
[**getGovOfficialContent**](GovOfficialContentResourceApi.md#getgovofficialcontent) | **GET** /api/gov-official-contents/{id} | 
[**partialUpdateGovOfficialContent**](GovOfficialContentResourceApi.md#partialupdategovofficialcontent) | **PATCH** /api/gov-official-contents/{id} | 
[**updateGovOfficialContent**](GovOfficialContentResourceApi.md#updategovofficialcontent) | **PUT** /api/gov-official-contents/{id} | 


# **countGovOfficialContents**
> int countGovOfficialContents(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, lawPeriodContains, lawPeriodDoesNotContain, lawPeriodEquals, lawPeriodNotEquals, lawPeriodSpecified, lawPeriodIn, lawPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, actionPeriodContains, actionPeriodDoesNotContain, actionPeriodEquals, actionPeriodNotEquals, actionPeriodSpecified, actionPeriodIn, actionPeriodNotIn, datePeriodGreaterThan, datePeriodLessThan, datePeriodGreaterThanOrEqual, datePeriodLessThanOrEqual, datePeriodEquals, datePeriodNotEquals, datePeriodSpecified, datePeriodIn, datePeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String lawPeriodContains = lawPeriodContains_example; // String | 
final String lawPeriodDoesNotContain = lawPeriodDoesNotContain_example; // String | 
final String lawPeriodEquals = lawPeriodEquals_example; // String | 
final String lawPeriodNotEquals = lawPeriodNotEquals_example; // String | 
final bool lawPeriodSpecified = true; // bool | 
final BuiltList<String> lawPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> lawPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final String actionPeriodContains = actionPeriodContains_example; // String | 
final String actionPeriodDoesNotContain = actionPeriodDoesNotContain_example; // String | 
final String actionPeriodEquals = actionPeriodEquals_example; // String | 
final String actionPeriodNotEquals = actionPeriodNotEquals_example; // String | 
final bool actionPeriodSpecified = true; // bool | 
final BuiltList<String> actionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> actionPeriodNotIn = ; // BuiltList<String> | 
final DateTime datePeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool datePeriodSpecified = true; // bool | 
final BuiltList<DateTime> datePeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> datePeriodNotIn = ; // BuiltList<DateTime> | 
final bool distinct = true; // bool | 

try {
    final response = api.countGovOfficialContents(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, lawPeriodContains, lawPeriodDoesNotContain, lawPeriodEquals, lawPeriodNotEquals, lawPeriodSpecified, lawPeriodIn, lawPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, actionPeriodContains, actionPeriodDoesNotContain, actionPeriodEquals, actionPeriodNotEquals, actionPeriodSpecified, actionPeriodIn, actionPeriodNotIn, datePeriodGreaterThan, datePeriodLessThan, datePeriodGreaterThanOrEqual, datePeriodLessThanOrEqual, datePeriodEquals, datePeriodNotEquals, datePeriodSpecified, datePeriodIn, datePeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->countGovOfficialContents: $e\n');
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
 **lawPeriodContains** | **String**|  | [optional] 
 **lawPeriodDoesNotContain** | **String**|  | [optional] 
 **lawPeriodEquals** | **String**|  | [optional] 
 **lawPeriodNotEquals** | **String**|  | [optional] 
 **lawPeriodSpecified** | **bool**|  | [optional] 
 **lawPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **lawPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **actionPeriodContains** | **String**|  | [optional] 
 **actionPeriodDoesNotContain** | **String**|  | [optional] 
 **actionPeriodEquals** | **String**|  | [optional] 
 **actionPeriodNotEquals** | **String**|  | [optional] 
 **actionPeriodSpecified** | **bool**|  | [optional] 
 **actionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **actionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **datePeriodGreaterThan** | **DateTime**|  | [optional] 
 **datePeriodLessThan** | **DateTime**|  | [optional] 
 **datePeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **datePeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **datePeriodEquals** | **DateTime**|  | [optional] 
 **datePeriodNotEquals** | **DateTime**|  | [optional] 
 **datePeriodSpecified** | **bool**|  | [optional] 
 **datePeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **datePeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createGovOfficialContent**
> GovOfficialContentDTO createGovOfficialContent(govOfficialContentDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final GovOfficialContentDTO govOfficialContentDTO = ; // GovOfficialContentDTO | 

try {
    final response = api.createGovOfficialContent(govOfficialContentDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->createGovOfficialContent: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **govOfficialContentDTO** | [**GovOfficialContentDTO**](GovOfficialContentDTO.md)|  | 

### Return type

[**GovOfficialContentDTO**](GovOfficialContentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteGovOfficialContent**
> deleteGovOfficialContent(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int id = 789; // int | 

try {
    api.deleteGovOfficialContent(id);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->deleteGovOfficialContent: $e\n');
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

# **getAllGovOfficialContents**
> BuiltList<GovOfficialContentDTO> getAllGovOfficialContents(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, lawPeriodContains, lawPeriodDoesNotContain, lawPeriodEquals, lawPeriodNotEquals, lawPeriodSpecified, lawPeriodIn, lawPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, actionPeriodContains, actionPeriodDoesNotContain, actionPeriodEquals, actionPeriodNotEquals, actionPeriodSpecified, actionPeriodIn, actionPeriodNotIn, datePeriodGreaterThan, datePeriodLessThan, datePeriodGreaterThanOrEqual, datePeriodLessThanOrEqual, datePeriodEquals, datePeriodNotEquals, datePeriodSpecified, datePeriodIn, datePeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String lawPeriodContains = lawPeriodContains_example; // String | 
final String lawPeriodDoesNotContain = lawPeriodDoesNotContain_example; // String | 
final String lawPeriodEquals = lawPeriodEquals_example; // String | 
final String lawPeriodNotEquals = lawPeriodNotEquals_example; // String | 
final bool lawPeriodSpecified = true; // bool | 
final BuiltList<String> lawPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> lawPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final String actionPeriodContains = actionPeriodContains_example; // String | 
final String actionPeriodDoesNotContain = actionPeriodDoesNotContain_example; // String | 
final String actionPeriodEquals = actionPeriodEquals_example; // String | 
final String actionPeriodNotEquals = actionPeriodNotEquals_example; // String | 
final bool actionPeriodSpecified = true; // bool | 
final BuiltList<String> actionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> actionPeriodNotIn = ; // BuiltList<String> | 
final DateTime datePeriodGreaterThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodLessThan = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodGreaterThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodLessThanOrEqual = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final DateTime datePeriodNotEquals = 2013-10-20T19:20:30+01:00; // DateTime | 
final bool datePeriodSpecified = true; // bool | 
final BuiltList<DateTime> datePeriodIn = ; // BuiltList<DateTime> | 
final BuiltList<DateTime> datePeriodNotIn = ; // BuiltList<DateTime> | 
final bool distinct = true; // bool | 
final int page = 56; // int | Zero-based page index (0..N)
final int size = 56; // int | The size of the page to be returned
final BuiltList<String> sort = ; // BuiltList<String> | Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.

try {
    final response = api.getAllGovOfficialContents(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, lawPeriodContains, lawPeriodDoesNotContain, lawPeriodEquals, lawPeriodNotEquals, lawPeriodSpecified, lawPeriodIn, lawPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, actionPeriodContains, actionPeriodDoesNotContain, actionPeriodEquals, actionPeriodNotEquals, actionPeriodSpecified, actionPeriodIn, actionPeriodNotIn, datePeriodGreaterThan, datePeriodLessThan, datePeriodGreaterThanOrEqual, datePeriodLessThanOrEqual, datePeriodEquals, datePeriodNotEquals, datePeriodSpecified, datePeriodIn, datePeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->getAllGovOfficialContents: $e\n');
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
 **lawPeriodContains** | **String**|  | [optional] 
 **lawPeriodDoesNotContain** | **String**|  | [optional] 
 **lawPeriodEquals** | **String**|  | [optional] 
 **lawPeriodNotEquals** | **String**|  | [optional] 
 **lawPeriodSpecified** | **bool**|  | [optional] 
 **lawPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **lawPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **actionPeriodContains** | **String**|  | [optional] 
 **actionPeriodDoesNotContain** | **String**|  | [optional] 
 **actionPeriodEquals** | **String**|  | [optional] 
 **actionPeriodNotEquals** | **String**|  | [optional] 
 **actionPeriodSpecified** | **bool**|  | [optional] 
 **actionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **actionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **datePeriodGreaterThan** | **DateTime**|  | [optional] 
 **datePeriodLessThan** | **DateTime**|  | [optional] 
 **datePeriodGreaterThanOrEqual** | **DateTime**|  | [optional] 
 **datePeriodLessThanOrEqual** | **DateTime**|  | [optional] 
 **datePeriodEquals** | **DateTime**|  | [optional] 
 **datePeriodNotEquals** | **DateTime**|  | [optional] 
 **datePeriodSpecified** | **bool**|  | [optional] 
 **datePeriodIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **datePeriodNotIn** | [**BuiltList&lt;DateTime&gt;**](DateTime.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 
 **page** | **int**| Zero-based page index (0..N) | [optional] [default to 0]
 **size** | **int**| The size of the page to be returned | [optional] [default to 20]
 **sort** | [**BuiltList&lt;String&gt;**](String.md)| Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional] 

### Return type

[**BuiltList&lt;GovOfficialContentDTO&gt;**](GovOfficialContentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGovOfficialContent**
> GovOfficialContentDTO getGovOfficialContent(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int id = 789; // int | 

try {
    final response = api.getGovOfficialContent(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->getGovOfficialContent: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

[**GovOfficialContentDTO**](GovOfficialContentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateGovOfficialContent**
> GovOfficialContentDTO partialUpdateGovOfficialContent(id, govOfficialContentDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int id = 789; // int | 
final GovOfficialContentDTO govOfficialContentDTO = ; // GovOfficialContentDTO | 

try {
    final response = api.partialUpdateGovOfficialContent(id, govOfficialContentDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->partialUpdateGovOfficialContent: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **govOfficialContentDTO** | [**GovOfficialContentDTO**](GovOfficialContentDTO.md)|  | 

### Return type

[**GovOfficialContentDTO**](GovOfficialContentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateGovOfficialContent**
> GovOfficialContentDTO updateGovOfficialContent(id, govOfficialContentDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getGovOfficialContentResourceApi();
final int id = 789; // int | 
final GovOfficialContentDTO govOfficialContentDTO = ; // GovOfficialContentDTO | 

try {
    final response = api.updateGovOfficialContent(id, govOfficialContentDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling GovOfficialContentResourceApi->updateGovOfficialContent: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **govOfficialContentDTO** | [**GovOfficialContentDTO**](GovOfficialContentDTO.md)|  | 

### Return type

[**GovOfficialContentDTO**](GovOfficialContentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

