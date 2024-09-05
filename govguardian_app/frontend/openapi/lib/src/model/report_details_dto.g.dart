// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'report_details_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$ReportDetailsDTO extends ReportDetailsDTO {
  @override
  final int? id;
  @override
  final String? owner;
  @override
  final String? responder;
  @override
  final String? description;
  @override
  final String? title;
  @override
  final DateTime? timestamp;
  @override
  final String? status;
  @override
  final BuiltList<String>? image;
  @override
  final String? imageContentType;
  @override
  final BuiltList<String>? video;
  @override
  final String? videoContentType;
  @override
  final BuiltList<String>? voiceData;
  @override
  final String? voiceDataContentType;
  @override
  final BuiltList<String>? file1;
  @override
  final String? file1ContentType;
  @override
  final BuiltList<String>? file2;
  @override
  final String? file2ContentType;
  @override
  final BuiltList<String>? file3;
  @override
  final String? file3ContentType;
  @override
  final AppUserDTO? appUser;

  factory _$ReportDetailsDTO(
          [void Function(ReportDetailsDTOBuilder)? updates]) =>
      (new ReportDetailsDTOBuilder()..update(updates))._build();

  _$ReportDetailsDTO._(
      {this.id,
      this.owner,
      this.responder,
      this.description,
      this.title,
      this.timestamp,
      this.status,
      this.image,
      this.imageContentType,
      this.video,
      this.videoContentType,
      this.voiceData,
      this.voiceDataContentType,
      this.file1,
      this.file1ContentType,
      this.file2,
      this.file2ContentType,
      this.file3,
      this.file3ContentType,
      this.appUser})
      : super._();

  @override
  ReportDetailsDTO rebuild(void Function(ReportDetailsDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  ReportDetailsDTOBuilder toBuilder() =>
      new ReportDetailsDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is ReportDetailsDTO &&
        id == other.id &&
        owner == other.owner &&
        responder == other.responder &&
        description == other.description &&
        title == other.title &&
        timestamp == other.timestamp &&
        status == other.status &&
        image == other.image &&
        imageContentType == other.imageContentType &&
        video == other.video &&
        videoContentType == other.videoContentType &&
        voiceData == other.voiceData &&
        voiceDataContentType == other.voiceDataContentType &&
        file1 == other.file1 &&
        file1ContentType == other.file1ContentType &&
        file2 == other.file2 &&
        file2ContentType == other.file2ContentType &&
        file3 == other.file3 &&
        file3ContentType == other.file3ContentType &&
        appUser == other.appUser;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, owner.hashCode);
    _$hash = $jc(_$hash, responder.hashCode);
    _$hash = $jc(_$hash, description.hashCode);
    _$hash = $jc(_$hash, title.hashCode);
    _$hash = $jc(_$hash, timestamp.hashCode);
    _$hash = $jc(_$hash, status.hashCode);
    _$hash = $jc(_$hash, image.hashCode);
    _$hash = $jc(_$hash, imageContentType.hashCode);
    _$hash = $jc(_$hash, video.hashCode);
    _$hash = $jc(_$hash, videoContentType.hashCode);
    _$hash = $jc(_$hash, voiceData.hashCode);
    _$hash = $jc(_$hash, voiceDataContentType.hashCode);
    _$hash = $jc(_$hash, file1.hashCode);
    _$hash = $jc(_$hash, file1ContentType.hashCode);
    _$hash = $jc(_$hash, file2.hashCode);
    _$hash = $jc(_$hash, file2ContentType.hashCode);
    _$hash = $jc(_$hash, file3.hashCode);
    _$hash = $jc(_$hash, file3ContentType.hashCode);
    _$hash = $jc(_$hash, appUser.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'ReportDetailsDTO')
          ..add('id', id)
          ..add('owner', owner)
          ..add('responder', responder)
          ..add('description', description)
          ..add('title', title)
          ..add('timestamp', timestamp)
          ..add('status', status)
          ..add('image', image)
          ..add('imageContentType', imageContentType)
          ..add('video', video)
          ..add('videoContentType', videoContentType)
          ..add('voiceData', voiceData)
          ..add('voiceDataContentType', voiceDataContentType)
          ..add('file1', file1)
          ..add('file1ContentType', file1ContentType)
          ..add('file2', file2)
          ..add('file2ContentType', file2ContentType)
          ..add('file3', file3)
          ..add('file3ContentType', file3ContentType)
          ..add('appUser', appUser))
        .toString();
  }
}

