import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for AppUserResourceApi
void main() {
  final instance = Openapi().getAppUserResourceApi();

  group(AppUserResourceApi, () {
    //Future<int> countAppUsers({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String emailPeriodContains, String emailPeriodDoesNotContain, String emailPeriodEquals, String emailPeriodNotEquals, bool emailPeriodSpecified, BuiltList<String> emailPeriodIn, BuiltList<String> emailPeriodNotIn, String addressPeriodContains, String addressPeriodDoesNotContain, String addressPeriodEquals, String addressPeriodNotEquals, bool addressPeriodSpecified, BuiltList<String> addressPeriodIn, BuiltList<String> addressPeriodNotIn, String phonePeriodContains, String phonePeriodDoesNotContain, String phonePeriodEquals, String phonePeriodNotEquals, bool phonePeriodSpecified, BuiltList<String> phonePeriodIn, BuiltList<String> phonePeriodNotIn, String genderPeriodContains, String genderPeriodDoesNotContain, String genderPeriodEquals, String genderPeriodNotEquals, bool genderPeriodSpecified, BuiltList<String> genderPeriodIn, BuiltList<String> genderPeriodNotIn, String departmentPeriodContains, String departmentPeriodDoesNotContain, String departmentPeriodEquals, String departmentPeriodNotEquals, bool departmentPeriodSpecified, BuiltList<String> departmentPeriodIn, BuiltList<String> departmentPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, double latitudePeriodGreaterThan, double latitudePeriodLessThan, double latitudePeriodGreaterThanOrEqual, double latitudePeriodLessThanOrEqual, double latitudePeriodEquals, double latitudePeriodNotEquals, bool latitudePeriodSpecified, BuiltList<double> latitudePeriodIn, BuiltList<double> latitudePeriodNotIn, double longitudePeriodGreaterThan, double longitudePeriodLessThan, double longitudePeriodGreaterThanOrEqual, double longitudePeriodLessThanOrEqual, double longitudePeriodEquals, double longitudePeriodNotEquals, bool longitudePeriodSpecified, BuiltList<double> longitudePeriodIn, BuiltList<double> longitudePeriodNotIn, String userTypePeriodEquals, String userTypePeriodNotEquals, bool userTypePeriodSpecified, BuiltList<String> userTypePeriodIn, BuiltList<String> userTypePeriodNotIn, int userIdPeriodGreaterThan, int userIdPeriodLessThan, int userIdPeriodGreaterThanOrEqual, int userIdPeriodLessThanOrEqual, int userIdPeriodEquals, int userIdPeriodNotEquals, bool userIdPeriodSpecified, BuiltList<int> userIdPeriodIn, BuiltList<int> userIdPeriodNotIn, int reviewsIdPeriodGreaterThan, int reviewsIdPeriodLessThan, int reviewsIdPeriodGreaterThanOrEqual, int reviewsIdPeriodLessThanOrEqual, int reviewsIdPeriodEquals, int reviewsIdPeriodNotEquals, bool reviewsIdPeriodSpecified, BuiltList<int> reviewsIdPeriodIn, BuiltList<int> reviewsIdPeriodNotIn, int rewardsIdPeriodGreaterThan, int rewardsIdPeriodLessThan, int rewardsIdPeriodGreaterThanOrEqual, int rewardsIdPeriodLessThanOrEqual, int rewardsIdPeriodEquals, int rewardsIdPeriodNotEquals, bool rewardsIdPeriodSpecified, BuiltList<int> rewardsIdPeriodIn, BuiltList<int> rewardsIdPeriodNotIn, int govOfficialContentIdPeriodGreaterThan, int govOfficialContentIdPeriodLessThan, int govOfficialContentIdPeriodGreaterThanOrEqual, int govOfficialContentIdPeriodLessThanOrEqual, int govOfficialContentIdPeriodEquals, int govOfficialContentIdPeriodNotEquals, bool govOfficialContentIdPeriodSpecified, BuiltList<int> govOfficialContentIdPeriodIn, BuiltList<int> govOfficialContentIdPeriodNotIn, bool distinct }) async
    test('test countAppUsers', () async {
      // TODO
    });

    //Future<AppUserDTO> createAppUser(AppUserDTO appUserDTO) async
    test('test createAppUser', () async {
      // TODO
    });

    //Future deleteAppUser(int id) async
    test('test deleteAppUser', () async {
      // TODO
    });

    //Future<BuiltList<AppUserDTO>> getAllAppUsers({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String emailPeriodContains, String emailPeriodDoesNotContain, String emailPeriodEquals, String emailPeriodNotEquals, bool emailPeriodSpecified, BuiltList<String> emailPeriodIn, BuiltList<String> emailPeriodNotIn, String addressPeriodContains, String addressPeriodDoesNotContain, String addressPeriodEquals, String addressPeriodNotEquals, bool addressPeriodSpecified, BuiltList<String> addressPeriodIn, BuiltList<String> addressPeriodNotIn, String phonePeriodContains, String phonePeriodDoesNotContain, String phonePeriodEquals, String phonePeriodNotEquals, bool phonePeriodSpecified, BuiltList<String> phonePeriodIn, BuiltList<String> phonePeriodNotIn, String genderPeriodContains, String genderPeriodDoesNotContain, String genderPeriodEquals, String genderPeriodNotEquals, bool genderPeriodSpecified, BuiltList<String> genderPeriodIn, BuiltList<String> genderPeriodNotIn, String departmentPeriodContains, String departmentPeriodDoesNotContain, String departmentPeriodEquals, String departmentPeriodNotEquals, bool departmentPeriodSpecified, BuiltList<String> departmentPeriodIn, BuiltList<String> departmentPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, double latitudePeriodGreaterThan, double latitudePeriodLessThan, double latitudePeriodGreaterThanOrEqual, double latitudePeriodLessThanOrEqual, double latitudePeriodEquals, double latitudePeriodNotEquals, bool latitudePeriodSpecified, BuiltList<double> latitudePeriodIn, BuiltList<double> latitudePeriodNotIn, double longitudePeriodGreaterThan, double longitudePeriodLessThan, double longitudePeriodGreaterThanOrEqual, double longitudePeriodLessThanOrEqual, double longitudePeriodEquals, double longitudePeriodNotEquals, bool longitudePeriodSpecified, BuiltList<double> longitudePeriodIn, BuiltList<double> longitudePeriodNotIn, String userTypePeriodEquals, String userTypePeriodNotEquals, bool userTypePeriodSpecified, BuiltList<String> userTypePeriodIn, BuiltList<String> userTypePeriodNotIn, int userIdPeriodGreaterThan, int userIdPeriodLessThan, int userIdPeriodGreaterThanOrEqual, int userIdPeriodLessThanOrEqual, int userIdPeriodEquals, int userIdPeriodNotEquals, bool userIdPeriodSpecified, BuiltList<int> userIdPeriodIn, BuiltList<int> userIdPeriodNotIn, int reviewsIdPeriodGreaterThan, int reviewsIdPeriodLessThan, int reviewsIdPeriodGreaterThanOrEqual, int reviewsIdPeriodLessThanOrEqual, int reviewsIdPeriodEquals, int reviewsIdPeriodNotEquals, bool reviewsIdPeriodSpecified, BuiltList<int> reviewsIdPeriodIn, BuiltList<int> reviewsIdPeriodNotIn, int rewardsIdPeriodGreaterThan, int rewardsIdPeriodLessThan, int rewardsIdPeriodGreaterThanOrEqual, int rewardsIdPeriodLessThanOrEqual, int rewardsIdPeriodEquals, int rewardsIdPeriodNotEquals, bool rewardsIdPeriodSpecified, BuiltList<int> rewardsIdPeriodIn, BuiltList<int> rewardsIdPeriodNotIn, int govOfficialContentIdPeriodGreaterThan, int govOfficialContentIdPeriodLessThan, int govOfficialContentIdPeriodGreaterThanOrEqual, int govOfficialContentIdPeriodLessThanOrEqual, int govOfficialContentIdPeriodEquals, int govOfficialContentIdPeriodNotEquals, bool govOfficialContentIdPeriodSpecified, BuiltList<int> govOfficialContentIdPeriodIn, BuiltList<int> govOfficialContentIdPeriodNotIn, bool distinct, int page, int size, BuiltList<String> sort }) async
    test('test getAllAppUsers', () async {
      // TODO
    });

    //Future<AppUserDTO> getAppUser(int id) async
    test('test getAppUser', () async {
      // TODO
    });

    //Future<AppUserDTO> partialUpdateAppUser(int id, AppUserDTO appUserDTO) async
    test('test partialUpdateAppUser', () async {
      // TODO
    });

    //Future<AppUserDTO> updateAppUser(int id, AppUserDTO appUserDTO) async
    test('test updateAppUser', () async {
      // TODO
    });

  });
}
