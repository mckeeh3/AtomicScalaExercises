
import com.atomicscala.AtomicTest._

// 1. Add a method vocalize to GreatApe. Satisfy the following tests:
//    val ape1 = new GreatApe
//    ape1.vocalize is "Grrr!"
//    val ape2 = new Bonobo
//    ape2.vocalize is "Grrr!"
//    val ape3 = new Chimpanzee
//    ape3.vocalize is "Grrr!"

class GreatApe {
  val weight = 100.0
  val age = 12
  def vocalize = "Grrr!"
}
class Bonobo extends GreatApe
class Chimpanzee extends GreatApe

val ape1 = new GreatApe
ape1.vocalize is "Grrr!"
val ape2 = new Bonobo
ape2.vocalize is "Grrr!"
val ape3 = new Chimpanzee
ape3.vocalize is "Grrr!"

// 2. Building on the previous exercise, create a method says that takes
//    a GreatApe argument and calls vocalize. Satisfy the following tests:
//    says(new GreatApe) is "says Grrr!"
//    says(new Bonobo) is "says Grrr!"
//    says(new Chimpanzee) is "says Grrr!"
//    says(new BonoboB) is "says Grrr!"

class BonoboB extends GreatApe

def says(greatApe: GreatApe) = s"says ${greatApe.vocalize}"
says(new GreatApe) is "says Grrr!"
says(new Bonobo) is "says Grrr!"
says(new Chimpanzee) is "says Grrr!"
says(new BonoboB) is "says Grrr!"

// 3. Create a class Cycle that has a field for wheels set to 2, and a
//    method ride that returns “Riding.” Create a derived class Bicycle
//    that inherits from Cycle. Satisfy the following tests:
//    val c = new Cycle
//    c.ride is "Riding"
//    val b = new Bicycle
//    b.ride is "Riding"
//    b.wheels is 2

class Cycle {
  val wheels = 2
  def ride = "Riding"
}
class Bicycle extends Cycle

val c = new Cycle
c.ride is "Riding"
val b = new Bicycle
b.ride is "Riding"
b.wheels is 2
