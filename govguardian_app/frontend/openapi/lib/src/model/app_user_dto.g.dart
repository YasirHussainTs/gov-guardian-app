// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'app_user_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

const AppUserDTOUserTypeEnum _$appUserDTOUserTypeEnum_USER =
    const AppUserDTOUserTypeEnum._('USER');
const AppUserDTOUserTypeEnum _$appUserDTOUserTypeEnum_COMMUNITY_MEMBER =
    const AppUserDTOUserTypeEnum._('COMMUNITY_MEMBER');
const AppUserDTOUserTypeEnum _$appUserDTOUserTypeEnum_GOV_OFFICIAL =
    const AppUserDTOUserTypeEnum._('GOV_OFFICIAL');

AppUserDTOUserTypeEnum _$appUserDTOUserTypeEnumValueOf(String name) {
  switch (name) {
    case 'USER':
      return _$appUserDTOUserTypeEnum_USER;
    case 'COMMUNITY_MEMBER':
      return _$appUserDTOUserTypeEnum_COMMUNITY_MEMBER;
    case 'GOV_OFFICIAL':
      return _$appUserDTOUserTypeEnum_GOV_OFFICIAL;
    default:
      throw new ArgumentError(name);
  }
}

final BuiltSet<AppUserDTOUserTypeEnum> _$appUserDTOUserTypeEnumValues =
    new BuiltSet<AppUserDTOUserTypeEnum>(const <AppUserDTOUserTypeEnum>[
  _$appUserDTOUserTypeEnum_USER,
  _$appUserDTOUserTypeEnum_COMMUNITY_MEMBER,
  _$appUserDTOUserTypeEnum_GOV_OFFICIAL,
]);

Serializer<AppUserDTOUserTypeEnum> _$appUserDTOUserTypeEnumSerializer =
    new _$AppUserDTOUserTypeEnumSerializer();

class _$AppUserDTOUserTypeEnumSerializer
    implements PrimitiveSerializer<AppUserDTOUserTypeEnum> {
  static const Map<String, Object> _toWire = const <String, Object>{
    'USER': 'USER',
    'COMMUNITY_MEMBER': 'COMMUNITY_MEMBER',
    'GOV_OFFICIAL': 'GOV_OFFICIAL',
  };
  static const Map<Object, String> _fromWire = const <Object, String>{
    'USER': 'USER',
    'COMMUNITY_MEMBER': 'COMMUNITY_MEMBER',
    'GOV_OFFICIAL': 'GOV_OFFICIAL',
  };

  @override
  final Iterable<Type> types = const <Type>[AppUserDTOUserTypeEnum];
  @override
  final String wireName = 'AppUserDTOUserTypeEnum';

  @override
  Object serialize(Serializers serializers, AppUserDTOUserTypeEnum object,
          {FullType specifiedType = FullType.unspecified}) =>
      _toWire[object.name] ?? object.name;

  @override
  AppUserDTOUserTypeEnum deserialize(Serializers serializers, Object serialized,
          {FullType specifiedType = FullType.unspecified}) =>
      AppUserDTOUserTypeEnum.valueOf(
          _fromWire[serialized] ?? (serialized is String ? serialized : ''));
}

class _$AppUserDTO extends AppUserDTO {
  @override
  final int? id;
  @override
  final String? email;
  @override
  final String? address;
  @override
  final String? phone;
  @override
  final String? gender;
  @override
  final String? department;
  @override
  final String? description;
  @override
  final double? latitude;
  @override
  final double? longitude;
  @override
  final AppUserDTOUserTypeEnum? userType;
  @override
  final UserDTO? user;
  @override
  final ReviewDTO? reviews;
  @override
  final RewardDTO? rewards;
  @override
  final GovOfficialContentDTO? govOfficialContent;

  factory _$AppUserDTO([void Function(AppUserDTOBuilder)? updates]) =>
      (new AppUserDTOBuilder()..update(updates))._build();

  _$AppUserDTO._(
      {this.id,
      this.email,
      this.address,
      this.phone,
      this.gender,
      this.department,
      this.description,
      this.latitude,
      this.longitude,
      this.userType,
      this.user,
      this.reviews,
      this.rewards,
      this.govOfficialContent})
      : super._();

