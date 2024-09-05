//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/reward_dto.dart';
import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/review_dto.dart';
import 'package:openapi/src/model/gov_official_content_dto.dart';
import 'package:openapi/src/model/user_dto.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'app_user_dto.g.dart';

/// AppUserDTO
///
/// Properties:
/// * [id] 
/// * [email] 
/// * [address] 
/// * [phone] 
/// * [gender] 
/// * [department] 
/// * [description] 
/// * [latitude] 
/// * [longitude] 
/// * [userType] 
/// * [user] 
/// * [reviews] 
/// * [rewards] 
/// * [govOfficialContent] 
@BuiltValue()
abstract class AppUserDTO implements Built<AppUserDTO, AppUserDTOBuilder> {
  @BuiltValueField(wireName: r'id')
  int? get id;

  @BuiltValueField(wireName: r'email')
  String? get email;

  @BuiltValueField(wireName: r'address')
  String? get address;

  @BuiltValueField(wireName: r'phone')
  String? get phone;

  @BuiltValueField(wireName: r'gender')
  String? get gender;

  @BuiltValueField(wireName: r'department')
  String? get department;

  @BuiltValueField(wireName: r'description')
  String? get description;

  @BuiltValueField(wireName: r'latitude')
  double? get latitude;

  @BuiltValueField(wireName: r'longitude')
  double? get longitude;

  @BuiltValueField(wireName: r'userType')
  AppUserDTOUserTypeEnum? get userType;
  // enum userTypeEnum {  USER,  COMMUNITY_MEMBER,  GOV_OFFICIAL,  };

  @BuiltValueField(wireName: r'user')
  UserDTO? get user;

  @BuiltValueField(wireName: r'reviews')
  ReviewDTO? get reviews;

  @BuiltValueField(wireName: r'rewards')
  RewardDTO? get rewards;

  @BuiltValueField(wireName: r'govOfficialContent')
  GovOfficialContentDTO? get govOfficialContent;

  AppUserDTO._();

  factory AppUserDTO([void updates(AppUserDTOBuilder b)]) = _$AppUserDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(AppUserDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<AppUserDTO> get serializer => _$AppUserDTOSerializer();
}

class _$AppUserDTOSerializer implements PrimitiveSerializer<AppUserDTO> {
  @override
  final Iterable<Type> types = const [AppUserDTO, _$AppUserDTO];

  @override
  final String wireName = r'AppUserDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    AppUserDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
    if (object.email != null) {
      yield r'email';
      yield serializers.serialize(
        object.email,
        specifiedType: const FullType(String),
      );
    }
    if (object.address != null) {
      yield r'address';
      yield serializers.serialize(
        object.address,
        specifiedType: const FullType(String),
      );
    }
    if (object.phone != null) {
      yield r'phone';
      yield serializers.serialize(
        object.phone,
        specifiedType: const FullType(String),
      );
    }
    if (object.gender != null) {
      yield r'gender';
      yield serializers.serialize(
        object.gender,
        specifiedType: const FullType(String),
      );
    }
    if (object.department != null) {
      yield r'department';
      yield serializers.serialize(
        object.department,
        specifiedType: const FullType(String),
      );
    }
    if (object.description != null) {
      yield r'description';
      yield serializers.serialize(
        object.description,
        specifiedType: const FullType(String),
      );
    }
    if (object.latitude != null) {
      yield r'latitude';
      yield serializers.serialize(
        object.latitude,
        specifiedType: const FullType(double),
      );
    }
    if (object.longitude != null) {
      yield r'longitude';
      yield serializers.serialize(
        object.longitude,
        specifiedType: const FullType(double),
      );
    }
    if (object.userType != null) {
      yield r'userType';
      yield serializers.serialize(
        object.userType,
        specifiedType: const FullType(AppUserDTOUserTypeEnum),
      );
    }
    if (object.user != null) {
      yield r'user';
      yield serializers.serialize(
        object.user,
        specifiedType: const FullType(UserDTO),
      );
    }
    if (object.reviews != null) {
      yield r'reviews';
      yield serializers.serialize(
        object.reviews,
        specifiedType: const FullType(ReviewDTO),
      );
    }
    if (object.rewards != null) {
      yield r'rewards';
      yield serializers.serialize(
        object.rewards,
        specifiedType: const FullType(RewardDTO),
      );
    }
    if (object.govOfficialContent != null) {
      yield r'govOfficialContent';
      yield serializers.serialize(
        object.govOfficialContent,
        specifiedType: const FullType(GovOfficialContentDTO),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    AppUserDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required AppUserDTOBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.id = valueDes;
          break;
        case r'email':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.email = valueDes;
          break;
        case r'address':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.address = valueDes;
          break;
        case r'phone':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.phone = valueDes;
          break;
        case r'gender':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.gender = valueDes;
          break;
        case r'department':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.department = valueDes;
          break;
        case r'description':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.description = valueDes;
          break;
        case r'latitude':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(double),
          ) as double;
          result.latitude = valueDes;
          break;
        case r'longitude':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(double),
          ) as double;
          result.longitude = valueDes;
          break;
        case r'userType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(AppUserDTOUserTypeEnum),
          ) as AppUserDTOUserTypeEnum;
          result.userType = valueDes;
          break;
        case r'user':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(UserDTO),
          ) as UserDTO;
          result.user.replace(valueDes);
          break;
        case r'reviews':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(ReviewDTO),
          ) as ReviewDTO;
          result.reviews.replace(valueDes);
          break;
        case r'rewards':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(RewardDTO),
          ) as RewardDTO;
          result.rewards.replace(valueDes);
          break;
        case r'govOfficialContent':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(GovOfficialContentDTO),
          ) as GovOfficialContentDTO;
          result.govOfficialContent.replace(valueDes);
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  AppUserDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = AppUserDTOBuilder();
    final serializedList = (serialized as Iterable<Object?>).toList();
    final unhandled = <Object?>[];
    _deserializeProperties(
      serializers,
      serialized,
      specifiedType: specifiedType,
      serializedList: serializedList,
      unhandled: unhandled,
      result: result,
    );
    return result.build();
  }
}

class AppUserDTOUserTypeEnum extends EnumClass {

  @BuiltValueEnumConst(wireName: r'USER')
  static const AppUserDTOUserTypeEnum USER = _$appUserDTOUserTypeEnum_USER;
  @BuiltValueEnumConst(wireName: r'COMMUNITY_MEMBER')
  static const AppUserDTOUserTypeEnum COMMUNITY_MEMBER = _$appUserDTOUserTypeEnum_COMMUNITY_MEMBER;
  @BuiltValueEnumConst(wireName: r'GOV_OFFICIAL')
  static const AppUserDTOUserTypeEnum GOV_OFFICIAL = _$appUserDTOUserTypeEnum_GOV_OFFICIAL;

  static Serializer<AppUserDTOUserTypeEnum> get serializer => _$appUserDTOUserTypeEnumSerializer;

  const AppUserDTOUserTypeEnum._(String name): super(name);

  static BuiltSet<AppUserDTOUserTypeEnum> get values => _$appUserDTOUserTypeEnumValues;
  static AppUserDTOUserTypeEnum valueOf(String name) => _$appUserDTOUserTypeEnumValueOf(name);
}

