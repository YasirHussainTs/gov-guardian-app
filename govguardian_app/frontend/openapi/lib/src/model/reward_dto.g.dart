// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reward_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$RewardDTO extends RewardDTO {
  @override
  final int? id;
  @override
  final String? description;
  @override
  final int? points;
  @override
  final DateTime? timestamp;

  factory _$RewardDTO([void Function(RewardDTOBuilder)? updates]) =>
      (new RewardDTOBuilder()..update(updates))._build();

  _$RewardDTO._({this.id, this.description, this.points, this.timestamp})
      : super._();

  @override
  RewardDTO rebuild(void Function(RewardDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  RewardDTOBuilder toBuilder() => new RewardDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is RewardDTO &&
        id == other.id &&
        description == other.description &&
        points == other.points &&
        timestamp == other.timestamp;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, description.hashCode);
    _$hash = $jc(_$hash, points.hashCode);
    _$hash = $jc(_$hash, timestamp.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'RewardDTO')
          ..add('id', id)
          ..add('description', description)
          ..add('points', points)
          ..add('timestamp', timestamp))
        .toString();
  }
}

class RewardDTOBuilder implements Builder<RewardDTO, RewardDTOBuilder> {
  _$RewardDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  int? _points;
  int? get points => _$this._points;
  set points(int? points) => _$this._points = points;

  DateTime? _timestamp;
  DateTime? get timestamp => _$this._timestamp;
  set timestamp(DateTime? timestamp) => _$this._timestamp = timestamp;

  RewardDTOBuilder() {
    RewardDTO._defaults(this);
  }

  RewardDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _description = $v.description;
      _points = $v.points;
      _timestamp = $v.timestamp;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(RewardDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$RewardDTO;
  }

  @override
  void update(void Function(RewardDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  RewardDTO build() => _build();

  _$RewardDTO _build() {
    final _$result = _$v ??
        new _$RewardDTO._(
            id: id,
            description: description,
            points: points,
            timestamp: timestamp);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
