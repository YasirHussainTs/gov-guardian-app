//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'gov_official_content_dto.g.dart';

/// GovOfficialContentDTO
///
/// Properties:
/// * [id] 
/// * [law] 
/// * [description] 
/// * [action] 
/// * [date] 
@BuiltValue()
abstract class GovOfficialContentDTO implements Built<GovOfficialContentDTO, GovOfficialContentDTOBuilder> {
  @BuiltValueField(wireName: r'id')
  int? get id;

  @BuiltValueField(wireName: r'law')
  String? get law;

  @BuiltValueField(wireName: r'description')
  String? get description;

  @BuiltValueField(wireName: r'action')
  String? get action;

  @BuiltValueField(wireName: r'date')
  DateTime? get date;

  GovOfficialContentDTO._();

  factory GovOfficialContentDTO([void updates(GovOfficialContentDTOBuilder b)]) = _$GovOfficialContentDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(GovOfficialContentDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<GovOfficialContentDTO> get serializer => _$GovOfficialContentDTOSerializer();
}

class _$GovOfficialContentDTOSerializer implements PrimitiveSerializer<GovOfficialContentDTO> {
  @override
  final Iterable<Type> types = const [GovOfficialContentDTO, _$GovOfficialContentDTO];

  @override
  final String wireName = r'GovOfficialContentDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    GovOfficialContentDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
    if (object.law != null) {
      yield r'law';
      yield serializers.serialize(
        object.law,
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
    if (object.action != null) {
      yield r'action';
      yield serializers.serialize(
        object.action,
        specifiedType: const FullType(String),
      );
    }
    if (object.date != null) {
      yield r'date';
      yield serializers.serialize(
        object.date,
        specifiedType: const FullType(DateTime),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    GovOfficialContentDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required GovOfficialContentDTOBuilder result,
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
        case r'law':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.law = valueDes;
          break;
        case r'description':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.description = valueDes;
          break;
        case r'action':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.action = valueDes;
          break;
        case r'date':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DateTime),
          ) as DateTime;
          result.date = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  GovOfficialContentDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = GovOfficialContentDTOBuilder();
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

