package fr.romaindu35.pufferjavaapi.api.request;

import fr.romaindu35.pufferjavaapi.api.Authentificator;
import fr.romaindu35.pufferjavaapi.api.messages.FileDesc;
import fr.romaindu35.pufferjavaapi.api.models.*;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.File;
import java.util.List;

public interface Request {

    // -- Authentication --

    @POST("/auth/login")
    Call<PufferSession> getSession(@Body Authentificator authentificator);

    // Self
    @GET("/api/self")
    Call<UserView> getSelf();

    @PUT("/api/self")
    Call<UserView> updateSelf(@Body ChangeSelfSetting changeSelfSetting);

    // -- Nodes --

    @GET("/api/nodes")
    Call<List<NodeView>> getNodes();

    @POST("/api/nodes")
    Call<NodeView> createNode(@Body NodeView nodeView);

    @GET("/api/nodes/{id}")
    Call<NodeView> getNode(@Path("id") String nodeId);

    @PUT("/api/nodes/{id}")
    Call<Void> editNode(@Path("id") String nodeId, @Body NodeView nodeView);

    @DELETE("/api/nodes/{id}")
    Call<Void> deleteNode(@Path("id") String nodeId);

    @GET("/api/nodes/{id}/deployment")
    Call<Deployment> getNodeDeploy(@Path("id") String nodeId);

    // -- Servers --

    @GET("/api/servers")
    Call<ServerSearchResponse> getServers();

    @GET("/api/servers/{id}")
    Call<GetServerResponse> getServer(@Path("id") String id);

    @PUT("/api/servers/{id}")
    Call<CreateServerResponse> createServer(@Path("id") String id, @Body ServerCreation serverCreation);

    @DELETE("/api/servers/{id}")
    Call<Void> deleteServer(@Path("id") String id); // DON'T WORK

    // TODO: add get oauth2

    // Server user access

    @GET("/api/servers/{id}/user")
    Call<List<PermissionView>> getUserAccessServer(@Path("id") String id);

    @PUT("/api/servers/{id}/users/{email}")
    Call<Void> editUserAccessServerPermission(@Path("id") String serverId, @Path("email") String userEmail, @Body PermissionView permissionView);

    @DELETE("/api/servers/{id}/users/{email}")
    Call<Void> deleteUserAccessServer(@Path("id") String serverId, @Path("email") String userEmail);

    // Panel setting

    @GET("/api/settings/{key}")
    Call<SettingResponse> getPanelSetting(@Path("key") String configKey);

    // Template

    @GET("/api/templates")
    Call<List<Template>> getTemplate();

    @POST("/api/templates/import")
    Call<String> getImportableTemplates(@Body Template template);

    @POST("/api/templates/import/{name}")
    Call<Void> importTemplateFromRepository(@Path("name") String templateName);

    @PUT("/api/templates/{name}")
    Call<Void> addOrUpdateTemplate(@Path("name") String templateName, @Body Template template);

    @DELETE("/api/templates/{name}")
    Call<Void> deleteTemplate(@Path("name") String templateName);

    // User setting
    @GET("/api/userSettings")
    Call<List<UserSettingView>> getUserSetting();

    @PUT("/api/userSettings/{key}")
    Call<Void> updateUserSetting(@Path("key") String configKey, @Body ChangeUserSetting changeUserSetting);

    // User
    @GET("/api/users")
    Call<UserSearchResponse> getUsers();

    @POST("/api/users")
    Call<UserView> createUser(@Body UserView userView);

    @GET("/api/users/{id}")
    Call<UserView> getUser(@Path("id") Integer userId);

    @POST("/api/users/{id}")
    Call<Void> updateUser(@Path("id") Integer userId, @Body UserView userView);

    @DELETE("/api/users/{id}")
    Call<UserView> deleteUser(@Path("id") Integer userId);

    @GET("/api/users/{id}/perms")
    Call<PermissionView> getUserPermissions(@Path("id") Integer userId);

    @PUT("/api/users/{id}/perms")
    Call<Void> setUserPermissions(@Path("id") Integer userId, @Body PermissionView permissionView);

    // Daemon

    @GET("/daemon")
    Call<PufferdRunning> isDaemonUp();

    //TODO: add head /daemon
    // I don't add /daemon/server/{id} for GET, PUT, POST, DELETE because it is already add with /api/servers/{id}

    @POST("/daemon/server/{id}/archive/{filename}")
    Call<Void> archiveFile(@Path("id") String serverId, @Path("filename") String destination);

    @POST("/daemon/server/{id}/console")
    Call<ServerLogs> getServerLogs(@Path("id") String serverId);

    @POST("/daemon/server/{id}/console")
    Call<Void> runCommand(@Path("id") String serverId, @Body String command);

    @GET("/daemon/server/{id}/data")
    Call<ServerData> getServerData(@Path("id") String serverId);

    @POST("/daemon/server/{id}/data")
    Call<Void> editServerData(@Path("id") String serverId, @Body ServerData serverData);

    @GET("/daemon/server/{id}/extract/{filename}")
    Call<Void> extractFile(@Path("id") String serverId, @Path("filename") String fileName, @Path("destination") String destination);

    @GET("/daemon/server/{id}/file/{filename}")
    Call<FileDesc> getFileList(@Path("id") String serverId, @Path("filename") String fileName);

    @PUT("/daemon/server/{id}/file/{filename}")
    Call<FileDesc> putFileOrFolder(@Path("id") String serverId, @Path("filename") String fileName, @Path("folder") boolean isFolder, @Path("file") File file);

    @DELETE("/daemon/server/{id}/file/{filename}")
    Call<Void> deleteFile(@Path("id") String serverId, @Path("filename") String fileName);

    @POST("/daemon/server/{id}/install")
    Call<Void> installServer(@Path("id") String serverId, @Query("wait") boolean wait);

    @POST("/daemon/server/{id}/kill")
    Call<Void> killServer(@Path("id") String serverId);

    @POST("/daemon/server/{id}/reload")
    Call<Void> reloadServer(@Path("id") String serverId);

    @POST("/daemon/server/{id}/start")
    Call<Void> startServer(@Path("id") String serverId, @Query("wait") boolean wait);

    @GET("/daemon/server/{id}/stats")
    Call<ServerStats> getServerStats(@Path("id") String serverId);

    @GET("/daemon/server/{id}/status")
    Call<ServerRunning> getServerStatus(@Path("id") String serverId);

    @POST("/daemon/server/{id}/stop")
    Call<Void> stopServer(@Path("id") String serverId, @Query("wait") boolean wait);




}
