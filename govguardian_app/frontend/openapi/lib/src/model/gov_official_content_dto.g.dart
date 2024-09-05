// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'gov_official_content_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$GovOfficialContentDTO extends GovOfficialContentDTO {
  @override
  final int? id;
  @override
  final String? law;
  @override
  final String? description;
  @override
  final String? action;
  @override
  final DateTime? date;

  factory _$GovOfficialContentDTO(
          [void Function(GovOfficialContentDTOBuilder)? updates]) =>
      (new GovOfficialContentDTOBuilder()..update(updates))._build();

  _$GovOfficialContentDTO._(
      {this.id, this.law, this.description, this.action, this.date})
      : super._();

  @override
  GovOfficialContentDTO rebuild(
          void Function(GovOfficialContentDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  GovOfficialContentDTOBuilder toBuilder() =>
      new GovOfficialContentDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is GovOfficialContentDTO &&
        id == other.id &&
        law == other.law &&
        description == other.description &&
        action == other.action &&
        date == other.date;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, law.hashCode);
    _$hash = $jc(_$hash, description.hashCode);
    _$hash = $jc(_$hash, action.hashCode);
    _$hash = $jc(_$hash, date.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'GovOfficialContentDTO')
          ..add('id', id)
          ..add('law', law)
          ..add('description', description)
          ..add('action', action)
          ..add('date', date))
        .toString();
  }
}

class GovOfficialContentDTOBuilder
    implements Builder<GovOfficialContentDTO, GovOfficialContentDTOBuilder> {
  _$GovOfficialContentDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  String? _law;
  String? get law => _$this._law;
  set law(String? law) => _$this._law = law;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _action;
  String? get action => _$this._action;
  set action(String? action) => _$this._action = action;

  DateTime? _date;
  DateTime? get date => _$this._date;
  set date(DateTime? date) => _$this._date = date;

  GovOfficialContentDTOBuilder() {
    GovOfficialContentDTO._defaults(this);
  }

  GovOfficialContentDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _law = $v.law;
      _description = $v.description;
      _action = $v.action;
      _date = $v.date;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(GovOfficialContentDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$GovOfficialContentDTO;
  }

  @override
  void update(void Function(GovOfficialContentDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  GovOfficialContentDTO build() => _build();

  _$GovOfficialContentDTO _build() {
    final _$result = _$v ??
        new _$GovOfficialContentDTO._(
            id: id,
            law: law,
            description: description,
            action: action,
            date: date);
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
