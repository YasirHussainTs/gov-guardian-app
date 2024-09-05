# openapi.api.AppUserResourceApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**countAppUsers**](AppUserResourceApi.md#countappusers) | **GET** /api/app-users/count | 
[**createAppUser**](AppUserResourceApi.md#createappuser) | **POST** /api/app-users | 
[**deleteAppUser**](AppUserResourceApi.md#deleteappuser) | **DELETE** /api/app-users/{id} | 
[**getAllAppUsers**](AppUserResourceApi.md#getallappusers) | **GET** /api/app-users | 
[**getAppUser**](AppUserResourceApi.md#getappuser) | **GET** /api/app-users/{id} | 
[**partialUpdateAppUser**](AppUserResourceApi.md#partialupdateappuser) | **PATCH** /api/app-users/{id} | 
[**updateAppUser**](AppUserResourceApi.md#updateappuser) | **PUT** /api/app-users/{id} | 


# **countAppUsers**
> int countAppUsers(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, emailPeriodContains, emailPeriodDoesNotContain, emailPeriodEquals, emailPeriodNotEquals, emailPeriodSpecified, emailPeriodIn, emailPeriodNotIn, addressPeriodContains, addressPeriodDoesNotContain, addressPeriodEquals, addressPeriodNotEquals, addressPeriodSpecified, addressPeriodIn, addressPeriodNotIn, phonePeriodContains, phonePeriodDoesNotContain, phonePeriodEquals, phonePeriodNotEquals, phonePeriodSpecified, phonePeriodIn, phonePeriodNotIn, genderPeriodContains, genderPeriodDoesNotContain, genderPeriodEquals, genderPeriodNotEquals, genderPeriodSpecified, genderPeriodIn, genderPeriodNotIn, departmentPeriodContains, departmentPeriodDoesNotContain, departmentPeriodEquals, departmentPeriodNotEquals, departmentPeriodSpecified, departmentPeriodIn, departmentPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, latitudePeriodGreaterThan, latitudePeriodLessThan, latitudePeriodGreaterThanOrEqual, latitudePeriodLessThanOrEqual, latitudePeriodEquals, latitudePeriodNotEquals, latitudePeriodSpecified, latitudePeriodIn, latitudePeriodNotIn, longitudePeriodGreaterThan, longitudePeriodLessThan, longitudePeriodGreaterThanOrEqual, longitudePeriodLessThanOrEqual, longitudePeriodEquals, longitudePeriodNotEquals, longitudePeriodSpecified, longitudePeriodIn, longitudePeriodNotIn, userTypePeriodEquals, userTypePeriodNotEquals, userTypePeriodSpecified, userTypePeriodIn, userTypePeriodNotIn, userIdPeriodGreaterThan, userIdPeriodLessThan, userIdPeriodGreaterThanOrEqual, userIdPeriodLessThanOrEqual, userIdPeriodEquals, userIdPeriodNotEquals, userIdPeriodSpecified, userIdPeriodIn, userIdPeriodNotIn, reviewsIdPeriodGreaterThan, reviewsIdPeriodLessThan, reviewsIdPeriodGreaterThanOrEqual, reviewsIdPeriodLessThanOrEqual, reviewsIdPeriodEquals, reviewsIdPeriodNotEquals, reviewsIdPeriodSpecified, reviewsIdPeriodIn, reviewsIdPeriodNotIn, rewardsIdPeriodGreaterThan, rewardsIdPeriodLessThan, rewardsIdPeriodGreaterThanOrEqual, rewardsIdPeriodLessThanOrEqual, rewardsIdPeriodEquals, rewardsIdPeriodNotEquals, rewardsIdPeriodSpecified, rewardsIdPeriodIn, rewardsIdPeriodNotIn, govOfficialContentIdPeriodGreaterThan, govOfficialContentIdPeriodLessThan, govOfficialContentIdPeriodGreaterThanOrEqual, govOfficialContentIdPeriodLessThanOrEqual, govOfficialContentIdPeriodEquals, govOfficialContentIdPeriodNotEquals, govOfficialContentIdPeriodSpecified, govOfficialContentIdPeriodIn, govOfficialContentIdPeriodNotIn, distinct)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String emailPeriodContains = emailPeriodContains_example; // String | 
final String emailPeriodDoesNotContain = emailPeriodDoesNotContain_example; // String | 
final String emailPeriodEquals = emailPeriodEquals_example; // String | 
final String emailPeriodNotEquals = emailPeriodNotEquals_example; // String | 
final bool emailPeriodSpecified = true; // bool | 
final BuiltList<String> emailPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> emailPeriodNotIn = ; // BuiltList<String> | 
final String addressPeriodContains = addressPeriodContains_example; // String | 
final String addressPeriodDoesNotContain = addressPeriodDoesNotContain_example; // String | 
final String addressPeriodEquals = addressPeriodEquals_example; // String | 
final String addressPeriodNotEquals = addressPeriodNotEquals_example; // String | 
final bool addressPeriodSpecified = true; // bool | 
final BuiltList<String> addressPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> addressPeriodNotIn = ; // BuiltList<String> | 
final String phonePeriodContains = phonePeriodContains_example; // String | 
final String phonePeriodDoesNotContain = phonePeriodDoesNotContain_example; // String | 
final String phonePeriodEquals = phonePeriodEquals_example; // String | 
final String phonePeriodNotEquals = phonePeriodNotEquals_example; // String | 
final bool phonePeriodSpecified = true; // bool | 
final BuiltList<String> phonePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> phonePeriodNotIn = ; // BuiltList<String> | 
final String genderPeriodContains = genderPeriodContains_example; // String | 
final String genderPeriodDoesNotContain = genderPeriodDoesNotContain_example; // String | 
final String genderPeriodEquals = genderPeriodEquals_example; // String | 
final String genderPeriodNotEquals = genderPeriodNotEquals_example; // String | 
final bool genderPeriodSpecified = true; // bool | 
final BuiltList<String> genderPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> genderPeriodNotIn = ; // BuiltList<String> | 
final String departmentPeriodContains = departmentPeriodContains_example; // String | 
final String departmentPeriodDoesNotContain = departmentPeriodDoesNotContain_example; // String | 
final String departmentPeriodEquals = departmentPeriodEquals_example; // String | 
final String departmentPeriodNotEquals = departmentPeriodNotEquals_example; // String | 
final bool departmentPeriodSpecified = true; // bool | 
final BuiltList<String> departmentPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> departmentPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final double latitudePeriodGreaterThan = 1.2; // double | 
final double latitudePeriodLessThan = 1.2; // double | 
final double latitudePeriodGreaterThanOrEqual = 1.2; // double | 
final double latitudePeriodLessThanOrEqual = 1.2; // double | 
final double latitudePeriodEquals = 1.2; // double | 
final double latitudePeriodNotEquals = 1.2; // double | 
final bool latitudePeriodSpecified = true; // bool | 
final BuiltList<double> latitudePeriodIn = ; // BuiltList<double> | 
final BuiltList<double> latitudePeriodNotIn = ; // BuiltList<double> | 
final double longitudePeriodGreaterThan = 1.2; // double | 
final double longitudePeriodLessThan = 1.2; // double | 
final double longitudePeriodGreaterThanOrEqual = 1.2; // double | 
final double longitudePeriodLessThanOrEqual = 1.2; // double | 
final double longitudePeriodEquals = 1.2; // double | 
final double longitudePeriodNotEquals = 1.2; // double | 
final bool longitudePeriodSpecified = true; // bool | 
final BuiltList<double> longitudePeriodIn = ; // BuiltList<double> | 
final BuiltList<double> longitudePeriodNotIn = ; // BuiltList<double> | 
final String userTypePeriodEquals = userTypePeriodEquals_example; // String | 
final String userTypePeriodNotEquals = userTypePeriodNotEquals_example; // String | 
final bool userTypePeriodSpecified = true; // bool | 
final BuiltList<String> userTypePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> userTypePeriodNotIn = ; // BuiltList<String> | 
final int userIdPeriodGreaterThan = 789; // int | 
final int userIdPeriodLessThan = 789; // int | 
final int userIdPeriodGreaterThanOrEqual = 789; // int | 
final int userIdPeriodLessThanOrEqual = 789; // int | 
final int userIdPeriodEquals = 789; // int | 
final int userIdPeriodNotEquals = 789; // int | 
final bool userIdPeriodSpecified = true; // bool | 
final BuiltList<int> userIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> userIdPeriodNotIn = ; // BuiltList<int> | 
final int reviewsIdPeriodGreaterThan = 789; // int | 
final int reviewsIdPeriodLessThan = 789; // int | 
final int reviewsIdPeriodGreaterThanOrEqual = 789; // int | 
final int reviewsIdPeriodLessThanOrEqual = 789; // int | 
final int reviewsIdPeriodEquals = 789; // int | 
final int reviewsIdPeriodNotEquals = 789; // int | 
final bool reviewsIdPeriodSpecified = true; // bool | 
final BuiltList<int> reviewsIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> reviewsIdPeriodNotIn = ; // BuiltList<int> | 
final int rewardsIdPeriodGreaterThan = 789; // int | 
final int rewardsIdPeriodLessThan = 789; // int | 
final int rewardsIdPeriodGreaterThanOrEqual = 789; // int | 
final int rewardsIdPeriodLessThanOrEqual = 789; // int | 
final int rewardsIdPeriodEquals = 789; // int | 
final int rewardsIdPeriodNotEquals = 789; // int | 
final bool rewardsIdPeriodSpecified = true; // bool | 
final BuiltList<int> rewardsIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> rewardsIdPeriodNotIn = ; // BuiltList<int> | 
final int govOfficialContentIdPeriodGreaterThan = 789; // int | 
final int govOfficialContentIdPeriodLessThan = 789; // int | 
final int govOfficialContentIdPeriodGreaterThanOrEqual = 789; // int | 
final int govOfficialContentIdPeriodLessThanOrEqual = 789; // int | 
final int govOfficialContentIdPeriodEquals = 789; // int | 
final int govOfficialContentIdPeriodNotEquals = 789; // int | 
final bool govOfficialContentIdPeriodSpecified = true; // bool | 
final BuiltList<int> govOfficialContentIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> govOfficialContentIdPeriodNotIn = ; // BuiltList<int> | 
final bool distinct = true; // bool | 

try {
    final response = api.countAppUsers(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, emailPeriodContains, emailPeriodDoesNotContain, emailPeriodEquals, emailPeriodNotEquals, emailPeriodSpecified, emailPeriodIn, emailPeriodNotIn, addressPeriodContains, addressPeriodDoesNotContain, addressPeriodEquals, addressPeriodNotEquals, addressPeriodSpecified, addressPeriodIn, addressPeriodNotIn, phonePeriodContains, phonePeriodDoesNotContain, phonePeriodEquals, phonePeriodNotEquals, phonePeriodSpecified, phonePeriodIn, phonePeriodNotIn, genderPeriodContains, genderPeriodDoesNotContain, genderPeriodEquals, genderPeriodNotEquals, genderPeriodSpecified, genderPeriodIn, genderPeriodNotIn, departmentPeriodContains, departmentPeriodDoesNotContain, departmentPeriodEquals, departmentPeriodNotEquals, departmentPeriodSpecified, departmentPeriodIn, departmentPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, latitudePeriodGreaterThan, latitudePeriodLessThan, latitudePeriodGreaterThanOrEqual, latitudePeriodLessThanOrEqual, latitudePeriodEquals, latitudePeriodNotEquals, latitudePeriodSpecified, latitudePeriodIn, latitudePeriodNotIn, longitudePeriodGreaterThan, longitudePeriodLessThan, longitudePeriodGreaterThanOrEqual, longitudePeriodLessThanOrEqual, longitudePeriodEquals, longitudePeriodNotEquals, longitudePeriodSpecified, longitudePeriodIn, longitudePeriodNotIn, userTypePeriodEquals, userTypePeriodNotEquals, userTypePeriodSpecified, userTypePeriodIn, userTypePeriodNotIn, userIdPeriodGreaterThan, userIdPeriodLessThan, userIdPeriodGreaterThanOrEqual, userIdPeriodLessThanOrEqual, userIdPeriodEquals, userIdPeriodNotEquals, userIdPeriodSpecified, userIdPeriodIn, userIdPeriodNotIn, reviewsIdPeriodGreaterThan, reviewsIdPeriodLessThan, reviewsIdPeriodGreaterThanOrEqual, reviewsIdPeriodLessThanOrEqual, reviewsIdPeriodEquals, reviewsIdPeriodNotEquals, reviewsIdPeriodSpecified, reviewsIdPeriodIn, reviewsIdPeriodNotIn, rewardsIdPeriodGreaterThan, rewardsIdPeriodLessThan, rewardsIdPeriodGreaterThanOrEqual, rewardsIdPeriodLessThanOrEqual, rewardsIdPeriodEquals, rewardsIdPeriodNotEquals, rewardsIdPeriodSpecified, rewardsIdPeriodIn, rewardsIdPeriodNotIn, govOfficialContentIdPeriodGreaterThan, govOfficialContentIdPeriodLessThan, govOfficialContentIdPeriodGreaterThanOrEqual, govOfficialContentIdPeriodLessThanOrEqual, govOfficialContentIdPeriodEquals, govOfficialContentIdPeriodNotEquals, govOfficialContentIdPeriodSpecified, govOfficialContentIdPeriodIn, govOfficialContentIdPeriodNotIn, distinct);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->countAppUsers: $e\n');
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
 **emailPeriodContains** | **String**|  | [optional] 
 **emailPeriodDoesNotContain** | **String**|  | [optional] 
 **emailPeriodEquals** | **String**|  | [optional] 
 **emailPeriodNotEquals** | **String**|  | [optional] 
 **emailPeriodSpecified** | **bool**|  | [optional] 
 **emailPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **emailPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **addressPeriodContains** | **String**|  | [optional] 
 **addressPeriodDoesNotContain** | **String**|  | [optional] 
 **addressPeriodEquals** | **String**|  | [optional] 
 **addressPeriodNotEquals** | **String**|  | [optional] 
 **addressPeriodSpecified** | **bool**|  | [optional] 
 **addressPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **addressPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **phonePeriodContains** | **String**|  | [optional] 
 **phonePeriodDoesNotContain** | **String**|  | [optional] 
 **phonePeriodEquals** | **String**|  | [optional] 
 **phonePeriodNotEquals** | **String**|  | [optional] 
 **phonePeriodSpecified** | **bool**|  | [optional] 
 **phonePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **phonePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **genderPeriodContains** | **String**|  | [optional] 
 **genderPeriodDoesNotContain** | **String**|  | [optional] 
 **genderPeriodEquals** | **String**|  | [optional] 
 **genderPeriodNotEquals** | **String**|  | [optional] 
 **genderPeriodSpecified** | **bool**|  | [optional] 
 **genderPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **genderPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **departmentPeriodContains** | **String**|  | [optional] 
 **departmentPeriodDoesNotContain** | **String**|  | [optional] 
 **departmentPeriodEquals** | **String**|  | [optional] 
 **departmentPeriodNotEquals** | **String**|  | [optional] 
 **departmentPeriodSpecified** | **bool**|  | [optional] 
 **departmentPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **departmentPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **latitudePeriodGreaterThan** | **double**|  | [optional] 
 **latitudePeriodLessThan** | **double**|  | [optional] 
 **latitudePeriodGreaterThanOrEqual** | **double**|  | [optional] 
 **latitudePeriodLessThanOrEqual** | **double**|  | [optional] 
 **latitudePeriodEquals** | **double**|  | [optional] 
 **latitudePeriodNotEquals** | **double**|  | [optional] 
 **latitudePeriodSpecified** | **bool**|  | [optional] 
 **latitudePeriodIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **latitudePeriodNotIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **longitudePeriodGreaterThan** | **double**|  | [optional] 
 **longitudePeriodLessThan** | **double**|  | [optional] 
 **longitudePeriodGreaterThanOrEqual** | **double**|  | [optional] 
 **longitudePeriodLessThanOrEqual** | **double**|  | [optional] 
 **longitudePeriodEquals** | **double**|  | [optional] 
 **longitudePeriodNotEquals** | **double**|  | [optional] 
 **longitudePeriodSpecified** | **bool**|  | [optional] 
 **longitudePeriodIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **longitudePeriodNotIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **userTypePeriodEquals** | **String**|  | [optional] 
 **userTypePeriodNotEquals** | **String**|  | [optional] 
 **userTypePeriodSpecified** | **bool**|  | [optional] 
 **userTypePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **userTypePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **userIdPeriodGreaterThan** | **int**|  | [optional] 
 **userIdPeriodLessThan** | **int**|  | [optional] 
 **userIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **userIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **userIdPeriodEquals** | **int**|  | [optional] 
 **userIdPeriodNotEquals** | **int**|  | [optional] 
 **userIdPeriodSpecified** | **bool**|  | [optional] 
 **userIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **userIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **reviewsIdPeriodGreaterThan** | **int**|  | [optional] 
 **reviewsIdPeriodLessThan** | **int**|  | [optional] 
 **reviewsIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **reviewsIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **reviewsIdPeriodEquals** | **int**|  | [optional] 
 **reviewsIdPeriodNotEquals** | **int**|  | [optional] 
 **reviewsIdPeriodSpecified** | **bool**|  | [optional] 
 **reviewsIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **reviewsIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **rewardsIdPeriodGreaterThan** | **int**|  | [optional] 
 **rewardsIdPeriodLessThan** | **int**|  | [optional] 
 **rewardsIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **rewardsIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **rewardsIdPeriodEquals** | **int**|  | [optional] 
 **rewardsIdPeriodNotEquals** | **int**|  | [optional] 
 **rewardsIdPeriodSpecified** | **bool**|  | [optional] 
 **rewardsIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **rewardsIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **govOfficialContentIdPeriodGreaterThan** | **int**|  | [optional] 
 **govOfficialContentIdPeriodLessThan** | **int**|  | [optional] 
 **govOfficialContentIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **govOfficialContentIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **govOfficialContentIdPeriodEquals** | **int**|  | [optional] 
 **govOfficialContentIdPeriodNotEquals** | **int**|  | [optional] 
 **govOfficialContentIdPeriodSpecified** | **bool**|  | [optional] 
 **govOfficialContentIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **govOfficialContentIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 

### Return type

**int**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createAppUser**
> AppUserDTO createAppUser(appUserDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final AppUserDTO appUserDTO = ; // AppUserDTO | 

try {
    final response = api.createAppUser(appUserDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->createAppUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appUserDTO** | [**AppUserDTO**](AppUserDTO.md)|  | 

### Return type

[**AppUserDTO**](AppUserDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteAppUser**
> deleteAppUser(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int id = 789; // int | 

try {
    api.deleteAppUser(id);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->deleteAppUser: $e\n');
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

# **getAllAppUsers**
> BuiltList<AppUserDTO> getAllAppUsers(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, emailPeriodContains, emailPeriodDoesNotContain, emailPeriodEquals, emailPeriodNotEquals, emailPeriodSpecified, emailPeriodIn, emailPeriodNotIn, addressPeriodContains, addressPeriodDoesNotContain, addressPeriodEquals, addressPeriodNotEquals, addressPeriodSpecified, addressPeriodIn, addressPeriodNotIn, phonePeriodContains, phonePeriodDoesNotContain, phonePeriodEquals, phonePeriodNotEquals, phonePeriodSpecified, phonePeriodIn, phonePeriodNotIn, genderPeriodContains, genderPeriodDoesNotContain, genderPeriodEquals, genderPeriodNotEquals, genderPeriodSpecified, genderPeriodIn, genderPeriodNotIn, departmentPeriodContains, departmentPeriodDoesNotContain, departmentPeriodEquals, departmentPeriodNotEquals, departmentPeriodSpecified, departmentPeriodIn, departmentPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, latitudePeriodGreaterThan, latitudePeriodLessThan, latitudePeriodGreaterThanOrEqual, latitudePeriodLessThanOrEqual, latitudePeriodEquals, latitudePeriodNotEquals, latitudePeriodSpecified, latitudePeriodIn, latitudePeriodNotIn, longitudePeriodGreaterThan, longitudePeriodLessThan, longitudePeriodGreaterThanOrEqual, longitudePeriodLessThanOrEqual, longitudePeriodEquals, longitudePeriodNotEquals, longitudePeriodSpecified, longitudePeriodIn, longitudePeriodNotIn, userTypePeriodEquals, userTypePeriodNotEquals, userTypePeriodSpecified, userTypePeriodIn, userTypePeriodNotIn, userIdPeriodGreaterThan, userIdPeriodLessThan, userIdPeriodGreaterThanOrEqual, userIdPeriodLessThanOrEqual, userIdPeriodEquals, userIdPeriodNotEquals, userIdPeriodSpecified, userIdPeriodIn, userIdPeriodNotIn, reviewsIdPeriodGreaterThan, reviewsIdPeriodLessThan, reviewsIdPeriodGreaterThanOrEqual, reviewsIdPeriodLessThanOrEqual, reviewsIdPeriodEquals, reviewsIdPeriodNotEquals, reviewsIdPeriodSpecified, reviewsIdPeriodIn, reviewsIdPeriodNotIn, rewardsIdPeriodGreaterThan, rewardsIdPeriodLessThan, rewardsIdPeriodGreaterThanOrEqual, rewardsIdPeriodLessThanOrEqual, rewardsIdPeriodEquals, rewardsIdPeriodNotEquals, rewardsIdPeriodSpecified, rewardsIdPeriodIn, rewardsIdPeriodNotIn, govOfficialContentIdPeriodGreaterThan, govOfficialContentIdPeriodLessThan, govOfficialContentIdPeriodGreaterThanOrEqual, govOfficialContentIdPeriodLessThanOrEqual, govOfficialContentIdPeriodEquals, govOfficialContentIdPeriodNotEquals, govOfficialContentIdPeriodSpecified, govOfficialContentIdPeriodIn, govOfficialContentIdPeriodNotIn, distinct, page, size, sort)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int idPeriodGreaterThan = 789; // int | 
final int idPeriodLessThan = 789; // int | 
final int idPeriodGreaterThanOrEqual = 789; // int | 
final int idPeriodLessThanOrEqual = 789; // int | 
final int idPeriodEquals = 789; // int | 
final int idPeriodNotEquals = 789; // int | 
final bool idPeriodSpecified = true; // bool | 
final BuiltList<int> idPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> idPeriodNotIn = ; // BuiltList<int> | 
final String emailPeriodContains = emailPeriodContains_example; // String | 
final String emailPeriodDoesNotContain = emailPeriodDoesNotContain_example; // String | 
final String emailPeriodEquals = emailPeriodEquals_example; // String | 
final String emailPeriodNotEquals = emailPeriodNotEquals_example; // String | 
final bool emailPeriodSpecified = true; // bool | 
final BuiltList<String> emailPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> emailPeriodNotIn = ; // BuiltList<String> | 
final String addressPeriodContains = addressPeriodContains_example; // String | 
final String addressPeriodDoesNotContain = addressPeriodDoesNotContain_example; // String | 
final String addressPeriodEquals = addressPeriodEquals_example; // String | 
final String addressPeriodNotEquals = addressPeriodNotEquals_example; // String | 
final bool addressPeriodSpecified = true; // bool | 
final BuiltList<String> addressPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> addressPeriodNotIn = ; // BuiltList<String> | 
final String phonePeriodContains = phonePeriodContains_example; // String | 
final String phonePeriodDoesNotContain = phonePeriodDoesNotContain_example; // String | 
final String phonePeriodEquals = phonePeriodEquals_example; // String | 
final String phonePeriodNotEquals = phonePeriodNotEquals_example; // String | 
final bool phonePeriodSpecified = true; // bool | 
final BuiltList<String> phonePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> phonePeriodNotIn = ; // BuiltList<String> | 
final String genderPeriodContains = genderPeriodContains_example; // String | 
final String genderPeriodDoesNotContain = genderPeriodDoesNotContain_example; // String | 
final String genderPeriodEquals = genderPeriodEquals_example; // String | 
final String genderPeriodNotEquals = genderPeriodNotEquals_example; // String | 
final bool genderPeriodSpecified = true; // bool | 
final BuiltList<String> genderPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> genderPeriodNotIn = ; // BuiltList<String> | 
final String departmentPeriodContains = departmentPeriodContains_example; // String | 
final String departmentPeriodDoesNotContain = departmentPeriodDoesNotContain_example; // String | 
final String departmentPeriodEquals = departmentPeriodEquals_example; // String | 
final String departmentPeriodNotEquals = departmentPeriodNotEquals_example; // String | 
final bool departmentPeriodSpecified = true; // bool | 
final BuiltList<String> departmentPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> departmentPeriodNotIn = ; // BuiltList<String> | 
final String descriptionPeriodContains = descriptionPeriodContains_example; // String | 
final String descriptionPeriodDoesNotContain = descriptionPeriodDoesNotContain_example; // String | 
final String descriptionPeriodEquals = descriptionPeriodEquals_example; // String | 
final String descriptionPeriodNotEquals = descriptionPeriodNotEquals_example; // String | 
final bool descriptionPeriodSpecified = true; // bool | 
final BuiltList<String> descriptionPeriodIn = ; // BuiltList<String> | 
final BuiltList<String> descriptionPeriodNotIn = ; // BuiltList<String> | 
final double latitudePeriodGreaterThan = 1.2; // double | 
final double latitudePeriodLessThan = 1.2; // double | 
final double latitudePeriodGreaterThanOrEqual = 1.2; // double | 
final double latitudePeriodLessThanOrEqual = 1.2; // double | 
final double latitudePeriodEquals = 1.2; // double | 
final double latitudePeriodNotEquals = 1.2; // double | 
final bool latitudePeriodSpecified = true; // bool | 
final BuiltList<double> latitudePeriodIn = ; // BuiltList<double> | 
final BuiltList<double> latitudePeriodNotIn = ; // BuiltList<double> | 
final double longitudePeriodGreaterThan = 1.2; // double | 
final double longitudePeriodLessThan = 1.2; // double | 
final double longitudePeriodGreaterThanOrEqual = 1.2; // double | 
final double longitudePeriodLessThanOrEqual = 1.2; // double | 
final double longitudePeriodEquals = 1.2; // double | 
final double longitudePeriodNotEquals = 1.2; // double | 
final bool longitudePeriodSpecified = true; // bool | 
final BuiltList<double> longitudePeriodIn = ; // BuiltList<double> | 
final BuiltList<double> longitudePeriodNotIn = ; // BuiltList<double> | 
final String userTypePeriodEquals = userTypePeriodEquals_example; // String | 
final String userTypePeriodNotEquals = userTypePeriodNotEquals_example; // String | 
final bool userTypePeriodSpecified = true; // bool | 
final BuiltList<String> userTypePeriodIn = ; // BuiltList<String> | 
final BuiltList<String> userTypePeriodNotIn = ; // BuiltList<String> | 
final int userIdPeriodGreaterThan = 789; // int | 
final int userIdPeriodLessThan = 789; // int | 
final int userIdPeriodGreaterThanOrEqual = 789; // int | 
final int userIdPeriodLessThanOrEqual = 789; // int | 
final int userIdPeriodEquals = 789; // int | 
final int userIdPeriodNotEquals = 789; // int | 
final bool userIdPeriodSpecified = true; // bool | 
final BuiltList<int> userIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> userIdPeriodNotIn = ; // BuiltList<int> | 
final int reviewsIdPeriodGreaterThan = 789; // int | 
final int reviewsIdPeriodLessThan = 789; // int | 
final int reviewsIdPeriodGreaterThanOrEqual = 789; // int | 
final int reviewsIdPeriodLessThanOrEqual = 789; // int | 
final int reviewsIdPeriodEquals = 789; // int | 
final int reviewsIdPeriodNotEquals = 789; // int | 
final bool reviewsIdPeriodSpecified = true; // bool | 
final BuiltList<int> reviewsIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> reviewsIdPeriodNotIn = ; // BuiltList<int> | 
final int rewardsIdPeriodGreaterThan = 789; // int | 
final int rewardsIdPeriodLessThan = 789; // int | 
final int rewardsIdPeriodGreaterThanOrEqual = 789; // int | 
final int rewardsIdPeriodLessThanOrEqual = 789; // int | 
final int rewardsIdPeriodEquals = 789; // int | 
final int rewardsIdPeriodNotEquals = 789; // int | 
final bool rewardsIdPeriodSpecified = true; // bool | 
final BuiltList<int> rewardsIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> rewardsIdPeriodNotIn = ; // BuiltList<int> | 
final int govOfficialContentIdPeriodGreaterThan = 789; // int | 
final int govOfficialContentIdPeriodLessThan = 789; // int | 
final int govOfficialContentIdPeriodGreaterThanOrEqual = 789; // int | 
final int govOfficialContentIdPeriodLessThanOrEqual = 789; // int | 
final int govOfficialContentIdPeriodEquals = 789; // int | 
final int govOfficialContentIdPeriodNotEquals = 789; // int | 
final bool govOfficialContentIdPeriodSpecified = true; // bool | 
final BuiltList<int> govOfficialContentIdPeriodIn = ; // BuiltList<int> | 
final BuiltList<int> govOfficialContentIdPeriodNotIn = ; // BuiltList<int> | 
final bool distinct = true; // bool | 
final int page = 56; // int | Zero-based page index (0..N)
final int size = 56; // int | The size of the page to be returned
final BuiltList<String> sort = ; // BuiltList<String> | Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.

try {
    final response = api.getAllAppUsers(idPeriodGreaterThan, idPeriodLessThan, idPeriodGreaterThanOrEqual, idPeriodLessThanOrEqual, idPeriodEquals, idPeriodNotEquals, idPeriodSpecified, idPeriodIn, idPeriodNotIn, emailPeriodContains, emailPeriodDoesNotContain, emailPeriodEquals, emailPeriodNotEquals, emailPeriodSpecified, emailPeriodIn, emailPeriodNotIn, addressPeriodContains, addressPeriodDoesNotContain, addressPeriodEquals, addressPeriodNotEquals, addressPeriodSpecified, addressPeriodIn, addressPeriodNotIn, phonePeriodContains, phonePeriodDoesNotContain, phonePeriodEquals, phonePeriodNotEquals, phonePeriodSpecified, phonePeriodIn, phonePeriodNotIn, genderPeriodContains, genderPeriodDoesNotContain, genderPeriodEquals, genderPeriodNotEquals, genderPeriodSpecified, genderPeriodIn, genderPeriodNotIn, departmentPeriodContains, departmentPeriodDoesNotContain, departmentPeriodEquals, departmentPeriodNotEquals, departmentPeriodSpecified, departmentPeriodIn, departmentPeriodNotIn, descriptionPeriodContains, descriptionPeriodDoesNotContain, descriptionPeriodEquals, descriptionPeriodNotEquals, descriptionPeriodSpecified, descriptionPeriodIn, descriptionPeriodNotIn, latitudePeriodGreaterThan, latitudePeriodLessThan, latitudePeriodGreaterThanOrEqual, latitudePeriodLessThanOrEqual, latitudePeriodEquals, latitudePeriodNotEquals, latitudePeriodSpecified, latitudePeriodIn, latitudePeriodNotIn, longitudePeriodGreaterThan, longitudePeriodLessThan, longitudePeriodGreaterThanOrEqual, longitudePeriodLessThanOrEqual, longitudePeriodEquals, longitudePeriodNotEquals, longitudePeriodSpecified, longitudePeriodIn, longitudePeriodNotIn, userTypePeriodEquals, userTypePeriodNotEquals, userTypePeriodSpecified, userTypePeriodIn, userTypePeriodNotIn, userIdPeriodGreaterThan, userIdPeriodLessThan, userIdPeriodGreaterThanOrEqual, userIdPeriodLessThanOrEqual, userIdPeriodEquals, userIdPeriodNotEquals, userIdPeriodSpecified, userIdPeriodIn, userIdPeriodNotIn, reviewsIdPeriodGreaterThan, reviewsIdPeriodLessThan, reviewsIdPeriodGreaterThanOrEqual, reviewsIdPeriodLessThanOrEqual, reviewsIdPeriodEquals, reviewsIdPeriodNotEquals, reviewsIdPeriodSpecified, reviewsIdPeriodIn, reviewsIdPeriodNotIn, rewardsIdPeriodGreaterThan, rewardsIdPeriodLessThan, rewardsIdPeriodGreaterThanOrEqual, rewardsIdPeriodLessThanOrEqual, rewardsIdPeriodEquals, rewardsIdPeriodNotEquals, rewardsIdPeriodSpecified, rewardsIdPeriodIn, rewardsIdPeriodNotIn, govOfficialContentIdPeriodGreaterThan, govOfficialContentIdPeriodLessThan, govOfficialContentIdPeriodGreaterThanOrEqual, govOfficialContentIdPeriodLessThanOrEqual, govOfficialContentIdPeriodEquals, govOfficialContentIdPeriodNotEquals, govOfficialContentIdPeriodSpecified, govOfficialContentIdPeriodIn, govOfficialContentIdPeriodNotIn, distinct, page, size, sort);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->getAllAppUsers: $e\n');
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
 **emailPeriodContains** | **String**|  | [optional] 
 **emailPeriodDoesNotContain** | **String**|  | [optional] 
 **emailPeriodEquals** | **String**|  | [optional] 
 **emailPeriodNotEquals** | **String**|  | [optional] 
 **emailPeriodSpecified** | **bool**|  | [optional] 
 **emailPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **emailPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **addressPeriodContains** | **String**|  | [optional] 
 **addressPeriodDoesNotContain** | **String**|  | [optional] 
 **addressPeriodEquals** | **String**|  | [optional] 
 **addressPeriodNotEquals** | **String**|  | [optional] 
 **addressPeriodSpecified** | **bool**|  | [optional] 
 **addressPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **addressPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **phonePeriodContains** | **String**|  | [optional] 
 **phonePeriodDoesNotContain** | **String**|  | [optional] 
 **phonePeriodEquals** | **String**|  | [optional] 
 **phonePeriodNotEquals** | **String**|  | [optional] 
 **phonePeriodSpecified** | **bool**|  | [optional] 
 **phonePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **phonePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **genderPeriodContains** | **String**|  | [optional] 
 **genderPeriodDoesNotContain** | **String**|  | [optional] 
 **genderPeriodEquals** | **String**|  | [optional] 
 **genderPeriodNotEquals** | **String**|  | [optional] 
 **genderPeriodSpecified** | **bool**|  | [optional] 
 **genderPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **genderPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **departmentPeriodContains** | **String**|  | [optional] 
 **departmentPeriodDoesNotContain** | **String**|  | [optional] 
 **departmentPeriodEquals** | **String**|  | [optional] 
 **departmentPeriodNotEquals** | **String**|  | [optional] 
 **departmentPeriodSpecified** | **bool**|  | [optional] 
 **departmentPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **departmentPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodContains** | **String**|  | [optional] 
 **descriptionPeriodDoesNotContain** | **String**|  | [optional] 
 **descriptionPeriodEquals** | **String**|  | [optional] 
 **descriptionPeriodNotEquals** | **String**|  | [optional] 
 **descriptionPeriodSpecified** | **bool**|  | [optional] 
 **descriptionPeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **descriptionPeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **latitudePeriodGreaterThan** | **double**|  | [optional] 
 **latitudePeriodLessThan** | **double**|  | [optional] 
 **latitudePeriodGreaterThanOrEqual** | **double**|  | [optional] 
 **latitudePeriodLessThanOrEqual** | **double**|  | [optional] 
 **latitudePeriodEquals** | **double**|  | [optional] 
 **latitudePeriodNotEquals** | **double**|  | [optional] 
 **latitudePeriodSpecified** | **bool**|  | [optional] 
 **latitudePeriodIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **latitudePeriodNotIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **longitudePeriodGreaterThan** | **double**|  | [optional] 
 **longitudePeriodLessThan** | **double**|  | [optional] 
 **longitudePeriodGreaterThanOrEqual** | **double**|  | [optional] 
 **longitudePeriodLessThanOrEqual** | **double**|  | [optional] 
 **longitudePeriodEquals** | **double**|  | [optional] 
 **longitudePeriodNotEquals** | **double**|  | [optional] 
 **longitudePeriodSpecified** | **bool**|  | [optional] 
 **longitudePeriodIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **longitudePeriodNotIn** | [**BuiltList&lt;double&gt;**](double.md)|  | [optional] 
 **userTypePeriodEquals** | **String**|  | [optional] 
 **userTypePeriodNotEquals** | **String**|  | [optional] 
 **userTypePeriodSpecified** | **bool**|  | [optional] 
 **userTypePeriodIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **userTypePeriodNotIn** | [**BuiltList&lt;String&gt;**](String.md)|  | [optional] 
 **userIdPeriodGreaterThan** | **int**|  | [optional] 
 **userIdPeriodLessThan** | **int**|  | [optional] 
 **userIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **userIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **userIdPeriodEquals** | **int**|  | [optional] 
 **userIdPeriodNotEquals** | **int**|  | [optional] 
 **userIdPeriodSpecified** | **bool**|  | [optional] 
 **userIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **userIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **reviewsIdPeriodGreaterThan** | **int**|  | [optional] 
 **reviewsIdPeriodLessThan** | **int**|  | [optional] 
 **reviewsIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **reviewsIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **reviewsIdPeriodEquals** | **int**|  | [optional] 
 **reviewsIdPeriodNotEquals** | **int**|  | [optional] 
 **reviewsIdPeriodSpecified** | **bool**|  | [optional] 
 **reviewsIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **reviewsIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **rewardsIdPeriodGreaterThan** | **int**|  | [optional] 
 **rewardsIdPeriodLessThan** | **int**|  | [optional] 
 **rewardsIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **rewardsIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **rewardsIdPeriodEquals** | **int**|  | [optional] 
 **rewardsIdPeriodNotEquals** | **int**|  | [optional] 
 **rewardsIdPeriodSpecified** | **bool**|  | [optional] 
 **rewardsIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **rewardsIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **govOfficialContentIdPeriodGreaterThan** | **int**|  | [optional] 
 **govOfficialContentIdPeriodLessThan** | **int**|  | [optional] 
 **govOfficialContentIdPeriodGreaterThanOrEqual** | **int**|  | [optional] 
 **govOfficialContentIdPeriodLessThanOrEqual** | **int**|  | [optional] 
 **govOfficialContentIdPeriodEquals** | **int**|  | [optional] 
 **govOfficialContentIdPeriodNotEquals** | **int**|  | [optional] 
 **govOfficialContentIdPeriodSpecified** | **bool**|  | [optional] 
 **govOfficialContentIdPeriodIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **govOfficialContentIdPeriodNotIn** | [**BuiltList&lt;int&gt;**](int.md)|  | [optional] 
 **distinct** | **bool**|  | [optional] 
 **page** | **int**| Zero-based page index (0..N) | [optional] [default to 0]
 **size** | **int**| The size of the page to be returned | [optional] [default to 20]
 **sort** | [**BuiltList&lt;String&gt;**](String.md)| Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional] 

### Return type

[**BuiltList&lt;AppUserDTO&gt;**](AppUserDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAppUser**
> AppUserDTO getAppUser(id)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int id = 789; // int | 

try {
    final response = api.getAppUser(id);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->getAppUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 

### Return type

[**AppUserDTO**](AppUserDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **partialUpdateAppUser**
> AppUserDTO partialUpdateAppUser(id, appUserDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int id = 789; // int | 
final AppUserDTO appUserDTO = ; // AppUserDTO | 

try {
    final response = api.partialUpdateAppUser(id, appUserDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->partialUpdateAppUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **appUserDTO** | [**AppUserDTO**](AppUserDTO.md)|  | 

### Return type

[**AppUserDTO**](AppUserDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/merge-patch+json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateAppUser**
> AppUserDTO updateAppUser(id, appUserDTO)



### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getAppUserResourceApi();
final int id = 789; // int | 
final AppUserDTO appUserDTO = ; // AppUserDTO | 

try {
    final response = api.updateAppUser(id, appUserDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling AppUserResourceApi->updateAppUser: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**|  | 
 **appUserDTO** | [**AppUserDTO**](AppUserDTO.md)|  | 

### Return type

[**AppUserDTO**](AppUserDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

