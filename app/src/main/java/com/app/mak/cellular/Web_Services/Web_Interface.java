package com.app.mak.cellular.Web_Services;

import com.app.mak.cellular.Agent.AttendanceGetResponse.AttendanceConfirmResponse;
import com.app.mak.cellular.Agent.AttendanceGetResponse.AttendanceGetResponse;
import com.app.mak.cellular.Agent.ScanBatchesResponse;
import com.app.mak.cellular.Agent.ScanPojo;
import com.app.mak.cellular.Agent.model.Simallocatemodel;
import com.app.mak.cellular.AgentBatchesGet.AgentBatchesGetResponse;
import com.app.mak.cellular.AgentBatchesGet.MyPojo;
import com.app.mak.cellular.AgentBatchesReceived.AgentBatchesReceivedResponse;
import com.app.mak.cellular.Agent_Login.AgentLoginResponse;
import com.app.mak.cellular.Agent_Login.RefreshToken;
import com.app.mak.cellular.AgentsGetResponse.AgentsGetResponse;
import com.app.mak.cellular.AgentsList.AgentsListResponse;
import com.app.mak.cellular.AirtimeSales.model.SmartCallAgentLogin;
import com.app.mak.cellular.AirtimeSales.model.get_all_networks.GetAllNetworksResponse;
import com.app.mak.cellular.AirtimeSales.model.get_data_plans.GetAllDataPlansResponse;
import com.app.mak.cellular.AllocationCreateResponse.AllocationCreate;

