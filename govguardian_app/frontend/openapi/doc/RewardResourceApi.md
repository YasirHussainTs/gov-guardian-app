# openapi.api.RewardResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countRewards**](RewardResourceApi.md#countrewards) | **GET** /api/rewards/count | 
[**createReward**](RewardResourceApi.md#createreward) | **POST** /api/rewards | 
[**deleteReward**](RewardResourceApi.md#deletereward) | **DELETE** /api/rewards/{id} | 
[**getAllRewards**](RewardResourceApi.md#getallrewards) | **GET** /api/rewards | 
[**getReward**](RewardResourceApi.md#getreward) | **GET** /api/rewards/{id} | 
[**partialUpdateReward**](RewardResourceApi.md#partialupdatereward) | **PATCH** /api/rewards/{id} | 
[**updateReward**](RewardResourceApi.md#updatereward) | **PUT** /api/rewards/{id} | 


# **countRewards**
> int countRewards(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, pointsPeriodGreaterThan, pointsPeriodLessThan, pointsPeriodGreaterThanOrEqual, pointsPeriodLessThanOrEqual, pointsPeriodEquals, pointsPeriodNotEquals, pointsPeriodSpecified, pointsPeriodIn, pointsPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final int pointsPeriodGreaterThan = 56; // int | 
final int pointsPeriodLessThan = 56; // int | 
final int pointsPeriodGreaterThanOrEqual = 56; // int | 
final int pointsPeriodLessThanOrEqual = 56; // int | 
final int pointsPeriodEquals = 56; // int | 
final int pointsPeriodNotEquals = 56; // int | 
final bool pointsPeriodSpecified = true; // bool | 
final BuiltList<int> pointsPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> pointsPeriodNotIn = ; // BuiltList<int> | 
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
    final response = api.countRewards(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, pointsPeriodGreaterThan, pointsPeriodLessThan, pointsPeriodGreaterThanOrEqual, pointsPeriodLessThanOrEqual, pointsPeriodEquals, pointsPeriodNotEquals, pointsPeriodSpecified, pointsPeriodIn, pointsPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->countRewards: $e\n');
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
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **pointsPeriodGreaterThan** | **int**|  | [optional] 
 **pointsPeriodLessThan** | **int**|  | [optional] 
 **pointsPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **pointsPeriodLessThanOrEqual** | **int**|  | [optional] 
 **pointsPeriodEquals** | **int**|  | [optional] 
 **pointsPeriodNotEquals** | **int**|  | [optional] 
 **pointsPeriodSpecified** | **bool**|  | [optional] 
 **pointsPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **pointsPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
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

# **createReward**
> RewardDTO createReward(rewardDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final RewardDTO rewardDTO = ; // RewardDTO | 

try {
    final response = api.createReward(rewardDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->createReward: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rewardDTO** | [**RewardDTO**](RewardDTO.md)|  | 

### Return type

[**RewardDTO**](RewardDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteReward**
> deleteReward(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int id = 789; // int | 

try {
    api.deleteReward(id);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->deleteReward: $e\n');
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

# **getAllRewards**
> BuiltList<RewardDTO> getAllRewards(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, pointsPeriodGreaterThan, pointsPeriodLessThan, pointsPeriodGreaterThanOrEqual, pointsPeriodLessThanOrEqual, pointsPeriodEquals, pointsPeriodNotEquals, pointsPeriodSpecified, pointsPeriodIn, pointsPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final int pointsPeriodGreaterThan = 56; // int | 
final int pointsPeriodLessThan = 56; // int | 
final int pointsPeriodGreaterThanOrEqual = 56; // int | 
final int pointsPeriodLessThanOrEqual = 56; // int | 
final int pointsPeriodEquals = 56; // int | 
final int pointsPeriodNotEquals = 56; // int | 
final bool pointsPeriodSpecified = true; // bool | 
final BuiltList<int> pointsPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> pointsPeriodNotIn = ; // BuiltList<int> | 
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
    final response = api.getAllRewards(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, pointsPeriodGreaterThan, pointsPeriodLessThan, pointsPeriodGreaterThanOrEqual, pointsPeriodLessThanOrEqual, pointsPeriodEquals, pointsPeriodNotEquals, pointsPeriodSpecified, pointsPeriodIn, pointsPeriodNotIn, timestampPeriodGreaterThan, timestampPeriodLessThan, timestampPeriodGreaterThanOrEqual, timestampPeriodLessThanOrEqual, timestampPeriodEquals, timestampPeriodNotEquals, timestampPeriodSpecified, timestampPeriodIn, timestampPeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->getAllRewards: $e\n');
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
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **pointsPeriodGreaterThan** | **int**|  | [optional] 
 **pointsPeriodLessThan** | **int**|  | [optional] 
 **pointsPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **pointsPeriodLessThanOrEqual** | **int**|  | [optional] 
 **pointsPeriodEquals** | **int**|  | [optional] 
 **pointsPeriodNotEquals** | **int**|  | [optional] 
 **pointsPeriodSpecified** | **bool**|  | [optional] 
 **pointsPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **pointsPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
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

[**BuiltList&lt;RewardDTO&gt;**](RewardDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getReward**
> RewardDTO getReward(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int id = 789; // int | 

try {
    final response = api.getReward(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->getReward: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

[**RewardDTO**](RewardDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateReward**
> RewardDTO partialUpdateReward(id, rewardDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int id = 789; // int | 
final RewardDTO rewardDTO = ; // RewardDTO | 

try {
    final response = api.partialUpdateReward(id, rewardDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->partialUpdateReward: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **rewardDTO** | [**RewardDTO**](RewardDTO.md)|  | 

### Return type

[**RewardDTO**](RewardDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateReward**
> RewardDTO updateReward(id, rewardDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getRewardResourceApi();
final int id = 789; // int | 
final RewardDTO rewardDTO = ; // RewardDTO | 

try {
    final response = api.updateReward(id, rewardDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling RewardResourceApi->updateReward: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **rewardDTO** | [**RewardDTO**](RewardDTO.md)|  | 

### Return type

[**RewardDTO**](RewardDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

