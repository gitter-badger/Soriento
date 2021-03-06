package com.emotioncity.soriento

import javax.persistence.Id

import com.emotioncity.soriento.annotations._
import com.orientechnologies.orient.core.id.{ORID, ORecordId}
import com.orientechnologies.orient.core.record.impl.ODocument
import com.emotioncity.soriento.RichODocumentImpl._


/*
 *
 * Copyright (c) 2014 Dmitriy Parenskiy aka stream (dimparf@gmail.com)
*/

case class Test(field: String)
case class BlogWithEmbeddedMessages(name: String, @Embedded message: Message)
case class BlogWithLinkSetMessages(name: String, @LinkSet messages: Set[Message])
case class BlogWithEmbeddedSetMessages(name: String, @EmbeddedSet messages: Set[Message])
case class BlogWithEmbeddedListMessages(@Id id: Option[ORID] = None, name: String, @EmbeddedList messages: List[Message])
case class Record(content: String)
case class Blog(author: String, @Embedded message: Record)
case class Checkin(location: String)
case class User(name: String, @EmbeddedList checkins: List[Checkin])
