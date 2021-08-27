package fr.romaindu35.pufferjavaapi.impl.manager;

import fr.romaindu35.pufferjavaapi.api.exception.PufferException;
import fr.romaindu35.pufferjavaapi.api.models.Deployment;
import fr.romaindu35.pufferjavaapi.api.models.NodeView;
import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class NodesManager extends Manager {

    public NodesManager(PufferJavaAPI pufferJavaAPI) {
        super(pufferJavaAPI);
    }

    /**
     * Get list of all nodes
     * @return List of NodeManager
     * @throws PufferException
     */
    public List<NodeManager> getNodes() throws PufferException {
        List<NodeManager> nodeManagerList = new ArrayList<>();
        pufferJavaAPI.send(pufferJavaAPI.getRequest().getNodes()).forEach(nodeView -> {
            nodeManagerList.add(new NodeManager(pufferJavaAPI, nodeView));
        });
        return nodeManagerList;
    }

    /**
     * Get NodeManager with his id
     * @param nodeId : Id of the node that we want to get
     * @return NodeManager depending on the node id asked
     * @throws PufferException
     */
    public NodeManager getNodeById(String nodeId) throws PufferException {
        return new NodeManager(pufferJavaAPI, pufferJavaAPI.send(pufferJavaAPI.getRequest().getNode(nodeId)));
    }

    /**
     * Get NodeManager with his name
     * @param nodeName : Name of the node that we want to get
     * @return NodeManager depending on the node name asked
     * @throws PufferException
     */
    public NodeManager getNodeByName(String nodeName) throws PufferException {
        AtomicReference<NodeManager> nodeManager = null;
        pufferJavaAPI.send(pufferJavaAPI.getRequest().getNodes()).forEach(nodeView -> {
            if (nodeView.getName().equalsIgnoreCase(nodeName))
                nodeManager.set(new NodeManager(pufferJavaAPI, nodeView));
        });
        return nodeManager.get();
    }

    //TODO: add JavaDoc
    public NodeManager createNode(String name, String privateHost, Integer privatePort, String publicHost, Integer publicPort, Integer sftpPort) throws PufferException {
        NodeManager nodeManager = new NodeManager(pufferJavaAPI, pufferJavaAPI.send(pufferJavaAPI.getRequest().createNode(new NodeView(0, name, privateHost, privatePort, publicHost, publicPort, sftpPort))));
        pufferJavaAPI.logger.info("The node " + nodeManager.getId() + " has been created.");
        return nodeManager;
    }

    public class NodeManager {

        private PufferJavaAPI pufferJavaAPI;
        protected Integer id;
        protected String name;
        protected String privateHost;
        protected Integer privatePort;
        protected String publicHost;
        protected Integer publicPort;
        protected Integer sftpPort;

        NodeManager(PufferJavaAPI pufferJavaAPI, Integer id, String name, String privateHost, Integer privatePort, String publicHost, Integer publicPort, Integer sftpPort) {
            this.id = id;
            this.name = name;
            this.privateHost = privateHost;
            this.privatePort = privatePort;
            this.publicHost = publicHost;
            this.publicPort = publicPort;
            this.sftpPort = sftpPort;
            this.pufferJavaAPI = pufferJavaAPI;
        }

        NodeManager(PufferJavaAPI pufferJavaAPI, NodeView nodeView) {
            this(pufferJavaAPI, nodeView.getId(), nodeView.getName(), nodeView.getPrivateHost(), nodeView.getPrivatePort(), nodeView.getPublicHost(), nodeView.getPublicPort(), nodeView.getSftpPort());
        }

        /**
         * Edit the node
         * @param nodeEditor : Create new Instance of NodeEditor, and use function that you want.
         * @throws PufferException
         */
        public void editNode(NodeEditor nodeEditor) throws PufferException {
            NodeView nodeView = new NodeView(id, name, privateHost, privatePort, publicHost, publicPort, sftpPort);
            if (nodeEditor.updateName)
                nodeView.setName(nodeEditor.getName());
            if (nodeEditor.updatePrivateHost)
                nodeView.setPrivateHost(nodeEditor.getPrivateHost());
            if (nodeEditor.updatePrivatePort)
                nodeView.setPrivatePort(nodeEditor.getPrivatePort());
            if (nodeEditor.updatePublicHost)
                nodeView.setPublicHost(nodeEditor.getPublicHost());
            if (nodeEditor.updatePublicPort)
                nodeView.setPublicPort(nodeEditor.getPublicPort());
            if (nodeEditor.updateSftpPort)
                nodeView.setSftpPort(nodeEditor.getSftpPort());

            pufferJavaAPI.send(pufferJavaAPI.getRequest().editNode(String.valueOf(this.id), nodeView));
            pufferJavaAPI.logger.info("The node " + this.id + " has been edited.");
        }

        /**
         * Delete the node
         * @throws PufferException
         */
        public void deleteNode() throws PufferException {
            pufferJavaAPI.send(pufferJavaAPI.getRequest().deleteNode(String.valueOf(this.id)));
            pufferJavaAPI.logger.info("The node " + this.id + " has been deleted.");
        }

        /**
         * Gets the data to deploy a node
         * @return Deployment class to get clientID ({@link Deployment#getClientID()}), clientSecret ({@link Deployment#getClientSecret()}) and publicKey ({@link Deployment#getPublicKey()})
         * @throws PufferException
         */
        public Deployment getNodeDeploy() throws PufferException {
            pufferJavaAPI.logger.info("Node deploy for node " + id + " has been get.");
            return pufferJavaAPI.send(pufferJavaAPI.getRequest().getNodeDeploy(String.valueOf(this.id)));
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPrivateHost() {
            return privateHost;
        }

        public Integer getPrivatePort() {
            return privatePort;
        }

        public String getPublicHost() {
            return publicHost;
        }

        public Integer getPublicPort() {
            return publicPort;
        }

        public Integer getSftpPort() {
            return sftpPort;
        }
    }

    public class NodeEditor {

        private boolean updateName = false;
        private boolean updatePrivateHost = false;
        private boolean updatePrivatePort = false;
        private boolean updatePublicHost = false;
        private boolean updatePublicPort = false;
        private boolean updateSftpPort = false;

        protected Integer id;
        protected String name;
        protected String privateHost;
        protected Integer privatePort;
        protected String publicHost;
        protected Integer publicPort;
        protected Integer sftpPort;

        /**
         * Empty constructor, it is just create to get new instance of class
         */
        public NodeEditor() {
            this.id = 0;
            this.name = "";
            this.privateHost = "";
            this.privatePort = 0;
            this.publicHost = "";
            this.publicPort = 0;
            this.sftpPort = 0;
        }

        /**
         * Edit name
         * @param name : The new name for the node
         * @return The class instance
         */
        public NodeEditor editName(String name) {
            this.updateName = true;
            this.name = name;
            return this;
        }

        /**
         * Edit private host
         * @param privateHost : The new private host for the node
         * @return The class instance
         */
        public NodeEditor editPrivateHost(String privateHost) {
            this.updatePrivateHost = true;
            this.privateHost = privateHost;
            return this;
        }

        /**
         * Edit private port
         * @param privatePort : The new private port for the node
         * @return The class instance
         */
        public NodeEditor editPrivatePort(Integer privatePort) {
            this.updatePrivatePort = true;
            this.privatePort = privatePort;
            return this;
        }

        /**
         * Edit public host
         * @param publicHost : The new public host for the node
         * @return The class instance
         */
        public NodeEditor editPublicHost(String publicHost) {
            this.updatePublicHost = true;
            this.publicHost = publicHost;
            return this;
        }

        /**
         * Edit public port
         * @param publicPort : The new public port for the node
         * @return The class instance
         */
        public NodeEditor editPublicPort(Integer publicPort) {
            this.updatePublicPort = true;
            this.publicPort = publicPort;
            return this;
        }

        /**
         * Edit sftp port
         * @param sftpPort : The new sftp port for the node
         * @return The class instance
         */
        public NodeEditor editSftpPort(Integer sftpPort) {
            this.updateSftpPort = true;
            this.sftpPort = sftpPort;
            return this;
        }

        public String getName() {
            return name;
        }

        public String getPrivateHost() {
            return privateHost;
        }

        public Integer getPrivatePort() {
            return privatePort;
        }

        public String getPublicHost() {
            return publicHost;
        }

        public Integer getPublicPort() {
            return publicPort;
        }

        public Integer getSftpPort() {
            return sftpPort;
        }
    }
}
