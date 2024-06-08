package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class MessagingClientEvent {
  private static final MessagingClientEvent DEFAULT_INSTANCE = new Builder().build();

  private final long project_number_;

  private final String message_id_;

  private final String instance_id_;

  private final MessageType message_type_;

  private final SDKPlatform sdk_platform_;

  private final String package_name_;

  private final String collapse_key_;

  private final int priority_;

  private final int ttl_;

  private final String topic_;

  private final long bulk_id_;

  private final Event event_;

  private final String analytics_label_;

  private final long campaign_id_;

  private final String composer_label_;

  MessagingClientEvent(long project_number_, String message_id_, String instance_id_,
      MessageType message_type_, SDKPlatform sdk_platform_, String package_name_,
      String collapse_key_, int priority_, int ttl_, String topic_, long bulk_id_, Event event_,
      String analytics_label_, long campaign_id_, String composer_label_) {
    this.project_number_ = project_number_;
    this.message_id_ = message_id_;
    this.instance_id_ = instance_id_;
    this.message_type_ = message_type_;
    this.sdk_platform_ = sdk_platform_;
    this.package_name_ = package_name_;
    this.collapse_key_ = collapse_key_;
    this.priority_ = priority_;
    this.ttl_ = ttl_;
    this.topic_ = topic_;
    this.bulk_id_ = bulk_id_;
    this.event_ = event_;
    this.analytics_label_ = analytics_label_;
    this.campaign_id_ = campaign_id_;
    this.composer_label_ = composer_label_;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Protobuf(
      tag = 1
  )
  public long getProjectNumber() {
    return project_number_;
  }

  @Protobuf(
      tag = 2
  )
  public String getMessageId() {
    return message_id_;
  }

  @Protobuf(
      tag = 3
  )
  public String getInstanceId() {
    return instance_id_;
  }

  @Protobuf(
      tag = 4
  )
  public MessageType getMessageType() {
    return message_type_;
  }

  @Protobuf(
      tag = 5
  )
  public SDKPlatform getSdkPlatform() {
    return sdk_platform_;
  }

  @Protobuf(
      tag = 6
  )
  public String getPackageName() {
    return package_name_;
  }

  @Protobuf(
      tag = 7
  )
  public String getCollapseKey() {
    return collapse_key_;
  }

  @Protobuf(
      tag = 8
  )
  public int getPriority() {
    return priority_;
  }

  @Protobuf(
      tag = 9
  )
  public int getTtl() {
    return ttl_;
  }

  @Protobuf(
      tag = 10
  )
  public String getTopic() {
    return topic_;
  }

  @Protobuf(
      tag = 11
  )
  public long getBulkId() {
    return bulk_id_;
  }

  @Protobuf(
      tag = 12
  )
  public Event getEvent() {
    return event_;
  }

  @Protobuf(
      tag = 13
  )
  public String getAnalyticsLabel() {
    return analytics_label_;
  }

  @Protobuf(
      tag = 14
  )
  public long getCampaignId() {
    return campaign_id_;
  }

  @Protobuf(
      tag = 15
  )
  public String getComposerLabel() {
    return composer_label_;
  }

  public static MessagingClientEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static final class Builder {
    private long project_number_;

    private String message_id_;

    private String instance_id_;

    private MessageType message_type_;

    private SDKPlatform sdk_platform_;

    private String package_name_;

    private String collapse_key_;

    private int priority_;

    private int ttl_;

    private String topic_;

    private long bulk_id_;

    private Event event_;

    private String analytics_label_;

    private long campaign_id_;

    private String composer_label_;

    Builder() {
      this.project_number_ = 0;
      this.message_id_ = "";
      this.instance_id_ = "";
      this.message_type_ = com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType.UNKNOWN;
      this.sdk_platform_ = com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform.UNKNOWN_OS;
      this.package_name_ = "";
      this.collapse_key_ = "";
      this.priority_ = 0;
      this.ttl_ = 0;
      this.topic_ = "";
      this.bulk_id_ = 0;
      this.event_ = com.google.firebase.messaging.reporting.MessagingClientEvent.Event.UNKNOWN_EVENT;
      this.analytics_label_ = "";
      this.campaign_id_ = 0;
      this.composer_label_ = "";
    }

    public MessagingClientEvent build() {
      return new MessagingClientEvent(project_number_, message_id_, instance_id_, message_type_, sdk_platform_, package_name_, collapse_key_, priority_, ttl_, topic_, bulk_id_, event_, analytics_label_, campaign_id_, composer_label_);
    }

    public Builder setProjectNumber(long project_number_) {
      this.project_number_ = project_number_;
      return this;
    }

    public Builder setMessageId(String message_id_) {
      this.message_id_ = message_id_;
      return this;
    }

    public Builder setInstanceId(String instance_id_) {
      this.instance_id_ = instance_id_;
      return this;
    }

    public Builder setMessageType(MessageType message_type_) {
      this.message_type_ = message_type_;
      return this;
    }

    public Builder setSdkPlatform(SDKPlatform sdk_platform_) {
      this.sdk_platform_ = sdk_platform_;
      return this;
    }

    public Builder setPackageName(String package_name_) {
      this.package_name_ = package_name_;
      return this;
    }

    public Builder setCollapseKey(String collapse_key_) {
      this.collapse_key_ = collapse_key_;
      return this;
    }

    public Builder setPriority(int priority_) {
      this.priority_ = priority_;
      return this;
    }

    public Builder setTtl(int ttl_) {
      this.ttl_ = ttl_;
      return this;
    }

    public Builder setTopic(String topic_) {
      this.topic_ = topic_;
      return this;
    }

    public Builder setBulkId(long bulk_id_) {
      this.bulk_id_ = bulk_id_;
      return this;
    }

    public Builder setEvent(Event event_) {
      this.event_ = event_;
      return this;
    }

    public Builder setAnalyticsLabel(String analytics_label_) {
      this.analytics_label_ = analytics_label_;
      return this;
    }

    public Builder setCampaignId(long campaign_id_) {
      this.campaign_id_ = campaign_id_;
      return this;
    }

    public Builder setComposerLabel(String composer_label_) {
      this.composer_label_ = composer_label_;
      return this;
    }
  }

  public enum MessageType implements ProtoEnum {
    UNKNOWN(0),

    DATA_MESSAGE(1),

    TOPIC(2),

    DISPLAY_NOTIFICATION(3);

    private final int number_;

    private MessageType(int number_) {
      this.number_ = number_;
    }

    @Override
    public int getNumber() {
      return number_;
    }
  }

  public enum SDKPlatform implements ProtoEnum {
    UNKNOWN_OS(0),

    ANDROID(1),

    IOS(2),

    WEB(3);

    private final int number_;

    private SDKPlatform(int number_) {
      this.number_ = number_;
    }

    @Override
    public int getNumber() {
      return number_;
    }
  }

  public enum Event implements ProtoEnum {
    UNKNOWN_EVENT(0),

    MESSAGE_DELIVERED(1),

    MESSAGE_OPEN(2);

    private final int number_;

    private Event(int number_) {
      this.number_ = number_;
    }

    @Override
    public int getNumber() {
      return number_;
    }
  }
}
