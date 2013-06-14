package com.devicehive.websockets.messagebus.local.subscriptions;

import javax.websocket.Session;
import java.util.Set;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: ssidorenko
 * Date: 11.06.13
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
abstract class SubscriptionsManager {
    public abstract void subscribe(Session clientSession, UUID... devices);

    public abstract void unsubscribe(Session clientSession, UUID... devices);


    public abstract Set<Session> getSubscriptions(UUID device);


    public void unsubscribe(Session clientSession) {
        synchronized (clientSession) {
            if (clientSession.getUserProperties().containsKey(SUBSCRIBED_FOR_NOTIFICATIONS_DEVICE_UUIDS)) {
                Set<Session> set = (Set<Session>) clientSession.getUserProperties().get(SUBSCRIBED_FOR_NOTIFICATIONS_DEVICE_UUIDS);
                unsubscribe(clientSession, set.toArray(new UUID[0]));
            }
        }
    }


    public static final String SUBSCRIBED_FOR_NOTIFICATIONS_DEVICE_UUIDS = "SUBSCRIBED_FOR_NOTIFICATIONS_DEVICE_UUIDS";

}
