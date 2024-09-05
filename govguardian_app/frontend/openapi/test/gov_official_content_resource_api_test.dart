import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for GovOfficialContentResourceApi
void main() {
  final instance = Openapi().getGovOfficialContentResourceApi();

  group(GovOfficialContentResourceApi, () {
    //Future<int> countGovOfficialContents({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String lawPeriodContains, String lawPeriodDoesNotContain, String lawPeriodEquals, String lawPeriodNotEquals, bool lawPeriodSpecified, BuiltList<String> lawPeriodIn, BuiltList<String> lawPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, String actionPeriodContains, String actionPeriodDoesNotContain, String actionPeriodEquals, String actionPeriodNotEquals, bool actionPeriodSpecified, BuiltList<String> actionPeriodIn, BuiltList<String> actionPeriodNotIn, DateTime datePeriodGreaterThan, DateTime datePeriodLessThan, DateTime datePeriodGreaterThanOrEqual, DateTime datePeriodLessThanOrEqual, DateTime datePeriodEquals, DateTime datePeriodNotEquals, bool datePeriodSpecified, BuiltList<DateTime> datePeriodIn, BuiltList<DateTime> datePeriodNotIn, bool distinct }) async
    test('test countGovOfficialContents', () async {
      // TODO
    });

    //Future<GovOfficialContentDTO> createGovOfficialContent(GovOfficialContentDTO govOfficialContentDTO) async
    test('test createGovOfficialContent', () async {
      // TODO
    });

    //Future deleteGovOfficialContent(int id) async
    test('test deleteGovOfficialContent', () async {
      // TODO
    });

    //Future<BuiltList<GovOfficialContentDTO>> getAllGovOfficialContents({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String lawPeriodContains, String lawPeriodDoesNotContain, String lawPeriodEquals, String lawPeriodNotEquals, bool lawPeriodSpecified, BuiltList<String> lawPeriodIn, BuiltList<String> lawPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, String actionPeriodContains, String actionPeriodDoesNotContain, String actionPeriodEquals, String actionPeriodNotEquals, bool actionPeriodSpecified, BuiltList<String> actionPeriodIn, BuiltList<String> actionPeriodNotIn, DateTime datePeriodGreaterThan, DateTime datePeriodLessThan, DateTime datePeriodGreaterThanOrEqual, DateTime datePeriodLessThanOrEqual, DateTime datePeriodEquals, DateTime datePeriodNotEquals, bool datePeriodSpecified, BuiltList<DateTime> datePeriodIn, BuiltList<DateTime> datePeriodNotIn, bool distinct, int page, int size, BuiltList<String> sort }) async
    test('test getAllGovOfficialContents', () async {
      // TODO
    });

    //Future<GovOfficialContentDTO> getGovOfficialContent(int id) async
    test('test getGovOfficialContent', () async {
      // TODO
    });

    //Future<GovOfficialContentDTO> partialUpdateGovOfficialContent(int id, GovOfficialContentDTO govOfficialContentDTO) async
    test('test partialUpdateGovOfficialContent', () async {
      // TODO
    });

    //Future<GovOfficialContentDTO> updateGovOfficialContent(int id, GovOfficialContentDTO govOfficialContentDTO) async
    test('test updateGovOfficialContent', () async {
      // TODO
    });

  });
}
