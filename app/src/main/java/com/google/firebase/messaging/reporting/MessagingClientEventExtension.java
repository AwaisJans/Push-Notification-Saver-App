package com.google.firebase.messaging.reporting;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;

import java.io.IOException;
import java.io.OutputStream;

public final class MessagingClientEventExtension {
  private static final MessagingClientEventExtension DEFAULT_INSTANCE = new Builder().build();

  private final MessagingClientEvent messaging_client_event_;

  MessagingClientEventExtension(MessagingClientEvent messaging_client_event_) {
    this.messaging_client_event_ = messaging_client_event_;
  }

  public byte[] toByteArray() {
    return ProtoEncoderDoNotUse.encode(this);
  }

  public void writeTo(OutputStream output) throws IOException {
    ProtoEncoderDoNotUse.encode(this, output);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Encodable.Ignore
  public MessagingClientEvent getMessagingClientEvent() {
    return messaging_client_event_ == null ? MessagingClientEvent.getDefaultInstance() : messaging_client_event_;
  }

  @Protobuf(
      tag = 1
  )
  @Encodable.Field(
      name = "messagingClientEvent"
  )
  public MessagingClientEvent getMessagingClientEventInternal() {
    return messaging_client_event_;
  }

  public static MessagingClientEventExtension getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static final class Builder {
    private MessagingClientEvent messaging_client_event_;

    Builder() {
      this.messaging_client_event_ = null;
    }

    public MessagingClientEventExtension build() {
      return new MessagingClientEventExtension(messaging_client_event_);
    }

    public Builder setMessagingClientEvent(MessagingClientEvent messaging_client_event_) {
      this.messaging_client_event_ = messaging_client_event_;
      return this;
    }
  }
}
