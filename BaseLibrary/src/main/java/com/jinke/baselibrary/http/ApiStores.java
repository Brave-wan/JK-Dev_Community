package com.jinke.baselibrary.http;



import com.jinke.baselibrary.bean.SMSBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


public interface ApiStores {

    @FormUrlEncoded
    @POST("api/watch/checkuser")
    Observable<HousingResult<SMSBean>> getSMS(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/watch/adduser")
//    Observable<HousingResult<SMSBean>> getAddUser(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/watch/getUserList")
//    Observable<HousingResult<SparkUserListBean>> getUserList(@FieldMap Map<String, String> map);
//
//
//    @FormUrlEncoded
//    @POST("api/watch/getinfo")
//    Observable<HousingResult<ParkInfoBean>> getParkInfo(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/getCheckList")
//    Observable<HousingResult<IdVerificationBean>> getCheckList(@FieldMap Map<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/queryOwnerCheck")
//    Observable<HousingResult<VerificationDetailsBean>> getQueryOwnerCheck(@FieldMap Map<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/checkOwner")
//    Observable<HousingResult<VerificationDetailsBean>> getCheckOwner(@FieldMap Map<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/getKeyHouseNo")
//    Observable<HousingResult<RoomManagerBean>> getKeyHouseNo(@FieldMap SortedMap<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/checkQRCode")
//    Observable<HousingResult<QRCodeUidBean>> getCheckQRCode(@FieldMap SortedMap<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/staffLendKey")
//    Observable<HousingResult<QRCodeUidBean>>  getStaffLendKey(@FieldMap SortedMap<String, String> map, @Header("signature") String sign);
//
//    @FormUrlEncoded
//    @POST("houseKeeper/staffRepayKey")
//    Observable<HousingResult<QRCodeUidBean>> getStaffRepayKey(@FieldMap SortedMap<String, String> map, @Header("signature") String sign);
//
//    //获取OpenID
//    @FormUrlEncoded
//    @POST("Appinterface/platformOauth")
//    Observable<HousingResult<AuthorizationBean>> getPlatformOauth(@FieldMap SortedMap<String, String> map, @Header("signature") String sign);
}
