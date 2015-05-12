package com.emotioncity.soriento

import com.emotioncity.soriento.annotations.EmbeddedSet
import com.orientechnologies.orient.core.record.impl.ODocument
import RichODocumentImpl._
import scala.collection.JavaConversions._


/**
 * Created by stream on 31.03.15.
 */
case class Family(mother: String, father: String, @EmbeddedSet brothers: List[Brother])
object Family {
  implicit object FamilyReader extends ODocumentReader[Family] {

    def read(oDocument: ODocument): Family = {
      val family = Family(
        oDocument.get[String]("mother").get,
        oDocument.get[String]("father").get,
        oDocument.listOfEmbedded[Brother]("brothers")
      )
      println(s"Family in FamilyReader $family")
      family
    }
  }
}