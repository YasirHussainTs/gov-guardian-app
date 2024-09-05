import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for ReviewResourceApi
void main() {
  final instance = Openapi().getReviewResourceApi();

  group(ReviewResourceApi, () {
    //Future<int> countReviews({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String contentPeriodContains, String contentPeriodDoesNotContain, String contentPeriodEquals, String contentPeriodNotEquals, bool contentPeriodSpecified, BuiltList<String> contentPeriodIn, BuiltList<String> contentPeriodNotIn, int ratingPeriodGreaterThan, int ratingPeriodLessThan, int ratingPeriodGreaterThanOrEqual, int ratingPeriodLessThanOrEqual, int ratingPeriodEquals, int ratingPeriodNotEquals, bool ratingPeriodSpecified, BuiltList<int> ratingPeriodIn, BuiltList<int> ratingPeriodNotIn, String feedbackPeriodContains, String feedbackPeriodDoesNotContain, String feedbackPeriodEquals, String feedbackPeriodNotEquals, bool feedbackPeriodSpecified, BuiltList<String> feedbackPeriodIn, BuiltList<String> feedbackPeriodNotIn, DateTime timestampPeriodGreaterThan, DateTime timestampPeriodLessThan, DateTime timestampPeriodGreaterThanOrEqual, DateTime timestampPeriodLessThanOrEqual, DateTime timestampPeriodEquals, DateTime timestampPeriodNotEquals, bool timestampPeriodSpecified, BuiltList<DateTime> timestampPeriodIn, BuiltList<DateTime> timestampPeriodNotIn, bool distinct }) async
    test('test countReviews', () async {
      // TODO
    });

    //Future<ReviewDTO> createReview(ReviewDTO reviewDTO) async
    test('test createReview', () async {
      // TODO
    });

    //Future deleteReview(int id) async
    test('test deleteReview', () async {
      // TODO
    });

    //Future<BuiltList<ReviewDTO>> getAllReviews({ int idPeriodGreaterThan, int idPeriodLessThan, int idPeriodGreaterThanOrEqual, int idPeriodLessThanOrEqual, int idPeriodEquals, int idPeriodNotEquals, bool idPeriodSpecified, BuiltList<int> idPeriodIn, BuiltList<int> idPeriodNotIn, String contentPeriodContains, String contentPeriodDoesNotContain, String contentPeriodEquals, String contentPeriodNotEquals, bool contentPeriodSpecified, BuiltList<String> contentPeriodIn, BuiltList<String> contentPeriodNotIn, int ratingPeriodGreaterThan, int ratingPeriodLessThan, int ratingPeriodGreaterThanOrEqual, int ratingPeriodLessThanOrEqual, int ratingPeriodEquals, int ratingPeriodNotEquals, bool ratingPeriodSpecified, BuiltList<int> ratingPeriodIn, BuiltList<int> ratingPeriodNotIn, String feedbackPeriodContains, String feedbackPeriodDoesNotContain, String feedbackPeriodEquals, String feedbackPeriodNotEquals, bool feedbackPeriodSpecified, BuiltList<String> feedbackPeriodIn, BuiltList<String> feedbackPeriodNotIn, DateTime timestampPeriodGreaterThan, DateTime timestampPeriodLessThan, DateTime timestampPeriodGreaterThanOrEqual, DateTime timestampPeriodLessThanOrEqual, DateTime timestampPeriodEquals, DateTime timestampPeriodNotEquals, bool timestampPeriodSpecified, BuiltList<DateTime> timestampPeriodIn, BuiltList<DateTime> timestampPeriodNotIn, bool distinct, int page, int size, BuiltList<String> sort }) async
    test('test getAllReviews', () async {
      // TODO
    });

    //Future<ReviewDTO> getReview(int id) async
    test('test getReview', () async {
      // TODO
    });

    //Future<ReviewDTO> partialUpdateReview(int id, ReviewDTO reviewDTO) async
    test('test partialUpdateReview', () async {
      // TODO
    });

    //Future<ReviewDTO> updateReview(int id, ReviewDTO reviewDTO) async
    test('test updateReview', () async {
      // TODO
    });

  });
}
