// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'report_header_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ReportHeaderDTO extends ReportHeaderDTO {
  @override
  final String? id;
  @override
  final String? description;
  @override
  final String? title;
  @override
  final DateTime? timestamp;
  @override
  final String? status;
  @override
  final AppUserDTO? appUser;

  factory _$ReportHeaderDTO([void Function(ReportHeaderDTOBuilder)? updates]) =>
      (new ReportHeaderDTOBuilder()..update(updates))._build();

  _$ReportHeaderDTO._(
      {this.id,
      this.description,
      this.title,
      this.timestamp,
      this.status,
      this.appUser})
      : super._();

  @override
  ReportHeaderDTO rebuild(void Function(ReportHeaderDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ReportHeaderDTOBuilder toBuilder() =>
      new ReportHeaderDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ReportHeaderDTO &&
        id == other.id &&
        description == other.description &&
        title == other.title &&
        timestamp == other.timestamp &&
        status == other.status &&
        appUser == other.appUser;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, description.hashCode);
    _$hash = $jc(_$hash, title.hashCode);
    _$hash = $jc(_$hash, timestamp.hashCode);
    _$hash = $jc(_$hash, status.hashCode);
    _$hash = $jc(_$hash, appUser.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'ReportHeaderDTO')
          ..add('id', id)
          ..add('description', description)
          ..add('title', title)
          ..add('timestamp', timestamp)
          ..add('status', status)
          ..add('appUser', appUser))
        .toString();
  }
}

class ReportHeaderDTOBuilder
    implements Builder<ReportHeaderDTO, ReportHeaderDTOBuilder> {
  _$ReportHeaderDTO? _$v;

  String? _id;
  String? get id => _$this._id;
  set id(String? id) => _$this._id = id;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  String? _title;
  String? get title => _$this._title;
  set title(String? title) => _$this._title = title;

  DateTime? _timestamp;
  DateTime? get timestamp => _$this._timestamp;
  set timestamp(DateTime? timestamp) => _$this._timestamp = timestamp;

  String? _status;
  String? get status => _$this._status;
  set status(String? status) => _$this._status = status;

  AppUserDTOBuilder? _appUser;
  AppUserDTOBuilder get appUser => _$this._appUser ??= new AppUserDTOBuilder();
  set appUser(AppUserDTOBuilder? appUser) => _$this._appUser = appUser;

  ReportHeaderDTOBuilder() {
    ReportHeaderDTO._defaults(this);
  }

  ReportHeaderDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _description = $v.description;
      _title = $v.title;
      _timestamp = $v.timestamp;
      _status = $v.status;
      _appUser = $v.appUser?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ReportHeaderDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ReportHeaderDTO;
  }

  @override
  void update(void Function(ReportHeaderDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  ReportHeaderDTO build() => _build();

  _$ReportHeaderDTO _build() {
    _$ReportHeaderDTO _$result;
    try {
      _$result = _$v ??
          new _$ReportHeaderDTO._(
              id: id,
              description: description,
              title: title,
              timestamp: timestamp,
              status: status,
              appUser: _appUser?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'appUser';
        _appUser?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            r'ReportHeaderDTO', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
