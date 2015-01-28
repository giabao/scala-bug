package sd.cb

import com.sandinh.couchbase.document.JsDocument
import play.api.libs.json.{JsValue, Json}
import rx.Observable

//if we `import com.sandinh.rx.Implicits._` instead of `import Implicits._`
//then both sbt clean compile & increment compile will be failed
//import com.sandinh.rx.Implicits._

//if we `import Implicits._` instead of `import com.sandinh.rx.Implicits._`
//then clean compile will success, but after that, if we change this file
// ex, by adding/ deleting `private` modifier from `def row2Obs`,
// then run increment compile => failed!
import Implicits._

object LogView {
  private def row2Obs(doc: Observable[JsDocument]): Observable[JsValue] =
    doc.scMap(d => Json.obj(d.id -> d.content))
}
