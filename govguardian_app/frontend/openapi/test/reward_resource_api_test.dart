import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for RewardResourceApi
void main() {
  final instance = Openapi().getRewardResourceApi();

  group(RewardResourceApi, () {
    //Future<int> countRewards({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, int pointsPeriodGreaterThan, int pointsPeriodLessThan, int pointsPeriodGreaterThanOrEqual, int pointsPeriodLessThanOrEqual, int pointsPeriodEquals, int pointsPeriodNotEquals, bool pointsPeriodSpecified, BuiltList<int> pointsPeriodIn, BuiltList<int> pointsPeriodNotIn, DateTime timestampPeriodGreaterThan, DateTime timestampPeriodLessThan, DateTime timestampPeriodGreaterThanOrEqual, DateTime timestampPeriodLessThanOrEqual, DateTime timestampPeriodEquals, DateTime timestampPeriodNotEquals, bool timestampPeriodSpecified, BuiltList<DateTime> timestampPeriodIn, BuiltList<DateTime> timestampPeriodNotIn, bool distinct }) async
    test('test countRewards', () async {
      // TODO
    });

    //Future<RewardDTO> createReward(RewardDTO rewardDTO) async
    test('test createReward', () async {
      // TODO
    });

    //Future deleteReward(int id) async
    test('test deleteReward', () async {
      // TODO
    });

    //Future<BuiltList<RewardDTO>> getAllRewards({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String descriptionPeriodContains, String descriptionPeriodDoesNotContain, String descriptionPeriodEquals, String descriptionPeriodNotEquals, bool descriptionPeriodSpecified, BuiltList<String> descriptionPeriodIn, BuiltList<String> descriptionPeriodNotIn, int pointsPeriodGreaterThan, int pointsPeriodLessThan, int pointsPeriodGreaterThanOrEqual, int pointsPeriodLessThanOrEqual, int pointsPeriodEquals, int pointsPeriodNotEquals, bool pointsPeriodSpecified, BuiltList<int> pointsPeriodIn, BuiltList<int> pointsPeriodNotIn, DateTime timestampPeriodGreaterThan, DateTime timestampPeriodLessThan, DateTime timestampPeriodGreaterThanOrEqual, DateTime timestampPeriodLessThanOrEqual, DateTime timestampPeriodEquals, DateTime timestampPeriodNotEquals, bool timestampPeriodSpecified, BuiltList<DateTime> timestampPeriodIn, BuiltList<DateTime> timestampPeriodNotIn, bool distinct, int page, int size, BuiltList<String> sort }) async
    test('test getAllRewards', () async {
      // TODO
    });

    //Future<RewardDTO> getReward(int id) async
    test('test getReward', () async {
      // TODO
    });

    //Future<RewardDTO> partialUpdateReward(int id, RewardDTO rewardDTO) async
    test('test partialUpdateReward', () async {
      // TODO
    });

    //Future<RewardDTO> updateReward(int id, RewardDTO rewardDTO) async
    test('test updateReward', () async {
      // TODO
    });

  });
}
