package samples

import org.specs2.mutable._
import org.junit.Test

/**
 * Sample specification.
 *
 * This specification can be executed with: scala -cp <your classpath=""> ${package}.SpecsTest
 * Or using maven: mvn test
 *
 * For more information on how to write or run specifications, please visit: http://etorreborre.github.com/specs2/
 *
 */
class MySpecTest extends Specification {

  @Test def test1 {
    "My" should {
      "allow " in {

        //0
      }
      "deny " in {
        //0
      }
    }
  }

  @Test def test2 {
    "A List" should {
      "have a size method returning the number of elements in the list" in {
        List(1, 2, 3).size must_== 3
      }
      // add more examples here
      // ...
    }
  }
}