  @override
  AppUserDTO rebuild(void Function(AppUserDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  AppUserDTOBuilder toBuilder() => new AppUserDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is AppUserDTO &&
        id == other.id &&
        email == other.email &&
        address == other.address &&
        phone == other.phone &&
        gender == other.gender &&
        department == other.department &&
        description == other.description &&
        latitude == other.latitude &&
        longitude == other.longitude &&
        userType == other.userType &&
        user == other.user &&
        reviews == other.reviews &&
        rewards == other.rewards &&
        govOfficialContent == other.govOfficialContent;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, email.hashCode);
    _$hash = $jc(_$hash, address.hashCode);
    _$hash = $jc(_$hash, phone.hashCode);
    _$hash = $jc(_$hash, gender.hashCode);
    _$hash = $jc(_$hash, department.hashCode);
    _$hash = $jc(_$hash, description.hashCode);
    _$hash = $jc(_$hash, latitude.hashCode);
    _$hash = $jc(_$hash, longitude.hashCode);
    _$hash = $jc(_$hash, userType.hashCode);
    _$hash = $jc(_$hash, user.hashCode);
    _$hash = $jc(_$hash, reviews.hashCode);
    _$hash = $jc(_$hash, rewards.hashCode);
    _$hash = $jc(_$hash, govOfficialContent.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'AppUserDTO')
          ..add('id', id)
          ..add('email', email)
          ..add('address', address)
          ..add('phone', phone)
          ..add('gender', gender)
          ..add('department', department)
          ..add('description', description)
          ..add('latitude', latitude)
          ..add('longitude', longitude)
          ..add('userType', userType)
          ..add('user', user)
          ..add('reviews', reviews)
          ..add('rewards', rewards)
          ..add('govOfficialContent', govOfficialContent))
        .toString();
  }
}

class AppUserDTOBuilder implements Builder<AppUserDTO, AppUserDTOBuilder> {
  _$AppUserDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  String? _email;
  String? get email => _$this._email;
  set email(String? email) => _$this._email = email;

  String? _address;
  String? get address => _$this._address;
  set address(String? address) => _$this._address = address;

  String? _phone;
  String? get phone => _$this._phone;
  set phone(String? phone) => _$this._phone = phone;

  String? _gender;
  String? get gender => _$this._gender;
  set gender(String? gender) => _$this._gender = gender;

  String? _department;
  String? get department => _$this._department;
  set department(String? department) => _$this._department = department;

  String? _description;
  String? get description => _$this._description;
  set description(String? description) => _$this._description = description;

  double? _latitude;
  double? get latitude => _$this._latitude;
  set latitude(double? latitude) => _$this._latitude = latitude;

  double? _longitude;
  double? get longitude => _$this._longitude;
  set longitude(double? longitude) => _$this._longitude = longitude;

  AppUserDTOUserTypeEnum? _userType;
  AppUserDTOUserTypeEnum? get userType => _$this._userType;
  set userType(AppUserDTOUserTypeEnum? userType) => _$this._userType = userType;

  UserDTOBuilder? _user;
  UserDTOBuilder get user => _$this._user ??= new UserDTOBuilder();
  set user(UserDTOBuilder? user) => _$this._user = user;

  ReviewDTOBuilder? _reviews;
  ReviewDTOBuilder get reviews => _$this._reviews ??= new ReviewDTOBuilder();
  set reviews(ReviewDTOBuilder? reviews) => _$this._reviews = reviews;

  RewardDTOBuilder? _rewards;
  RewardDTOBuilder get rewards => _$this._rewards ??= new RewardDTOBuilder();
  set rewards(RewardDTOBuilder? rewards) => _$this._rewards = rewards;

  GovOfficialContentDTOBuilder? _govOfficialContent;
  GovOfficialContentDTOBuilder get govOfficialContent =>
      _$this._govOfficialContent ??= new GovOfficialContentDTOBuilder();
  set govOfficialContent(GovOfficialContentDTOBuilder? govOfficialContent) =>
      _$this._govOfficialContent = govOfficialContent;

  AppUserDTOBuilder() {
    AppUserDTO._defaults(this);
  }

  AppUserDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _email = $v.email;
      _address = $v.address;
      _phone = $v.phone;
      _gender = $v.gender;
      _department = $v.department;
      _description = $v.description;
      _latitude = $v.latitude;
      _longitude = $v.longitude;
      _userType = $v.userType;
      _user = $v.user?.toBuilder();
      _reviews = $v.reviews?.toBuilder();
      _rewards = $v.rewards?.toBuilder();
      _govOfficialContent = $v.govOfficialContent?.toBuilder();
      _$v = null;
    }
    return this;
  }

  @override
  void replace(AppUserDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$AppUserDTO;
  }

  @override
  void update(void Function(AppUserDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  AppUserDTO build() => _build();

  _$AppUserDTO _build() {
    _$AppUserDTO _$result;
    try {
      _$result = _$v ??
          new _$AppUserDTO._(
              id: id,
              email: email,
              address: address,
              phone: phone,
              gender: gender,
              department: department,
              description: description,
              latitude: latitude,
              longitude: longitude,
              userType: userType,
              user: _user?.build(),
              reviews: _reviews?.build(),
              rewards: _rewards?.build(),
              govOfficialContent: _govOfficialContent?.build());
    } catch (_) {
      late String _$failedField;
      try {
        _$failedField = 'user';
        _user?.build();
        _$failedField = 'reviews';
        _reviews?.build();
        _$failedField = 'rewards';
        _rewards?.build();
        _$failedField = 'govOfficialContent';
        _govOfficialContent?.build();
      } catch (e) {
        throw new BuiltValueNestedFieldError(
            r'AppUserDTO', _$failedField, e.toString());
      }
      rethrow;
    }
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
