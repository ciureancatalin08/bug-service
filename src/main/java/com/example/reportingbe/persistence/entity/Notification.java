package com.example.reportingbe.persistence.entity;

import com.example.reportingbe.core.utils.NotificationType;

import javax.persistence.*;
import java.util.Date;

/**
 * The Notification Entity.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Entity
@Table(name = "notifications")
//@NamedQueries({@NamedQuery(name = NotificationEntity.NOTIFICATION_FIND_USER_ID, query = "SELECT n from NotificationEntity n where n.userID =:id order by n.date desc "),
//        @NamedQuery(name = NotificationEntity.NOTIFICATION_FIND_BY_NOTIFICATION_TYPE, query = "SELECT n from NotificationEntity n  where n.userID =:id and n.notificationType =:notificationType"),
//        @NamedQuery(name = NotificationEntity.DELETE_NOTIFICATIONS_PERIODICALLY, query = "DELETE FROM NotificationEntity n WHERE n.date <:currentDate")
//})
public class Notification extends BaseEntity<Long> {

    public static final String NOTIFICATION_FIND_USER_ID = "NotificationEntity.findById";
    public static final String NOTIFICATION_FIND_BY_NOTIFICATION_TYPE = "NotificationEntity.findByNotificationType";
    public static final String DELETE_NOTIFICATIONS_PERIODICALLY = "NotificationEntity.delete";

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private NotificationType notificationType;

    @Column(name = "url")
    private String url;

    @Column(name = "message")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private long userID;

}
