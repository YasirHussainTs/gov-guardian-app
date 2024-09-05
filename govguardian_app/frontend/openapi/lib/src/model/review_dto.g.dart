// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'review_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ReviewDTO extends ReviewDTO {
  @override
  final int? id;
  @override
  final String? content;
  @override
  final int? rating;
  @override
  final String? feedback;
  @override
  final DateTime? timestamp;

  factory _$ReviewDTO([void Function(ReviewDTOBuilder)? updates]) =>
      (new ReviewDTOBuilder()..update(updates))._build();

  _$ReviewDTO._(
      {this.id, this.content, this.rating, this.feedback, this.timestamp})
      : super._();

  @override
  ReviewDTO rebuild(void Function(ReviewDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ReviewDTOBuilder toBuilder() => new ReviewDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ReviewDTO &&
        id == other.id &&
        content == other.content &&
        rating == other.rating &&
        feedback == other.feedback &&
        timestamp == other.timestamp;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, content.hashCode);
    _$hash = $jc(_$hash, rating.hashCode);
    _$hash = $jc(_$hash, feedback.hashCode);
    _$hash = $jc(_$hash, timestamp.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'ReviewDTO')
          ..add('id', id)
          ..add('content', content)
          ..add('rating', rating)
          ..add('feedback', feedback)
          ..add('timestamp', timestamp))
        .toString();
  }
}

class ReviewDTOBuilder implements Builder<ReviewDTO, ReviewDTOBuilder> {
  _$ReviewDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  String? _content;
  String? get content => _$this._content;
  set content(String? content) => _$this._content = content;

  int? _rating;
  int? get rating => _$this._rating;
  set rating(int? rating) => _$this._rating = rating;

  String? _feedback;
  String? get feedback => _$this._feedback;
  set feedback(String? feedback) => _$this._feedback = feedback;

  DateTime? _timestamp;
  DateTime? get timestamp => _$this._timestamp;
  set timestamp(DateTime? timestamp) => _$this._timestamp = timestamp;

  ReviewDTOBuilder() {
    ReviewDTO._defaults(this);
  }

  ReviewDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _content = $v.content;
      _rating = $v.rating;
      _feedback = $v.feedback;
      _timestamp = $v.timestamp;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ReviewDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ReviewDTO;
  }

  @override
  void update(void Function(ReviewDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  ReviewDTO build() => _build();

  _$ReviewDTO _build() {
    final _$result = _$v ??
        new _$ReviewDTO._(
            id: id,
            content: content,
            rating: rating,
            feedback: feedback,
            timestamp: timestamp);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
