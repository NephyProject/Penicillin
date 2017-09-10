package jp.nephy.penicillin.api

import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonElement
import jp.nephy.penicillin.api.model.*
import jp.nephy.penicillin.api.model.List
import jp.nephy.penicillin.request.HTTPMethod
import jp.nephy.penicillin.request.handler.OAuthRequestHandler
import java.net.URL
import kotlin.Error

internal fun String.GET(oauth: OAuthRequestHandler) = OAuthRequest(oauth, HTTPMethod.GET, this@GET)

internal fun String.POST(oauth: OAuthRequestHandler) = OAuthRequest(oauth, HTTPMethod.POST, this@POST)

internal fun String.DELETE(oauth: OAuthRequestHandler) = OAuthRequest(oauth, HTTPMethod.DELETE, this@DELETE)

internal val JsonElement.byUser: JsonConvertDelegate<User, JsonElement> get() = JsonConvertDelegate(User::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byStatusID: JsonConvertDelegate<StatusID, Long> get() = JsonConvertDelegate(StatusID::class.java, Long::class.java, this.obj)
internal val JsonElement.bySource: JsonConvertDelegate<Source, String> get() = JsonConvertDelegate(Source::class.java, String::class.java, this.obj)
internal val JsonElement.byURL: JsonConvertDelegate<URL, String> get() = JsonConvertDelegate(URL::class.java, String::class.java, this.obj)
internal val JsonElement.byStatusEntity: JsonConvertDelegate<StatusEntity, JsonElement> get() = JsonConvertDelegate(StatusEntity::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byPlaceType: JsonConvertDelegate<PlaceType, JsonElement> get() = JsonConvertDelegate(PlaceType::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byUserEntity: JsonConvertDelegate<UserEntity, JsonElement> get() = JsonConvertDelegate(UserEntity::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byUserProfileEntity: JsonConvertDelegate<UserProfileEntity, JsonElement> get() = JsonConvertDelegate(UserProfileEntity::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byRelationship: JsonConvertDelegate<Relationship, JsonElement> get() = JsonConvertDelegate(Relationship::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byRelationshipSource: JsonConvertDelegate<RelationshipSource, JsonElement> get() = JsonConvertDelegate(RelationshipSource::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byRelationshipTarget: JsonConvertDelegate<RelationshipTarget, JsonElement> get() = JsonConvertDelegate(RelationshipTarget::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byPhotoSize: JsonConvertDelegate<PhotoSize, JsonElement> get() = JsonConvertDelegate(PhotoSize::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byLanguage: JsonConvertDelegate<Language, String> get() = JsonConvertDelegate(Language::class.java, String::class.java, this.obj)
internal val JsonElement.byPlaceAttribute: JsonConvertDelegate<Place, JsonElement> get() = JsonConvertDelegate(Place::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byPhoto: JsonConvertDelegate<Photo, JsonElement> get() = JsonConvertDelegate(Photo::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byFace: JsonConvertDelegate<Face, JsonElement> get() = JsonConvertDelegate(Face::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byMediaFeature: JsonConvertDelegate<MediaFeature, JsonElement> get() = JsonConvertDelegate(MediaFeature::class.java, JsonElement::class.java, this.obj)

internal val JsonElement.byLongArray: JsonConvertArrayDelegate<Long> get() = JsonConvertArrayDelegate(Long::class.java, this.obj)
internal val JsonElement.byListArray: JsonConvertArrayDelegate<List> get() = JsonConvertArrayDelegate(List::class.java, this.obj)
internal val JsonElement.byUserArray: JsonConvertArrayDelegate<User> get() = JsonConvertArrayDelegate(User::class.java, this.obj)
internal val JsonElement.byStringArray: JsonConvertArrayDelegate<String> get() = JsonConvertArrayDelegate(String::class.java, this.obj)
internal val JsonElement.byIntArray: JsonConvertArrayDelegate<Int> get() = JsonConvertArrayDelegate(Int::class.java, this.obj)
internal val JsonElement.byHashtagEntityArray: JsonConvertArrayDelegate<HashtagEntity> get() = JsonConvertArrayDelegate(HashtagEntity::class.java, this.obj)
internal val JsonElement.byURLEntityArray: JsonConvertArrayDelegate<URLEntity> get() = JsonConvertArrayDelegate(URLEntity::class.java, this.obj)
internal val JsonElement.byLocationArray: JsonConvertArrayDelegate<Location> get() = JsonConvertArrayDelegate(Location::class.java, this.obj)
internal val JsonElement.byTrendArray: JsonConvertArrayDelegate<Trend> get() = JsonConvertArrayDelegate(Trend::class.java, this.obj)
internal val JsonElement.bySymbolEntityArray: JsonConvertArrayDelegate<SymbolEntity> get() = JsonConvertArrayDelegate(SymbolEntity::class.java, this.obj)
internal val JsonElement.byErrorArray: JsonConvertArrayDelegate<Error> get() = JsonConvertArrayDelegate(Error::class.java, this.obj)
internal val JsonElement.byStatusArray: JsonConvertArrayDelegate<Status> get() = JsonConvertArrayDelegate(Status::class.java, this.obj)
internal val JsonElement.byFloatArray: JsonConvertArrayDelegate<Float> get() = JsonConvertArrayDelegate(Float::class.java, this.obj)
internal val JsonElement.byFaceCoordinateArray: JsonConvertArrayDelegate<FaceCoordinate> get() = JsonConvertArrayDelegate(FaceCoordinate::class.java, this.obj)
internal val JsonElement.byVideoFileArray: JsonConvertArrayDelegate<VideoFile> get() = JsonConvertArrayDelegate(VideoFile::class.java, this.obj)

internal fun JsonElement.byURL(key: String?=null): JsonConvertDelegate<URL, String> = JsonConvertDelegate(URL::class.java, String::class.java, this.obj, key)
internal fun JsonElement.bySearchMetadata(key: String?=null): JsonConvertDelegate<SearchMetadata, JsonElement> = JsonConvertDelegate(SearchMetadata::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byTimeZone(key: String?=null): JsonConvertDelegate<TimeZone, JsonElement> = JsonConvertDelegate(TimeZone::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.bySettingMetadata(key: String?=null): JsonConvertDelegate<SettingMetadata, JsonElement> = JsonConvertDelegate(SettingMetadata::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.bySleepTime(key: String?=null): JsonConvertDelegate<SleepTime, JsonElement> = JsonConvertDelegate(SleepTime::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byPhoto(key: String?=null): JsonConvertDelegate<Photo, JsonElement> = JsonConvertDelegate(Photo::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byCreatedAt(key: String?=null): JsonConvertDelegate<CreatedAt, String> = JsonConvertDelegate(CreatedAt::class.java, String::class.java, this.obj, key)
internal fun JsonElement.byCountry(key: String?=null): JsonConvertDelegate<Country, String> = JsonConvertDelegate(Country::class.java, String::class.java, this.obj, key)
internal fun JsonElement.byBoundingBox(key: String?=null): JsonConvertDelegate<BoundingBox, JsonElement> = JsonConvertDelegate(BoundingBox::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byMediaProcessingInfo(key: String?=null): JsonConvertDelegate<MediaProcessingInfo, JsonElement> = JsonConvertDelegate(MediaProcessingInfo::class.java, JsonElement::class.java, this.obj, key)

internal fun JsonElement.byStatusIDArray(key: String?=null): JsonConvertArrayDelegate<StatusID> = JsonConvertArrayDelegate(StatusID::class.java, this.obj, key)
internal fun JsonElement.byStringArray(key: String?=null): JsonConvertArrayDelegate<String> = JsonConvertArrayDelegate(String::class.java, this.obj, key)
internal fun JsonElement.byUserMentionEntityArray(key: String?=null): JsonConvertArrayDelegate<UserMentionEntity> = JsonConvertArrayDelegate(UserMentionEntity::class.java, this.obj, key)
internal fun JsonElement.byPlaceArray(key: String?=null): JsonConvertArrayDelegate<Place> = JsonConvertArrayDelegate(Place::class.java, this.obj, key)

internal val JsonElement.byNullableStatus: NullableJsonConvertDelegate<Status, JsonElement> get() = NullableJsonConvertDelegate(Status::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byNullableURL: NullableJsonConvertDelegate<URL, String> get() = NullableJsonConvertDelegate(URL::class.java, String::class.java, this.obj)
internal val JsonElement.byNullableCoordinate: NullableJsonConvertDelegate<Coordinate, JsonElement> get() = NullableJsonConvertDelegate(Coordinate::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byNullablePlace: NullableJsonConvertDelegate<Place, JsonElement> get() = NullableJsonConvertDelegate(Place::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byNullableError: NullableJsonConvertDelegate<Error, JsonElement> get() = NullableJsonConvertDelegate(Error::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byNullableVideo: NullableJsonConvertDelegate<Video, JsonElement> get() = NullableJsonConvertDelegate(Video::class.java, JsonElement::class.java, this.obj)
internal val JsonElement.byNullableImage: NullableJsonConvertDelegate<Image, JsonElement> get() = NullableJsonConvertDelegate(Image::class.java, JsonElement::class.java, this.obj)

internal val JsonElement.byNullableContributorArray: NullableJsonConvertArrayDelegate<Contributor> get() = NullableJsonConvertArrayDelegate(Contributor::class.java, this.obj)
internal val JsonElement.byNullableFloatArray: NullableJsonConvertArrayDelegate<Float> get() = NullableJsonConvertArrayDelegate(Float::class.java, this.obj)
internal val JsonElement.byNullableMediaEntityArray: NullableJsonConvertArrayDelegate<MediaEntity> get() = NullableJsonConvertArrayDelegate(MediaEntity::class.java, this.obj)

internal fun JsonElement.byNullableStatus(key: String?=null): NullableJsonConvertDelegate<Status, JsonElement> = NullableJsonConvertDelegate(Status::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byNullableStatusID(key: String?=null): NullableJsonConvertDelegate<StatusID, Long> = NullableJsonConvertDelegate(StatusID::class.java, Long::class.java, this.obj, key)
internal fun JsonElement.byNullableURL(key: String?=null): NullableJsonConvertDelegate<URL, String> = NullableJsonConvertDelegate(URL::class.java, String::class.java, this.obj, key)
internal fun JsonElement.byNullableUserRetweet(key: String?=null): NullableJsonConvertDelegate<UserRetweet, JsonElement> = NullableJsonConvertDelegate(UserRetweet::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byNullableVideoInfo(key: String?=null): NullableJsonConvertDelegate<VideoInfo, JsonElement> = NullableJsonConvertDelegate(VideoInfo::class.java, JsonElement::class.java, this.obj, key)
internal fun JsonElement.byNullableAdditionalMediaInfo(key: String?=null): NullableJsonConvertDelegate<AdditionalMediaInfo, JsonElement> = NullableJsonConvertDelegate(AdditionalMediaInfo::class.java, JsonElement::class.java, this.obj, key)

internal fun JsonElement.byNullableCountryArray(key: String?=null): JsonConvertArrayDelegate<Country> = JsonConvertArrayDelegate(Country::class.java, this.obj, key)