import com.app.mak.cellular.AllocationGet.AllocationGetResponse;
import com.app.mak.cellular.AllocationStatus.AgentAllocationStatusResponse;
import com.app.mak.cellular.AllocationStatus.AllocationStatusResponse;
import com.app.mak.cellular.AnyAgentAllocation.AgentSearchResponse;
import com.app.mak.cellular.Driver.Contract.ContractResponse;
import com.app.mak.cellular.Driver.DriverAttendance.model.driverattendancephoto.IndividualAttendancePojo;
import com.app.mak.cellular.Driver.DriverAttendance.model.team_attendance.TeamAttendanceResponse_MyPojo;
import com.app.mak.cellular.Driver.DriverAttendance.model.team_attendance.Team_Attendance_Response;
import com.app.mak.cellular.Driver.SignUpAgent.ResponseAuthority;
import com.app.mak.cellular.Driver.Driver_Dashboard.ValueWalletResponse;
import com.app.mak.cellular.Driver.SignUpAgent.SignUpResponse;
import com.app.mak.cellular.Driver.SignUpAgent.UpdateResponse;
import com.app.mak.cellular.Driver.SignUpAgent.WarehouseResponse;
import com.app.mak.cellular.DriverBatchesGet.BatchesGetResponse;
import com.app.mak.cellular.DriverBatchesGet.Pojo;
import com.app.mak.cellular.BatchesReceived.BatchesReceivedResponse;
import com.app.mak.cellular.CredentialsCheck.CredentailsCheckResponse;
import com.app.mak.cellular.Driver.DriverAttendance.model.driverattendancephoto.IndividualAttendanceResponse;
import com.app.mak.cellular.Driver.DriverAttendance.model.driverattendancephoto.UploadedFile;
import com.app.mak.cellular.Driver.DriverAttendance.model.get_Agent.FetchAgent;
import com.app.mak.cellular.FetchOneAgent.CommentsResponse;
import com.app.mak.cellular.FetchOneAgent.FetchOneAgent;
import com.app.mak.cellular.OpenBatchesResponse.OpenedBatchesResponse;
import com.app.mak.cellular.OpenBatchesResponse.SerialsGet;
import com.app.mak.cellular.OpenCloseBatches.CashHistory.CashHistoryResponse;
import com.app.mak.cellular.OpenCloseBatches.OpenCloseResponse;
import com.app.mak.cellular.OpenCloseBatches.SerialsGetResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Web_Interface {

    @POST("login")
    Call<AgentLoginResponse> requestAgentLogin(@Body RequestBody agentLoginBody);

//    @Headers({"x-access-token:"})
//    @GET("")
//    Call<FetchStocksResponse> requestFetchStocks();

    @Headers("Content-Type: application/json")
    @GET("users/me")
    Call<CredentailsCheckResponse> requestCredentialsCheck();

    @Headers("Accept: application/json")
    @GET("batches/")
    Call<BatchesGetResponse> requestBatchesGet(@Query("size") int size, @Query("page") int page);

    @Headers({"Accept: application/json"})
    @GET("users")
    Call<AgentsListResponse> requestAgentsList();

    @Headers({"Accept: application/json"})
    @GET("users?")
    Call<AgentsGetResponse> requestAgentsGet(@Query("size") int size, @Query("page") int page, @Query("authorities") String authorities);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("allocations/{userId}")
    Call<AllocationCreate> requestAllocationCreate(@Path("userId") String id, @Query("lat")double lat, @Query("lng") double longitude,@Body String[] batches);

    @Headers("Accept: application/json")
    @GET("allocations/")
    Call<AllocationGetResponse> requestAllocationGet(@Query("size") int size, @Query("page") int page);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
   // @Headers("Accept: application/json");
    @PUT("allocations")
    Call<AllocationStatusResponse> requestAllocationStatus(@Query("lat") double lat,@Query("lng") double longitude,@Body Pojo pojo);

    @Headers("Accept: application/json")
    @GET("batches/")
    Call<BatchesReceivedResponse> requestBatchesReceived(@Query("size") int size, @Query("page") int page);

    @Headers("Accept: application/json")
    @POST("sims")
    Call<Simallocatemodel> simallocate(@Body RequestBody simallocate);

    //Atendance section
    //for fetching stores list
    @Headers("Accept: application/json")
    @GET("users/")
    Call<FetchAgent> requestfetchagent(@Header("Authorization") String auth,@Query("size") int size, @Query("page") int page);

    @Headers("Accept: application/json")
    @GET("users/{id}")
    Call<FetchOneAgent> requestfetchoneagent(@Path("id") int id);

    //for agent start day
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("attendance")
    Call<IndividualAttendanceResponse> individualAttendanceRespomse(@Body IndividualAttendancePojo myPojo);

    //for image upload
    @Multipart
    @Headers("Accept: application/json")
    @POST("attachments")
    Call<UploadedFile> requestUpdateProfilePic(@Part MultipartBody.Part[] files, @Header("Authorization") String auth);

    @Headers("Accept: application/json")
    @GET("batches/")
    Call<AgentBatchesGetResponse> requestAgentBatchesGet(@Query("size") int size, @Query("page") int page);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    // @Headers("Accept: application/json");
    @PUT("allocations")
    Call<AgentAllocationStatusResponse> requestAgentAllocationStatus(@Query("lat")double lat, @Query("lng") double longitude,@Body MyPojo pojo);

    @Headers("Accept: application/json")
    @GET("batches/")
    Call<AgentBatchesReceivedResponse> requestAgentBatchesReceived(@Query("size") int size, @Query("page") int page);

    @Headers("Accept: application/json")
    @GET("batches/{id}/serials")
    Call<SerialsGetResponse> requestSerialsGet(@Path("id") String id);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("attendance/team")
    Call<Team_Attendance_Response> requestTeamAttendance(@Body TeamAttendanceResponse_MyPojo pojo);

    @Headers("Accept: application/json")
    @GET("attendance")
    Call<AttendanceGetResponse> requestAttendanceGet(@Query("page") int page, @Query("size") int size);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @PUT("attendance/{id}")
    Call<AttendanceConfirmResponse> requestAttendanceConfirm(@Path("id")int id, @Body RequestBody body);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("activities")
    Call<OpenCloseResponse> requestOpenClose(@Query("lat")double lat,@Query("lng") double longitude,@Query("action") String action, @Body RequestBody body);

    @Headers("Accept: application/json")
    @GET("batches/")
    Call<OpenedBatchesResponse> requestOpenedBatches(@Query("size") int size, @Query("page") int page);

    @Headers("Accept: application/json")
    @GET("batches/{id}/serials")
    Call<SerialsGet> requestSerials(@Path("id") int id, @Query("status") String status);

    @Headers("Content-Type: application/json")
    @GET("users/me/balance")
    Call<ValueWalletResponse> requestValueWallet();

    @Headers("Accept: application/json")
    @GET("cashflow?page=page&size=size")
    Call<CashHistoryResponse> requestCashHistory(@Query("page") int page, @Query("size") int size);

    @Headers("Content-Type: application/json")
    @POST("sims/batches")
    Call<ScanBatchesResponse> requestScanBatches(@Body ScanPojo scanPojo);

    @GET("attachments/{id}/download")
    Call<ResponseBody> requestImagefromserver(@Path("id") Integer id);

    //smartcall login auth
    @POST("auth")
    Call<SmartCallAgentLogin> requestSmartCallLogin(@Header("Authorization") String auth);
    //smartcall delete auth
    @DELETE("auth")
    Call<SmartCallAgentLogin> requestSmartCallLoginInvalidateToken(@Header("Authorization") String auth);
    //smartcall get all networks
    @GET("smartload/networks")
    Call<GetAllNetworksResponse> requestSmartCallGetAllNetworks();

    //smartcall get recharge plans
    @Headers({ "Content-Type: application/json"})
    @GET("smartload/networks/{networkId}")
    Call<GetAllDataPlansResponse> requestGetAllDataPlans(@Path("networkId") int network_id);

    //smartcall recharge request
    @POST("smartload/v2/recharges")
    Call<ResponseBody> requestSmartCallRecharge(@Body RequestBody requestRecharge);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("refresh")
    Call<RefreshToken> requestRefreshToken();

    @Headers({ "Content-Type: application/json"})
    @GET("authorities")
    Call<ResponseAuthority> requestResponseAuthority();

    @Headers({ "Content-Type: application/json"})
    @GET("warehouses")
    Call<WarehouseResponse> requestWarehouseResponse();

    @Headers({ "Content-Type: application/json"})
    @POST("users")
    Call<SignUpResponse> requestSignUpResponse(@Body RequestBody signupBody);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @PUT("users/{userid}")
    Call<UpdateResponse> requestUpdateResponse(@Path("userid") int userid, @Body RequestBody updateBody);

    @Headers({"Content-Type: application/json"})
    @POST("users/contract")
    Call<ContractResponse> requestContractResponse(@Body RequestBody contractbody);

    @Headers({ "Content-Type: application/json"})
    @GET("notes")
    Call<CommentsResponse> requestCommentsresponse(@Query("id") int id, @Query("type") String type);

    @Headers({ "Content-Type: application/json"})
    @GET("users")
    Call<AgentSearchResponse> requestAgentSearchResponse(@Query("type") String type, @Query("profile.mobileNo") String number);

    // update rica username password and group name
    @Headers("Content-Type: application/json")
    @PUT("users/{id}")
    Call<ResponseBody> requestRicaDetailsUpdate(@Path("id") int id, @Body RequestBody requestAgentRicaUpdateDetails);
}
