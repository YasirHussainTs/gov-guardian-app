//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/app_user_dto.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'report_header_dto.g.dart';

/// ReportHeaderDTO
///
/// Properties:
/// * [id] 
/// * [description] 
/// * [title] 
/// * [timestamp] 
/// * [status] 
/// * [appUser] 
@BuiltValue()
abstract class ReportHeaderDTO implements Built<ReportHeaderDTO, ReportHeaderDTOBuilder> {
  @BuiltValueField(wireName: r'id')
  String? get id;

  @BuiltValueField(wireName: r'description')
  String? get description;

  @BuiltValueField(wireName: r'title')
  String? get title;

  @BuiltValueField(wireName: r'timestamp')
  DateTime? get timestamp;

  @BuiltValueField(wireName: r'status')
  String? get status;

  @BuiltValueField(wireName: r'appUser')
  AppUserDTO? get appUser;

  ReportHeaderDTO._();

  factory ReportHeaderDTO([void updates(ReportHeaderDTOBuilder b)]) = _$ReportHeaderDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(ReportHeaderDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<ReportHeaderDTO> get serializer => _$ReportHeaderDTOSerializer();
}

class _$ReportHeaderDTOSerializer implements PrimitiveSerializer<ReportHeaderDTO> {
  @override
  final Iterable<Type> types = const [ReportHeaderDTO, _$ReportHeaderDTO];

  @override
  final String wireName = r'ReportHeaderDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    ReportHeaderDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
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
    if (object.title != null) {
      yield r'title';
      yield serializers.serialize(
        object.title,
        specifiedType: const FullType(String),
      );
    }
    if (object.timestamp != null) {
      yield r'timestamp';
      yield serializers.serialize(
        object.timestamp,
        specifiedType: const FullType(DateTime),
      );
    }
    if (object.status != null) {
      yield r'status';
      yield serializers.serialize(
        object.status,
        specifiedType: const FullType(String),
      );
    }
    if (object.appUser != null) {
      yield r'appUser';
      yield serializers.serialize(
        object.appUser,
        specifiedType: const FullType(AppUserDTO),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    ReportHeaderDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required ReportHeaderDTOBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.id = valueDes;
          break;
        case r'description':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.description = valueDes;
          break;
        case r'title':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.title = valueDes;
          break;
        case r'timestamp':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DateTime),
          ) as DateTime;
          result.timestamp = valueDes;
          break;
        case r'status':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.status = valueDes;
          break;
        case r'appUser':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(AppUserDTO),
          ) as AppUserDTO;
          result.appUser.replace(valueDes);
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  ReportHeaderDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = ReportHeaderDTOBuilder();
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

