package fr.romaindu35.pufferjavaapi.impl.manager;

import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;

abstract class Manager {

    protected PufferJavaAPI pufferJavaAPI;

    public Manager(PufferJavaAPI pufferJavaAPI) {
        this.pufferJavaAPI = pufferJavaAPI;
    }
}
