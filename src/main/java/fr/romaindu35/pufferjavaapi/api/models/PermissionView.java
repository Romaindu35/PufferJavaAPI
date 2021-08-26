package fr.romaindu35.pufferjavaapi.api.models;

public class PermissionView {

    private boolean admin;
    private boolean createServers;
    private boolean deleteServers;
    private boolean deployNodes;
    private boolean editNodes;
    private boolean editServerAdmin;
    private boolean editServerData;
    private boolean editServerUsers;
    private boolean editTemplates;
    private boolean editUsers;
    private String email;
    private boolean installServer;
    private boolean panelSettings;
    private boolean putServerFiles;
    private boolean sendServerConsole;
    private String serverIdentifier;
    private boolean sftpServer;
    private boolean startServer;
    private boolean stopServer;
    private String username;
    private boolean viewNodes;
    private boolean viewServerConsole;
    private boolean viewServerFiles;
    private boolean viewServerStats;
    private boolean viewServers;
    private boolean viewTemplates;
    private boolean viewUsers;

    public boolean isAdmin() {
        return admin;
    }

    public boolean isCreateServers() {
        return createServers;
    }

    public boolean isDeleteServers() {
        return deleteServers;
    }

    public boolean isDeployNodes() {
        return deployNodes;
    }

    public boolean isEditNodes() {
        return editNodes;
    }

    public boolean isEditServerAdmin() {
        return editServerAdmin;
    }

    public boolean isEditServerData() {
        return editServerData;
    }

    public boolean isEditServerUsers() {
        return editServerUsers;
    }

    public boolean isEditTemplates() {
        return editTemplates;
    }

    public boolean isEditUsers() {
        return editUsers;
    }

    public String getEmail() {
        return email;
    }

    public boolean isInstallServer() {
        return installServer;
    }

    public boolean isPanelSettings() {
        return panelSettings;
    }

    public boolean isPutServerFiles() {
        return putServerFiles;
    }

    public boolean isSendServerConsole() {
        return sendServerConsole;
    }

    public String getServerIdentifier() {
        return serverIdentifier;
    }

    public boolean isSftpServer() {
        return sftpServer;
    }

    public boolean isStartServer() {
        return startServer;
    }

    public boolean isStopServer() {
        return stopServer;
    }

    public String getUsername() {
        return username;
    }

    public boolean isViewNodes() {
        return viewNodes;
    }

    public boolean isViewServerConsole() {
        return viewServerConsole;
    }

    public boolean isViewServerFiles() {
        return viewServerFiles;
    }

    public boolean isViewServerStats() {
        return viewServerStats;
    }

    public boolean isViewServers() {
        return viewServers;
    }

    public boolean isViewTemplates() {
        return viewTemplates;
    }

    public boolean isViewUsers() {
        return viewUsers;
    }

    @Override
    public String toString() {
        return "PermissionView{" +
                "admin=" + admin +
                ", createServers=" + createServers +
                ", deleteServers=" + deleteServers +
                ", deployNodes=" + deployNodes +
                ", editNodes=" + editNodes +
                ", editServerAdmin=" + editServerAdmin +
                ", editServerData=" + editServerData +
                ", editServerUsers=" + editServerUsers +
                ", editTemplates=" + editTemplates +
                ", editUsers=" + editUsers +
                ", email='" + email + '\'' +
                ", installServer=" + installServer +
                ", panelSettings=" + panelSettings +
                ", putServerFiles=" + putServerFiles +
                ", sendServerConsole=" + sendServerConsole +
                ", serverIdentifier='" + serverIdentifier + '\'' +
                ", sftpServer=" + sftpServer +
                ", startServer=" + startServer +
                ", stopServer=" + stopServer +
                ", username='" + username + '\'' +
                ", viewNodes=" + viewNodes +
                ", viewServerConsole=" + viewServerConsole +
                ", viewServerFiles=" + viewServerFiles +
                ", viewServerStats=" + viewServerStats +
                ", viewServers=" + viewServers +
                ", viewTemplates=" + viewTemplates +
                ", viewUsers=" + viewUsers +
                '}';
    }
}
