package sd.cb

import rx.Observable
import rx.functions.Func1
import scala.language.implicitConversions

object Implicits {
  implicit class ScalaObservable[T](val underlying: Observable[T]) extends AnyVal {
    //if remove `@inline` annotation then test will success
    @inline def scMap[R](f: T => R): Observable[R] = underlying.map[R](f.toRx)

    //if change `f.toRx` to `new SFunc1(f)` then test will success
    //@inline def scMap[R](f: T => R): Observable[R] = underlying.map[R](new SFunc1(f))
  }

  final class SFunc1[T1, R](f: T1 => R) extends Func1[T1, R] {
    def call(t1: T1): R = f(t1)
  }
  implicit class RichFunction1[T1, R](val f: T1 => R) extends AnyVal {
    def toRx = new SFunc1(f)
  }
}