class ReportDetailsDTOBuilder
    implements Builder<ReportDetailsDTO, ReportDetailsDTOBuilder> {
  _$ReportDetailsDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  String? _owner;
  String? get owner => _$this._owner;
  set owner(String? owner) => _$this._owner = owner;

  String? _responder;
  String? get responder => _$this._responder;
  set responder(String? responder) => _$this._responder = responder;

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

  ListBuilder<String>? _image;
  ListBuilder<String> get image => _$this._image ??= new ListBuilder<String>();
  set image(ListBuilder<String>? image) => _$this._image = image;

  String? _imageContentType;
  String? get imageContentType => _$this._imageContentType;
  set imageContentType(String? imageContentType) =>
      _$this._imageContentType = imageContentType;

  ListBuilder<String>? _video;
  ListBuilder<String> get video => _$this._video ??= new ListBuilder<String>();
  set video(ListBuilder<String>? video) => _$this._video = video;

  String? _videoContentType;
  String? get videoContentType => _$this._videoContentType;
  set videoContentType(String? videoContentType) =>
      _$this._videoContentType = videoContentType;

  ListBuilder<String>? _voiceData;
  ListBuilder<String> get voiceData =>
      _$this._voiceData ??= new ListBuilder<String>();
  set voiceData(ListBuilder<String>? voiceData) =>
      _$this._voiceData = voiceData;

  String? _voiceDataContentType;
  String? get voiceDataContentType => _$this._voiceDataContentType;
  set voiceDataContentType(String? voiceDataContentType) =>
      _$this._voiceDataContentType = voiceDataContentType;

  ListBuilder<String>? _file1;
  ListBuilder<String> get file1 => _$this._file1 ??= new ListBuilder<String>();
  set file1(ListBuilder<String>? file1) => _$this._file1 = file1;

  String? _file1ContentType;
  String? get file1ContentType => _$this._file1ContentType;
  set file1ContentType(String? file1ContentType) =>
      _$this._file1ContentType = file1ContentType;

  ListBuilder<String>? _file2;
  ListBuilder<String> get file2 => _$this._file2 ??= new ListBuilder<String>();
  set file2(ListBuilder<String>? file2) => _$this._file2 = file2;

  String? _file2ContentType;
  String? get file2ContentType => _$this._file2ContentType;
  set file2ContentType(String? file2ContentType) =>
      _$this._file2ContentType = file2ContentType;

  ListBuilder<String>? _file3;
  ListBuilder<String> get file3 => _$this._file3 ??= new ListBuilder<String>();
  set file3(ListBuilder<String>? file3) => _$this._file3 = file3;

  String? _file3ContentType;
  String? get file3ContentType => _$this._file3ContentType;
  set file3ContentType(String? file3ContentType) =>
      _$this._file3ContentType = file3ContentType;

  AppUserDTOBuilder? _appUser;
  AppUserDTOBuilder get appUser => _$this._appUser ??= new AppUserDTOBuilder();
  set appUser(AppUserDTOBuilder? appUser) => _$this._appUser = appUser;

  ReportDetailsDTOBuilder() {
    ReportDetailsDTO._defaults(this);
  }

  ReportDetailsDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _owner = $v.owner;
      _responder = $v.responder;
      _description = $v.description;
      _title = $v.title;
      _timestamp = $v.timestamp;
      _status = $v.status;
      _image = $v.image?.toBuilder();
      _imageContentType = $v.imageContentType;
      _video = $v.video?.toBuilder();
      _videoContentType = $v.videoContentType;
      _voiceData = $v.voiceData?.toBuilder();
      _voiceDataContentType = $v.voiceDataContentType;
      _file1 = $v.file1?.toBuilder();
      _file1ContentType = $v.file1ContentType;
      _file2 = $v.file2?.toBuilder();
      _file2ContentType = $v.file2ContentType;
      _file3 = $v.file3?.toBuilder();
      _file3ContentType = $v.file3ContentType;
      _appUser = $v.appUser?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(ReportDetailsDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$ReportDetailsDTO;
  }

  @override
  void update(void Function(ReportDetailsDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  ReportDetailsDTO build() => _build();

  _$ReportDetailsDTO _build() {
    _$ReportDetailsDTO _$result;
    try {
      _$result = _$v ??
          new _$ReportDetailsDTO._(
              id: id,
              owner: owner,
              responder: responder,
              description: description,
              title: title,
              timestamp: timestamp,
              status: status,
              image: _image?.build(),
              imageContentType: imageContentType,
              video: _video?.build(),
              videoContentType: videoContentType,
              voiceData: _voiceData?.build(),
              voiceDataContentType: voiceDataContentType,
              file1: _file1?.build(),
              file1ContentType: file1ContentType,
              file2: _file2?.build(),
              file2ContentType: file2ContentType,
              file3: _file3?.build(),
              file3ContentType: file3ContentType,
              appUser: _appUser?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'image';
        _image?.build();

        _$failedField = 'video';
        _video?.build();

        _$failedField = 'voiceData';
        _voiceData?.build();

        _$failedField = 'file1';
        _file1?.build();

        _$failedField = 'file2';
        _file2?.build();

        _$failedField = 'file3';
        _file3?.build();

        _$failedField = 'appUser';
        _appUser?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            r'ReportDetailsDTO', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
