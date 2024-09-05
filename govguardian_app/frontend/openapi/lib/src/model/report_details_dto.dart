//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/app_user_dto.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'report_details_dto.g.dart';

/// ReportDetailsDTO
///
/// Properties:
/// * [id] 
/// * [owner] 
/// * [responder] 
/// * [description] 
/// * [title] 
/// * [timestamp] 
/// * [status] 
/// * [image] 
/// * [imageContentType] 
/// * [video] 
/// * [videoContentType] 
/// * [voiceData] 
/// * [voiceDataContentType] 
/// * [file1] 
/// * [file1ContentType] 
/// * [file2] 
/// * [file2ContentType] 
/// * [file3] 
/// * [file3ContentType] 
/// * [appUser] 
@BuiltValue()
abstract class ReportDetailsDTO implements Built<ReportDetailsDTO, ReportDetailsDTOBuilder> {
  @BuiltValueField(wireName: r'id')
  int? get id;

  @BuiltValueField(wireName: r'owner')
  String? get owner;

  @BuiltValueField(wireName: r'responder')
  String? get responder;

  @BuiltValueField(wireName: r'description')
  String? get description;

  @BuiltValueField(wireName: r'title')
  String? get title;

  @BuiltValueField(wireName: r'timestamp')
  DateTime? get timestamp;

  @BuiltValueField(wireName: r'status')
  String? get status;

  @BuiltValueField(wireName: r'image')
  BuiltList<String>? get image;

  @BuiltValueField(wireName: r'imageContentType')
  String? get imageContentType;

  @BuiltValueField(wireName: r'video')
  BuiltList<String>? get video;

  @BuiltValueField(wireName: r'videoContentType')
  String? get videoContentType;

  @BuiltValueField(wireName: r'voiceData')
  BuiltList<String>? get voiceData;

  @BuiltValueField(wireName: r'voiceDataContentType')
  String? get voiceDataContentType;

  @BuiltValueField(wireName: r'file1')
  BuiltList<String>? get file1;

  @BuiltValueField(wireName: r'file1ContentType')
  String? get file1ContentType;

  @BuiltValueField(wireName: r'file2')
  BuiltList<String>? get file2;

  @BuiltValueField(wireName: r'file2ContentType')
  String? get file2ContentType;

  @BuiltValueField(wireName: r'file3')
  BuiltList<String>? get file3;

  @BuiltValueField(wireName: r'file3ContentType')
  String? get file3ContentType;

  @BuiltValueField(wireName: r'appUser')
  AppUserDTO? get appUser;

  ReportDetailsDTO._();

  factory ReportDetailsDTO([void updates(ReportDetailsDTOBuilder b)]) = _$ReportDetailsDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(ReportDetailsDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<ReportDetailsDTO> get serializer => _$ReportDetailsDTOSerializer();
}

class _$ReportDetailsDTOSerializer implements PrimitiveSerializer<ReportDetailsDTO> {
  @override
  final Iterable<Type> types = const [ReportDetailsDTO, _$ReportDetailsDTO];

  @override
  final String wireName = r'ReportDetailsDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    ReportDetailsDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
    if (object.owner != null) {
      yield r'owner';
      yield serializers.serialize(
        object.owner,
        specifiedType: const FullType(String),
      );
    }
    if (object.responder != null) {
      yield r'responder';
      yield serializers.serialize(
        object.responder,
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
    if (object.image != null) {
      yield r'image';
      yield serializers.serialize(
        object.image,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.imageContentType != null) {
      yield r'imageContentType';
      yield serializers.serialize(
        object.imageContentType,
        specifiedType: const FullType(String),
      );
    }
    if (object.video != null) {
      yield r'video';
      yield serializers.serialize(
        object.video,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.videoContentType != null) {
      yield r'videoContentType';
      yield serializers.serialize(
        object.videoContentType,
        specifiedType: const FullType(String),
      );
    }
    if (object.voiceData != null) {
      yield r'voiceData';
      yield serializers.serialize(
        object.voiceData,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.voiceDataContentType != null) {
      yield r'voiceDataContentType';
      yield serializers.serialize(
        object.voiceDataContentType,
        specifiedType: const FullType(String),
      );
    }
    if (object.file1 != null) {
      yield r'file1';
      yield serializers.serialize(
        object.file1,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.file1ContentType != null) {
      yield r'file1ContentType';
      yield serializers.serialize(
        object.file1ContentType,
        specifiedType: const FullType(String),
      );
    }
    if (object.file2 != null) {
      yield r'file2';
      yield serializers.serialize(
        object.file2,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.file2ContentType != null) {
      yield r'file2ContentType';
      yield serializers.serialize(
        object.file2ContentType,
        specifiedType: const FullType(String),
      );
    }
    if (object.file3 != null) {
      yield r'file3';
      yield serializers.serialize(
        object.file3,
        specifiedType: const FullType(BuiltList, [FullType(String)]),
      );
    }
    if (object.file3ContentType != null) {
      yield r'file3ContentType';
      yield serializers.serialize(
        object.file3ContentType,
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
    ReportDetailsDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required ReportDetailsDTOBuilder result,
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
        case r'owner':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.owner = valueDes;
          break;
        case r'responder':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.responder = valueDes;
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
        case r'image':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.image.replace(valueDes);
          break;
        case r'imageContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.imageContentType = valueDes;
          break;
        case r'video':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.video.replace(valueDes);
          break;
        case r'videoContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.videoContentType = valueDes;
          break;
        case r'voiceData':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.voiceData.replace(valueDes);
          break;
        case r'voiceDataContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.voiceDataContentType = valueDes;
          break;
        case r'file1':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.file1.replace(valueDes);
          break;
        case r'file1ContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.file1ContentType = valueDes;
          break;
        case r'file2':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.file2.replace(valueDes);
          break;
        case r'file2ContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.file2ContentType = valueDes;
          break;
        case r'file3':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(String)]),
          ) as BuiltList<String>;
          result.file3.replace(valueDes);
          break;
        case r'file3ContentType':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.file3ContentType = valueDes;
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
  ReportDetailsDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = ReportDetailsDTOBuilder();
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

